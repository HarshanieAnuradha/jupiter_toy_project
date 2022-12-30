package org.jupiter.pageobjects;

import org.jupiter.AbstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage extends AbstractComponent {
    WebDriver driver;

    public ContactPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(linkText = "Submit")
    WebElement submit;

    @FindBy(id = "forename-err")
    WebElement errorForename;
    @FindBy(id = "email-err")
    WebElement errorEmail;
    @FindBy(id = "message-err")
    WebElement errorMessage;
    @FindBy(id = "forename")
    WebElement foreName;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "message")
    WebElement message;
    @FindBy(xpath = ("//*[contains(text(),'Thanks Harshanie')]"))
    WebElement successMessage;


    //Method to submit the form
    public void clickSubmit() {
        waitForWebElementToAppear(submit);
        submit.click();
    }

    //Method to get the error message for ForeName
    public String getErrorForename() {
        waitForWebElementToAppear(errorForename);
        return errorForename.getText();
    }

    //Method to get the error message for Email
    public String getErrorEmail() {
        waitForWebElementToAppear(errorEmail);
        return errorEmail.getText();
    }

    //Method to get the error message for Message
    public String getErrorMessage() {
        waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();
    }

    //Method to enter the mandatory fields
    public void enterMandatoryDetails() {
        waitForWebElementToAppear(foreName);
        foreName.sendKeys("Harshanie");
        email.sendKeys("anuharshichanse@gmail.com");
        message.sendKeys("message text here");
        submit.click();

    }

    //Method to get the success message
    public String getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        //waitForWebElementToAppear(successMessage);
        return successMessage.getText();
    }

    //Method to verify the error message for ForeName is visible
    public boolean isErrorForeNameVisible() {
        try {
            driver.findElement(By.id("forename-err"));
            return false;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return true;
        }
    }

    //Method to verify the error message for Email is visible
    public boolean isErrorEmailVisible() {
        try {
            driver.findElement(By.id("email-err"));
            return false;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return true;
        }
    }

    //Method to verify the error message for Message is visible
    public boolean isErrorMessageVisible() {
        try {
            driver.findElement(By.id("message-err"));
            return false;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return true;
        }
    }

}