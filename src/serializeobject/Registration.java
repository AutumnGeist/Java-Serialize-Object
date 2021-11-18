/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializeobject;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author marilyn
 */
@XmlRootElement(name="Registration", namespace = "serializeobject")
@XmlType(propOrder= {"registrationNumber", "totalHours", "totalCost", "courseList", "payment"})

public class Registration {
    private int registrationNumber;
    private int totalHours;
    private int totalCost;
    private ArrayList<Course> courseList;
    private Payment payment;

    public Registration(int registrationNumber, int totalHours, int totalCost, ArrayList<Course> courseList, Payment payment) {
        this.registrationNumber = registrationNumber;
        this.totalHours = totalHours;
        this.totalCost = totalCost;
        this.courseList = courseList;
        this.payment = payment;
    }

    public Registration() {
    }
    
    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    @XmlElement(name= "Course")
    @XmlElementWrapper(name="Courses")
    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    @XmlElement(name= "Payment")
    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Registration{" + "registrationNumber=" + registrationNumber + ", totalHours=" + totalHours + ", totalCost=" + totalCost + '}';
    }
    
    
}
