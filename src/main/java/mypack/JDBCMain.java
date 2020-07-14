package mypack;

import mypack.dao.AnimalCRUD;
import mypack.dao.Entities;
import mypack.dao.EntityFactory;
import mypack.entity.Animal;

import java.util.ArrayList;

public class JDBCMain {

    public static void main(String[] args) {
        Entities factory = EntityFactory.getFactory();
        AnimalCRUD animal = factory.getAnimal();
        ArrayList<Animal> a = animal.getByID(0);

//        animal.add(2,"Mursik",3);
//        animal.remove(12);
//        animal.updateAge("Barsik", 2);
        a = animal.getAll();

        for (Animal an : a) {
            System.out.println(an.getId() + " - " + an.getAge() + " - " + an.getName());
        }

    }
}

