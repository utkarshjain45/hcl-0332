package com.hcl.library.model;

public class DVD extends LibraryItem{
    int durationMinutes;

    public DVD(int id, String title, int year, boolean isAvailable, int durationMinutes) {
        super(id, title, year, isAvailable);
        this.durationMinutes = durationMinutes;
    }

    @Override
    double lateFee(int daysLate) {
        return 5.0;
    }

    @Override
    public String toString() {
        return super.toString() + "DVD{" +
                "durationMinutes=" + durationMinutes +
                '}';
    }
}
