package subclass;

public class Book {
    private String title;
    private String author;
    private int publicationYear;

    //contructors
    public Book(String title, String author, int publicationYear){
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    //method
    public void displayBookInfo(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publication Year: " + publicationYear);
    }

    public static void main(String[] args){
        /* lab 01: khởi tạo class Book */
        Book book1 = new Book("Harry Potter", "J.K. Rowling", 1997);
        book1.displayBookInfo();
    }
}
