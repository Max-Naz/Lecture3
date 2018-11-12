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
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.open();
        signInPage.signInToAdminPanel();

        AdminPanelPage adminPanelPage = PageFactory.initElements(driver, AdminPanelPage.class);
        adminPanelPage.openCategoryManagementPage();
        adminPanelPage.addNewCategory();
        adminPanelPage.filterCategoriesByName();
        adminPanelPage.FindNewCategory();

        driver.quit();
    }
}
