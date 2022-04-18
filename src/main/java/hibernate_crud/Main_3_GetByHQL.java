package hibernate_crud;

import hibernate_crud.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main_3_GetByHQL {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession();
            session.beginTransaction();

            List<Employee> listEmployeeAll = session.createQuery("from Employee").getResultList();

            List<Employee> listEmployeeByName = session
                    .createQuery("from Employee " + "where name = 'Alexandr'").getResultList();

            List<Employee> listEmployeeByDepartmentAndSalary = session
                    .createQuery("from Employee " + "where department = 'IT' AND salary>650")
                    .getResultList();

            System.out.println("\nAll Employees:");
            for (Employee e : listEmployeeAll) {
                System.out.println(e);
            }

            System.out.println("\nEmployees by name Alexandr");
            for (Employee e : listEmployeeByName) {
                System.out.println(e);
            }

            System.out.println("\nEmployees by department (IT) and salary (>650):");
            for (Employee e : listEmployeeByDepartmentAndSalary) {
                System.out.println(e);
            }

            session.getTransaction().commit();
            System.out.println(">>>> Done!");
        } finally {
            factory.close();
        }
    }
}
