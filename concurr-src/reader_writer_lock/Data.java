package reader_writer_lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Data {
    public final int n;
    private final char[] buffer;

    // embed the read-write lock inside the Data object so that
    // client code (run() method of reader / writer threads)
    // don't need to care about the locking thing
    private final ReadWriteLock rwlock = new ReentrantReadWriteLock();

    public Data(int n) {
        this.n = n;
        this.buffer = new char[n];
        for (int i = 0; i < n; i++) {
            buffer[i] = (char) ('a' + (i % 26));
        }
    }

    // read-only operation
    public char[] getCopy() {
        rwlock.readLock().lock();
        try {
            char[] cpy = new char[n];
            System.arraycopy(buffer, 0, cpy, 0, n);
            return cpy;
        } finally {
            rwlock.readLock().unlock();
        }
    }

    public void write(char[] newContent) {
        rwlock.writeLock().lock();
        try {
            System.arraycopy(newContent, 0, buffer, 0,
                    Math.min(newContent.length, n));
        } finally {
            rwlock.writeLock().unlock();
        }
    }
}
