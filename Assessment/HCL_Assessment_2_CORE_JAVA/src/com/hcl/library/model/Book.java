package com.hcl.library.model;

public class Book extends LibraryItem {
    String author;
    String ISBN;

    public Book(int id, String title, int year, boolean isAvailable, String author, String ISBN) {
        super(id, title, year, isAvailable);
        this.author = author;
        this.ISBN = ISBN;
    }

    @Override
    double lateFee(int daysLate) {
        return 2.0;
    }

    @Override
    public String toString() {
        return super.toString() + "Book{" +
                "author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }
}
