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

    public TitanicQueries() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // select people by name
            String sqlQuery = "select name, gender, age from titanic WHERE name like ?";
            getPeopleByName = con.prepareStatement(sqlQuery);

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

            results = new ArrayList<Passenger>();

            while(resultSet.next()) {
                Passenger newPassenger = new Passenger();
                newPassenger.name = resultSet.getString("name");
                newPassenger.gender = resultSet.getString("gender");
                newPassenger.age = resultSet.getInt("age");
                results.add(newPassenger);
            }




        } catch (SQLException e) {

        } catch (Exception e) {

        }

        return results;
    }
}
