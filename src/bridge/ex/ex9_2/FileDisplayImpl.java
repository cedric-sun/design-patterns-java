package bridge.ex.ex9_2;

import bridge.DisplayImpl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileDisplayImpl extends DisplayImpl {
    BufferedReader br;
    String filename;

    public FileDisplayImpl(String filename) {
        this.filename = filename;
    }

    @Override
    public void rawOpen() {
        System.out.println(String.format("Opening file: %s", filename));
        try {
            br = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            throw new Error(e);
        }
    }

    @Override
    public void rawPrint() {
        String line = null;
        try {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new Error(e);
        }
    }

    @Override
    public void rawClose() {
        System.out.println(String.format("Closing file: %s",filename));
        try {
            br.close();
        } catch (IOException e) {
            throw new Error(e);
        }
    }
}
