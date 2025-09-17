// This is for uml understanding and relationships betweem classes
import java.util.ArrayList;
import java.util.List;

// University class (Composition relationship with Department)
 class University {
    private String name;
    private List<Department> departments; // Composition: University owns Departments
    
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

// Department class (Aggregation relationship with University, Composition with Course, Association with Professor)
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
    
    public void addCourse(Course course) {
        courses.add(course);
    }
    
    // Getter methods
    public String getName() { return name; }
    public List<Professor> getProfessors() { return professors; }
    public List<Course> getCourses() { return courses; }
}

// Professor class (Association relationship with Department and Course)
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

// Course class (Association relationship with Department and Professor, Association with Student)
 class Course {
    private String code;
    private String title;
    private Professor instructor; // Association: Course has an Instructor (Professor)
    
    public Course(String code, String title, Professor instructor) {
        this.code = code;
        this.title = title;
        this.instructor = instructor;
    }
    
    // Getter methods
    public String getCode() { return code; }
    public String getTitle() { return title; }
    public Professor getInstructor() { return instructor; }
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
         * 1. COMPOSITION: University → Department
         *    - Departments cannot exist without a University
         *    - When University is destroyed, Departments are destroyed too
         *    - Strong lifecycle dependency
         */
        University university = new University("Tech University");
        
        /*
         * 2. COMPOSITION: Department → Course
         *    - Courses are created and managed by Departments
         *    - Courses cannot exist without a Department
         */
        Department csDepartment = new Department("Computer Science");
        Department mathDepartment = new Department("Mathematics");
        
        university.addDepartment(csDepartment);
        university.addDepartment(mathDepartment);
        
        /*
         * 3. ASSOCIATION: Department ↔ Professor
         *    - Professors work in Departments but have independent existence
         *    - This is a bidirectional association
         */
        Professor profSmith = new Professor("Dr. Smith", "Algorithms");
        Professor profJohnson = new Professor("Dr. Johnson", "Calculus");
        
        csDepartment.addProfessor(profSmith);
        mathDepartment.addProfessor(profJohnson);
        
        /*
         * 4. ASSOCIATION: Course → Professor
         *    - A Course is taught by a Professor
         *    - This is a unidirectional association
         */
        Course algoCourse = new Course("CS101", "Introduction to Algorithms", profSmith);
        Course calcCourse = new Course("MATH201", "Advanced Calculus", profJohnson);
        
        csDepartment.addCourse(algoCourse);
        mathDepartment.addCourse(calcCourse);
        
        /*
         * 5. ASSOCIATION: Student → Course
         *    - A Student enrolls in Courses
         *    - This is a unidirectional association
         *    - In a more complex system, this could be a many-to-many relationship
         */
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");
        
        student1.enrollInCourse(algoCourse);
        student1.enrollInCourse(calcCourse);
        student2.enrollInCourse(algoCourse);
        
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