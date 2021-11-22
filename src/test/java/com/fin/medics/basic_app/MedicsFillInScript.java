package com.fin.medics.basic_app;
import com.fin.medics.TestInit;
import com.fin.medics.entities.User;
import com.fin.medics.site.MainSite;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.*;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.fin.medics.site.MainSite.*;

public class MedicsFillInScript extends TestInit {
    String name;
    String date;
    String date2;

    @SneakyThrows
    @Test
    public void medicsTest() {
        adminPage.open();
        login(new User("Admin"));
        Assert.assertEquals(adminPage.siteName.getText(), "Medics");
        //adminPage.matriculation.click();
        //adminPage.premedical.click();
        //adminPage.candidatePhil.click();
        //adminPage.candidateMed.click();
        //adminPage.licentiateMed.click();
        //adminPage.legislation.click();
        adminPage.fistPost.click();
        //adminPage.persons.click();
        //adminPage.docDegree.click();
        //adminPage.docentships.click();
        readFile();
    }

    @SneakyThrows
    public void addRecord(String name_value, String date_value){
        adminPage.addNew.waitDisplayed();
        adminPage.addNew.click();
        adminPage.arrow.click();
        adminPage.selectPerson.setValue(name_value);
        //update
        //adminPage.searchBar.clear();
        //adminPage.searchBar.sendKeys(name_value);
        //adminPage.search.click();
        //adminPage.record.waitDisplayed();
        //adminPage.record.click();
        //new person
        //adminPage.name.sendKeys(name_value);
        //adminPage.gender.setValue("Male");
        adminPage.date.sendKeys(date_value);
        adminPage.save.click();
        adminPage.success.waitDisplayed();
        Assert.assertTrue(adminPage.success.isDisplayed());

        logger.info("   ADDED: " + name_value + " " + date_value);
    }

    public void readFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\marii\\Documents\\software_project\\women_marticulatio.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 2){
                    name = values[0];
                    date = values[1];

                    String[] nums = date.split("/");
                    if (Integer.parseInt(nums[0]) > 12) {
                        String day_first = nums[1] + "/" + nums[0] + "/" + nums[2];
                        addRecord(name, day_first);
                    } else {
                        addRecord(name, date);
                    }
                }
            }
        }
    }
}
