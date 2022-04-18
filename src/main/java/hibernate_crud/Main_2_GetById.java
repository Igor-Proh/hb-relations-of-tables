package hibernate_crud;

import hibernate_crud.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main_2_GetById {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession();

            Employee employee = new Employee("Oleg", "Sidorov", "HR", 750);

            session.beginTransaction();
            session.save(employee);

            int myId = employee.getId();

            Employee tempEmployee = session.get(Employee.class, myId);
            session.getTransaction().commit();

            System.out.println(tempEmployee);
            System.out.println(">>>> Done!");
        } finally {
            factory.close();
        }

    }
}
