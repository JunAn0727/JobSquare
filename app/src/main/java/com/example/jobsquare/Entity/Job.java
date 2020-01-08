package com.example.jobsquare.Entity;

public class Job {
    private String position;
    private String desc;
    private String salary;
    private String requirenment;

    public Job() {
    }

    public Job(String position, String desc, String salary, String requirenment) {
        this.position = position;
        this.desc = desc;
        this.salary = salary;
        this.requirenment = requirenment;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getRequirenment() {
        return requirenment;
    }

    public void setRequirenment(String requirenment) {
        this.requirenment = requirenment;
    }
}
