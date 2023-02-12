package com.linhares.crisley.pages;

import com.linhares.crisley.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public void clickAbastecimentos(){
        click(By.xpath("//*[.='Abastecimentos']"));
    }

    public boolean isLoggedIn(){
        waitVisibilityElement(By.id("site-name"));
        return true;
    }
}
