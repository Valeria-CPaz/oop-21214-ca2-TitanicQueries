package com.val;

import com.val.models.Passenger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.List;

public class TitanicListing extends JFrame {

    String[] columns = new String[]{
            "name", "gender", "age"
    };

    DefaultTableModel model = new DefaultTableModel();


    public TitanicListing() {

        // Selecting by name method
//        retrieveByName();


        // Selecting by gender method
//        retrieveByGender();


        // Selecting by age method
        retrieveByAge();

        // Selecting by name and gender method
//        retrieveByNameAndGender();


    }

    private void tableModel(DefaultTableModel model, JTable table, List<Passenger> passengers) {

        for (Passenger p : passengers) {

            model.addRow(new Object[]{p.name, p.gender, p.age});
        }

        this.add(new JScrollPane(table));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public void retrieveByName() {

        model.setColumnIdentifiers(columns);
        JTable table = new JTable(model);

        TitanicQueries tq = new TitanicQueries();
        List<Passenger> passengers = tq.getPassengersByName("peter");

        tableModel(model, table, passengers);

    }

    public void retrieveByGender() {

        model.setColumnIdentifiers(columns);
        JTable table = new JTable(model);

        TitanicQueries tq2 = new TitanicQueries();
        List<Passenger> passengers = tq2.getPeopleByGender("female");

        tableModel(model, table, passengers);

    }

    public void retrieveByAge() {

        model.setColumnIdentifiers(columns);
        JTable table = new JTable(model);

        TitanicQueries tq3 = new TitanicQueries();
        List<Passenger> passengers = tq3.getPeopleByAge(35);

        tableModel(model, table, passengers);

    }

    private void retrieveByNameAndGender() {

        model.setColumnIdentifiers(columns);
        JTable table = new JTable(model);

        TitanicQueries tq4 = new TitanicQueries();
        List<Passenger> passengers = tq4.getPeopleByNameAndGender("james", "female");

        tableModel(model, table, passengers);
    }


}
