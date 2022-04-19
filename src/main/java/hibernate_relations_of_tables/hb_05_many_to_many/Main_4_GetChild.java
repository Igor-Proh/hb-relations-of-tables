package hibernate_relations_of_tables.hb_05_many_to_many;

import hibernate_relations_of_tables.hb_05_many_to_many.entity.Child;
import hibernate_relations_of_tables.hb_05_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main_4_GetChild {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate_05_many_to_many.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try {

            session = factory.getCurrentSession();
            session.beginTransaction();

            int idForGetChild = 13;
            Child child = session.get(Child.class, idForGetChild);

            System.out.println("Child: " + child);
            System.out.println("Child sections:" + child.getSections());

            session.getTransaction().commit();

            System.out.println(">>>> Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
