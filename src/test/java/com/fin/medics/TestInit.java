package com.fin.medics;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.settings.WebSettings;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.fin.medics.site.MainSite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;

public class TestInit extends TestNGBase {
    public String hubUrl;
    public WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setUpSuite(ITestContext iTestContext) throws IOException {
        initDriver(iTestContext);
    }

    public void initDriver(ITestContext iTestContext) throws IOException {
//        hubUrl = "http://deawilgrpt001.syngentaaws.org:4444/wd/hub";
//        hubUrl = "http://localhost:4444/wd/hub";
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setBrowserName("chrome");
//        capabilities.setVersion("93.0");
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", false);
//        capabilities.setCapability("acceptInsecureCerts", true);
//        driver = new RemoteWebDriver(URI.create(hubUrl).toURL(), capabilities);
//        driver.manage().window().maximize();

        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe ");
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebSettings.initFromProperties();
        WebSettings.useDriver(() -> driver);
        WebSite.init(MainSite.class);
        iTestContext.setAttribute("driver", driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpTest(Method method) {
        logger.info("Run Test " + method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        logger.info("Tear down");
        //logout();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownSuite() {
        WebSettings.getDriver().close();
    }
}
