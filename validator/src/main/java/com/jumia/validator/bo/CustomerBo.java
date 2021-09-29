package com.jumia.validator.bo;


public class CustomerBo {

    private String name;
    private String phoneNumber;
    private boolean isValid;
    private String CountryName;

    public CustomerBo() {
    }

    public CustomerBo(String name, String phoneNumber, boolean isValid, String countryName) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isValid = isValid;
        CountryName = countryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isValid=" + isValid +
                ", CountryName='" + CountryName + '\'' +
                '}';
    }
}
