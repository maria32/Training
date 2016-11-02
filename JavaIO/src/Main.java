import java.io.*;
import java.util.Scanner;

/**
 * Created by martanase on 11/2/2016.
 */


public class Main {

    // check if the file exists
    public static boolean fileExists(File file) {
        return file.exists();
    }

    public static void main(String[] args) {


        //ex1. count no of times character "a" appears in a text
        int aCounter = 0;
        try(Reader reader = new FileReader("input-file.txt")){
            int data = reader.read();
            while(data != -1){
                if(data == 97)
                aCounter++;
                data  = reader.read();
            }
            System.out.println("Caracterul 'a' apare de " + aCounter + " ori.");
        }catch(IOException e){
            e.printStackTrace();
        }


        //ex2. reads from a text file and writes the words in reversed order in another text file
        StringBuilder text = new StringBuilder();
        try(Scanner scanner = new Scanner(new File("input-file.txt"))) {

            while (scanner.hasNextLine()) {
                Scanner line = new Scanner(scanner.nextLine());
                while (line.hasNext()) {
                    text = text.insert(0, line.next() + " ");
                }
                text.insert(0, "\n");
            }
            text.deleteCharAt(0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try(OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("output-file.txt"))){
            writer.write(text.toString());
        }catch(Exception e){
            e.printStackTrace();
        }

        //ex3. listed content of a folder, in a tree model
        File directory = new File("C:\\Users\\martanase\\Desktop\\Mind-it");
        String spaces = "";
        try {
            System.out.println(spaces + (String) directory.getName());
            printFolderStructure(directory, spaces);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void printFolderStructure(File directory, String spaces){
        if(directory.isDirectory()){
            File[] fileNames = directory.listFiles();
            spaces = spaces + "\t";
            for(File file: fileNames){
                System.out.println(spaces + (String) file.getName());

                printFolderStructure(file, spaces);
            }
        }
    }

}

