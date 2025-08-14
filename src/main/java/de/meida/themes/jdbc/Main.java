package de.meida.themes.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null) {
                System.out.println("Erfolgreich mit der Datenbank verbunden!");
                // Führen Sie hier Ihre SQL-Befehle aus
            } else {
                System.out.println("Verbindung fehlgeschlagen.");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}