package com.fin.medics.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;

public class NewPersonRecord extends Section {
    @Css(".field-name")
    public Label personName;
}
