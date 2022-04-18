package hibernate_relations_of_tables.hb_04_one_to_many_bi;


import hibernate_relations_of_tables.hb_04_one_to_many_bi.entity.Department;
import hibernate_relations_of_tables.hb_04_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main_2_Get {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate_04_one_to_many_bi.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {

            session = factory.getCurrentSession();
            session.beginTransaction();

//          Get Department by ID and inner employees

            int idForGetDep = 1;

            Department department = session.get(Department.class, idForGetDep);

            System.out.println("\nDepartment: " + department);
            System.out.println("\nEmployees: " + department.getEmps());

//          Get Employer and his Department

            int idForGetEmp = 1;

            Employee employee = session.get(Employee.class,idForGetEmp);

            System.out.println("\nEmployer: " + employee);
            System.out.println("Employer Department: " + employee.getDepartment());

            session.getTransaction().commit();
            System.out.println(">>>>> Done!");

        } finally {
            session.close();
            factory.close();
        }

    }
}
