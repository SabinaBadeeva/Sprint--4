package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.sql.Driver;
import java.util.List;


public class OrderPage {
    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    //локаторы  для страницы АВТОРИЗАЦИИ
    //локатор кнопки "Заказать ВВЕРХУ HEADER"
    private  By orderButtonHeader = By.xpath(".//div[1]/div[2]/button[1]");
    //локатор кнопки "Заказать №2"
    private  By orderButtonTwo = By.xpath(".//*[@id='root']/div/div[1]/div[4]/div[2]/div[5]/button");

    // локатор поля ввода «Имя»
    private By nameField = By.xpath(".//div/div[2]/div[2]/div[1]/input");
    // локатор поля ввода «Фамилия»
    private By secondNameField = By.xpath(".//div/div[2]/div[2]/div[2]/input");
    // локатор поля ввода «Адресс»
    private By addressField = By.xpath(".//div/div[2]/div[2]/div[3]/input");
    // локаторы поля  «Станция метро»
    private By metroStationSelect = By.xpath(".//input[@placeholder = '* Станция метро']");
    private By metroStList = By.xpath(".//li");
    private By certainMetroSt = By.xpath(".//li[@data-value='3']");

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
    public void clickMetroStInput() {
        driver.findElement(metroStationSelect).click();
    }
    public void choiceMetroStList(){
        List<WebElement> elements = driver.findElements(metroStList);
        driver.findElement(certainMetroSt).click();
        System.out.println(elements.size());
    }
    public void choiceMetro(){
        clickMetroStInput();
        choiceMetroStList();
    }
    public void inputTelNumber(String telNumber){
        driver.findElement(telNumberInput).sendKeys(telNumber);
    }


    //МЕТОД ожидания ЗАГРУЗКИ внесенных ДАННЫХ
    public void waitForLoadProfileData() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(driver -> (driver.findElement(nextButton).getText() != null
                && !driver.findElement(nextButton).getText().isEmpty()
        ));
    }

    //МЕТОДЫ для КНОПОК
    public void pushButtonHeader(){driver.findElement(orderButtonHeader).click();}
    public  void pushOrderButtonTwo(){
        driver.findElement(orderButtonTwo).click();
    }
    public void setNextButton(){
        driver.findElement(nextButton).click();
    }

    //МЕТОД ЗАПОЛНЕНИЯ полей ИМЯ,ФАМИЛИЯ,АДРЕС
    public void login(String username, String secondName, String address) {
        setUsername(username);
        setSecondNameField(secondName);
        setAddressField(address);
    }

    //локаторы  для страницы "ПРО АРЕНДУ"

    //локаторы поля КОГДА ПРИВЕЗТИ самокат (КАЛЕНДАРЬ)
    private By whenToDeliverScooterField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //локатор поля СРОК АРЕНДЫ
    private By rentalPeriod = By.cssSelector("div.Dropdown-placeholder");
    //private By dataDropDown = By.xpath(".//*[@id='root']/div/div[2]/div[2]/div[2]/div[2]");
    private By daysTime = By.xpath(".//div[text()='четверо суток']");

    //локатор выбора ЦВЕТ САМОКАТА
    private By checkBoxScooter = By.className("Order_Title__3EKne");
    private By checkBoxColor = By.xpath(".//*[@id='black']");

    //локатор поля КОММЕНТАРИЙ для КУРЬЕРА
    private By commentForCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // локатор кнопки ЗАКАЗАТЬ на странице "ПРО АРЕНДУ"
    private By getOrder  = By.xpath(".//*[@id='root']/div/div[2]/div[3]/button[2]");

    //ОЖИДАНИЕ прогрузки ДАННЫХ ЗАКАЗА


    public void waitForLoadOrderData() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(driver -> (driver.findElement(getOrder).getText() != null
                && !driver.findElement(getOrder).getText().isEmpty()
        ));
    }

    // локатор кнопки ХОТИТЕ ОФОРМИТЬ ЗАКАЗ "ДА"
    private By buttonOrderYes = By.xpath(".//button[text()='Да']");

    // POP-UP "ЗАКАЗ ОФОРМЛЕН
    private By popUpOrder = By.className("Order_ModalHeader__3FDaJ");

    //МЕТОДЫ для страницы "ПРО АРЕНДУ"
    //метод выбора "ДАТЫ в КАЛЕНДАРЕ"
    public void choiceDataCalendarDeliverField(String data,String month,String year) {
        WebElement element = driver.findElement(whenToDeliverScooterField);
        element.click();
        element.sendKeys(data,month,year);
        element.sendKeys(Keys.ENTER);
    }
    public void choiceDataCalendDeliverField(String data) {
        WebElement element = driver.findElement(whenToDeliverScooterField);
        element.click();
        element.sendKeys(data);
        element.sendKeys(Keys.ENTER);
    }
    public void choiceDataString(String data){
        choiceDataCalendDeliverField(data);
    }


    //метод выбора поля "СРОК АРЕНДЫ"

    public void setRentalPeriod(){
        driver.findElement(rentalPeriod).click();
    }

    public void daysOrderChoice(){
        driver.findElement(daysTime).click();
    }

    // }
    public void clickDropDownRental(){
        setRentalPeriod();
        daysOrderChoice();
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
    public void commentForCourier(String comment){
        fillCommentForCourier(comment);
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

