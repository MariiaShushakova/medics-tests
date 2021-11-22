package com.fin.medics.admin;

import com.fin.medics.TestInit;
import com.fin.medics.entities.PersonData;
import com.fin.medics.entities.User;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.fin.medics.site.MainSite.adminPage;
import static com.fin.medics.site.MainSite.login;

public class AdminTests extends TestInit {
    PersonData personData = new PersonData();
    String successMsg = "The person “" + personData.name + "” was deleted successfully.";

    @BeforeClass
    public void adminLogInTest(){
        adminPage.open();
        login(new User("Admin"));
        adminPage.shouldBeOpened();
        Assert.assertEquals(adminPage.siteName.getText(), "Medics");
    }

    @SneakyThrows
    @Test
    public void addPersonTest(){
        adminPage.persons.click();
        adminPage.addNew.waitDisplayed();
        adminPage.addNew.click();
        adminPage.addNewPersonForm.waitDisplayed();
        adminPage.addNewPersonForm.fill(personData);
        adminPage.addNewPersonForm.saveBtn.click();
        adminPage.success.waitDisplayed();
        Assert.assertTrue(adminPage.success.isDisplayed());
        String topRecord = adminPage.addedPerson.get(1).personName.getText();
        if(topRecord.equals(personData.name)) {
            adminPage.addedPerson.get(1).personName.click();
            adminPage.addNewPersonForm.waitDisplayed();
            adminPage.addNewPersonForm.deleteBtn.click();
            adminPage.confirmBtn.waitDisplayed();
            adminPage.confirmBtn.click();
            adminPage.success.waitDisplayed();
            Assert.assertTrue(adminPage.success.isDisplayed());
            Assert.assertEquals(adminPage.success.getText(), successMsg);
        }else{
            System.out.println("Test data wasn't deleted!");
        }
    }

    @Test
    public void updatePersonTest(){
        adminPage.persons.click();
        adminPage.addNew.waitDisplayed();
        adminPage.addNew.click();
        adminPage.addNewPersonForm.waitDisplayed();
        adminPage.addNewPersonForm.fill(personData);
        adminPage.addNewPersonForm.saveBtn.click();
        adminPage.success.waitDisplayed();
        adminPage.addedPerson.waitDisplayed();
        String topRecord = adminPage.addedPerson.get(1).personName.getText();
        if(topRecord.equals(personData.name)) {
            adminPage.addedPerson.get(1).personName.click();
            adminPage.addNewPersonForm.waitDisplayed();
            adminPage.addNewPersonForm.name.clear();
            adminPage.addNewPersonForm.name.sendKeys("update");
            adminPage.addNewPersonForm.saveBtn.click();
            adminPage.success.waitDisplayed();
            Assert.assertTrue(adminPage.success.isDisplayed());
            adminPage.addedPerson.waitDisplayed();
            Assert.assertEquals(adminPage.addedPerson.get(1).personName.getText(), "update");
            if(adminPage.addedPerson.get(1).personName.getText().equals("update")) {
                adminPage.addNewPersonForm.deleteBtn.click();
                adminPage.confirmBtn.waitDisplayed();
                adminPage.confirmBtn.click();
                adminPage.success.waitDisplayed();
                Assert.assertTrue(adminPage.success.isDisplayed());
                Assert.assertEquals(adminPage.success.getText(), successMsg);
            }
        }else{
            Assert.assertTrue(false);
        }
    }

    @Test
    public void e2ePersonTest(){

    }
}
