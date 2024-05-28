import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    private Connection connection;
    private static DbHelper instance = null;

    private DbHelper() {
        try {
            String connectionString = ConfigReader.getConnectionString();
            if (connectionString != null) {
                // Thêm thuộc tính vào chuỗi kết nối để bỏ qua SSL hoặc cấu hình khác
                connectionString += ";encrypt=true;trustServerCertificate=true;";
                connection = DriverManager.getConnection(connectionString);
            } else {
                System.out.println("Failed to get connection string from config.ini");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DbHelper getInstance() {
        if (instance == null) {
            instance = new DbHelper();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}