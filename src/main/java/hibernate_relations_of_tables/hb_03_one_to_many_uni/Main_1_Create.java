package hibernate_relations_of_tables.hb_03_one_to_many_uni;

import hibernate_relations_of_tables.hb_03_one_to_many_uni.entity.Department;
import hibernate_relations_of_tables.hb_03_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main_1_Create {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate_03_one_to_many_uni.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;

        try {

            session = factory.getCurrentSession();

            Department department = new Department("IT", 300, 1200);
            Employee emp1 = new Employee("Ihor", "Proh", 800);
            Employee emp2 = new Employee("Elena", "Smirnova", 500);

            department.addEmployeeToDepartment(emp1);
            department.addEmployeeToDepartment(emp2);

            session.beginTransaction();
            session.save(department);
            session.getTransaction().commit();
            System.out.println(">>>>> Done!");

        } finally {
            session.close();
            factory.close();
        }

    }
}
