package mypack.entity;

public class Animal {
    private int id;
    private int age;
    private String name;

    public Animal(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
