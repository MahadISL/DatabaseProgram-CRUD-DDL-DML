// POJO CLASS

public class Employee {

    // Employee Attributes
    private String firstName, lastName, occupation;
    private int employeeID, yearOfJoining;

    // Getter & Setter
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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    public Employee() {
    }

    public Employee(int employeeID, String firstName, String lastName, String occupation, int yearOfJoining) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.occupation = occupation;
        this.yearOfJoining = yearOfJoining;
    }

    // Overriding in-built object method to display object attributes instead of hashcode
    @Override
    public String toString() {
        return "Employee{" +
                ", enroll=" + employeeID +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", occupation='" + occupation + '\'' +
                ", yearOfJoining=" + yearOfJoining +
                '}';
    }
}

