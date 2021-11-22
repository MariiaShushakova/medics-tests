package com.fin.medics.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;

import static com.epam.jdi.uitests.core.interfaces.complex.tables.interfaces.CheckPageTypes.CONTAINS;

@JPage(url = "/about", title = "Medics", urlCheckType = CONTAINS)
public class AboutPage extends WebPage {
    @Css(".mt-3")
    public Text aboutText;
}
