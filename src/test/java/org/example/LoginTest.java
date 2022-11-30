package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest {

    public org.example.OrderPage orderPage;
    public org.example.MainPage mainPage;
    //public  ChromeDriver driver;
    public FirefoxDriver driver;
    String url = "https://qa-scooter.praktikum-services.ru/";


    @Before
    public void openMainPage() {
        //System.setProperty("webdriver.chrome.driver","C:\\tools\\chromedriver\\chromedriver.exe");
        //driver = new ChromeDriver();
        System.setProperty("webdriver.geckodriver.driver", "C:\\tools\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        orderPage = new org.example.OrderPage(driver);
        mainPage = new org.example.MainPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }


    @Test // Тестовый сценарий для "ЗАКАЗ САМОКАТА"
    public void orderAuthorisationTest() throws InterruptedException {
        //Нажать на кнопку ЗАКАЗАТЬ ВВЕРХУ HEADER
        orderPage.pushButtonHeader();
        //АВТОРИЗАЦИЯ
        orderPage.login("Сабина", "Бадеева", "Охотный ряд");
        //Выбор СТАНЦИИ МЕТРО
        orderPage.choiceMetro();
        //Ввод НОМЕРА ТЕЛ
        orderPage.inputTelNumber("+79001112233");
        //Ожидание ЗАГРУЗКИ ДАННЫХ
        orderPage.waitForLoadProfileData();
        orderPage.setNextButton();
        //Аренда и выбор Самоката
        //Выбор ДАТЫ
        orderPage.choiceDataCalendarDeliverField("13.", "12.", "2022");
        //Выбор ДНЯ
        orderPage.clickDropDownRental();
        //Выбор ЦВЕТА САМОКАТА
        orderPage.clickCheckBoxColorScooter();
        //КОММЕНТАРИЙ
        orderPage.fillCommentForCourier("Привезти до 12 дня");
        //Ожидание ЗАГРУЗКИ ДАННЫХ
        orderPage.waitForLoadOrderData();
        //НАЖАТЬ кнопку ЗАКАЗАТЬ
        orderPage.clickGetOrder();
        orderPage.clickButtonOrderYes();

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

