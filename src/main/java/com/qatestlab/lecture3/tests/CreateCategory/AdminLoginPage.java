package com.qatestlab.lecture3.tests.CreateCategory;

import com.qatestlab.lecture3.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminLoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public AdminLoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(css = "#email")
    private WebElement emailField;

    @FindBy(css = "#passwd")
    private WebElement passwordField;

    @FindBy(css = "button[name='submitLogin']")
    private WebElement submitBtn;

    public void open() {
        driver.get(Properties.getDefaultBaseAdminUrl());
    }

    public void loginToAdminPanel() {
        emailField.sendKeys(Properties.getAdminEmail());
        passwordField.sendKeys(Properties.getAdminPassword());
        submitBtn.click();
    }
}
