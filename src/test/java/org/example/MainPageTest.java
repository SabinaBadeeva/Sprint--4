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

public class MainPageTest {
    private WebDriver driver;

    public MainPageTest(WebDriver driver) {

        this.driver = driver;
    }

    //локаторы  ACCORDION BUTTON "СКОЛЬКО ЭТО СТОИТ?"
    private By accordionButtonWhatPrice = By.xpath(".//*[@id='accordion__heading-0']");
    private By answerQuestionWhatPrice = By.xpath(".//*[@id='accordion__panel-0']");

    //локаторы  ACCORDION BUTTON "ВЫ ПРИВОЗИТЕ ЗАРЯДКУ ВМЕСТЕ С САМОКАТОМ?"
    private By accordionButtonChargeWithScooter = By.xpath(".//*[@id='accordion__heading-5']");
    private By answerButtonChargeWithScooter =By.xpath(".//*[@id='accordion__panel-5']");

    //СКРОЛЛ СТРАНИЦЫ
    public void scrollPaigeMain() throws InterruptedException {
        WebElement element = driver.findElement
                (By.xpath(".//*[@id='root']/div/div[1]/div[4]/div[2]/div[5]/button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(1000);
    }
// методы для ACCORDION COMPONENT

    //метод для элемента "СКОЛЬКО ЭТО СТОИТ?"
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
    //метод для элемента "ВЫ ПРИВОЗИТЕ ЗАРЯДКУ ВМЕСТЕ С САМОКАТОМ?"
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
}
