package mypack.dao;

import mypack.entity.Animal;

import java.util.ArrayList;
import java.util.List;

public interface AnimalCRUD {
    void add(int id, String name, int age);

    ArrayList<Animal> getAll();

    void updateAge(String name, int age);

    ArrayList<Animal> getByID(int id);

    void remove(int age);
}
