package org.jupiter.pageobjects;

import org.jupiter.AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage extends AbstractComponent {

    WebDriver driver;

    public ShopPage(WebDriver driver) {
        super(driver);
        //initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[@id=\"product-2\"]/div/p/a")
    WebElement stuffedFrog;

    @FindBy(xpath = "//*[@id=\"product-4\"]/div/p/a")
    WebElement fluffyBunny;
    @FindBy(xpath = "//*[@id=\"product-7\"]/div/p/a")
    WebElement valentineBear;
    @FindBy(id = "nav-cart")
    WebElement cart;

    //Method to add items to the cart
    public void addItems(int i, int j, int k) {
        waitForWebElementToAppear(stuffedFrog);
        for (i = 0; i < 2; i++) {
            stuffedFrog.click();
        }
        waitForWebElementToAppear(fluffyBunny);
        for (j = 0; j < 5; j++) {
            fluffyBunny.click();
        }
        waitForWebElementToAppear(valentineBear);
        for (k = 0; k < 3; k++) {
            valentineBear.click();
        }

    }

    //Method to go to Cart page
    public CartPage goToCart() {
        cart.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }
}
