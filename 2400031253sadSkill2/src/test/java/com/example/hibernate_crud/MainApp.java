package com.example.hibernate_crud;

import java.util.List;
import java.util.Scanner;

import com.example.dao.StudentDAO;
import com.example.entity.Student;

public class MainApp {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- STUDENT CRUD MENU ---");
            System.out.println("1. Insert");
            System.out.println("2. View All");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // buffer clear

            switch (choice) {

                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter city: ");
                    String city = sc.nextLine();

                    Student s = new Student(name, city);
                    dao.saveStudent(s);
                    break;

                case 2:
                    List<Student> list = dao.getAllStudents();
                    for (Student st : list) {
                        System.out.println(
                            st.getId() + " " + st.getName() + " " + st.getCity()
                        );
                    }
                    break;

                case 3:
                    System.out.print("Enter student id: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new city: ");
                    String newCity = sc.nextLine();

                    dao.updateStudent(uid, newCity);
                    break;

                case 4:
                    System.out.print("Enter student id to delete: ");
                    int did = sc.nextInt();

                    dao.deleteStudent(did);
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
