package org.jupiter.test;

import org.jupiter.TestComponents.BaseTest;
import org.jupiter.pageobjects.CartPage;
import org.jupiter.pageobjects.ContactPage;
import org.jupiter.pageobjects.ShopPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class JupiterToysTests extends BaseTest {

    int numStuffedFrog = 2;
    int numFluffyBunny = 5;
    int numValentineBear = 3;
    double stuffedFrogPrice = 10.99;
    double fluffyBunnyPrice = 9.99;
    double valentineBearPrice = 14.99;
    double subStuffedFrogPrice;
    double subFluffyBunnyPrice;
    double subValentineBearPrice;
    double totalPrice;


    @BeforeClass(alwaysRun = true)
    public void calculations() {
        subStuffedFrogPrice = stuffedFrogPrice * numStuffedFrog;
        subFluffyBunnyPrice = fluffyBunnyPrice * numFluffyBunny;
        subValentineBearPrice = valentineBearPrice * numValentineBear;
        totalPrice = subStuffedFrogPrice + subFluffyBunnyPrice + subValentineBearPrice;
    }

    @Test()
    public void errorValidation() throws InterruptedException {

        ContactPage contactPage = homePage.goToContactPage();
        contactPage.clickSubmit();
        Assert.assertEquals(contactPage.getErrorForename(), "Forename is required");
        Assert.assertEquals(contactPage.getErrorEmail(), "Email is required");
        Assert.assertEquals(contactPage.getErrorMessage(), "Message is required");
        contactPage.enterMandatoryDetails();
        Thread.sleep(9000);
        Assert.assertTrue(contactPage.isErrorForeNameVisible());
        Assert.assertTrue(contactPage.isErrorEmailVisible());
        Assert.assertTrue(contactPage.isErrorMessageVisible());

    }

    @Test()
    public void verifySuccessSubmission() throws InterruptedException {

        ContactPage contactPage = homePage.goToContactPage();
        contactPage.clickSubmit();
        contactPage.enterMandatoryDetails();
        Thread.sleep(9000);
        Assert.assertEquals(contactPage.getSuccessMessage(), "Thanks Harshanie");

    }

    @Test()
    public void verifyOrderProcess() {

        ShopPage shopPage = homePage.goToShopPage();
        shopPage.addItems(numStuffedFrog, numFluffyBunny, numValentineBear);
        CartPage cartPage = shopPage.goToCart();
        System.out.println(cartPage.verifySubtotal());
        Assert.assertEquals(cartPage.verifySubtotal().get(0), subStuffedFrogPrice);
        Assert.assertEquals(cartPage.verifySubtotal().get(1), subFluffyBunnyPrice);
        Assert.assertEquals(cartPage.verifySubtotal().get(2), subValentineBearPrice);
        Assert.assertEquals(cartPage.verifySubtotal().get(3), totalPrice);


    }
}
