/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializeobject;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marilyn
 */
@XmlRootElement(name = "Course")
public class Course {
    private String courseName;
    private String courseID;
    private int creditHours;

    public Course(String courseName, String courseID, int creditHours) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.creditHours = creditHours;
    }

    public Course() {
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    @Override
    public String toString() {
        return "Course{" + "courseName=" + courseName + ", courseID=" + courseID + ", creditHours=" + creditHours + '}';
    }
    
    
    
}
