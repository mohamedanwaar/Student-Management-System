package com.example.studentsystem;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private float Gpa;

    public Student(String firstName, String lasrName, String email, float gpa) {
        this.firstName = firstName;
        this.lastName = lasrName;
        this.email = email;
        Gpa = gpa;
    }

    // constructor that take id pf student as parameter
    public Student(int id, String firstName, String lasrName, String email,float gpa) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lasrName;
        this.email = email;
        Gpa = gpa;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getGpa() {
        return Gpa;
    }

    public void setGpa(float gpa) {
        Gpa = gpa;
    }

    @Override
    public String toString()
    {
        /// this is used to print the student object
        return "Student{" +
                ", firstName='" + firstName + '\'' +
                ", lasrName='" + lastName + '\'' +
                ", Gpa=" + Gpa +
                '}';

    }
}
