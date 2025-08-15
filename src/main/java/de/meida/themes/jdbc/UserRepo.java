package de.meida.themes.jdbc;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepo {



    public int insertUsers(List<Users> users) {

        String sql = "insert into users (name, email) values (?, ?)";

        // Statement object um daten and die datenbank zu senden: erwarte komplette Sql anweisung
        // PreparedStatement: das erwartet eine vorbereitete sql anweisung mit platzhaltern. daten folgen
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            con.setAutoCommit(false);// Trancaction gestartet
            try {
                for (Users user : users) {
                    ps.setString(1, user.getName());
                    ps.setString(2, user.getEmail());
                    ps.addBatch();
                }

                ps.executeBatch();
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                System.out.println(e.getMessage());
                System.out.println(e.getSQLState());
                System.out.println(e.getErrorCode());
            } finally {
                //con.setAutoCommit(true);
            }

        } catch (SQLException | IOException e) {

            e.printStackTrace();
        }
        return 0;
    }

    public List<Users> findAll() {

        String sql = "select * from users where email = ?";
        List<Users> list = new ArrayList<>();
        // Statement object um daten and die datenbank zu senden: erwarte komplette Sql anweisung
        // PreparedStatement: das erwartet eine vorbereitete sql anweisung mit platzhaltern. daten folgen
        try (Connection con = DatabaseConnection.getConnection();
             Statement stm = con.createStatement();) {

            try (ResultSet rs = stm.executeQuery(sql)) {

                while (rs.next()) {

                    Users users = new Users();
                    users.setId(rs.getLong("id"));
                    users.setName(rs.getString("name"));
                    users.setEmail(rs.getString("email"));
                    list.add(users);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public <T> List<T> queryForList(String sql, Object[] parameters, ResultTemplate<T> result) {

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            if (parameters != null) {
                for (int i = 0; i < parameters.length; i++) {
                    ps.setObject(i + 1, parameters[i]);
                }
            }

            try (ResultSet rs = ps.executeQuery()) {
                List<T> resultList = new ArrayList<>();
                while (rs.next()) {
                    resultList.add(result.process(rs));
                }
                return resultList;
            }

        } catch (SQLException e) {
            System.err.println("Datenbankfehler: " + e.getMessage());
            throw new RuntimeException("Fehler beim Datenbankzugriff.", e);
        } catch (IOException e) {
            throw new RuntimeException("Fehler beim Herstellen der Datenbankverbindung.", e);
        }
    }

    private static Users process(ResultSet rs) throws SQLException {
        Users user = new Users();
        user.setId(rs.getLong("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        return user;
    }


    public static void main(String[] args) {
        UserRepo repo = new UserRepo();
      /*  List<Users> list = List.of(new Users("Peter Pan", "peter@pan.com"),
                new Users("Hans Peter", "hans@peter.com"));

        repo.insertUsers(list);

        //System.out.println(repo.findAll());*/

        String sql = "select * from users where name = ?";
        Object[] para = {"Anna Schmidt"};
        List<Users> result = repo.queryForList(sql, para, UserRepo::process);
        System.out.println(result);
    }

}

