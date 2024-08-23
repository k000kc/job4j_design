package ru.job4j.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(in);
            Class.forName(properties.getProperty("driver_class"));
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, username, password);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new IllegalStateException("Failed initialize connection", e);
        }
    }

    private void execute(String sql) {
        try (var statment = connection.createStatement()) {
            statment.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createTable(String tableName) {
        execute(String.format(
                "CREATE TABLE IF NOT EXISTS %s()", tableName
        ));
    }

    public void dropTable(String tableName) {
        execute(String.format(
                "DROP TABLE IF EXISTS %s", tableName
        ));
    }

    public void addColumn(String tableName, String columnName, String type) {
        execute(String.format(
                "ALTER TABLE %s ADD COLUMN %s %s",
                tableName, columnName, type
        ));
    }

    public void dropColumn(String tableName, String columnName) {
        execute(String.format(
                "ALTER TABLE %s DROP COLUMN %s",
                tableName, columnName
        ));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        execute(String.format(
                "ALTER TABLE %s RENAME COLUMN %s TO %s",
                tableName, columnName, newColumnName
        ));
    }

    public String getTableScheme(String tableName) throws SQLException {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "SELECT * FROM %s LIMIT 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args)  {
        Properties config = new Properties();
        try (TableEditor tableEditor = new TableEditor(config)) {
            tableEditor.createTable("NewTable");
            System.out.println(tableEditor.getTableScheme("NewTable"));
            tableEditor.addColumn("NewTable", "value", "text");
            System.out.println(tableEditor.getTableScheme("NewTable"));
            tableEditor.renameColumn("NewTable", "value", "new_value");
            System.out.println(tableEditor.getTableScheme("NewTable"));
            tableEditor.dropColumn("NewTable", "new_value");
            System.out.println(tableEditor.getTableScheme("NewTable"));
            tableEditor.dropTable("NewTable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
