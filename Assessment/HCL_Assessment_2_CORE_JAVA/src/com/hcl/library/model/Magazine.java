package com.hcl.library.model;

public class Magazine extends LibraryItem {
    String issueNumber;

    public Magazine(int id, String title, int year, boolean isAvailable, String issueNumber) {
        super(id, title, year, isAvailable);
        this.issueNumber = issueNumber;
    }

    @Override
    double lateFee(int daysLate) {
        return 1.0;
    }

    @Override
    public String toString() {
        return super.toString() + "Magazine{" +
                "issueNumber='" + issueNumber + '\'' +
                '}';
    }
}
