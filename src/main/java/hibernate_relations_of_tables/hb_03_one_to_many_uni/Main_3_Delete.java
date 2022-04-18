package hibernate_relations_of_tables.hb_03_one_to_many_uni;


import hibernate_relations_of_tables.hb_04_one_to_many_bi.entity.Department;
import hibernate_relations_of_tables.hb_04_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main_3_Delete {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate_03_one_to_many_uni.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {

            session = factory.getCurrentSession();
            session.beginTransaction();

            int idForGetEmp = 1;

            Employee employee = session.get(Employee.class,idForGetEmp);

            /*
            If we delete employee cascade do not work, because he do not have reference to department.
            But if we delete Department, Employees will be delete too, because cascade work in this situation.
             */

            session.delete(employee);

            session.getTransaction().commit();
            System.out.println(">>>>> Done!");

        } finally {
            session.close();
            factory.close();
        }

    }
}
