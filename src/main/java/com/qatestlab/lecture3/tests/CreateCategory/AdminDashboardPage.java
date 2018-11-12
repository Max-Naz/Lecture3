package com.qatestlab.lecture3.tests.CreateCategory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AdminDashboardPage {
   private WebDriver driver;
   private WebDriverWait wait;

   public AdminDashboardPage(WebDriver driver) {
       this.driver = driver;
       wait = new WebDriverWait(driver, 10);
   }

   private By subtabAdminCatalogLocator = By.cssSelector("#subtab-AdminCatalog");

   @FindBy(css = "#subtab-AdminCatalog")
   private WebElement catalogMenuItem;

   @FindBy(css = "#subtab-AdminCategories")
   private WebElement categoriesMenuItem;

   public void openCategoryManagementPage() {
       wait.until(ExpectedConditions.visibilityOfElementLocated(subtabAdminCatalogLocator));
       Actions builder = new Actions(driver);
       builder.moveToElement(catalogMenuItem).pause(Duration.ofSeconds(2)).click(categoriesMenuItem).build().perform();
   }
}
