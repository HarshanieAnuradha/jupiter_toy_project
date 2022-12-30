package org.jupiter.pageobjects;

import org.jupiter.AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractComponent {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        //initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "nav-contact")
    WebElement contact;
    @FindBy(id = "nav-shop")
    WebElement shop;


    //Method to go to Contact Page
    public ContactPage goToContactPage() {
        contact.click();
        ContactPage contactPage = new ContactPage(driver);
        return contactPage;
    }

    //Method to go to Shop page
    public ShopPage goToShopPage() {
        shop.click();
        ShopPage shopPage = new ShopPage(driver);
        return shopPage;
    }

    //Method to launch the application
    public void goTo() {
        driver.get("http://jupiter.cloud.planittesting.com");
    }


}
















