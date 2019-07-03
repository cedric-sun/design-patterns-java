package composite;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
    private String name;
    private List<Entry> dir = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int sz = 0;
        for (Entry entry : dir) {
            sz += entry.getSize();
        }
        return sz;
    }

    @Override
    public Entry add(Entry entry) {
        dir.add(entry);
        return this;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for (Entry entry : dir) {
            entry.printList(prefix + "/" + name);
        }
    }
}
