package org.example;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

    public  OrderPageTest orderPageTest;
    //public  ChromeDriver driver;
    public FirefoxDriver driver;


    @Before
    public void openMainPage() {
        //System.setProperty("webdriver.chrome.driver","C:\\tools\\chromedriver\\chromedriver.exe");
         //driver = new ChromeDriver();
        System.setProperty("webdriver.geckodriver.driver","C:\\tools\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        orderPageTest  = new OrderPageTest(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }


    @Test // Тестовый сценарий для "ЗАКАЗ САМОКАТА"
    public  void orderAuthorisationTest() throws InterruptedException {
        //Нажать на кнопку ЗАКАЗАТЬ №2
        WebElement element = driver.findElement
                (By.xpath(".//*[@id='root']/div/div[1]/div[4]/div[2]/div[5]/button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);
        orderPageTest.pushOrderButtonTwo();
        //АВТОРИЗАЦИЯ
        orderPageTest.login("Сабина","Бадеева","Охотный ряд");
        Thread.sleep(2000);

        //Выбор СТАНЦИИ МЕТРО
        orderPageTest.choiceMetroSt();
        List<WebElement> elements = driver.findElements(By.xpath(".//li"));
        driver.findElement(By.xpath(".//li[@data-value='3']")).click();
        System.out.println(elements.size());
        //Ввод НОМЕРА ТЕЛ
        orderPageTest.inputTelNumber("+79001112233");
        Thread.sleep(2000);
        orderPageTest.setNextButton();
        //Аренда и выбор Самоката
        orderPageTest.clickCalendar();
        orderPageTest.clickDropDownRental();
        Thread.sleep(2000);
        orderPageTest.clickCheckBoxColorScooter();
        orderPageTest.fillCommentForCourier("Привезти до 12 дня");
        Thread.sleep(2000);
        orderPageTest.clickGetOrder();
        Thread.sleep(2000);
        orderPageTest.clickButtonOrderYes();
        //ПРОВЕРКА СТАТУСА ЗАКАЗА
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_ModalHeader__3FDaJ")));
        String orderElement = driver.findElement(By.className("Order_ModalHeader__3FDaJ")).getText();
        String textOrderElement = "Заказ оформлен";
        Assert.assertTrue("Text not found!", orderElement.contains(textOrderElement));

    }
    @After
    public void quitDriver() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}

