package bg.codexio;

import bg.codexio.entity.Project;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("softuni").createEntityManager();
        entityManager.getTransaction().begin();
/*        Vehicle bike = new Bike();
        Vehicle car = new Car();
        entityManager.persist(bike);
        entityManager.persist(car);*/
        Project project = new Project();
        project.setName("Project1");
        entityManager.persist(project);
        entityManager.getTransaction().commit();
    }
}
