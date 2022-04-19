package hibernate_relations_of_tables.hb_05_many_to_many;

import hibernate_relations_of_tables.hb_05_many_to_many.entity.Child;
import hibernate_relations_of_tables.hb_05_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main_3_GetSection {
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

            int idForGetSection = 4;
            Section section = session.get(Section.class, idForGetSection);

            System.out.println("Section: " + section);
            System.out.println("Section children:" + section.getChildren());

            session.getTransaction().commit();

            System.out.println(">>>> Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
