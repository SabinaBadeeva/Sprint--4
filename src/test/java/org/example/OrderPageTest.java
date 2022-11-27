package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static java.util.concurrent.TimeUnit.valueOf;

public class OrderPageTest {
    public static OrderPageTest OrderPageTest;
    private WebDriver driver;

    public OrderPageTest(WebDriver driver) {
        this.driver = driver;
    }
    //локаторы  для страницы АВТОРИЗАЦИИ
    //локатор кнопки "Заказать"
    private  By orderButtonTwo = By.xpath(".//*[@id='root']/div/div[1]/div[4]/div[2]/div[5]/button");

    // локатор поля ввода «Имя»
    private By nameField = By.xpath(".//div/div[2]/div[2]/div[1]/input");
    // локатор поля ввода «Фамилия»
    private By secondNameField = By.xpath(".//div/div[2]/div[2]/div[2]/input");
    // локатор поля ввода «Адресс»
    private By addressField = By.xpath(".//div/div[2]/div[2]/div[3]/input");
    // локатор поля  «Станция метро»
    private By metroStationSelect = By.xpath(".//input[@placeholder = '* Станция метро']");

    // локатор поля ввода «Телефон»
    private By telNumberInput = By.xpath(".//div/div[2]/div[2]/div[5]/input");
    // локатор кнопки "Далее"
    private By nextButton = By.xpath(".//*[@id='root']/div/div[2]/div[3]/button");




    //МЕТОДЫ для АВТОРИЗАЦИИ
    public void setUsername(String username) {
        driver.findElement(nameField).sendKeys(username);
    }
    public void setSecondNameField(String secondName) {
        driver.findElement(secondNameField).sendKeys(secondName);
    }
    public void setAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }
    public void choiceMetroSt() {
        driver.findElement(metroStationSelect).click();
    }
    public void inputTelNumber(String telNumber){
        driver.findElement(telNumberInput).sendKeys(telNumber);
    }

    //МЕТОДЫ для КНОПОК
    public  void pushOrderButtonTwo(){
     driver.findElement(orderButtonTwo).click();
    }
    public void setNextButton(){
        driver.findElement(By.xpath(".//*[@id='root']/div/div[2]/div[3]/button")).click();
    }

   //МЕТОД ЗАПОЛНЕНИЯ полей ИМЯ,ФАМИЛИЯ,АДРЕС
    public void login(String username, String secondName, String address) {
        setUsername(username);
        setSecondNameField(secondName);
        setAddressField(address);
    }

    //локаторы  для страницы "ПРО АРЕНДУ"

    //локатор поля КОГДА ПРИВЕЗТИ самокат
    private By whenToDeliverScooterField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By monthContainer = By.xpath(".//div[@class ='react-datepicker__month-container']");

    //локатор поля СРОК АРЕНДЫ
    private By rentalPeriod = By.className("Dropdown-placeholder");
    private By daysTime = By.xpath(".//div[text()='четверо суток']");
    //локатор выбора ЦВЕТ САМОКАТА
    private By checkBoxScooter = By.className("Order_Title__3EKne");
    private By checkBoxColor = By.xpath(".//*[@id='black']");

    //локатор поля КОММЕНТАРИЙ для КУРЬЕРА
    private By commentForCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // локатор кнопки ЗАКАЗАТЬ на странице "ПРО АРЕНДУ"
    private By getOrder  = By.xpath(".//*[@id='root']/div/div[2]/div[3]/button[2]");
    // локатор кнопки ХОТИТЕ ОФОРМИТЬ ЗАКАЗ "ДА"
    private By buttonOrderYes = By.xpath(".//button[text()='Да']");

    // POP-UP "ЗАКАЗ ОФОРМЛЕН
    private By popUpOrder = By.className("Order_ModalHeader__3FDaJ");

//МЕТОДЫ для страницы "ПРО АРЕНДУ"
    //метод выбора "ДАТЫ в КАЛЕНДАРЕ"
    public void choiceDataCalendarDeliverField() {
    driver.findElement(whenToDeliverScooterField).click();
    }
    public void clickNextButtonCalendar(){
        driver.findElement(By.cssSelector(" div > button.react-datepicker__navigation.react-datepicker__navigation--next")).click();
    }
    public void clickMonthContainer(){
        driver.findElement(monthContainer).click();
    }

    public void clickCalendar(){
        choiceDataCalendarDeliverField();
        clickNextButtonCalendar();
        clickMonthContainer();
    }

    //метод выбора поля "СРОК АРЕНДЫ"
    public void setRentalPeriod(){
        driver.findElement(rentalPeriod).click();
    }
    public void setDaysTime(){
        driver.findElement(daysTime).click();
    }
    public void clickDropDownRental(){
        setRentalPeriod();
        setDaysTime();
    }
    //метод выбора CHECKBOX SCOOTER
    public void choiceCheckBoxScooter(){
        driver.findElement(checkBoxScooter).click();
    }
    public void clickCheckBoxColor(){
        driver.findElement(checkBoxColor).click();
    }
    public void clickCheckBoxColorScooter(){
        choiceCheckBoxScooter();
        clickCheckBoxColor();
    }
    //метод поля КОММЕНТАРИЙ для КУРЬЕРА
    public void fillCommentForCourier(String comment){
        driver.findElement(commentForCourier).sendKeys(comment);
    }
    //метод кнопки ЗАКАЗАТЬ на стр. ПРО АРЕНДУ
    public void clickGetOrder(){
        driver.findElement(getOrder).click();
    }
    //метод кнопки ХОТИТЕ СДЕЛАТЬ ЗАКАЗ "ДА"
    public void clickButtonOrderYes(){
        driver.findElement(buttonOrderYes).click();
    }

}
