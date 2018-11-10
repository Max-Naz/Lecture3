package com.qatestlab.lecture3.tests;

import com.qatestlab.lecture3.DriverManager;
import com.qatestlab.lecture3.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class CreateCategoryTest {
    private static WebDriver driver;

    public static void main(String[] args) {
        driver = DriverManager.getConfiguredDriver(DriverManager.CHROME);
        createCategoryCheck();

//        driver = DriverManager.getDriver(DriverManager.FIREFOX);
//        createCategoryCheck();

//        driver = DriverManager.getDriver(DriverManager.IE);
//        createCategoryCheck();
    }

    public static void createCategoryCheck() {
        //Step-1.
        // Login to admin panel
        driver.get(Properties.getDefaultBaseAdminUrl());

        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("passwd"));
        WebElement submitBtn = driver.findElement(By.cssSelector("button[name='submitLogin']"));

        emailField.sendKeys(Properties.getAdminEmail());
        passwordField.sendKeys(Properties.getAdminPassword());
        submitBtn.click();

        //Step-2.
        // Wait and go to Catalog -> Category
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subtab-AdminCatalog")));

        WebElement catalogMeintab = driver.findElement(By.id("subtab-AdminCatalog"));
        WebElement categoriesSubtab = driver.findElement(By.id("subtab-AdminCategories"));
        Actions builder = new Actions(driver);
        builder.moveToElement(catalogMeintab).pause(Duration.ofSeconds(3)).click(categoriesSubtab).build().perform();

        //Step-3.
        // Wait and click 'add category' btn
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("page-header-desc-category-new_category")));

        WebElement addNewCategoryBtn = driver.findElement(By.id("page-header-desc-category-new_category"));
        addNewCategoryBtn.click();

        //Step-4.
        // Wait
        // Enter category name and click 'save' btn
        // Check the msg about the successful creation of the category
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name_1")));

        Random random = new Random();
        int n = random.nextInt(100) + 1;
        String categoryName = "Test Category - " + n;
        WebElement categoryNameField = driver.findElement(By.id("name_1"));
        categoryNameField.sendKeys(categoryName);

        WebElement saveCategoryBtn = driver.findElement(By.id("category_form_submit_btn"));
        saveCategoryBtn.click();

        //Step-5. Wait and filter categories by name
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'alert alert-success')]")));

        WebElement categoryFilterName = driver.findElement(By.name("categoryFilter_name"));
        categoryFilterName.sendKeys(categoryName);

        WebElement searchFilterBtn = driver.findElement(By.id("submitFilterButtoncategory"));
        searchFilterBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(), '"+categoryName+"')]")));

        driver.quit();
    }


}
