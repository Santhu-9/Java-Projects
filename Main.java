import java.util.*;
import java.util.Scanner;

class Student {

    private int Id;
    private String Name;
    private int Age;

    static ArrayList<Student> students = new ArrayList<>();
    public Student(int Id, String Name, int Age) {
        this.Id = Id;
        this.Name = Name;
        this.Age = Age;
    }
    static int noOfStudents() {
        return students.size();
    }
    static void displayAllStudent() {
        if(noOfStudents() == 0) System.out.println("No Students Found");
        else {
            for(Student i: students){
                System.out.println("ID: " + i.Id + " Name: " + i.Name + " Age: " + i.Age);
            }
        }
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    static void searchStudent(int id) {
        boolean found = false;
        for(Student i: students){
            if(i.Id==id){
                found = true;
                System.out.println("ID: " + i.Id + " Name: " + i.Name + " Age: " + i.Age);
            }
        }
        if(!found) System.out.println("Student Not Found");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by Id");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            if(choice == 1){
                System.out.println("Enter Student Id: ");
                int Id = sc.nextInt();
                System.out.println("Enter Student Name: ");
                sc.nextLine();
                String Name = sc.nextLine();
                System.out.println("Enter Student Age: ");
                int Age = sc.nextInt();

                Student student = new Student(Id, Name, Age);
                student.addStudent(student);
            }
            else if(choice == 2) Student.displayAllStudent();
            else if(choice == 3){
                System.out.println("Enter Student Id: ");
                int Id = sc.nextInt();
                Student.searchStudent(Id);
            }
            else{
                System.out.println("Exiting.....");
                System.exit(0);
            }
        }
    }
}