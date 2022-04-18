package hibernate_crud;

import hibernate_crud.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main_5_DeleteByIdAndHQL {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession();
            session.beginTransaction();

            // delete by Id
            int idForUpdate = 6;
            Employee employee = session.get(Employee.class, idForUpdate);
            session.delete(employee);

            // delete by HQL
            session.createQuery("delete Employee where name = 'Elena'").executeUpdate();

            session.getTransaction().commit();
            System.out.println(">>>> Done!");

        } finally {
            factory.close();
        }
    }
}
