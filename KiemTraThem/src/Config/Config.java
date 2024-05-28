package Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private String url;

    public Config(String filePath) {
        Properties props = new Properties();
        File configFile = new File(filePath);
        // System.out.println("Config file path: " + configFile.getAbsolutePath());
        try (FileInputStream fis = new FileInputStream(configFile)) {
            props.load(fis);
            this.url = props.getProperty("url");
            // System.out.println("URL: " + this.url); // In URL ra để kiểm tra
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not read the config file: " + filePath);
        }
    }

    public String getUrl() {
        return url;
    }
}
