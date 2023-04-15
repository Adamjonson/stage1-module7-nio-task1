package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileReader {
    Logger logger = Logger.getLogger(FileReader.class.getName());

    public Profile getDataFromFile(File file) {
        String[] arrOfContent = new String[4];
        String content = "";
        //Path path = Paths.get("C:\\Users\\Hp\\IdeaProjects\\stage1-module7-nio-task1\\src\\main\\resources\\Profile.txt");
        String filePath = file.getPath();

        try(java.io.FileReader fr = new java.io.FileReader(filePath);
            BufferedReader br = new BufferedReader(fr)){
            //String content =  Files.readString(path);
            String line;
            //System.out.println(line);
            int indexCount = 0;
            while((line = br.readLine()) != null){
                content += line;
                content = line.substring(line.indexOf(" ")+1, line.length());
                arrOfContent[indexCount] = content;
                indexCount++;
                //System.out.println(content);
            }

            System.out.println("Array print");
            for (int i = 0; i<arrOfContent.length; i++){
                System.out.println(arrOfContent[i]);
            }
            System.out.println(arrOfContent.length);


            return new Profile(arrOfContent[0], Integer.parseInt(arrOfContent[1]), arrOfContent[2], Long.parseLong(arrOfContent[3]));

        }catch (IOException e){
            logger.log(Level.INFO, "Error");
        }

        return new Profile();
    }

}
