package pl.infoshare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Button;

public class HandbagCatalouqePage extends BasePage {

    private By ChickVintageDeVilleLink= By.cssSelector("#productsContainer > .col-md-4:nth-child(2) .addToCart");
    private Button addToCart;
    private By ShippingCartLink= By.xpath("//*[@id='miniCartSummary']/a[text()='Shopping cart ']");
    private Button shoppingCart;
    private By ChackoutLink;
    private Button checkout;


    public HandbagCatalouqePage(WebDriver driver){
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/category/handbags.html/ref=c:1";
        this.driver.get(this.url);
        this.addToCart = new Button(this.driver, this.ChickVintageDeVilleLink);

    }

    public void addToCart(){
        this.addToCart.click();
    }

    public void proceedToCheckout(){
        this.shoppingCart = new Button(this.driver, this.ShippingCartLink);
        this.shoppingCart.safeClick();
        this.shoppingCart.click();


        this.ChackoutLink= By.cssSelector(".checkout-bg > a");
        this.checkout= new Button(this.driver, this.ChackoutLink);
        checkout.clickWithJs();
    }

}
