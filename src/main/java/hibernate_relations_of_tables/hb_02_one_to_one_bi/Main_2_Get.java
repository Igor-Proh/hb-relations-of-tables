package hibernate_relations_of_tables.hb_02_one_to_one_bi;


import hibernate_relations_of_tables.hb_02_one_to_one_bi.entity.Detail;
import hibernate_relations_of_tables.hb_02_one_to_one_bi.entity.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main_2_Get {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate_02_one_to_one_bi.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            int idForDetail = 3;
            Detail detail = session.get(Detail.class, idForDetail);

            System.out.println(detail.getEmployee());

            session.getTransaction().commit();
            System.out.println(">>>>> Done!");

        } finally {
            session.close();
            factory.close();
        }

    }
}
