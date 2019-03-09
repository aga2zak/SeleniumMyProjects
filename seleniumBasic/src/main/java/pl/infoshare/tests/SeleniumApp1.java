package pl.infoshare.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.infoshare.pages.*;


public class SeleniumApp1 {
    private WebDriver driver;
    private BasePage basePage;


    @Before
    public void startBrowser() {
        driver = new ChromeDriver();
        this.basePage = new BasePage(driver);
    }

    @After
    public void closeBrowser() {
        basePage.close();
    }

    @Test
    public void purchase() {
        MainPage mainPage = new MainPage(driver);
        mainPage.ChooseHandbagsCategory();

        HandbagCatalouqePage handbagCatalouqePage = new HandbagCatalouqePage(driver);
        handbagCatalouqePage.addToCart();
        handbagCatalouqePage.proceedToCheckout();

        ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(driver);
        reviewYourOrderPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.sectionFullName();
        checkoutPage.sectionCountryState();
        checkoutPage.subbmitOrder();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        Assert.assertNotNull("order is null", orderConfirmationPage.readOrderNumber());
        try {
            Assert.assertNotEquals("string not the same", "Order completed", orderConfirmationPage.readOrderCompleted());
        }
        catch (AssertionError e) {
            System.out.println(e);
        }

        Assert.assertEquals("string not the same", "Order completed", orderConfirmationPage.readOrderCompleted());


    }

}
