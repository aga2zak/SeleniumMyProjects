package pl.infoshare.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {

    private WebDriver driver;
    private PurchaseSelectors selector;
    private String url;


    @Before
     public void startBrowser() {
         selector = new PurchaseSelectors();
         url = "http://demo.shopizer.com:8080/shop/";
         driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        JavascriptExecutor runner = (JavascriptExecutor) driver;
//        runner.executeScript("return document.readyState");
//        runner.executeScript("return document.readyState").equals("complete");

        wait.until((ExpectedCondition<Boolean>) driver ->
            (runner.executeScript("return document.readyState").equals("complete")));

    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void purchase() {
        driver.get(url);
        driver.manage().window().maximize();

        WebElement handbagMenu = driver.findElement(By.xpath(selector.getHandbagsLink()));
        handbagMenu.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);


        String select = selector.getChickVintageDeVilleLink();
        //By cssSelector = By.cssSelector(select);
        //ExpectedConditions.elementToBeClickable((cssSelector));


        WebElement chickVintageDeVilleLink = driver.findElement(By.cssSelector(selector.getChickVintageDeVilleLink()));
        chickVintageDeVilleLink.click();


        WebElement cart =
                wait.until((ExpectedConditions.elementToBeClickable((By.xpath(selector.getShippingCartLink())))));
        cart.click();


        Actions carActionSequence = new Actions(driver);
        carActionSequence.moveToElement(cart).click().build().perform();

        WebElement chackoutLink =
                wait.until((ExpectedConditions.elementToBeClickable((By.cssSelector(selector.getChackoutLink())))));
        chackoutLink.click();


        WebElement proceedTpCheckoutLink =
                wait.until((ExpectedConditions.elementToBeClickable((By.cssSelector(selector.getProceedToCheckoutLink())))));

        JavascriptExecutor runner = (JavascriptExecutor) driver;
        String script = "arguments[0].click();";
        runner.executeScript(script, proceedTpCheckoutLink);
        //proceedTpCheckoutLink.click();


        WebElement ferstNameInput =
                wait.until((ExpectedConditions.elementToBeClickable((By.cssSelector(selector.getFerstNameInput())))));

        ferstNameInput.sendKeys("Jan");

        WebElement lastNameInput =
                wait.until((ExpectedConditions.elementToBeClickable((By.cssSelector(selector.getLastNameInput())))));

        lastNameInput.sendKeys("Nowak");

        WebElement streetInput =
                wait.until((ExpectedConditions.elementToBeClickable((By.cssSelector(selector.getStreetInput())))));

        streetInput.sendKeys("Polna 10/7");

        WebElement cityInput =
                wait.until((ExpectedConditions.elementToBeClickable((By.cssSelector(selector.getCityInput())))));

        cityInput.sendKeys("Gdynia");

        WebElement countrySelect =
                wait.until((ExpectedConditions.elementToBeClickable((By.cssSelector(selector.getCountrySelect())))));

        countrySelect.sendKeys("Brasil");

        WebElement stateInput =
                wait.until((ExpectedConditions.elementToBeClickable((By.cssSelector(selector.getStateInput())))));

        stateInput.click();
        stateInput.sendKeys("Gdynia");

        WebElement postalCodeInput =
                wait.until((ExpectedConditions.elementToBeClickable((By.cssSelector(selector.getPostalCodeInput())))));

        postalCodeInput.sendKeys("11-111");

        WebElement emailInput =
                wait.until((ExpectedConditions.elementToBeClickable((By.cssSelector(selector.getEmailInput())))));

        emailInput.sendKeys("test@test.com");

        WebElement phoneNumberInput =
                wait.until((ExpectedConditions.elementToBeClickable((By.cssSelector(selector.getPhoneNumberInput())))));

        phoneNumberInput.sendKeys("+48 111222333");


        WebElement cart1 =
                wait.until((ExpectedConditions.elementToBeClickable((By.cssSelector(selector.getSubmitOrderButton())))));

        //submitOrderButton.click();

        Actions submitOrderButton = new Actions(driver);
        submitOrderButton.moveToElement(cart1).click().build().perform();

    }
}
