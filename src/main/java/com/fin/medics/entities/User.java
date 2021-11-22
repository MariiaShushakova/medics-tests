package com.fin.medics.entities;

import com.epam.commons.DataClass;

public class User extends DataClass {
    public String userName;
    public String password;
    public String userIndicator;

    public User(String userRole) {
        switch (userRole) {
            case "Admin":
                userName = "maria";
                password = "shushakova123";
                userIndicator = "MARIA";
                break;
        }
    }
}
