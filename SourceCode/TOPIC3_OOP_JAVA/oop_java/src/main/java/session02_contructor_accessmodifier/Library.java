package session02_contructor_accessmodifier;

public class Library {
    // method displayBookInfo
    public void displayBookInfo(Book book) {
        // xet null de tranh bi loi nullPointerException
        if (book == null) {
            System.out.println("Book object is null");
            return;
        }
        System.out.println(String.format("Title: %s | Author: %s | Year: %d", book.getTitle(), book.getAuthor(),
                book.getPublicationYear()));
    }

    // ham main
    public static void main(String[] args) {
        // khoi tao class book
        Library lib = new Library();

        Book b1 = new Book("Java Core", "James Gosling", 1995);
        Book b2 = new Book("Clean Code", "Robert C. Martin", 2008);
        Book b3 = new Book("Design Patterns", "Erich Gamma", 1994);

        lib.displayBookInfo(b1);
        lib.displayBookInfo(b2);
        lib.displayBookInfo(b3);
    }
}
