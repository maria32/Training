package com.weather.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by martanase on 12/4/2016.
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("F");
        System.out.println(date);
        System.out.printf("%s %tB %<te, %<tY", "Due date:", date);
    }
}
