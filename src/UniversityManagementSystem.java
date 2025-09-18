// This is for uml understanding and relationships betweem classes
import java.util.ArrayList;
import java.util.List;

// University class (Aggregation relationship with Department)
class University {
    private String name;
    private List<Department> departments; // Aggregation: University has Departments, but Departments can exist independently
    
    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }
    
    public void addDepartment(Department dept) {
        departments.add(dept);
    }
    
    // Getter methods
    public String getName() { return name; }
    public List<Department> getDepartments() { return departments; }
}

// Department class (Aggregation with University, Composition with Course, Association with Professor)
class Department {
    private String name;
    private List<Professor> professors; // Association: Department has Professors
    private List<Course> courses;       // Composition: Department owns Courses
    
    public Department(String name) {
        this.name = name;
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
    }
    
    public void addProfessor(Professor prof) {
        professors.add(prof);
    }
    
    // Stronger Composition: Department creates and owns its Courses
    public void addCourse(String code, String title, Professor instructor) {
        Course course = new Course(code, title, instructor, this);
        courses.add(course);
    }
    
    // Getter methods
    public String getName() { return name; }
    public List<Professor> getProfessors() { return professors; }
    public List<Course> getCourses() { return courses; }
}

// Professor class (Association with Department and Course)
class Professor {
    private String name;
    private String specialty;
    
    public Professor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }
    
    // Getter methods
    public String getName() { return name; }
    public String getSpecialty() { return specialty; }
}

// Course class (Composition with Department, Association with Professor and Student)
class Course {
    private String code;
    private String title;
    private Professor instructor; 
    private Department department; // Now tied strongly to Department
    
    public Course(String code, String title, Professor instructor, Department department) {
        this.code = code;
        this.title = title;
        this.instructor = instructor;
        this.department = department;
    }
    
    // Getter methods
    public String getCode() { return code; }
    public String getTitle() { return title; }
    public Professor getInstructor() { return instructor; }
    public Department getDepartment() { return department; }
}

// Student class (Association relationship with Course)
class Student {
    private String name;
    private List<Course> enrolledCourses; // Association: Student enrolls in Courses
    
    public Student(String name) {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }
    
    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
    }
    
    // Getter methods
    public String getName() { return name; }
    public List<Course> getEnrolledCourses() { return enrolledCourses; }
}

// Main class to demonstrate all relationships
public class UniversityManagementSystem {
    public static void main(String[] args) {
        /*
         * RELATIONSHIP EXPLANATIONS:
         *
         * 1. AGGREGATION: University → Department
         *    - University contains Departments, but Departments can exist independently.
         *
         * 2. COMPOSITION: Department → Course
         *    - Courses are created and owned by Departments.
         *    - Courses cannot exist without a Department.
         *
         * 3. ASSOCIATION: Department → Professor
         *    - Professors are linked to Departments (unidirectional in this code).
         *
         * 4. ASSOCIATION: Course → Professor
         *    - A Course is taught by a Professor.
         *
         * 5. ASSOCIATION: Student → Course
         *    - A Student enrolls in Courses (many-to-many in reality).
         *
         * 6. DEPENDENCY:
         *    - The main method depends on all classes to demonstrate relationships.
         */
        University university = new University("Tech University");
        
        Department csDepartment = new Department("Computer Science");
        Department mathDepartment = new Department("Mathematics");
        
        university.addDepartment(csDepartment);
        university.addDepartment(mathDepartment);
        
        Professor profSmith = new Professor("Dr. Smith", "Algorithms");
        Professor profJohnson = new Professor("Dr. Johnson", "Calculus");
        
        csDepartment.addProfessor(profSmith);
        mathDepartment.addProfessor(profJohnson);
        
        csDepartment.addCourse("CS101", "Introduction to Algorithms", profSmith);
        mathDepartment.addCourse("MATH201", "Advanced Calculus", profJohnson);
        
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");
        
        student1.enrollInCourse(csDepartment.getCourses().get(0));
        student1.enrollInCourse(mathDepartment.getCourses().get(0));
        student2.enrollInCourse(csDepartment.getCourses().get(0));
        
        // Display the university structure
        System.out.println("=== UNIVERSITY MANAGEMENT SYSTEM ===");
        System.out.println("University: " + university.getName());
        System.out.println();
        
        for (Department dept : university.getDepartments()) {
            System.out.println("Department: " + dept.getName());
            
            System.out.println("  Professors:");
            for (Professor prof : dept.getProfessors()) {
                System.out.println("    - " + prof.getName() + " (" + prof.getSpecialty() + ")");
            }
            
            System.out.println("  Courses:");
            for (Course course : dept.getCourses()) {
                System.out.println("    - " + course.getCode() + ": " + course.getTitle() + 
                                 " (Instructor: " + course.getInstructor().getName() + ")");
            }
            System.out.println();
        }
        
        // Display student enrollments
        System.out.println("Student Enrollments:");
        System.out.println(student1.getName() + " is enrolled in:");
        for (Course course : student1.getEnrolledCourses()) {
            System.out.println("  - " + course.getCode() + ": " + course.getTitle());
        }
        
        System.out.println();
        System.out.println(student2.getName() + " is enrolled in:");
        for (Course course : student2.getEnrolledCourses()) {
            System.out.println("  - " + course.getCode() + ": " + course.getTitle());
        }
    }
}