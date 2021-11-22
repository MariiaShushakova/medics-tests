package com.fin.medics.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.XPath;

import static com.epam.jdi.uitests.core.interfaces.complex.tables.interfaces.CheckPageTypes.CONTAINS;

@JPage(url = "/charts", title = "Medics", urlCheckType = CONTAINS)
public class ChartsPage extends WebPage {
    @Css(".row")
    public Elements<Label> charts;

    @XPath("//*[text()='1051']")
    public Label totalNumbOfGraduates;
    @XPath("//*[text()='959']")
    public Label totalNumOfMaleGraduates;
    @XPath("//*[text()='92']")
    public Label totalNumOfFemaleGraduate;
    @XPath("//*[text()='57.48 years']")
    public Label avgLifeExpectancy;
    @XPath("//*[text()='56.56 years']")
    public Label avgLifeExpectancyOfMaleGraduates;
    @XPath("//*[text()='68.86 years']")
    public Label avgLifeExpectancyOfFemaleGraduates;
}
