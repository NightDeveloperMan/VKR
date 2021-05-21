package com.website.prostudy.DAO;

import com.website.prostudy.models.People;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;


@Component
public class Dao {


    private static final String URL = "jdbc:postgresql://localhost:5432/people_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD= "123";





    public ArrayList<People> allPeople()
    {
        String SQL = "SELECT * FROM people";
        ArrayList<People> peopleList = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            statement.executeQuery(SQL);
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next())
            {
                People people = new People(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"));
                peopleList.add(people);
            }
        } catch (ClassNotFoundException | SQLException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
        return peopleList;
    }


   public void addPeople(People people)
    {

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO people VALUES(5, ?, ?)");
            statement.setString(1, people.getName());
            statement.setString(2, people.getEmail());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updatePeople(People people)
    {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement =
                    connection.prepareStatement("UPDATE people SET name =?, email=? WHERE id=?");
            statement.setInt(3, people.getId());
            statement.setString(1, people.getName());
            statement.setString(2, people.getEmail());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deletePeople(People people)
    {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement =
                    connection.prepareStatement("DELETE FROM people WHERE id=?");
            statement.setInt(1, people.getId());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }


}
