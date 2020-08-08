package ru.netology.sqlUtils;
import lombok.val;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class SqlUtils {
    public static Connection getConnection() throws SQLException {
        final Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/app", "app", "pass");
        return connection;
    }

        public static void cleanDb() throws SQLException {
        String deleteCards = "DELETE FROM cards; ";
        String deleteAuthCodes = "DELETE FROM auth_codes; ";
        String deleteUsers = "DELETE FROM users; ";
        try (val conn = SqlUtils.getConnection();
             val deleteCardsStmt = conn.createStatement();
             val deleteAuthCodesStmt = conn.createStatement();
             val deleteUsersStmt = conn.createStatement();
        ) {
            deleteCardsStmt.executeUpdate(deleteCards);
            deleteAuthCodesStmt.executeUpdate(deleteAuthCodes);
            deleteUsersStmt.executeUpdate(deleteUsers);
        }
    }
}
