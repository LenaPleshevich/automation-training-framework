package com.epam.model;

public class Email {
    private String email;
    private String textWithTotalCost;

    public Email(String email, String textWithTotalCost) {
        this.email = email;
        this.textWithTotalCost = textWithTotalCost;
    }

    public Email(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTextWithTotalCost() {
        return textWithTotalCost;
    }

    public void setTextWithTotalCost(String textWithTotalCost) {
        this.textWithTotalCost = textWithTotalCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email email1 = (Email) o;

        if (!email.equals(email1.email)) return false;
        return textWithTotalCost.equals(email1.textWithTotalCost);
    }

    @Override
    public int hashCode() {
        int result = email.hashCode();
        result = 31 * result + textWithTotalCost.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Email{" +
                "email='" + email + '\'' +
                ", textWithTotalCost='" + textWithTotalCost + '\'' +
                '}';
    }
}
