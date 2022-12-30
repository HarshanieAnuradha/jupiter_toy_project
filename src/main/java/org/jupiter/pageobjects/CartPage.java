package org.jupiter.pageobjects;

import org.jupiter.AbstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends AbstractComponent {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//table[@class='table table-striped cart-items']")
    WebElement table;
    List<WebElement> rowsList = table.findElements(By.tagName("tr"));


    public List<Double> values = new ArrayList<>();
    List<WebElement> cols = null;


    public List<Double> verifySubtotal() {
        for (int i = 1; i < 4; i++) {
            WebElement row = rowsList.get(i);
            cols = row.findElements(By.tagName("td"));
            String value = cols.get(3).getText();
            value = value.substring(1);
            values.add(Double.parseDouble(value));
        }
        String total = rowsList.get(4).findElement(By.tagName("td")).getText();
        total = total.substring(7);
        double totalPrice = Double.parseDouble(total);
        values.add(totalPrice);
        return values;


    }

}

