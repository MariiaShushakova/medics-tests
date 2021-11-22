package com.fin.medics.site.custom_el;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Input;
import com.epam.jdi.uitests.web.selenium.elements.complex.ComboBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.Selector;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import lombok.SneakyThrows;

public class MedComboBox extends ComboBox {
    private Button entry;
    private Input value;

    @SneakyThrows
    @Override
    public void setValue(String text) {
        Thread.sleep(1000);
        entry = new Button(this.getLocator());
        entry.waitDisplayed();
        entry.click();

        value = new Input(this.getLocator());
        value.input(text);
        Thread.sleep(1500);
        value.sendKeys("\n");
    }
}
