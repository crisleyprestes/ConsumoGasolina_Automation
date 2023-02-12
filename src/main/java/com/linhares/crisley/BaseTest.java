package com.linhares.crisley;

import com.linhares.crisley.pages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import static com.linhares.crisley.DriverFactory.getDriver;
import static com.linhares.crisley.DriverFactory.killDriver;

public class BaseTest {

    private LoginPage loginPage = new LoginPage();
    @Rule
    public TestName testName = new TestName();

    @Before
    public void init(){
        String ip = getIPAddress();
        getDriver().get("http://" + ip + ":8000/");
        loginPage.login("admin", "123456");
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

    public String getIPAddress() {
        String ip;
        try (final DatagramSocket socket = new DatagramSocket()) {
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            ip = socket.getLocalAddress().getHostAddress();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        return ip;
    }
}
