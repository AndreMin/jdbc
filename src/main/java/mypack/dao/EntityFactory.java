package mypack.dao;

public class EntityFactory implements Entities {
    private static Entities factory;

    public EntityFactory() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Entities getFactory(){
        if(factory==null){
            factory=new EntityFactory();
        }
        return factory;
    }
@Override
    public AnimalCRUD getAnimal() {
        return new AnimalDB();
    }
}
