package com.gemecosystem;

import com.galenframework.junit.GalenJUnitTestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.gemecosystem.locators.GemBookElements;



public class GalenLayoutTesting extends GalenJUnitTestBase {



    @Override
    public WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private DeviceSetup device;

    public GalenLayoutTesting(final DeviceSetup deviceSetup) {
        super();
        this.device = deviceSetup;
    }

    public static class DeviceSetup {
        private final Dimension screenSize;
        private final List<String> tags;

        public DeviceSetup(Dimension screenSize, String... tags) {
            this.screenSize = screenSize;
            this.tags = Arrays.asList(tags);
        }

        public Dimension getScreenSize() {
            return screenSize;
        }

        protected List<String> getTags() {
            return tags;
        }
    }


    @Parameterized.Parameters
    public static Iterable<Object[]> devices() {
        return Arrays.asList(new Object[][] {

                //device name and size
                { new DeviceSetup(new Dimension(1440, 1080), "normal", "desktop") },

   //             { new DeviceSetup(new Dimension(375, 800), "normal-phone", "phone", "mobile") }

        });
    }

    @Test
    public void testHomePage() throws Exception {

        WebDriver driver = this.getDriver();
        driver.get("https://gembook.geminisolutions.com");
        resize(device.getScreenSize().getWidth(), device.getScreenSize().getHeight());

        Thread.sleep(2000);
        GemBookElements.signinButton(driver).click();


        Thread.sleep(3000);
        String parent=driver.getWindowHandle();

        Set<String> drivers =driver.getWindowHandles();

        Iterator<String> iterator = drivers.iterator();

        while(iterator.hasNext()) {

            String child_window = iterator.next();


            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
                GemBookElements.signinPageButtons(driver,"email").sendKeys("honey.raj@geminisolutions.com");
                GemBookElements.signinPageButtons(driver,"submit").click();
                Thread.sleep(3000);
                GemBookElements.signinPageButtons(driver,"password").sendKeys("Google$890");
                GemBookElements.signinPageButtons(driver,"submit").click();
                Thread.sleep(3000);
                GemBookElements.signinPageButtons(driver,"submit").click();
                driver.switchTo().window(parent);
            }
        }


        System.out.println(driver.manage().window().getSize());
        Thread.sleep(5000);
        checkLayout("HomePage.spec", device.getTags());



    }

    @Test
    public void testsigninpage() throws Exception {

        WebDriver driver = this.getDriver();
        driver.get("https://gembook.geminisolutions.com");
        resize(device.getScreenSize().getWidth(), device.getScreenSize().getHeight());
        System.out.println("----"+driver.manage().window().getSize());
        Thread.sleep(3000);
        checkLayout("SigninPage.spec", device.getTags());

    }

    @Test
    public void testprofilepage() throws Exception {

        WebDriver driver = this.getDriver();
        driver.get("https://gembook.geminisolutions.com");
        resize(device.getScreenSize().getWidth(), device.getScreenSize().getHeight());

        Thread.sleep(2000);
        GemBookElements.signinButton(driver).click();


        Thread.sleep(3000);
        String parent=driver.getWindowHandle();

        Set<String> drivers =driver.getWindowHandles();

        Iterator<String> iterator = drivers.iterator();

        while(iterator.hasNext()) {

            String child_window = iterator.next();


            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
                GemBookElements.signinPageButtons(driver,"email").sendKeys("honey.raj@geminisolutions.com");
                GemBookElements.signinPageButtons(driver,"submit").click();
                Thread.sleep(3000);
                GemBookElements.signinPageButtons(driver,"password").sendKeys("Google$890");
                GemBookElements.signinPageButtons(driver,"submit").click();
                Thread.sleep(3000);
                GemBookElements.signinPageButtons(driver,"submit").click();
                driver.switchTo().window(parent);
            }
        }

        System.out.println(driver.manage().window().getSize());

        GemBookElements.profileImg(driver).click();
        Thread.sleep(3000);
        checkLayout("ProfilePage.spec", device.getTags());


    }







}
