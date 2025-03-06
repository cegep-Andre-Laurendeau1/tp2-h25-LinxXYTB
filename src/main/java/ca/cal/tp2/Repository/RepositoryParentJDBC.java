package ca.cal.tp2.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class RepositoryParentJDBC {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:mem:tp2iulianmoraru;DB_CLOSE_DELAY=-1";
    static final String USER = "sa";
    static final String PASS = "";
    static Connection conn = null;

    static {
        // STEP 1: Register JDBC driver
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            String sql = "CREATE TABLE AMENDE " +
                    "(fineid INTEGER not NULL, " +
                    " montant NUMERIC(6,2), " +
                    " dateCreation DATE, " +
                    " status BOOLEAN, " +
                    " PRIMARY KEY ( fineid ))";
            statement.executeUpdate(sql);
            statement.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
