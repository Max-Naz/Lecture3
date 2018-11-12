package com.qatestlab.lecture3.tests.CreateCategory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class AdminPanelPage {
   private WebDriver driver;
   private WebDriverWait wait;

   public AdminPanelPage(WebDriver driver) {
       this.driver = driver;
       wait = new WebDriverWait(driver, 10);
   }

   private By subtabAdminCatalogLocator = By.id("subtab-AdminCatalog");

   @FindBy(id = "subtab-AdminCatalog")
   private WebElement catalogMenuItem;

   @FindBy(id = "subtab-AdminCategories")
   private WebElement categoriesMenuItem;

   private By headerCategoryPageLocator = By.id("page-header-desc-category-new_category");

   @FindBy(id = "page-header-desc-category-new_category")
   private WebElement addNewCategoryBtn;

   private By categoryNameFieldLocator = By.id("name_1");

   @FindBy(id = "name_1")
   private WebElement categoryNameField;

   Random random = new Random();
   private int n = random.nextInt(100) + 1;
   private String categoryName = "Test Category - " + n;

   @FindBy(id = "category_form_submit_btn")
   private WebElement saveCategoryBtn;

   private By successAlertMessage= By.xpath("//*[contains(@class,'alert alert-success')]");

   @FindBy(name = "categoryFilter_name")
   private WebElement categoryFilterName;

   @FindBy(id = "submitFilterButtoncategory")
   private WebElement searchFilterBtn;

   private By newCategoryNameLocator = By.xpath("//td[contains(text(), '"+categoryName+"')]");


   public void openCategoryManagementPage() {
       wait.until(ExpectedConditions.visibilityOfElementLocated(subtabAdminCatalogLocator));
       Actions builder = new Actions(driver);
       builder.moveToElement(catalogMenuItem).pause(Duration.ofSeconds(3)).click(categoriesMenuItem).build().perform();
   }

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
