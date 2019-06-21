package iterator;

public class BoolShelfIterator implements Iterator {
    private BookShelf bookShelf;
    private int i;

    public BoolShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        i =0;
    }

    @Override
    public boolean hasNext() {
        if (i < bookShelf.getLength()) {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        Book book = bookShelf.getBookAt(i++);
        return book;
    }
}
