package com.fin.medics.site;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.fin.medics.site.pages.*;
import com.fin.medics.entities.User;
import lombok.SneakyThrows;
import org.junit.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSite extends WebSite {
    public static MedicsPage medicsPage;
    public static AdminPage adminPage;
    public static LoginPage loginPage;
    public static HomePage homePage;
    public static DetailPage detailPage;
    public static AboutPage aboutPage;
    public static ChartsPage chartsPage;


    @SneakyThrows
    @Step
    public static void login(User user) {
        loginPage.loginForm.waitDisplayed();
        loginPage.loginForm.username.waitDisplayed();
        loginPage.loginForm.username.sendKeys(user.userName);
        loginPage.loginForm.password.waitDisplayed();
        loginPage.loginForm.password.sendKeys(user.password);
        loginPage.loginForm.login.click();
        Thread.sleep(1000);
        adminPage.userIndicator.waitDisplayed();
        Assert.assertEquals(adminPage.userIndicator.getText(), user.userIndicator);
    }
}
