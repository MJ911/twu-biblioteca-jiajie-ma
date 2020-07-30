package com.twu.biblioteca.library;

public abstract class Item {
    protected String itemNo;
    protected boolean isIn;

    public Item(String content, boolean isIn) {
        this.itemNo = content;
        this.isIn = isIn;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public boolean isIn() {
        return isIn;
    }

    public void setIn(boolean in) {
        isIn = in;
    }
}
