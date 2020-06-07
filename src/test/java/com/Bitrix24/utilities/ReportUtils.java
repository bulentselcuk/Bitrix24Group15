package com.Bitrix24.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportUtils {
    protected static WebDriver driver = Driver.getDriver();
    public static String getScreenshot(String name){

        SimpleDateFormat sd = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        String date = sd.format(new Date());

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String target = System.getProperty("user.dir")+ "/test-output/Screenshots/"+name+date+".png";
        File finalDestanation = new File(target);
        try {
            FileUtils.copyFile(source, finalDestanation);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return target;

    }
}
