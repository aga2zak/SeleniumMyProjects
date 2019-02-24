package pl.infoshare.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumMethods {

    public WebDriver setUrl(String url) {
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }

    public  WebElement findElementByXPath(String xpathSelectorParam , WebDriver driver) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable((By.xpath(xpathSelectorParam))));
        return driver.findElement(By.xpath(xpathSelectorParam));
    }

    public  WebElement findElementByCss(String cssSelectorParam, WebDriver driver) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable((By.cssSelector(cssSelectorParam))));
        return driver.findElement(By.cssSelector(cssSelectorParam));
    }

}
