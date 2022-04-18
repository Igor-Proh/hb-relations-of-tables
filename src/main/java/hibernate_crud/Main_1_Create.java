package hibernate_crud;

import hibernate_crud.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main_1_Create {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession();

            Employee employee = new Employee("Alex", "Petrov", "IT", 1000);

            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();

            System.out.println(">>>> Done!");
            System.out.println(employee);
        }
        finally {
            factory.close();
        }
    }
}
