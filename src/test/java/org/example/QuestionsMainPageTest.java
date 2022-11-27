package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class QuestionsMainPageTest {
    //public  ChromeDriver driver;
    public FirefoxDriver driver;
    public  MainPageTest mainPageTest;

    @Before
    public void openMainPage() {
        //System.setProperty("webdriver.chrome.driver","C:\\tools\\chromedriver\\chromedriver.exe");
         //driver = new ChromeDriver();
        System.setProperty("webdriver.geckodriver.driver","C:\\tools\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        mainPageTest = new MainPageTest(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://qa-scooter.praktikum-services.ru/");
        //if (driver.getTitle().equals("Самокат")){
            //System.out.println("Title is Samokat ");
        //} else
       // { System.out.println("Title is not Samokat");}
    }

    @Test
    public void mainQuestionsTest() throws InterruptedException {


        //СКРОЛЛ СТРАНИЦЫ
        WebElement element = driver.findElement
                (By.xpath(".//*[@id='root']/div/div[1]/div[4]/div[2]/div[5]/button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(1000);

        //ПРОВЕРЯЕМ, что ЭЛЕМЕНТЫ СОДЕРЖАТ НУЖНЫЙ ТЕКСТ
        mainPageTest.accordionButtonWhatPriceGetText();
        Thread.sleep(1000);
        String questionWhatPrice = driver.findElement
                (By.xpath(".//*[@id='accordion__panel-0']")).getText();
        String textOfFirstEl = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        Assert.assertTrue("Text not found!", questionWhatPrice.contains(textOfFirstEl));

        WebElement lastElement = driver.findElement
                (By.xpath(".//*[@id='accordion__heading-7']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastElement);
        Thread.sleep(1000);

        mainPageTest.accordionButtonChargeWithScooter();
        Thread.sleep(1000);
         String questionGetChargeWithScooter = driver.findElement
        (By.xpath(".//*[@id='accordion__panel-5']")).getText();
        String textOfFiveEl = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        Assert.assertTrue("Text not found!", questionGetChargeWithScooter.contains(textOfFiveEl));

        //проверить НАЛИЧИЕ ВСЕХ ВОПРОСОВ
        List<WebElement> allElements = driver.findElements(By.xpath(
                "//div[@class='accordion']/div"));
        for (WebElement elem :allElements) {
            System.out.println(elem.getText());
        }
        }


        @After
       public void quitDriver() {
        driver.manage().deleteAllCookies();
       driver.quit();
     }
}
