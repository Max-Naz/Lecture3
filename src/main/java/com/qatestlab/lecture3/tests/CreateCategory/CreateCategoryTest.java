package com.qatestlab.lecture3.tests.CreateCategory;

import com.qatestlab.lecture3.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CreateCategoryTest {
    private static WebDriver driver;

    public static void main(String[] args) {
        driver = DriverManager.getConfiguredDriver(DriverManager.CHROME);
        createCategoryCheck();
    }

    public static void createCategoryCheck() {
        AdminLoginPage adminLoginPage = PageFactory.initElements(driver, AdminLoginPage.class);
        adminLoginPage.open();
        adminLoginPage.loginToAdminPanel();

        AdminDashboardPage adminDashboardPage = PageFactory.initElements(driver, AdminDashboardPage.class);
        adminDashboardPage.openCategoryManagementPage();

        AdminCategoriesPage adminCategoriesPage = PageFactory.initElements(driver, AdminCategoriesPage.class);
        adminCategoriesPage.addNewCategory();
        adminCategoriesPage.filterCategoriesByName();
        adminCategoriesPage.FindNewCategory();

        driver.quit();
    }
}
