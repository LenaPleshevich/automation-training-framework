package task.com.epam.service;

import task.com.epam.model.Email;

public class EmailCreator {
    public static Email withEmptyText(String email){
        return new Email(email);
    }
}
