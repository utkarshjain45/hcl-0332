package com.hcl.library.model;

public abstract class LibraryItem implements Comparable<LibraryItem>{
    private int id;
    private String title;
    private int year;
    private boolean isAvailable;

    public LibraryItem(int id, String title, int year, boolean isAvailable) {
        if(title.isBlank()){
            throw new IllegalArgumentException("Title must not be blank");
        }
        if(year < 1900 || year > 2026){
            throw new IllegalArgumentException("Year must be within the range of 1900-2026");
        }
        this.id = id;
        this.title = title;
        this.year = year;
        this.isAvailable = isAvailable;
    }

    abstract double lateFee(int daysLate);

    @Override
    public int compareTo(LibraryItem o) {
        return (this.title).compareTo(o.title);
    }

    @Override
    public String toString() {
        return "LibraryItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", isAvailable=" + isAvailable +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
