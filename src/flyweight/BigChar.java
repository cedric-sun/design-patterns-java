package flyweight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BigChar {
    private char c;

    private String value;

    public BigChar(char c) {
        this.c = c;
        try (BufferedReader reader = new BufferedReader(
                new FileReader(String.format(
                        "res/flyweight/big%c.txt", c
                ))
        )) {
            String line;
            StringBuffer buffer = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
                buffer.append(System.lineSeparator());
            }
            value = buffer.toString();
        } catch (IOException e) {
            throw new Error(e);
        }
    }

    public void print() {
        System.out.println(value);
    }
}
