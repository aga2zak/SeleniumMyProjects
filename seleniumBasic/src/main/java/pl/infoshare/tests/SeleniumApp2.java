package pl.infoshare.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.infoshare.catrgories.AddCartTest;
import pl.infoshare.catrgories.PurchaseTests;
import pl.infoshare.dataModels.Address;
import pl.infoshare.dataModels.RegisteredUser;
import pl.infoshare.pages.*;


public class SeleniumApp2 {
    private WebDriver driver;
    private BasePage basePage;
    private Address address;
    private RegisteredUser user;


    @Before
    public void prepareTest() {
        driver = new ChromeDriver();
        this.basePage = new BasePage(driver);
        this.address =  new Address(true);
        this.user = new RegisteredUser(true);

    }

    @After
    public void closeBrowser() {
        basePage.close();
    }

    @Category(PurchaseTests.class)
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
        checkoutPage.sectionFullName(user);
        checkoutPage.sectionCountryState(user);
        checkoutPage.subbmitOrder();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        Assert.assertNotNull("order is null", orderConfirmationPage.readOrderNumber());
        Assert.assertEquals("string not the same", "Order completed", orderConfirmationPage.readOrderCompleted());


    }

    @Category(AddCartTest.class)
    @Test
    public void purchase1() {
        MainPage mainPage = new MainPage(driver);
        mainPage.ChooseHandbagsCategory();

        HandbagCatalouqePage handbagCatalouqePage = new HandbagCatalouqePage(driver);
        handbagCatalouqePage.addToCart();
        handbagCatalouqePage.proceedToCheckout();

        ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(driver);
        reviewYourOrderPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.sectionFullName(user);
        checkoutPage.sectionCountryState(user);
        checkoutPage.subbmitOrder();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        Assert.assertNotNull("order is null", reviewYourOrderPage.isCartContentCorrect());


      //  Assert.assertEquals("string not the same", "Order completed", orderConfirmationPage.readOrderCompleted());

    }

}
