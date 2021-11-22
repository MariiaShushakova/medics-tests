package com.fin.medics.site.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import com.fin.medics.entities.User;

public class LoginForm extends Form<User> {
    @Css("#id_username")
    public TextField username;
    @Css("#id_password")
    public TextField password;
    @Css(".submit-row input")
    public Button login;
}
