package com.val;

import com.val.models.Passenger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.List;

public class TitanicListing extends JFrame {

//    private PreparedStatement getSurvivalByStatus;

    public TitanicListing() {

        String[] columns = new String[]{
                "name", "gender", "age"
        };

        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columns);

        JTable table = new JTable(model);

//        model.addRow(new Object[]{"testName1", "testGender1", 24});
//        model.addRow(new Object[]{"testName2", "testGender2", 26});
//        model.addRow(new Object[]{"testName3", "testGender3", 26});

        TitanicQueries tq = new TitanicQueries();
        List<Passenger> passengers = tq.getPassengersByName("james");

//        System.out.println("total passengers wis " + passengers.size());


        for(Passenger p : passengers) {

            model.addRow(new Object[]{p.name, p.gender, p.age});
        }



        this.add(new JScrollPane(table));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);


//        final String DB_DATABASE = "titanicmanifest";
//        final String DB_URL = "jdbc:mysql://localhost:3306/titanicmanifest" + DB_DATABASE;
//        final String DB_USER = "ValeriaPaz";
//        final String DB_PASSWORD = "280585";

//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//
//            Statement stmt = con.createStatement();
//            String sqlQuery = "select name, gender, age from titanic WHERE survived = ?";
//            String sqlQuery = "select name, gender, age from titanic WHERE name like ? and survived = ?";
//            getSurvivalByStatus = con.prepareStatement(sqlQuery);
//
//
//            ResultSet rs = stmt.executeQuery(sqlQuery);
//
//            getSurvivalByStatus.setInt(2, 0); // 0 is dead 1 survived
//            getSurvivalByStatus.setString(1, "%michael%");
//
//            ResultSet rs = getSurvivalByStatus.executeQuery();
//
//            while (rs.next()) {
//
//                String name = rs.getString(1);
//                String gender = rs.getString(2);
//                Integer age = rs.getInt(3);
//
//                model.addRow(new Object[]{name, gender, age});
//            }
//
//        } catch (SQLException e) {
//            System.out.println(e.toString());
//
//        } catch (Exception e) {
//
//
//        } finally {
//
//        }


    }
}
