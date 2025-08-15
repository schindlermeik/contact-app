package de.meida.themes.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@FunctionalInterface
public interface ResultTemplate<T> {
    T process(ResultSet rs) throws SQLException;
}
