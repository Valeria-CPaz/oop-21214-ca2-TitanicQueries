package com.val;

import com.val.models.Passenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TitanicQueries {

    final String DB_DATABASE = "titanicmanifest";
    final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_DATABASE;
    final String DB_USER = "ValeriaPaz";
    final String DB_PASSWORD = "280585";

    private PreparedStatement getPeopleByName;
    private PreparedStatement getPeopleByGender;
    private PreparedStatement getPeopleByAge;
    private PreparedStatement getPeopleByNameAndGender;

    public TitanicQueries() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // select people by name
            String sqlQuery = "select name, gender, age from titanic WHERE name like ?";
            getPeopleByName = con.prepareStatement(sqlQuery);

            // Selecting people by gender
            sqlQuery = "select name, gender, age from titanic WHERE gender like ?";
            getPeopleByGender = con.prepareStatement((sqlQuery));

            // Selecting people by age
            sqlQuery = "select name, gender, age from titanic WHERE age like ?";
            getPeopleByAge = con.prepareStatement((sqlQuery));

            // Selecting people by name and gender
            sqlQuery = "select name, gender, age from titanic WHERE name like ? AND gender like ?";
            getPeopleByNameAndGender = con.prepareStatement((sqlQuery));

        } catch (SQLException e) {

        } catch (Exception e) {

        }

    }

    public List<Passenger> getPassengersByName(String name) {
        ResultSet resultSet = null;
        List<Passenger> results = null;

        try {
            getPeopleByName.setString(1, "%" + name + "%");

            resultSet = getPeopleByName.executeQuery();

            results = new ArrayList<>();

            while (resultSet.next()) {
                Passenger newPassenger = new Passenger();
                newPassenger.name = resultSet.getString("name");
                newPassenger.gender = resultSet.getString("gender");
                newPassenger.age = resultSet.getInt("age");
                results.add(newPassenger);
            }


        } catch (SQLException e) {

        }

        return results;
    }

    public List<Passenger> getPeopleByGender(String gender) {

        ResultSet resultSet = null;
        List<Passenger> results = null;

        try {

            getPeopleByGender.setString(1, gender);
            resultSet = getPeopleByGender.executeQuery();

            results = new ArrayList<>();

            while (resultSet.next()) {
                Passenger newPassenger = new Passenger();
                newPassenger.name = resultSet.getString("name");
                newPassenger.gender = resultSet.getString("gender");
                newPassenger.age = resultSet.getInt("age");
                results.add(newPassenger);
            }
        } catch (SQLException e) {

        }

        return results;

    }

    public List<Passenger> getPeopleByAge(Integer age) {

        ResultSet resultSet = null;
        List<Passenger> results = null;

        try {

            getPeopleByAge.setInt(1, age);
            resultSet = getPeopleByAge.executeQuery();

            results = new ArrayList<>();

            while (resultSet.next()) {
                Passenger newPassenger = new Passenger();
                newPassenger.name = resultSet.getString("name");
                newPassenger.gender = resultSet.getString("gender");
                newPassenger.age = resultSet.getInt("age");
                results.add(newPassenger);
            }
        } catch (SQLException e) {

        }

        return results;

    }

    public List<Passenger> getPeopleByNameAndGender(String name, String gender) {

        ResultSet resultSet = null;
        List<Passenger> results = null;

        try {

            getPeopleByNameAndGender.setString(1, "%" + name + "%");
            getPeopleByNameAndGender.setString(2, gender);
            resultSet = getPeopleByNameAndGender.executeQuery();

            results = new ArrayList<>();

            while (resultSet.next()) {
                Passenger newPassenger = new Passenger();
                newPassenger.name = resultSet.getString("name");
                newPassenger.gender = resultSet.getString("gender");
                newPassenger.age = resultSet.getInt("age");
                results.add(newPassenger);
            }
        } catch (SQLException e) {

        }

        return results;

    }
}

