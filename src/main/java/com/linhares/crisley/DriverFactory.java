package com.linhares.crisley;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>(){
        @Override
        protected synchronized WebDriver initialValue(){
            return initDriver();
        }
    };

    private DriverFactory(){
    }

    public static WebDriver getDriver(){
        return threadDriver.get();
    }

    public static WebDriver initDriver(){
        WebDriver driver = null;
        if(Properties.EXECUTION_TYPE == Properties.ExecutionType.GRID) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            switch (Properties.BROWSER) {
                case FIREFOX:
                    capabilities.setBrowserName("firefox");
                    break;
                case CHROME:
                    capabilities.setBrowserName("chrome");
                    break;
            }
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
            } catch (MalformedURLException e){
                System.err.println("Fail connection with the GRID.");
                e.printStackTrace();
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void killDriver(){
        WebDriver driver = getDriver();
        if(driver != null){
            driver.quit();
            driver = null;
        }
        if(threadDriver != null){
            threadDriver.remove();
        }
    }
}
