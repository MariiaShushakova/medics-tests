package com.fin.medics.basic_app;

import com.fin.medics.TestInit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.fin.medics.site.MainSite.aboutPage;
import static com.fin.medics.site.MainSite.homePage;

public class AboutPageTests extends TestInit {
    @BeforeMethod
    public void openWebPage(){
        homePage.open();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".logo")));
        Assert.assertTrue(homePage.logoMedics.isDisplayed());
        homePage.title();
    }

    @Test
    public void openPageTests(){
        homePage.shouldBeOpened();
        homePage.aboutLink.waitDisplayed();
        homePage.aboutLink.click();
        aboutPage.shouldBeOpened();
        Assert.assertTrue(aboutPage.aboutText.isDisplayed());
    }
}
