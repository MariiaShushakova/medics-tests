package com.fin.medics.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.XPath;

public class PersonSection extends Section {
    @XPath("//td[1]")
    public Text name;
    @XPath("//td[2]")
    public Text gender;
    @XPath("//td[3]")
    public Text premedical;
    @XPath("//td[4]")
    public Text licentiateOfMedicine;
    @XPath("//td[5]")
    public Button arrowBtn;
}
