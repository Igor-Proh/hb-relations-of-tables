package hibernate_crud;

import hibernate_crud.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main_4_UpdateByIdAndHQL {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession();
            session.beginTransaction();

            // update by Id
            int idForUpdate = 2;
            Employee employee = session.get(Employee.class, idForUpdate);
            employee.setSalary(1100);

            // update by HQL
            session.createQuery("update Employee set salary = 800 where department = 'IT'").executeUpdate();

            session.getTransaction().commit();
            System.out.println(">>>> Done!");

        } finally {
            factory.close();
        }
    }
}
