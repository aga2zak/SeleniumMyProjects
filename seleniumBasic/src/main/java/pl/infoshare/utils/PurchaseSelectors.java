package pl.infoshare.utils;

public class PurchaseSelectors {
    private String HandbagsLink="//div[contains(@class, 'mainmenu')]//a[text()='Handbags']";
 //   private String VintageChickHandbagLink="div#productsContainer div[item-name='Chic vintage DeVille'] div.store-btn-addtocart";
 //   private String ChickVintageDeVilleLink="div#productsContainer div[item-name='Chic vintage DeVille'] div.store-btn-addtocart";
    private String ChickVintageDeVilleLink="#productsContainer > .col-md-4:nth-child(2) .addToCart";
    private String ShippingCartLink="//*[@id='miniCartSummary']/a[text()='Shopping cart ']";
    private String ChackoutLink=".checkout-bg > a";
 //   private String ChackoutLink="//div[contains(@class, 'shop-cart')]//a[text()='Checkout']";
    private String ProceedTpCheckoutLink=".wc-proceed-to-checkout > a";
    private String FerstNameInput="input[name='customer.billing.firstName']";
    private String LastNameInput="input[name='customer.billing.lastName']";
    private String StreetInput="input[name='customer.billing.address']";
    private String CityInput="input[name='customer.billing.city']";
    private String CountrySelect="select[name='customer.billing.country']";
    private String StateInput="input[name='customer.billing.stateProvince']";
    private String PostalCodeInput="input[name='customer.billing.postalCode']";
    private String EmailInput="input[name='customer.emailAddress']";
    private String PhoneNumberInput="input[name='customer.billing.phone']";
    private String SubmitOrderButton="#submitOrder";

    public String getHandbagsLink() {
        return HandbagsLink;
    }

    public String getChickVintageDeVilleLink() {
        return ChickVintageDeVilleLink;
    }

    public String getShippingCartLink() {
        return ShippingCartLink;
    }

    public String getChackoutLink() {
        return ChackoutLink;
    }

    public String getProceedTpCheckoutLink() {
        return ProceedTpCheckoutLink;
    }

    public String getFerstNameInput() {
        return FerstNameInput;
    }

    public String getLastNameInput() {
        return LastNameInput;
    }

    public String getStreetInput() {
        return StreetInput;
    }

    public String getCityInput() {
        return CityInput;
    }

    public String getCountrySelect() {
        return CountrySelect;
    }

    public String getStateInput() {
        return StateInput;
    }

    public String getPostalCodeInput() {
        return PostalCodeInput;
    }

    public String getEmailInput() {
        return EmailInput;
    }

    public String getPhoneNumberInput() {
        return PhoneNumberInput;
    }

    public String getSubmitOrderButton() {
        return SubmitOrderButton;
    }
}
