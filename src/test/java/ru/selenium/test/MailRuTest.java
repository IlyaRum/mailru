package ru.selenium.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class MailRuTest {

    private static WebDriver driver;
	Properties prop = new Properties();

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");

        setPropetry();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://mail.ru/desktop/login");
    }

    @Test
    public void _main() {
        PageObjectMailRu driverChrome = new PageObjectMailRu(driver);
		System.out.println("-------------");
        System.out.println("LOGIN: " + prop.getProperty("LOGIN"));
        driverChrome.getLoginField().sendKeys(prop.getProperty("LOGIN"));
        System.out.println("PASSWORD: " + prop.getProperty("PASSWORD"));
        driverChrome.getPasswordField().sendKeys(prop.getProperty("PASSWORD"));
        driverChrome.getLoginBtn().click();

        driverChrome.getWriteEmailBtn().click();

        driverChrome.getTo().click();
        System.out.println("TOEMAIL: " + prop.getProperty("TOEMAIL"));
        driverChrome.getTo().sendKeys(prop.getProperty("TOEMAIL"));

        driver.switchTo().frame(driverChrome.getBodyText());

        driverChrome.getBody().click();
        System.out.println("TEXTBODY: " + prop.getProperty("TEXTBODY"));
        driverChrome.getBody().sendKeys(prop.getProperty("TEXTBODY"));

        driver.switchTo().defaultContent();

        driverChrome.getSendBtn().click();
		System.out.println("-------------");
	}

    @AfterTest
    public void terminatetest() {
        //driver.close();
    }
    
    private void setPropetry() {
    InputStream input = null;
        try {
            input = new FileInputStream("config.properties");
            prop.load(input);
        }
        catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
