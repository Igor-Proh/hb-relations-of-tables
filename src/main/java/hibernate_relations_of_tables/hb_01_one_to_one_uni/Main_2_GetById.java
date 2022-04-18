package hibernate_relations_of_tables.hb_01_one_to_one_uni;

import hibernate_relations_of_tables.hb_01_one_to_one_uni.entity.Detail;
import hibernate_relations_of_tables.hb_01_one_to_one_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main_2_GetById {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate_01_one_to_one_uni.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();;

        try {

            session.beginTransaction();

            int idForGet = 1;
            Employee employee = session.get(Employee.class, idForGet);
            System.out.println(employee.getEmpDetail());


            session.getTransaction().commit();
            System.out.println(">>>>> Done!");

        } finally {
            session.close();
            factory.close();
        }

    }
}
