package pl.infoshare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Button;

public class ReviewYourOrderPage extends BasePage{

    private By proceedToCheckoutLink=By.cssSelector(".wc-proceed-to-checkout > a");
    private Button proceedToCheckout;

    public ReviewYourOrderPage(WebDriver driver){
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/cart/shoppingCart.html";
        this.driver.get(this.url);
        this.proceedToCheckout = new Button(this.driver, this.proceedToCheckoutLink);

    }


    public void proceedToCheckout(){
        this.proceedToCheckout.click();
    }
}
