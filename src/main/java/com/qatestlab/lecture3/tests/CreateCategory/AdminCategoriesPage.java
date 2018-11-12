package com.qatestlab.lecture3.tests.CreateCategory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class AdminCategoriesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public AdminCategoriesPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    private By headerCategoryPageLocator = By.cssSelector("#page-header-desc-category-new_category");

    @FindBy(css = "#page-header-desc-category-new_category")
    private WebElement addNewCategoryBtn;

    private By categoryNameFieldLocator = By.cssSelector("#name_1");

    @FindBy(css = "#name_1")
    private WebElement categoryNameField;

    Random random = new Random();
    private int n = random.nextInt(100) + 1;
    private String categoryName = "Test Category - " + n;

    @FindBy(css = "#category_form_submit_btn")
    private WebElement saveCategoryBtn;

    private By successAlertMessage= By.xpath("//*[contains(@class,'alert alert-success')]");

    @FindBy(css = "[name = categoryFilter_name]")
    private WebElement categoryFilterName;

    @FindBy(css = "#submitFilterButtoncategory")
    private WebElement searchFilterBtn;

    private By newCategoryNameLocator = By.xpath("//td[contains(text(), '"+categoryName+"')]");


    public void addNewCategory() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerCategoryPageLocator));
        addNewCategoryBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoryNameFieldLocator));
        categoryNameField.sendKeys(categoryName);
        saveCategoryBtn.click();
    }

    public void filterCategoriesByName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successAlertMessage));
        categoryFilterName.sendKeys(categoryName);
        searchFilterBtn.click();
    }

    public void FindNewCategory() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(newCategoryNameLocator));
    }
}
