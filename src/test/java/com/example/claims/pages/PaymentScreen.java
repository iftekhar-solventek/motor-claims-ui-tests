package com.example.claims.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class PaymentScreen {

    private final WebDriver driver;

    @FindAll({@FindBy(css = ".amount"), @FindBy(name = "amount")})
    private WebElement amount;

    public PaymentScreen(WebDriver driver) {
        this.driver = driver;
    }

    public void approve(int value) {
        amount.sendKeys(String.valueOf(value));
        driver.findElement(By.linkText("Approve")).click();
    }
}
