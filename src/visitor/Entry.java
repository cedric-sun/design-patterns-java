package visitor;

import java.util.Iterator;

public abstract class Entry implements Visitee {
    public abstract String getName();

    public abstract int getSize();

    public Entry add(Entry entry) throws NotDirException {
        throw new NotDirException();
    }

    public Iterator iterator() throws NotDirException {
        throw new NotDirException();
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", getName(), getSize());
    }
}