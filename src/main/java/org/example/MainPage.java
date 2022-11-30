
package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {

        this.driver = driver;
    }
    //локатор кнопки ЗАКАЗАТЬ №2
    private By orderButton = By.xpath(".//*[@id='root']/div/div[1]/div[4]/div[2]/div[5]/button");

    // 1.локаторы  ACCORDION BUTTON "СКОЛЬКО ЭТО СТОИТ?"
    private By accordionButtonWhatPrice = By.xpath(".//*[@id='accordion__heading-0']");
    private By answerQuestionWhatPrice = By.xpath(".//*[@id='accordion__panel-0']");

    // 2.локаторы  ACCORDION BUTTON "ХОЧУ СРАЗУ НЕСКОЛЬКО САМОКАТОВ"
    private By accordionButtonWantSome = By.xpath(".//*[@id='accordion__heading-1']");
    private By answerButtonWantSome = By.xpath(".//*[@id='accordion__panel-1']");

    // 3.локаторы  ACCORDION BUTTON "КАК РАССЧИТЫВАЕТСЯ ВРЕМЯ АРЕНДЫ?"
    private By accordionButtonTimeRental = By.xpath(".//*[@id='accordion__heading-2']");
    private By answerAccordionButtonTimeRental = By.xpath(".//*[@id='accordion__panel-2']");

    // 4.локаторы  ACCORDION BUTTON "МОЖНО ЗАКАЗАТЬ САМОКАТ СЕГОДНЯ"
    private By accordionButtonGetOrderNow = By.xpath(".//*[@id='accordion__heading-3']");
    private By answerAccordionButtonGetOrderNow = By.xpath(".//*[@id='accordion__panel-3']");

    // 5.локаторы  ACCORDION BUTTON "МОЖНО ЛИ ПРОДЛИТЬ ЗАКАЗ"
    private By accordionButtonExtendOrder = By.xpath(".//*[@id='accordion__heading-4']");
    private By answerAccordionButtonExtendOrder = By.xpath(".//*[@id='accordion__panel-4']");

    // 6.локаторы  ACCORDION BUTTON "ВЫ ПРИВОЗИТЕ ЗАРЯДКУ ВМЕСТЕ С САМОКАТОМ?"
    private By accordionButtonChargeWithScooter = By.xpath(".//*[@id='accordion__heading-5']");
    private By answerButtonChargeWithScooter =By.xpath(".//*[@id='accordion__panel-5']");

    // 7.локаторы  ACCORDION BUTTON "МОЖНО ЛИ ОТМЕНИТЬ ЗАКАЗ"
    private By accordionButtonCancelOrder = By.xpath(".//*[@id='accordion__heading-6']");
    private By answerButtonCancelOrder =By.xpath(".//*[@id='accordion__panel-6']");

    // 8.локаторы  ACCORDION BUTTON "Я ЖИВУ ЗА МКАДОМ, ПРИВЕЗЁТЕ"
    private By accordionButtonLiveFar = By.xpath(".//*[@id='accordion__heading-7']");
    private By answerButtonLiveFar =By.xpath(".//*[@id='accordion__panel-7']");

    //СКРОЛЛ СТРАНИЦЫ
    public void scrollPaigeMain() throws InterruptedException {
        WebElement element = driver.findElement
                (orderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(1000);
    }

    public void scrollPageMainDown() throws InterruptedException {
        WebElement lastElement = driver.findElement
                (By.xpath(".//*[@id='accordion__heading-3']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastElement);
        Thread.sleep(1000);}

    public void scrollPageDown() throws InterruptedException {
        WebElement thirdElement = driver.findElement
                (By.xpath(".//*[@id='accordion__heading-3']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", thirdElement);
        Thread.sleep(1000);

    }
// методы для ACCORDION COMPONENT

    // 1.метод для элемента "СКОЛЬКО ЭТО СТОИТ?"
    public void clickAccordionButtonWhatPrice(){
        driver.findElement(accordionButtonWhatPrice).click();
    }
    public void getAnswerQuestionWhatPrice (){
        driver.findElement(answerQuestionWhatPrice).getText();
    }
    public void accordionButtonWhatPriceGetText(){
        clickAccordionButtonWhatPrice();
        getAnswerQuestionWhatPrice();
    }
    // 2.метод для элемента "ХОЧУ НЕСКОЛЬКО САМОКАТОВ"
    public void clickAccordionButtonWantSome(){driver.findElement(accordionButtonWantSome).click();}
    public void getAnswerButtonWantSome(){driver.findElement(answerButtonWantSome).getText();}
    public void accordionButtonWantSomeGetText(){
        clickAccordionButtonWantSome();
        getAnswerButtonWantSome();
    }

    // 3.метод для элемента "КАК РАССЧИТЫВАЕТСЯ ВРЕМЯ АРЕНДЫ?"
    public void clickAccordionButtonTimeRental(){
        driver.findElement(accordionButtonTimeRental).click();
    }
    public void getAnswerButtonTimeRental(){
        driver.findElement(answerAccordionButtonTimeRental).getText();
    }
    public void accordionButtonTimeRentalGetText(){
        clickAccordionButtonTimeRental();
        getAnswerButtonTimeRental();
    }

    // 4.метод для элемента "МОЖНО ЗАКАЗАТЬ САМОКАТ СЕГОДНЯ"
    public void clickAccordionButtonGetOrderNow(){
        driver.findElement(accordionButtonGetOrderNow).click();
    }
    public void getAnswerAccordionButtonGetOrderNow(){
        driver.findElement(answerAccordionButtonGetOrderNow).getText();
    }
    public void accordionButtonGetOrderNowGetText(){
        clickAccordionButtonGetOrderNow();
        getAnswerAccordionButtonGetOrderNow();
    }
    // 5.метод для элемента "МОЖНО ЛИ ПРОДЛИТЬ ЗАКАЗ"
    public void clickAccordionButtonExtendOrder(){
        driver.findElement(accordionButtonExtendOrder).click();
    }
    public void getAnswerAccordionButtonExtendOrder(){
        driver.findElement(answerAccordionButtonExtendOrder).getText();
    }
    public void accordionButtonExtendOrderGetText(){
        clickAccordionButtonExtendOrder();
        getAnswerAccordionButtonExtendOrder();
    }

    // 6.метод для элемента "ВЫ ПРИВОЗИТЕ ЗАРЯДКУ ВМЕСТЕ С САМОКАТОМ?"
    public void clickAccordionButtonChargeWithScooter(){
        driver.findElement(accordionButtonChargeWithScooter).click();
    }
    public void getAnswerButtonChargeWithScooter(){
        driver.findElement(answerButtonChargeWithScooter).getText();
    }
    public void accordionButtonChargeWithScooter(){
        clickAccordionButtonChargeWithScooter();
        getAnswerButtonChargeWithScooter();
    }
    // 7.метод для элемента "МОЖНО ЛИ ОТМЕНИТЬ ЗАКАЗ"
    public void clickAccordionButtonCancelOrder(){
        driver.findElement(accordionButtonCancelOrder).click();
    }
    public void getAnswerAccordionButtonCancelOrder(){
        driver.findElement(answerButtonCancelOrder).getText();
    }
    public void accordionButtonCancelOrderGetText(){
        clickAccordionButtonCancelOrder();
        getAnswerAccordionButtonCancelOrder();
    }
    // 8.метод для элемента "Я ЖИВУ ЗА МКАДОМ, ПРИВЕЗЁТЕ"
    public void clickAccordionButtonLiveFar(){
        driver.findElement(accordionButtonLiveFar).click();
    }
    public void getAnswerAccordionButtonLiveFar(){
        driver.findElement(answerButtonLiveFar).getText();
    }
    public void accordionButtonLiveFarGetText(){
        clickAccordionButtonLiveFar();
        getAnswerAccordionButtonLiveFar();
    }
}
