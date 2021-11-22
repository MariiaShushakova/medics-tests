package com.fin.medics.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.common.Link;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.XPath;
import com.fin.medics.site.custom_el.MedComboBox;
import com.fin.medics.site.forms.AddNewPersonForm;
import com.fin.medics.site.sections.NewPersonRecord;
import com.fin.medics.site.sections.PersonAdminSection;

@JPage(url = "/admin/", title = "Site administration | Django site admin")
public class AdminPage extends WebPage {
    @Css("#site-name a")
    public Label siteName;
    @Css("#user-tools strong")
    public Label userIndicator;

    @XPath("//*[@class= \"model-matriculation\"]//a[text() = \"Matriculation\"]")
    public Link matriculation;
    @XPath("//a[text() = \"Premedical\"]")
    public Link premedical;
    @XPath("//a[text() = \"Candidate of Medicine\"]")
    public Link candidateMed;
    @XPath("//a[text() = \"Candidate of Philosophy\"]")
    public Link candidatePhil;
    @XPath("//a[text() = \"Licentiate of Medicine\"]")
    public Link licentiateMed;
    @XPath("//a[text() = \"Legislation\"]")
    public Link legislation;
    @XPath("//a[text() = \"First public posts\"]")
    public Link fistPost;
    @XPath("//a[text() = \"Persons\"]")
    public Link persons;
    @XPath("//a[text() = \"Doctoral degrees\"]")
    public Link docDegree;
    @XPath("//a[text() = \"Docentships\"]")
    public Link docentships;
    @Css(".app-pages")
    public PersonAdminSection personAdminSection;
    @Css("#person_form")
    public AddNewPersonForm addNewPersonForm;

    @Css("#searchbar")
    public TextField searchBar;
    @XPath("//input[@type='submit']")
    public Button search;
    @Css(".field-name")
    public Link record;

    @Css(".object-tools a")
    public Button addNew;
    @Css(".select2-search__field")
    public MedComboBox selectPerson;
    @Css(".select2-selection__arrow")
    public Button arrow;
    @Css("#id_date")
    public TextField date;
    @Css(".default")
    public Button save;
    @Css(".success")
    public Label success;
    @XPath("//input[@value='Yes, I’m sure']")
    public Button confirmBtn;
    @Css("#result_list tr")
    public Elements<NewPersonRecord> addedPerson;

}
