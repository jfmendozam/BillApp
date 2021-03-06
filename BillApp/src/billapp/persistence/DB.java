package billapp.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jf
 */
public class DB {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    /**
     * Default constructor
     */
    public DB() {
    }

    /**
     * Get connection
     * @return connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Set connection
     * @param connection connection
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * Get Query Statement
     * @return Query Statement
     */
    public Statement getStatement() {
        return statement;
    }

    /**
     * set Query Statement
     * @param statement Query Statement
     */
    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    /**
     * Get Result set
     * @return Result set
     */
    public ResultSet getResultSet() {
        return resultSet;
    }

    /**
     * Set Result set
     * @param resultSet Result set
     */
    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    /**
     * Connect to DB
     * @param dbFilename Database filename (+ path)
     * @return True = connected
     */
    public boolean connectMSAccess(String dbFilename) {
        boolean connected = false;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            this.setConnection(DriverManager.getConnection("jdbc:ucanaccess://" 
                    + dbFilename));
            connected = true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connected;
    }

    /**
     * Work with DB (SELECT, INSERT, UPDATE, DELETE)
     * @param query Query Statement (TABLE)
     * @return True = Successful query
     */
    public boolean execute(String query) {
        boolean result = false;

        try {
            this.setStatement(this.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
            this.getStatement().execute(query);
            this.setResultSet(this.getStatement().getResultSet());
            result = true;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
