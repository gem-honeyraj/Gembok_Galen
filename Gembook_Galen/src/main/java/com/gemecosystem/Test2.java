package com.gemecosystem;
import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class Test2 {

    public  WebDriver driver;
    @Before
    public void setUp()
    {

        WebDriverManager.chromedriver().setup();
        //Create a Chrome Driver
        driver = new ChromeDriver();
        //Set the browser size for desktop
        driver.manage().window().setSize(new Dimension(1200, 800));
        driver.get("https://gembook.geminisolutions.com");
    }

    @org.junit.Test
    public void homePageLayoutTest() throws IOException
    {
        //Create a layoutReport object
        //checkLayout function checks the layout and returns a LayoutReport object






/*
        LayoutReport layoutReport = Galen.checkLayout(driver, "HomePage.spec", Arrays.asList("desktop"));
        //Create a tests list
        List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();
        //Create a GalenTestInfo object
        GalenTestInfo test = GalenTestInfo.fromString("homepage layout");
        //Get layoutReport and assign to test object
        test.getReport().layout(layoutReport, "check homepage layout");
        //Add test object to the tests list
        tests.add(test);


        //Create a htmlReportBuilder object
        HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();
        //Create a report under /target folder based on tests list
        htmlReportBuilder.build(tests, "target");
        //If layoutReport has errors Assert Fail



 */

    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

}

