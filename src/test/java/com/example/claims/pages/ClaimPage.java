package com.example.claims.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClaimPage {

    private final WebDriver driver;
    private final By policyNumber = By.id("policy-number");
    private final By incidentDate = By.cssSelector(".incident-date");
    private final By vehicleReg = By.name("vehicle-reg");
    private final By submit = By.xpath("//button[text()='Submit claim']");

    public ClaimPage(WebDriver driver) {
        this.driver = driver;
    }

    public void report(String policy, String date) {
        driver.findElement(policyNumber).sendKeys(policy);
        driver.findElement(incidentDate).sendKeys(date);
        driver.findElement(submit).click();
    }
}
