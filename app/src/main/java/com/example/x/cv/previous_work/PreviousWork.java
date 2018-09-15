package com.example.x.cv.previous_work;

public class PreviousWork {

    private String company;
    private String role;
    private String from;
    private String to;

    public PreviousWork(String company, String role, String from, String to) {
        this.company = company;
        this.role = role;
        this.from = from;
        this.to = to;
    }

    public String getCompany() {
        return company;
    }

    public String getRole() {
        return role;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}
