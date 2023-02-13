package com.linhares.crisley.pages;

import com.linhares.crisley.BasePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import java.util.UUID;

public class UsuariosPage extends BasePage {

    public void clickAddButton(){
        click(By.cssSelector("a[href='/admin/auth/user/add/']"));
    }

    public void clickSaveButton(){
        click(By.cssSelector("button[name*='save']"));
    }

    public void createUser(String username, String password, String confirmPassword){
        setUsername(username);
        setPassword(password);
        setConfirmPassword(confirmPassword);
        clickSaveButton();
    }

    public String generateUsername(){
        return RandomStringUtils.randomAlphabetic(8);
    }

    public String getMenuPath(){
        return getText(By.cssSelector("div[class='breadcrumbs']"));
    }

    public String getSuccessMessage(){
        return getText(By.cssSelector("div[class*='success-toast']"));
    }

    public void setConfirmPassword(String password){
        inputValue(By.cssSelector("input[name='password2']"), password);
    }

    public void setPassword(String password){
        inputValue(By.cssSelector("input[name='password1']"), password);
    }

    public void setUsername(String username){
        inputValue(By.cssSelector("input[name='username']"), username);
    }
}
