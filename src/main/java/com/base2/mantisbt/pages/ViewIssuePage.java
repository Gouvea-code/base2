package com.base2.mantisbt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ViewIssuePage {
    private WebDriver driver;

    //Localizadores dos elementos
    private By issueSummary = By.xpath("//td[@class='bug-summary']");
    private By successMessage = By.xpath("//p[contains(text(),'Operação realizada com sucesso.')]");

    private By errorMessage = By.xpath("//div[@class='error-info']");

    public ViewIssuePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getIssueSummary() {
        return driver.findElement(issueSummary).getText();
    }
    public boolean isIssueCreated() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }

    public String getErrorMessage() { return  driver.findElement(errorMessage).getText();}
}
