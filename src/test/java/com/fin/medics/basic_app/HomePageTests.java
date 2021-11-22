package com.fin.medics.basic_app;

import com.fin.medics.TestInit;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.fin.medics.site.MainSite.*;

public class HomePageTests extends TestInit {
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
        Assert.assertTrue(homePage.homeLink.isDisplayed());
        Assert.assertEquals(homePage.homeLink.getAttribute("class"), "links active");
        Assert.assertTrue(homePage.aboutLink.isDisplayed());
        Assert.assertTrue(homePage.chartsLink.isDisplayed());
        Assert.assertTrue(homePage.signInBtn.isDisplayed());
    }

    @SneakyThrows
    @Test
    public void searchingByFullNameTests(){
        homePage.shouldBeOpened();
        homePage.searchField.waitDisplayed();
        homePage.searchField.sendKeys("Himberg Eino Jalmari");
        homePage.searchButton.click();
        homePage.personsList.waitDisplayed();
        homePage.personsList.get(1).waitDisplayed();
        Thread.sleep(1000);
        Assert.assertEquals(homePage.personsList.get(1).name.getText(), "Himberg Eino Jalmari");
        Assert.assertEquals(homePage.personsList.get(1).gender.getText(), "Male");
        Assert.assertEquals(homePage.personsList.get(1).licentiateOfMedicine.getText(), "27 March, 1928");
    }

    @SneakyThrows
    @Test
    public void searchingByOneNameTests(){
        homePage.shouldBeOpened();
        homePage.searchField.waitDisplayed();
        homePage.searchField.sendKeys("Viktor");
        homePage.searchButton.click();
        homePage.personsList.waitDisplayed();
        homePage.personsList.get(1).waitDisplayed();
        Thread.sleep(1000);
        for (int i = 1; i < homePage.personsList.size(); i++) {
            Assert.assertTrue(homePage.personsList.get(i).name.getText().contains("Viktor"));
        }
    }

    @SneakyThrows
    @Test
    public void searchingByIncorrectNameTests(){
        homePage.shouldBeOpened();
        homePage.searchField.waitDisplayed();
        homePage.searchField.sendKeys("Shushakova");
        homePage.searchButton.click();
        homePage.personsList.waitDisplayed();
        Thread.sleep(1000);
        Assert.assertEquals(homePage.personsList.size(), 1);
    }

    @SneakyThrows
    @Test
    public void filteringByGenderTests(){
        homePage.shouldBeOpened();
        homePage.searchField.waitDisplayed();
        homePage.gender.setValue("Gender: Female");
        homePage.searchButton.click();
        homePage.personsList.waitDisplayed();
        Thread.sleep(1000);
        for (int i = 1; i < homePage.personsList.size(); i++) {
            Assert.assertTrue(homePage.personsList.get(i).gender.getText().contains("Female"));
        }
    }

    @SneakyThrows
    @Test
    public void filteringByMultipleVarsTests(){
        homePage.shouldBeOpened();
        homePage.searchField.waitDisplayed();
        homePage.gender.setValue("Gender: Male");
        homePage.socialClass.setValue("Elite");
        homePage.placeOfBirth.setValue("Oulu");
//        homePage.birthFromDate.setValue("29/05/1889");
//        homePage.birthToDate.setValue("30/05/1889");
//        homePage.deathFromDate.setValue("10/04/1919");
//        homePage.deathToDate.setValue("10/04/1919");

        homePage.searchButton.click();
        Thread.sleep(1000);
        homePage.personsList.waitDisplayed();
        homePage.personsList.get(1).waitDisplayed();
        Assert.assertEquals(homePage.personsList.size(), 2);
        homePage.personsList.get(1).clickCenter();

        List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));

        detailPage.shouldBeOpened();
        Assert.assertEquals(detailPage.profileSection.gender.getText(), "Male");
        Assert.assertEquals(detailPage.profileSection.placeOfBirth.getText(), "Oulu");
        Assert.assertEquals(detailPage.profileSection.socialClass.getText(), "elite");
        Assert.assertEquals(detailPage.profileSection.dateOfBirth.getText(), "June 29, 1889");
        Assert.assertEquals(detailPage.profileSection.dateOfDearth.getText(), "April 10, 1919");
    }

    @SneakyThrows
    @Test
    public void paginationTests(){
        homePage.shouldBeOpened();
        homePage.paginationBtns.waitDisplayed();
        Assert.assertEquals(homePage.paginationBtns.get(0).getAttribute("class"), "page-item active");
        Assert.assertEquals(homePage.paginationBtns.get(0).getText(), "1");
        Assert.assertEquals(homePage.paginationBtns.get(1).getAttribute("class"), "page-item");
        Assert.assertEquals(homePage.paginationBtns.get(1).getText(), "2");
        homePage.paginationBtns.get(1).click();
        Thread.sleep(1000);
        Assert.assertEquals(homePage.paginationBtns.get(2).getText(), "2");
        Assert.assertEquals(homePage.paginationBtns.get(2).getAttribute("class"), "page-item active");
        homePage.personsList.waitDisplayed();
    }

    @Test
    public void verifySignInTest(){
        homePage.shouldBeOpened();
        homePage.signInBtn.waitDisplayed();
        homePage.signInBtn.click();
        loginPage.shouldBeOpened();
        loginPage.loginForm.waitDisplayed();
        Assert.assertTrue(loginPage.loginForm.isDisplayed());
    }
}
