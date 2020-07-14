package mypack.dao;

import mypack.entity.Animal;

import java.sql.*;
import java.util.ArrayList;

public class AnimalDB implements AnimalCRUD {

    private Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testhibernate", "root", "root");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void add(int id,String name, int age) {
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO animal VALUES (?,?,?)");
            statement.setInt(1,id);
            statement.setInt(3, age);
            statement.setString(2, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ArrayList<Animal> getAll() {
        ArrayList<Animal> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement("SELECT * FROM animal");
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                int id = res.getInt(1);
                int age = res.getInt(3);
                String name = res.getString(2);
                Animal an = new Animal(id, age, name);
                list.add(an);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public void updateAge(String name, int age) {
        Connection connection=getConnection();
        PreparedStatement statement=null;
        try {
            statement=connection.prepareStatement("UPDATE animal SET age=? WHERE name=?");
            statement.setInt(1,age);
            statement.setString(2,name);
            statement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
                statement.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

    @Override
    public ArrayList<Animal> getByID(int id) {
        ArrayList<Animal> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement("SELECT * FROM animal where id=?");
            statement.setInt(1, id);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                int age = res.getInt(3);
                String name = res.getString(2);
                Animal an = new Animal(age, name);
                list.add(an);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void remove(int age) {
        Connection connection=getConnection();
        PreparedStatement statement=null;
        try{
            statement=connection.prepareStatement("DELETE FROM animal WHERE age=?");
            statement.setInt(1,age);
            statement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
                statement.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }

    }
}
