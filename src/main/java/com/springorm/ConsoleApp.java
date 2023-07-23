package com.springorm;

import com.springorm.dao.StudentDao;
import com.springorm.entities.Student;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsoleApp {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("com/config/config.xml");

        StudentDao studentDao = context.getBean("std", StudentDao.class);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean f = true;

        while (f) {

            System.out.println("Press 1 to add new student:");
            System.out.println("Press 2 to show particular student details: ");
            System.out.println("Press 3 to show all students: ");
            System.out.println("Press 4 to delete a student: ");
            System.out.println("Press 5 to update student details: ");
            System.out.println("Press 6 to exit: ");

            try {
                int op = Integer.parseInt(br.readLine());

                switch (op) {
                    case 1:

                        System.out.println("Enter student id: ");
                        int id = Integer.parseInt(br.readLine());

                        System.out.println("Enter student name: ");
                        String name = br.readLine();

                        System.out.println("Enter student address: ");
                        String address = br.readLine();

                        Student student = new Student(id, name, address);

                        studentDao.insert(student);

                        System.out.println("Added: " + student.getName());

                        break;

                    case 2:

                        System.out.println("Enter student id: ");
                        int stId = Integer.parseInt(br.readLine());

                        Student st = studentDao.getStudent(stId);

                        System.out.println("Id : " + st.getId() + "\nName : " + st.getName() + "\nAddress : " + st.getAddress() + "\n");

                        break;

                    case 3:

                        List<Student> list = studentDao.getStudents();

                        System.out.println(list + "\n");

                        break;

                    case 4:

                        System.out.println("Enter student id: ");
                        int studentId = Integer.parseInt(br.readLine());

                        studentDao.delete(studentId);

                        System.out.println("Deleted...!!");

                        break;

                    case 5:

                        System.out.println("Enter student id: ");
                        int stdId = Integer.parseInt(br.readLine());

                        System.out.println("Enter name to be updated: ");
                        String stName = br.readLine();

                        System.out.println("Enter student address to be updated: ");
                        String stAddress = br.readLine();

                        Student std = new Student(stdId, stName, stAddress);

                        studentDao.updateStudent(std);

                        System.out.println("Updated : " + std);

                        break;

                    case 6:

                        f = false;

                        break;
                }

            } catch (Exception e) {

                System.out.println("Invalid input, try again..!!");

                System.out.println(e.getMessage());
            }
        }
    }
}
