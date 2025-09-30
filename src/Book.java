public class Book {
    private String title;
    private String author;
    private String borrowedId;

    void setTitle(String title) {
        this.title = title;
    }

    void setAuthor(String author) {
        this.author = author;
    }

    void setBorrowedId(String memberId) {
        this.borrowedId = memberId;
    }

    String getTitle() {
        return title;
    }

    String getAuthor() {
        return author;
    }

    String getBorrowedId() {
        return borrowedId;
    }

    void displayBookInfo() {
        System.out.printf("Title: %s%nAuthor: %s%n", title, author);
    }
}
