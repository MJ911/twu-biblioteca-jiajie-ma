package com.twu.biblioteca.console;

public class Option {
    private String optionNo;
    private String description;

    public Option(String optionNo, String description) {
        this.optionNo = optionNo;
        this.description = description;
    }

    public String getOptionNo() {
        return optionNo;
    }

    public void setOptionNo(String optionNo) {
        this.optionNo = optionNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
