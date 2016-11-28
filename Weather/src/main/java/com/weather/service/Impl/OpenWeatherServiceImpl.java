package com.weather.service.Impl;

import com.weather.configuration.WeatherApiConfiguration;
import com.weather.model.City;
import com.weather.model.Dto.CityDto;
import com.weather.model.Temperature;
import com.weather.service.CityService;
import com.weather.service.OpenWeatherService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by martanase on 11/23/2016.
 */

@Service
@Transactional
public class OpenWeatherServiceImpl implements OpenWeatherService {

    private String apiUrl = "http://api.openweathermap.org/data/2.5/forecast";
    private String cityParamName = "q";

    @Autowired
    private CityService cityService;


    /***
     * Method gets json from openweathermap.org for *cityName*  and inserts
     * city and temperatures tu database
     *
     * @param cityName
     */
    public CityDto getWeatherDetails(String cityName){

        CityDto cityDto = new CityDto();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = readJsonFromUrl(createRequestUrl(cityName));
            System.out.println(jsonObject);
            cityDto = cityService.create(jsonObject);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cityDto;
    }

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private JSONObject readJsonFromUrl(String url) throws IOException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);

            return json;
        } finally {
            is.close();
        }
    }

    private String createRequestUrl(String cityName){
        WeatherApiConfiguration apiKey = new WeatherApiConfiguration();
        StringBuffer requestUrl = new StringBuffer(apiUrl);
        requestUrl.append("?")
                .append(cityParamName)
                .append("=")
                .append(cityName)
                .append("&")
                .append("mode=json")
                .append("&units=metric")
                .append("&appid=")
                //.append(apiKey.getApiKey());
                .append("4ea65affea463252478f3b6f61dac23b");
        System.out.println("\n\tURL:\t" + requestUrl.toString());
        return requestUrl.toString();
    }
}



