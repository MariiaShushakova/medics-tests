package com.fin.medics.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.XPath;
import com.fin.medics.site.sections.ProfileSection;

import static com.epam.jdi.uitests.core.interfaces.complex.tables.interfaces.CheckPageTypes.CONTAINS;

@JPage(url = "/details/", title = "Medics", urlCheckType = CONTAINS)
public class DetailPage extends WebPage {
    @XPath("//h5[text()='Profile']/..")
    public ProfileSection profileSection;
}
