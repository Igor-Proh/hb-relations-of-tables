package hibernate_relations_of_tables.hb_01_one_to_one_uni;

import hibernate_relations_of_tables.hb_01_one_to_one_uni.entity.Detail;
import hibernate_relations_of_tables.hb_01_one_to_one_uni.entity.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main_1_Create {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate_01_one_to_one_uni.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        try {

            Session session = factory.getCurrentSession();

            Employee employee = new Employee("Ihor","Prokhnov",
                    "IT",2000);
            Detail detail = new Detail("Kyiv","093-510-**-**",
                    "olegsmirnov@gmail.com");
            employee.setEmpDetail(detail);

            session.beginTransaction();

            session.save(employee);

            session.getTransaction().commit();
            System.out.println(">>>>> Done!");

        } finally {
            factory.close();
        }

    }
}
