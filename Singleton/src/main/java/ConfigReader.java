import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final String CONFIG_FILE = "D:\\DesignPattern\\Singleton\\src\\main\\java\\config.ini";

    public static String getConnectionString() {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
            props.load(fis);
            return props.getProperty("ConnectionString");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
