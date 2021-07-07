package bg.codexio;

import bg.codexio.entity.Car;
import bg.codexio.entity.Truck;
import bg.codexio.entity.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("softuni").createEntityManager();
        entityManager.getTransaction().begin();

        Vehicle tesla = new Car(5, "Tesla", "Elon");
        Vehicle porschePanamera = new Car(5, "Porsche Panamera", "Bob");
        Vehicle lolisTruck = new Truck(150, 10, "Loli");

        entityManager.persist(tesla);
        entityManager.persist(porschePanamera);
        entityManager.persist(lolisTruck);

        entityManager.getTransaction().commit();
    }
}
