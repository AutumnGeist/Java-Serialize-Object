/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializeobject;

import com.google.gson.Gson;
import java.util.ArrayList;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author marilyn
 */
public class SerializeObject {

    /**
     * @param args the command line arguments
     */
    
    //declare files to store JSON and XML data
    private static final String STUDENT_XML = "./student-jaxb.xml";
    private static final String STUDENT_JSON_XML = "./student-json.xml";  
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        //create student object
        Student stud = createStudent();
        stud.setRegistration(createRegistration());
        
        //test if all objects were created successfully
        System.out.println(stud.toString());
        System.out.println(stud.getRegistration().toString());
        System.out.println(stud.getRegistration().getCourseList());
        System.out.println(stud.getRegistration().getPayment().toString());
        
        //serialize student to JSON
        serializeStudentJSON(stud);
        //deserialize JSON to student
        Student fromJSON = deserializeStudentJSON();
        //serialize student to XML
        serializeStudentXML(stud);
        //deserialize XML to student
        Student stud1 = deserializeStudentXML();
       
    }
    
    private static Student createStudent() {
        Student stud = new Student();
        stud.setFirstName("Rose");
        stud.setLastName("Potter");
        stud.setAddress("17 Cherry Lane");
        stud.setCity("Vienna");
        stud.setState("Virginia");
        stud.setZip("22180");
        
        return stud;
    }
    
     private static Registration createRegistration() {
        Registration register = new Registration();
        register.setRegistrationNumber(5556);
        //create ArrayList courses
        register.setCourseList(createCourses());
        //call methods to set total hours and cost
        setTotalHours(register);
        setTotalCost(register);
        //create payment
        register.setPayment(createPayment());
        
        return register;
    }
     
    private static ArrayList<Course> createCourses() {
        //initialize arrayList
        ArrayList<Course> courses = new ArrayList();
        
        //create new course
        Course course1 = new Course();
        course1.setCourseID("MATH105");
        course1.setCourseName("Precalculus");
        course1.setCreditHours(3);
        //add course to ArrayList
        courses.add(course1);
        
        Course course2 = new Course();
        course2.setCourseID("IT207");
        course2.setCourseName("PHP Fundamentals");
        course2.setCreditHours(3);
        courses.add(course2);
        
        Course course3 = new Course();
        course3.setCourseID("ENGH101");
        course3.setCourseName("Composition");
        course3.setCreditHours(3);
        courses.add(course3);
        
        return courses;
        
    }
    
    private static Payment createPayment() {
        Payment pay = new Payment();
        pay.setType("Credit");
        pay.setCardNumber("400461259467000");
        pay.setPin("101");
        
        return pay;
                
    }
    
    //method to set totalHours in Registration object
    private static void setTotalHours(Registration reg) {
        reg.setTotalHours(getTotalHours(reg.getCourseList()));
        
    }
    //method to set totalCost in registration object
    private static void setTotalCost(Registration reg) {
        reg.setTotalCost(getTotalCost(reg.getCourseList()));
    }
    
    //method to calculate totalHours for registration object
    private static int getTotalHours(ArrayList<Course> courses) {
        //iterate through courses ArrayList to get number of credit hours per course
        int totalHours = 0;
        for(int i = 0; i < courses.size(); i++) {
            totalHours += courses.get(i).getCreditHours();           
        }
        
        return totalHours;
    }
    
    //method to calculate totalCost for registration object
    private static int getTotalCost(ArrayList<Course> courses) {
        int cost = 450;
        int totalHours = getTotalHours(courses);
        //total cost is $450 per credit hour * number of credit hours
        int totalCost = cost * totalHours;
        
        return totalCost;
    }
    //converts student object to JSON
    private static void serializeStudentJSON(Student stud) {
        Gson gson = new Gson();
	//Serialization
        String studString = gson.toJson(stud);	  
	System.out.println("STUDENT --> JSON: " + studString);
        //write to file
        try {
            FileWriter writer = new FileWriter(STUDENT_JSON_XML);
            writer.write(studString);
            writer.close();	 
	} catch (IOException e) {
            e.printStackTrace();
	}
               
    } 
    //converts JSON to student object
    private static Student deserializeStudentJSON() {
        Gson gson = new Gson();       
        Student stud = null;	  
        try {	 
            BufferedReader br = new BufferedReader(new FileReader(STUDENT_JSON_XML));
	 
            //convert the json string back to object
            stud = gson.fromJson(br, Student.class);
	 
            System.out.println("JSON --> STUDENT: " + stud);;

	} catch (IOException e) {
            e.printStackTrace();
	}
	 
	return stud;
    }
    
    //converts student object to XML
    private static void serializeStudentXML(Student stud) {
        String STUDENT_XML = "./student-jaxb.xml";
        
        try {
            JAXBContext context = JAXBContext.newInstance(Student.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            //Write to system.out
            System.out.println("STUDENT --> XML: Write to file successful!");
            m.marshal(stud, System.out);
            
            // Write to File
            m.marshal(stud, new File(STUDENT_XML));
            

        } catch (Exception e) {
            System.out.println("Exception -- " + e.getMessage());
        }
           
    }
    
    //converts XML back to Student object
    private static Student deserializeStudentXML() {
        try {
            JAXBContext context = JAXBContext.newInstance(Student.class);
            Unmarshaller um = context.createUnmarshaller();
            Student stud1 = (Student) um.unmarshal(new FileReader(STUDENT_XML));
            
            System.out.println("XML --> STUDENT: " + stud1 + System.lineSeparator() + stud1.getRegistration() + System.lineSeparator() +
                    stud1.getRegistration().getCourseList() + System.lineSeparator() + stud1.getRegistration().getPayment().toString());

            return stud1;
         
        }catch(Exception e) {
            System.out.println("Exception -- " + e.getMessage());
            return null;
        }
        
       
    }
    
}
