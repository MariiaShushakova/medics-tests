package com.fin.medics.basic_app;

import com.fin.medics.TestInit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.fin.medics.site.MainSite.chartsPage;
import static com.fin.medics.site.MainSite.homePage;

public class ChartsPageTests extends TestInit {
    @BeforeMethod
    public void openWebPage(){
        homePage.open();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".logo")));
        Assert.assertTrue(homePage.logoMedics.isDisplayed());
        homePage.title();
    }

    @Test
    public void verifyChartsTests() {
        homePage.shouldBeOpened();
        homePage.chartsLink.waitDisplayed();
        homePage.chartsLink.click();
        chartsPage.shouldBeOpened();
        Assert.assertEquals(chartsPage.charts.size(), 5);
    }

    @Test
    public void verifyChartsDataTests() {
        homePage.shouldBeOpened();
        homePage.chartsLink.waitDisplayed();
        homePage.chartsLink.click();
        chartsPage.shouldBeOpened();
        Assert.assertEquals(chartsPage.totalNumbOfGraduates.getText(), "1051");
        Assert.assertEquals(chartsPage.totalNumOfMaleGraduates.getText(), "959");
        Assert.assertEquals(chartsPage.totalNumOfFemaleGraduate.getText(), "92");
        Assert.assertEquals(chartsPage.avgLifeExpectancy.getText(), "57.48 years");
        Assert.assertEquals(chartsPage.avgLifeExpectancyOfMaleGraduates.getText(), "56.56 years");
        Assert.assertEquals(chartsPage.avgLifeExpectancyOfFemaleGraduates.getText(), "68.86 years");
    }
}
