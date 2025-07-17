package Mapping_Relationship.OneToMany;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        A a = new A();
        a.setAid(1);
        a.setAname("A");
        a.setTech("Python");

        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Lenovo");
        l1.setModel("X1 Carbon");
        l1.setRam(16);
        l1.setA(a);

        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("Asus");
        l2.setModel("TUF");
        l2.setRam(32);
        l2.setA(a);

        a.setLaptops(Arrays.asList(l1, l2));

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(A.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(a);
        session.persist(l1);
        session.persist(l2);

        tx.commit();

        A a1 = session.find(A.class,1);
        System.out.println(a1);

        session.close();
        sf.close();
    }
}
