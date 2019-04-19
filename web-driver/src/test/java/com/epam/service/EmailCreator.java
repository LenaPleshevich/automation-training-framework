package com.epam.service;

import com.epam.model.Email;

public class EmailCreator {
    public static Email withEmptyText(String email){
        return new Email(email);
    }
}
