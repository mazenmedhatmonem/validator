package com.jumia.validator.bo;

public class CountryBo {

    private String code;
    private String name;
    private String ValidRegexPattern;

    public CountryBo() {
    }

    public CountryBo(String code, String name, String validRegexPattern) {
        this.code = code;
        this.name = name;
        ValidRegexPattern = validRegexPattern;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValidRegexPattern() {
        return ValidRegexPattern;
    }

    public void setValidRegexPattern(String validRegexPattern) {
        ValidRegexPattern = validRegexPattern;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", ValidRegexPattern='" + ValidRegexPattern + '\'' +
                '}';
    }
}
