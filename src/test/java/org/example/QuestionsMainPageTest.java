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
    public org.example.MainPage mainPage;
    String url = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void openMainPage() {
        //System.setProperty("webdriver.chrome.driver","C:\\tools\\chromedriver\\chromedriver.exe");
         //driver = new ChromeDriver();
        System.setProperty("webdriver.geckodriver.driver","C:\\tools\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        mainPage = new org.example.MainPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

    }

    @Test
    public void whatPriceScooter() throws InterruptedException {


        //СКРОЛЛ СТРАНИЦЫ и ОЖИДАНИЕ
        mainPage.scrollPaigeMain();
        //ПРОВЕРЯЕМ, что ЭЛЕМЕНТЫ СОДЕРЖАТ НУЖНЫЙ ТЕКСТ
        //  1.Элемент СКОЛЬКО ЭТО СТОИТ?
        mainPage.accordionButtonWhatPriceGetText();
        String questionWhatPrice = driver.findElement
                (By.xpath(".//*[@id='accordion__panel-0']")).getText();
        String textOfFirstEl = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        Assert.assertTrue("Text not found!", questionWhatPrice.contains(textOfFirstEl));
    }

    @Test
    public void wantSomeScooter() throws InterruptedException{
        //  2.Элемент "ХОЧУ НЕСКОЛЬКО САМОКАТОВ?"
        //СКРОЛЛ СТРАНИЦЫ и ОЖИДАНИЕ
        mainPage.scrollPaigeMain();
        //ПРОВЕРЯЕМ, что ЭЛЕМЕНТЫ СОДЕРЖАТ НУЖНЫЙ ТЕКСТ
        mainPage.accordionButtonWantSomeGetText();
        String questionWantSome = driver.findElement
                (By.xpath(".//*[@id='accordion__panel-1']")).getText();
        String textOfSecondEl = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        Assert.assertTrue("Text not found!", questionWantSome.contains(textOfSecondEl));}

    @Test
    public void timeRentalScooter() throws InterruptedException{
        mainPage.scrollPageDown();
        //  3.Элемент "КАК РАССЧИТЫВАЕТСЯ ВРЕМЯ АРЕНДЫ?"
        mainPage.accordionButtonTimeRentalGetText();
       String questionTimeRental = driver.findElement
                (By.xpath(".//*[@id='accordion__panel-2']")).getText();
        String textOfThirdEl = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру." +
                " Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
       Assert.assertTrue("Text not found!", questionTimeRental.contains(textOfThirdEl));}

    @Test
    public void getOrderNowScooter() throws InterruptedException{
        mainPage.scrollPageDown();
        //  4.Элемент "МОЖНО ЗАКАЗАТЬ САМОКАТ СЕГОДНЯ"
        mainPage.accordionButtonGetOrderNowGetText();
        String questionOrderNow = driver.findElement
                (By.xpath(".//*[@id='accordion__panel-3']")).getText();
        String textOfFoursEl = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        Assert.assertTrue("Text not found!", questionOrderNow.contains(textOfFoursEl));}
    @Test
    public void extendOrderScooter() throws InterruptedException{
        mainPage.scrollPageDown();
        // 5.Элемент "МОЖНО ЛИ ПРОДЛИТЬ ЗАКАЗ"
        mainPage.accordionButtonExtendOrderGetText();
        String questionOrderExtend = driver.findElement
                (By.xpath(".//*[@id='accordion__panel-4']")).getText();
        String textOfFivesEl = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        Assert.assertTrue("Text not found!", questionOrderExtend.contains(textOfFivesEl));}
    @Test
    public void chargeWithScooter() throws InterruptedException{
        //  СКРОЛЛ СТРАНИЦЫ
        mainPage.scrollPageMainDown();
        // 6.Элемент ВЫ ПРИВОЗИТЕ ЗАРЯДКУ?
        mainPage.accordionButtonChargeWithScooter();
        WebElement web = new WebDriverWait(driver, Duration.ofSeconds(5))
               .until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='accordion__panel-5']")));
         String questionGetChargeWithScooter = driver.findElement
        (By.xpath(".//*[@id='accordion__panel-5']")).getText();
        String textOfSixthEl = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        Assert.assertTrue("Text not found!", questionGetChargeWithScooter.contains(textOfSixthEl));}

    @Test
    public void cancelOrderScooter() throws InterruptedException{
        //  СКРОЛЛ СТРАНИЦЫ
        mainPage.scrollPageMainDown();
        // 7.Элемент "МОЖНО ЛИ ОТМЕНИТЬ ЗАКАЗ"
        mainPage.accordionButtonCancelOrderGetText();
        String questionCancelScooter = driver.findElement
                (By.xpath(".//*[@id='accordion__panel-6']")).getText();
        String textOfSeventhEl = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        Assert.assertTrue("Text not found!", questionCancelScooter.contains(textOfSeventhEl));}

    @Test
    public void questionAboutLiveFar() throws InterruptedException{
        //  СКРОЛЛ СТРАНИЦЫ
        mainPage.scrollPageMainDown();
        // 8.Элемент "Я ЖИВУ ЗА МКАДОМ, ПРИВЕЗЁТЕ"
        mainPage.accordionButtonLiveFarGetText();
        String questionLiveFar = driver.findElement
                (By.xpath(".//*[@id='accordion__panel-7']")).getText();
        String textOfEighthEl = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        Assert.assertTrue("Text not found!", questionLiveFar.contains(textOfEighthEl));}


    @Test
    public void questionAllElements(){
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
