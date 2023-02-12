package com.linhares.crisley.pages;

import com.linhares.crisley.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private HomePage homePage = new HomePage();

    public void clickAcessar(){
        waitVisibilityElement(By.cssSelector("button[type='submit']"));
        click(By.cssSelector("button[type='submit']"));
    }

    public void inputUsername(String username){
        waitVisibilityElement(By.id("username-input"));
        inputValue(By.id("username-input"), username);
    }

    public void inputPassword(String password){
        waitVisibilityElement(By.id("password-input"));
        inputValue(By.id("password-input"), password);
    }

    public boolean login(String username, String password){
        inputUsername(username);
        inputPassword(password);
        clickAcessar();
        return homePage.isLoggedIn();
    }
}
