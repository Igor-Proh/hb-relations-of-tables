package hibernate_relations_of_tables.hb_04_one_to_many_bi;


import hibernate_relations_of_tables.hb_04_one_to_many_bi.entity.Department;
import hibernate_relations_of_tables.hb_04_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main_3_Delete {
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

            int idForGetEmp = 1;

            Employee employee = session.get(Employee.class,idForGetEmp);

            session.delete(employee);       // Attention to CASCADE !!!

            session.getTransaction().commit();
            System.out.println(">>>>> Done!");

        } finally {
            session.close();
            factory.close();
        }

    }
}
