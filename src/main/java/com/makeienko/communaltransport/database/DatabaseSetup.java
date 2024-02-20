package com.makeienko.communaltransport.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseSetup {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS myDatabase");

            stmt.executeUpdate("USE myDatabase");

            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS communal_transport (" +
                    "id BIGINT NOT NULL AUTO_INCREMENT," +
                    "from_place VARCHAR(255)," +
                    "to_place VARCHAR(255)," +
                    "departure_time DATETIME," +
                    "arrival_time DATETIME," +
                    "number_of_transfers INT," +
                    "travel_time VARCHAR(255)," +
                    "walk_time VARCHAR(255)," +
                    "delay_report VARCHAR(255)," +
                    "estimated_delay VARCHAR(255)," +
                    "is_favourite BOOLEAN," +
                    "PRIMARY KEY (id)" +
                    ")");

            stmt.executeUpdate("INSERT INTO communal_transport (from_place, to_place, departure_time, arrival_time, number_of_transfers, travel_time, walk_time, delay_report, estimated_delay, is_favourite) VALUES " +
                    "('My Lovely Street 1', 'Fantasy Avenue 2', '2024-02-20 08:00:00', '2024-02-20 09:00:00', 1, '01:00:00', '00:10:00', NULL, NULL, 0)," +
                    "('Crazy fogs Boulevard 3', 'Curve Lane 4', '2024-02-20 10:00:00', '2024-02-20 11:30:00', 2, '01:30:00', '00:15:00', 'Delayed by 10 minutes', '00:10:00', 1)," +
                    "('Short Road 5', 'Brake Drive 6', '2024-02-20 12:00:00', '2024-02-20 13:30:00', 2, '01:30:00', '00:20:00', NULL, NULL, 0)," +
                    "('Milky Way 7', 'Jurassic Park 8', '2024-02-20 14:00:00', '2024-02-20 15:30:00', 1, '01:30:00', '00:15:00', 'Delayed by 15 minutes', '00:15:00', 1)");

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
