package com.fin.medics.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import com.fin.medics.site.forms.LoginForm;

@JPage(url = "/admin/login/?next=/admin/", title = "Log in | Django site admin")
public class LoginPage extends WebPage {
    @Css("#main")
    public LoginForm loginForm;
}
