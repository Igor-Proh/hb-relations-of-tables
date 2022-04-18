package hibernate_relations_of_tables.hb_02_one_to_one_bi;


import hibernate_relations_of_tables.hb_02_one_to_one_bi.entity.Detail;
import hibernate_relations_of_tables.hb_02_one_to_one_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main_1_Create {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate_02_one_to_one_bi.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        try {

            Session session = factory.getCurrentSession();

            Employee employee = new Employee("Nik","Petrov",
                    "HR",1500);
            Detail detail = new Detail("Lviv","093-510-**-**",
                    "**@gmail.com");

            session.beginTransaction();

            employee.setEmpDetail(detail);
            detail.setEmployee(employee);
            session.save(detail);

            session.getTransaction().commit();
            System.out.println(">>>>> Done!");

        } finally {
            factory.close();
        }

    }
}
