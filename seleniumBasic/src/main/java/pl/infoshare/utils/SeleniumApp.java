package pl.infoshare.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumApp {
    public static void main(String[] args) {
        PurchaseSelectors  selector = new PurchaseSelectors();

        String url = "http://demo.shopizer.com:8080/shop/";
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement handbagMenu = driver.findElement(By.xpath(selector.getHandbagsLink()));
        handbagMenu.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        String select = selector.getChickVintageDeVilleLink();
        By cssSelector = By.cssSelector(select);
        ExpectedConditions.elementToBeClickable((cssSelector));


        WebElement chickVintageDeVilleLink = driver.findElement(By.cssSelector(selector.getChickVintageDeVilleLink()));
        chickVintageDeVilleLink .click();


        WebElement cart =
                wait.until((ExpectedConditions.elementToBeClickable((By.xpath(selector.getShippingCartLink())))));
        cart.click();


        Actions carActionSequence = new Actions(driver);
        carActionSequence.moveToElement(cart).click().build().perform();

        WebElement chackoutLink =
                wait.until((ExpectedConditions.elementToBeClickable((By.xpath(selector.getChackoutLink())))));
        chackoutLink.click();

//
//        WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable
//                ((By.xpath(selector.getProceedTpCheckoutLink()))));
//        checkout.click();
//
//        Actions checkoutActions = new Actions(driver);
//        checkoutActions.moveToElement(checkout).click().build().perform();

//        WebElement chackoutLink = driver.findElement(By.xpath(selector.getChackoutLink()));
//        chackoutLink.click();




//        WebElement shippingCartLink= driver.findElement(By.xpath(selectors.getShippingCartLink()));
//        handbagMenu.click();
//
//        WebElement ChackoutLink = driver.findElement(By.xpath(selectors.getChackoutLink()));
//        handbagMenu.click();




    }

}
