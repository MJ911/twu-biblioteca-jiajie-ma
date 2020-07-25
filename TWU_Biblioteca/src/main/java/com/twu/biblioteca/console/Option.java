package com.twu.biblioteca.console;

public class Option {
    private String optionNo;
    private String optionName;
    private String description;

    public Option(String optionNo, String optionName, String description) {
        this.optionNo = optionNo;
        this.optionName = optionName;
        this.description = description;
    }

    public String getOptionNo() {
        return optionNo;
    }

    public void setOptionNo(String optionNo) {
        this.optionNo = optionNo;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
