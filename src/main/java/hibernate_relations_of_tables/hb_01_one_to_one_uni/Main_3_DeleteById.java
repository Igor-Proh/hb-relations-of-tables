package hibernate_relations_of_tables.hb_01_one_to_one_uni;

import hibernate_relations_of_tables.hb_01_one_to_one_uni.entity.Detail;
import hibernate_relations_of_tables.hb_01_one_to_one_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main_3_DeleteById {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate_01_one_to_one_uni.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int idForDelete = 1;
            Employee employee = session.get(Employee.class, idForDelete);

            session.delete(employee);

//              Output in console (cascade delete):
//            Hibernate: delete from employees where id=?
//            Hibernate: delete from details where id=?

            session.getTransaction().commit();
            System.out.println(">>>>> Done!");

        } finally {
            session.close();
            factory.close();
        }

    }
}
