package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.entity.Student;
import com.example.util.HibernateUtil;

public class StudentDAO {

    // CREATE
    public void saveStudent(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(student);

        tx.commit();
        session.close();

        System.out.println("Student saved");
    }

    // READ - single student
    public Student getStudent(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Student student = session.get(Student.class, id);

        session.close();
        return student;
    }

    // READ - all students
    public List<Student> getAllStudents() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Student> list = session.createQuery("from Student", Student.class).list();

        session.close();
        return list;
    }

    // UPDATE
    public void updateStudent(int id, String newCity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, id);
        if (student != null) {
            student.setCity(newCity);
            session.update(student);
            System.out.println("Student updated");
        } else {
            System.out.println("Student not found");
        }

        tx.commit();
        session.close();
    }

    // DELETE
    public void deleteStudent(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, id);
        if (student != null) {
            session.delete(student);
            System.out.println("Student deleted");
        } else {
            System.out.println("Student not found");
        }

        tx.commit();
        session.close();
    }
}
