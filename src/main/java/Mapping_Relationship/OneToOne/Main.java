package Mapping_Relationship.OneToOne;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        laptop.setLid(1);
        laptop.setBrand("Lenovo");
        laptop.setModel("X1");
        laptop.setRam(16);

        A a = new A();
        a.setAid(1);
        a.setAname("A");
        a.setTech("Java");
        a.setLaptop(laptop);
        laptop.setA(a);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(A.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(a);

        tx.commit();

        A a1 = session.find(A.class,1);
        System.out.println(a1);

        session.close();
        sf.close();

    }
}
