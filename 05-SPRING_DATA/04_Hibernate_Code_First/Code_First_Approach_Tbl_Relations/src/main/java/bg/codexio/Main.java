package bg.codexio;

import bg.codexio.entity.Batch;
import bg.codexio.entity.Shampoo;
import bg.codexio.entity.ShampooLabel;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("softuni").createEntityManager();
        entityManager.getTransaction().begin();

        Batch batch = new Batch();
        batch.setCreatedOn(new Date());
        entityManager.persist(batch);

        ShampooLabel volumeLabel = new ShampooLabel();
        volumeLabel.setName("Volume");
        entityManager.persist(volumeLabel);

        Shampoo shampoo = new Shampoo();
        shampoo.setWeight(244);
        shampoo.setLabel(volumeLabel);
        shampoo.setBatch(batch);
        entityManager.persist(shampoo);

        ShampooLabel colorLabel = new ShampooLabel();
        colorLabel.setName("Color");
        entityManager.persist(colorLabel);

        Shampoo colorShampoo = new Shampoo();
        colorShampoo.setLabel(colorLabel);
        colorShampoo.setWeight(250);
        colorShampoo.setBatch(batch);
        entityManager.persist(colorShampoo);

        ShampooLabel damagedHairLabel = new ShampooLabel();
        damagedHairLabel.setName("DamagedHair");
        entityManager.persist(damagedHairLabel);

        Shampoo damagedHairShampoo = new Shampoo();
        damagedHairShampoo.setLabel(damagedHairLabel);
        damagedHairShampoo.setWeight(200);
        damagedHairShampoo.setBatch(batch);
        entityManager.persist(damagedHairShampoo);

        ShampooLabel curlyHairLabel = new ShampooLabel();
        curlyHairLabel.setName("CurlyHair");
        entityManager.persist(curlyHairLabel);

        Shampoo curlyHairShampoo = new Shampoo();
        curlyHairShampoo.setLabel(curlyHairLabel);
        curlyHairShampoo.setWeight(280);
        curlyHairShampoo.setBatch(batch);
        entityManager.persist(curlyHairShampoo);

        entityManager.getTransaction().commit();
    }
}
