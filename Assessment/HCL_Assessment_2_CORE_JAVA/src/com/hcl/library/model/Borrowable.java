package com.hcl.library.model;

public interface Borrowable {
    boolean isAvailable();
    void borrow();
    void giveback();

    //LibraryItem implements it
    //Use toString everywhere
}
