package com.fin.medics.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.XPath;

public class ProfileSection extends Section {
    @XPath("//*[text()='Gender: ']/b")
    public Label gender;
    @XPath("//*[text()='Date of birth: ']/b")
    public Label dateOfBirth;
    @XPath("//*[text()='Place of birth: ']/b")
    public Label placeOfBirth;
    @XPath("//*[text()='Social Class: ']/b")
    public Label socialClass;
    @XPath("//*[text()='Date of death: ']/b")
    public Label dateOfDearth;
}
