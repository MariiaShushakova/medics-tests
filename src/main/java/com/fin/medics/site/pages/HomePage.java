package com.fin.medics.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.common.Link;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.XPath;
import com.fin.medics.site.sections.PersonSection;

@JPage(url = "http://128.214.253.175/", title = "Medics")
public class HomePage extends WebPage {
    @Css(".logo")
    public Label logoMedics;
    @XPath("//a[text()='Home']")
    public Link homeLink;
    @XPath("//a[text()='About']")
    public Link aboutLink;
    @XPath("//a[text()='Charts']")
    public Link chartsLink;
    @Css(".sign_in")
    public Button signInBtn;

    @Css("#search_query")
    public TextField searchField;
    @Css(".searchButton")
    public Button searchButton;
    @Css("#persons_list tr")
    public Elements<PersonSection> personsList;

    @Css("#gender_id")
    public Dropdown gender;
    @Css("#social_class")
    public Dropdown socialClass;
    @Css("#place_of_birth")
    public TextField placeOfBirth;
    @Css("#birthFromDate")
    public TextField birthFromDate;
    @Css("#birthToDate")
    public TextField birthToDate;
    @Css("#deathFromDate")
    public TextField deathFromDate;
    @Css("#deathFromDate")
    public TextField deathToDate;

    @Css(".page-item")
    public Elements<Button> paginationBtns;

}
