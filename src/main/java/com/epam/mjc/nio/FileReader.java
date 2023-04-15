package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileReader {
    Logger logger = Logger.getLogger(FileReader.class.getName());

    public Profile getDataFromFile(File file) {
        String[] arrOfContent = new String[4];
        String content = "";

        String filePath = file.getPath();

        try(java.io.FileReader fr = new java.io.FileReader(filePath);
            BufferedReader br = new BufferedReader(fr)){

            String line;

            int indexCount = 0;
            while((line = br.readLine()) != null){
                content = line.substring(line.indexOf(" ")+1, line.length());
                arrOfContent[indexCount] = content;
                indexCount++;
            }




            return new Profile(arrOfContent[0], Integer.parseInt(arrOfContent[1]), arrOfContent[2], Long.parseLong(arrOfContent[3]));

        }catch (IOException e){
            logger.log(Level.INFO, "Error");
        }

        return new Profile();
    }

}
