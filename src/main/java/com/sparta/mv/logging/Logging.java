package com.sparta.mv.logging;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Logging {
    public static Logger logger = Logger.getLogger("myLogger");
    public static void logging(){
       try{
            Handler fileHandler = new FileHandler("SortingManager/src/main/java/com/sparta/mv/logging/myLog.log");
            logger.addHandler(fileHandler);
            fileHandler.setFormatter(new CustomFormatter());
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}
