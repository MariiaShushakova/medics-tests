package com.fin.medics.site.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.XPath;
import com.fin.medics.entities.PersonData;
import com.fin.medics.site.custom_el.MedComboBox;

public class AddNewPersonForm extends Form<PersonData> {
    @Css("#id_name")
    public TextField name;
    @Css("#id_gender")
    public Dropdown gender;
    @Css("#id_place_of_birth")
    public TextField placeOfBirth;
    @Css("#id_birth")
    public TextField dateBirth;
    @Css("#id_death")
    public TextField dateDeath;
//    @XPath("//*[@aria-labelledby='select2-id_father-container']")
//    public MedComboBox fatherComboBox;
//    @XPath("//*[@aria-labelledby='select2-id_mother-container']")
//    public MedComboBox motherComboBox;
    @Css("#id_social_class")
    public Dropdown socialClass;
    @Css("#id_language")
    public Dropdown language;
    @Css("#id_retirement")
    public TextField dateRetirement;

    @Css(".default")
    public Button saveBtn;
    @Css(".deletelink")
    public Button deleteBtn;
}
