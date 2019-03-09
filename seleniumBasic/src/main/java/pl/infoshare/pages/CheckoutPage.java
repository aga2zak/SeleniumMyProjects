package pl.infoshare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Button;
import pl.infoshare.elements.Label;
import pl.infoshare.elements.Select;
import pl.infoshare.elements.TextInput;

public class CheckoutPage extends BasePage{

    private By firstNameInput=By.cssSelector("input[name='customer.billing.firstName']");
    private TextInput firstName;
    private By lastNameInput=By.cssSelector("input[name='customer.billing.lastName']");
    private TextInput lastName;
    private By streetInput=By.cssSelector("input[name='customer.billing.address']");
    private TextInput street;
    private By cityInput=By.cssSelector("input[name='customer.billing.city']");
    private TextInput city;
    private By countrySelect;
    private Select country;
    private By stateInput;
    private TextInput state;
    private By postalCodeInput;
    private TextInput postal;
    private By emailInput;
    private TextInput email;
    private By phoneNumberInput;
    private TextInput phoneNumber;
    private By submitOrderButton;
    private Button submitOrder;
    private By orderIdText;
    private Label orderNumber;

    public CheckoutPage(WebDriver driver){
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/order/checkout.html";
        this.driver.get(this.url);
        this.firstName = new TextInput(this.driver, this.firstNameInput);
        this.lastName = new TextInput(this.driver, this.lastNameInput);
        this.street = new TextInput(this.driver, this.streetInput);
        this.city = new TextInput(this.driver, this.cityInput);

    }


    public void sectionFullName(){
        this.firstName.sendKeys("Jan");
        this.lastName.sendKeys("Nowak");
        this.street.sendKeys("Polna 1/1");
        this.city.sendKeys("Gdańsk");
    }

    public void sectionCountryState(){
        this.countrySelect=By.cssSelector("select[name='customer.billing.country']");
        this.country = new Select(this.driver, this.countrySelect);
        this.country.choose("Brazil");

        this.stateInput=By.cssSelector("input[name='customer.billing.stateProvince']");
        this.state= new TextInput(this.driver, this.stateInput);
        this.state.sendKeys("Gdańsk");

        this.postalCodeInput=By.cssSelector("input[name='customer.billing.postalCode']");
        this.postal = new TextInput(this.driver, this.postalCodeInput);
        this.postal.sendKeys("Gdańsk");

        this.emailInput=By.cssSelector("input[name='customer.emailAddress']");
        this.email = new TextInput(this.driver, this.emailInput);
        this.email.sendKeys("test@test.com");

        this.phoneNumberInput=By.cssSelector("input[name='customer.billing.phone']");
        this.phoneNumber = new TextInput(this.driver, this.phoneNumberInput);
        this.phoneNumber.sendKeys("111111111");

    }

//    public String getNumberOrder(){
//      this.submitOrderButton=By.id("submitOrder");
//      this.orderNumber = new Label(this.driver, this.submitOrderButton);
//       return this.orderNumber.read();


    public void subbmitOrder() {
        this.submitOrderButton=By.id("submitOrder");
        this.submitOrder = new Button(this.driver, this.submitOrderButton);
        this.submitOrder.click();

    }

    public String readOrderNumber() {
        this.orderIdText=By.cssSelector("#main-content > div > div > p:nth-child(2)");
        this.orderNumber = new Label(this.driver, this.orderIdText);
        return this.orderNumber.read();
    }
}
