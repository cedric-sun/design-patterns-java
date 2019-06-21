package iterator;

public class App {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Around"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinder"));
        bookShelf.appendBook(new Book("DLL"));
        Iterator it = bookShelf.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            System.out.println(book.getName());
        }
    }
}
