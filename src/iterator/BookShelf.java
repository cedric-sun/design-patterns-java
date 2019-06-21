package iterator;

public class BookShelf implements Collection {
    private Book[] books;
    private int last = 0;

    public BookShelf(int maxSize) {
        books = new Book[maxSize];
    }

    public Book getBookAt(int i) {
        return books[i];
    }

    public void appendBook(Book book) {
        this.books[last++] = book;
    }

    public int getLength() {
        return last;
    }

    @Override
    public Iterator iterator() {
        return new BoolShelfIterator(this);
    }
}
