package com.linhares.crisley;

import com.linhares.crisley.utils.SleepTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.linhares.crisley.DriverFactory.getDriver;

public class BasePage {

    public void click(By by){
        new WebDriverWait(getDriver(), SleepTime.TEN_SEC).until(ExpectedConditions.elementToBeClickable(by));
        getDriver().findElement(by).click();
    }

    public boolean elementExists(By by){
        List<WebElement> elements = getDriver().findElements(by);
        return elements.size() > 0;
    }

    public String getText(By by){
        waitVisibilityElement(by);
        return getDriver().findElement(by).getText();
    }

    public void inputValue(By by, String text){
        waitVisibilityElement(by);
        getDriver().findElement(by).sendKeys(text);
    }

    public void waitVisibilityElement(By by){
        new WebDriverWait(getDriver(), SleepTime.TEN_SEC).until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
