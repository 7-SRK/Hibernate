package Mapping_Relationship.ManyToMany;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


//Student

        //Create and Save Data

//    Student s1 = new Student();
//        s1.setRollNo(3);
//        s1.setName("C");
//        s1.setAge(25);
//        Student s2 = null;

//        Configuration cfg = new Configuration();
//        cfg.configure(); // loads the default hibernate.cfg.xml
//        cfg.addAnnotatedClasses(org.ram.Student.class);

        //SessionFactory sf = cfg.buildSessionFactory();
        //Session session = sf.openSession();

//        Transaction transaction = session.beginTransaction();
//        session.persist(s1); // Save student

        //Fetch Data

        //s1= session.find(Student.class,7);
        //s2 = session.find(Student.class,4);

        //Delete Data

        //session.remove(s1);

//        transaction.commit();
//
//        session.close();
//        sf.close();

        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Lenovo");
        l1.setModel("X1");
        l1.setRam(16);

        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("Lenovo");
        l2.setModel("X1 Carbon");
        l2.setRam(16);

        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setBrand("Asus");
        l3.setModel("TUF");
        l3.setRam(32);

        A a1 = new A();
        a1.setAid(1);
        a1.setAname("A");
        a1.setTech("Java");
        a1.setLaptops(Arrays.asList(l1,l2));

        A a2 = new A();
        a2.setAid(2);
        a2.setAname("B");
        a2.setTech("Python");
        a2.setLaptops(Arrays.asList(l2,l3));

        A a3 = new A();
        a3.setAid(3);
        a3.setAname("C");
        a3.setTech("C++");
        a3.setLaptops(Arrays.asList(l1));

        l1.setA(Arrays.asList(a1,a3));
        l2.setA(Arrays.asList(a1,a2));
        l3.setA(Arrays.asList(a2));

        SessionFactory sf = new Configuration()
                .addAnnotatedClasses(A.class)
                .addAnnotatedClasses(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(a1);
        session.persist(a2);
        session.persist(a3);

        session.persist(l1);
        session.persist(l2);
        session.persist(l3);

        transaction.commit();

        A a5 = session.find(A.class,3);
        System.out.println(a5);

        session.close();
        sf.close();

        //System.out.println(a1);

        }
    }
