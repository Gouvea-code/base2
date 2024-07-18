package com.base2.mantisbt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    // Localizadores dos elementos da página
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("input[type='submit']");
    private By successMessage = By.cssSelector(".alert-success");
    private By failureMessage = By.cssSelector(".alert-danger");

    public By accountLink = By.xpath("//a[contains(text(),'Igor_Gouvea ( Igor Gouvea ) ')]");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("http://mantis-prova.base2.com.br/login_page.php");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(usernameField));
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(loginButton).click();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getSuccessMessage() {
        WebElement messageElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return messageElement.getText();
    }


    public String getFailureMessage() {
        WebElement messageElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(failureMessage));
        return messageElement.getText();
    }

    public boolean isLoggedIn() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(accountLink));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
