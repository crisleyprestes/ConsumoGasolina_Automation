package com.linhares.crisley;

import com.linhares.crisley.pages.LoginPage;
import com.linhares.crisley.utils.SleepTime;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.linhares.crisley.DriverFactory.getDriver;
import static com.linhares.crisley.DriverFactory.killDriver;

public class BaseTest {

    @Rule
    public TestName testName = new TestName();

    @Before
    public void init(){
        getDriver().get("http://192.168.0.218:8000/");
        getDriver().manage().timeouts().implicitlyWait(SleepTime.TEN_SEC, TimeUnit.SECONDS);
    }

    @After
    public void quit() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("target/screenshot/"+testName.getMethodName()+".jpg"));

        if(Properties.CLOSE_BROWSER){
            killDriver();
        }
    }
}
