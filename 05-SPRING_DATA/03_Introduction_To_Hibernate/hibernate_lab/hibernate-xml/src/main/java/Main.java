import bg.codexio.entity.City;
import bg.codexio.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Session session = new Configuration()
                .configure()
                .buildSessionFactory()
                .openSession();

        Transaction transaction = session.beginTransaction();

        var userToInsert = new User();
        userToInsert.setUsername("Pesho");
        userToInsert.setPassword("12345");
        session.save(userToInsert);

        var secondUserToInsert = new User();
        secondUserToInsert.setUsername("Ani");
        secondUserToInsert.setPassword("44444");
        session.save(secondUserToInsert);

/*        var userToDelete = session.get(User.class, 2);
        session.delete(userToDelete);*/

        var thirdUserToInsert = new User();
        thirdUserToInsert.setUsername("Koko");
        thirdUserToInsert.setPassword("88888");
        session.save(thirdUserToInsert);

        var pesho = session.get(User.class, 1);
        pesho.setUsername("renamed Pesho");

        transaction.commit();

/*        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        var cityQuery = session.createQuery("FROM City c WHERE c.name = :name", City.class);
        cityQuery.setParameter("name", "Sofia");
        var sofiaCity = cityQuery.getSingleResult();

        var manol = new User();
        manol.setUsername("Manol");
        manol.setPassword("333");
        manol.setCity(sofiaCity);

        session.save(manol);

        transaction.commit();*/

        // inner join
//        TypedQuery<User> query4 = session.createQuery("SELECT u FROM User u " +
//                        "JOIN FETCH u.city c " +
//                        "WHERE c.name = :city_name",
//                User.class);
//        query4.setParameter("city_name", "Bourgas");
//        query4.getResultList().forEach(System.out::println);

        // cross join
//        TypedQuery<User> query3 = session.createQuery("SELECT u FROM User u " +
//                "WHERE u.city.name = :city_name",
//                User.class);
//        query3.setParameter("city_name", "Bourgas");
//        query3.getResultList().forEach(System.out::println);

//        TypedQuery<User> query = session.createQuery("SELECT u FROM User u " +
//                "WHERE u.username = :un",
//                User.class);
//        query.setParameter("un", "renamed Pesho");
//        query.getResultList().forEach(System.out::println);
//
//        // JPQL Language
//        TypedQuery<User> query2 = session.createQuery("SELECT u FROM User u " +
//                        "WHERE u.id > :id",
//                User.class);
//        query2.setParameter("id", 1);
//        query2.getResultList().forEach(System.out::println);

/*        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
        EntityManager session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cr = cb.createQuery(User.class);
        Root<User> root = cr.from(User.class);

        cr.select(root).where(cb.gt(root.get("id"), 4));
        TypedQuery<User> query = session.createQuery(cr);
        query.getResultList().forEach(System.out::println);*/

    }
}
