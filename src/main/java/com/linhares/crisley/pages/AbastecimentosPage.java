package com.linhares.crisley.pages;

import com.linhares.crisley.BasePage;
import org.openqa.selenium.By;

public class AbastecimentosPage extends BasePage {

    public void clickAddAbastecimentos(){
        waitVisibilityElement(By.cssSelector("a[href='/admin/api/supply/add/']"));
        click(By.cssSelector("a[href='/admin/api/supply/add/']"));
    }

    public void clickSave(){
        waitVisibilityElement(By.cssSelector("button[name*='save']"));
        click(By.cssSelector("button[name*='save']"));
    }

    public void inputKmSupply(String value){
        inputValue(By.cssSelector("input[name='km_supply']"), value);
    }

    public void inputQuantifyLiters(String value){
        inputValue(By.cssSelector("input[name='quantity_liters']"), value);
    }

    public void inputValue(String value){
        inputValue(By.cssSelector("input[name='value']"), value);
    }

    public boolean isAbastecimentoExist(){
        return elementExists(By.cssSelector("tr[class='row1']"));
    }

    public boolean isSuccessMessage(String startMessage, String finishMessage){
        waitVisibilityElement(By.cssSelector("div[class*='success-toast']"));
        String message = getText(By.cssSelector("div[class*='success-toast']"));
        if(message.startsWith(startMessage)
                && message.endsWith(finishMessage)){
            return true;
        }
        return false;
    }

    public boolean isAbastecimentoAdded(String kmSupply, String quantifyLitters, String value){
        waitVisibilityElement(By.cssSelector("tr[class='row1']"));
        String values = getText(By.cssSelector("tr[class='row1']"));
        if(values.contains(kmSupply)
                && values.contains(quantifyLitters)
                && values.contains(value)){
            return true;
        }
        return false;
    }

    public void setDateSupply(String day, String month, String year){
        click(By.cssSelector("input[name='date_supply_0']"));
        waitVisibilityElement(By.cssSelector("div[class*='datepicker-container']"));
        click(By.cssSelector("div[class*='select-month']"));
        waitVisibilityElement(By.xpath("//span[.='"+month+"']"));
        click(By.xpath("//span[.='"+month+"']"));
        waitVisibilityElement(By.cssSelector("div[class*='select-year']"));
        click(By.cssSelector("div[class*='select-year']"));
        waitVisibilityElement(By.xpath("//span[.='"+year+"']"));
        click(By.xpath("//span[.='"+year+"']"));
        waitVisibilityElement(By.cssSelector("td[data-day='"+day+"']"));
        click(By.cssSelector("td[data-day='"+day+"']"));
    }

    public void setTimeSupplyNow(String hour, String minute){
        waitVisibilityElement(By.cssSelector("input[name='date_supply_1']"));
        click(By.cssSelector("input[name='date_supply_1']"));
        waitVisibilityElement(By.cssSelector("div[class='timepicker-analog-display']"));
        click(By.xpath("//div[contains(text(),'"+hour+"')]"));
        waitVisibilityElement(By.xpath("//div[contains(text(), '"+minute+"')]"));
        click(By.xpath("//div[contains(text(), '"+minute+"')]"));
    }

    public void search(String id){
        inputValue(By.cssSelector("input[id='icon_prefix']"), id);
        click(By.cssSelector("button[class='search-cta']"));
    }
}
