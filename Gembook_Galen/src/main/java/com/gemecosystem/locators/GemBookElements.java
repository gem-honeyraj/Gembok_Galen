package com.gemecosystem.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GemBookElements {


    public static WebElement signinButton (WebDriver driver)
    {return driver.findElement(By.className("auth_signin__3ILKi"));}

    public static WebElement signinPageButtons (WebDriver driver,String type)
    {return driver.findElement(By.xpath("//*[@type='"+type+"']"));}

    public static WebElement profileImg (WebDriver driver)
    {return driver.findElement(By.xpath("//*[@alt='profile image']"));}






}
