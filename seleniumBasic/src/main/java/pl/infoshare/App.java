package pl.infoshare;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pl.infoshare.utils.PurchaseSelectors;
import pl.infoshare.utils.SeleniumMethods;

public class App 
{
    public static void main( String[] args ) {

        SeleniumMethods sm = new SeleniumMethods();
        PurchaseSelectors ps = new PurchaseSelectors();
        WebDriver driver= sm.setUrl("http://demo.shopizer.com:8080/shop/");

        sm.findElementByXPath(ps.getHandbagsLink(), driver).click();
        sm.findElementByCss(ps.getChickVintageDeVilleLink(), driver).click();
        sm.findElementByXPath(ps.getShippingCartLink(), driver).click();
        (new Actions(driver)).moveToElement(sm.findElementByXPath(ps.getShippingCartLink(), driver)).click().build().perform();
        sm.findElementByCss(ps.getChackoutLink(), driver).click();
        sm.findElementByCss(ps.getProceedToCheckoutLink(), driver).click();
        sm.findElementByCss(ps.getFerstNameInput(), driver).sendKeys("Jan");
        sm.findElementByCss(ps.getLastNameInput(), driver).sendKeys("Nowak");
        sm.findElementByCss(ps.getStreetInput(), driver).sendKeys("Polna 10/1");
        sm.findElementByCss(ps.getCityInput(), driver).sendKeys("Gdynia");
        sm.findElementByCss(ps.getCountrySelect(), driver).sendKeys("Brasil");
        sm.findElementByCss(ps.getStateInput(), driver).click();
        sm.findElementByCss(ps.getStateInput(), driver).sendKeys("Gdynia");
        sm.findElementByCss(ps.getPostalCodeInput(), driver).sendKeys("11-111");
        sm.findElementByCss(ps.getEmailInput(), driver).sendKeys("test@test.pl");
        sm.findElementByCss(ps.getPhoneNumberInput(), driver).sendKeys("+48 111222333");
        (new Actions(driver)).moveToElement(sm.findElementByCss(ps.getSubmitOrderButton(), driver)).click().build().perform();

        System.out.println(sm.findElementByCss(ps.getOrderIdText(), driver).getText());
        driver.close();
    }
}
