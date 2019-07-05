package facade.pagemaker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Database {
    private Database() {

    }

    public static Properties getProperties(String dbname) {
        String filename = String.format("test-res/facade-%s.txt", dbname);
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(filename));
        } catch (IOException e) {
            System.err.println(String.format(
                    "File: %s not found.",filename)
            );
        }
        return props;
    }
}
