package com.base2.mantisbt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReportIssuePage {
    private WebDriver driver;

    // Localizadores dos elementos da página
    private By categorySelect = By.id("category_id");
    private By reproducibilitySelect = By.id("reproducibility");
    private By severitySelect = By.id("severity");
    private By prioritySelect = By.id("priority");
    private By summaryInput = By.id("summary");
    private By descriptionInput = By.id("description");
    private By viewStatusSelect = By.name("view_state");
    private By submitReportButton = By.xpath("//input[@class='btn btn-primary btn-white btn-round']");
    private By successMessage = By.cssSelector(".alert-success");


    public ReportIssuePage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCategory(String category) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(categorySelect));
        Select select = new Select(element);
        select.selectByVisibleText(category);
    }

    public void selectReproducibility(String reproducibility) {
        Select select = new Select(driver.findElement(reproducibilitySelect));
        select.selectByVisibleText(reproducibility);
    }

    public void selectSeverity(String severity) {
        Select select = new Select(driver.findElement(severitySelect));
        select.selectByVisibleText(severity);
    }

    public void selectPriority(String priority) {
        Select select = new Select(driver.findElement(prioritySelect));
        select.selectByVisibleText(priority);
    }

    public void selectViewStatus(String viewStatus) {
        Select select = new Select(driver.findElement(viewStatusSelect));
        select.selectByVisibleText(viewStatus);
    }

    public void enterSummary(String summary) {
        driver.findElement(summaryInput).sendKeys(summary);
    }

    public void enterDescription(String description) {
        driver.findElement(descriptionInput).sendKeys(description);
    }

    public void clickSubmitReportButton() {
        driver.findElement(submitReportButton).click();
    }

    public boolean isIssueCreated() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }
}
