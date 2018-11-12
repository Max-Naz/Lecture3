package com.qatestlab.lecture3.tests.CreateCategory;

import com.qatestlab.lecture3.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {
    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(css = "button[name='submitLogin']")
    private WebElement submitBtn;

    public void open() {
        driver.get(Properties.getDefaultBaseAdminUrl());
    }

    public void signInToAdminPanel() {
        emailField.sendKeys(Properties.getAdminEmail());
        passwordField.sendKeys(Properties.getAdminPassword());
        submitBtn.click();
    }
}
