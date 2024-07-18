package com.base2.mantisbt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    // Localizadores dos elementos da página principal
    private By reportIssueLink = By.linkText("Criar Tarefa");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickReportIssueLink() {
        driver.findElement(reportIssueLink).click();
    }
}
