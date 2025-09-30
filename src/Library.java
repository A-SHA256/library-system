import java.util.*;

public class Library {
    private Scanner sc;
    private Map<String, Book> store;
    public List<Member> members;

    void setScanner() {
        this.sc = new Scanner(System.in);
    }

    void setStore() {
        this.store = new HashMap<>();
    }

    Scanner getScanner() {
        return sc;
    }

    Map<String, Book> getStore() {
        return store;
    }

    void addBook() {
        Random r = new Random();
        setScanner();

        outer: do {
            Book b = new Book();
            String isbn;
            while (true) {
                System.out.print("Enter the title of the book you want to add: ");
                if (!getScanner().hasNextLine()) {
                    System.out.println("Invalid input");
                    getScanner().nextLine();
                    continue;
                }
                b.setTitle(getScanner().nextLine().trim());
                break;
            }
            while (true) {
                System.out.print("Enter the author of the book you want to add: ");
                if (!getScanner().hasNextLine()) {
                    System.out.println("Invalid input");
                    getScanner().nextLine();
                    continue;
                }
                b.setAuthor(getScanner().nextLine().trim());
                break;
            }
            isbn = Long.toString(r.nextLong(1_000_000_000_000L));
            getStore().put(isbn, b);
            while (true) {
                System.out.print("Want to add more?(y/n): ");
                if (getScanner().hasNextLine()) {
                    if (getScanner().nextLine().trim().equalsIgnoreCase("y")) {
                        break;
                    } else {
                        break outer;
                    }
                }
            }
        }
        while (true);

        sc.close();
        System.out.println();
    }

    void removeBook(String title) {
        String s = "";
        for (String isbn : getStore().keySet()) {
            Book b = getStore().get(isbn);
            if (b.getTitle().equalsIgnoreCase(title.trim())) {
                s = isbn;
                break;
            }
        }
        if (!s.isEmpty()) {
            getStore().remove(s);
        }
        System.out.println("THE " + "\"" + title + "\"" + " HAS BEEN REMOVED FROM THE LIBRARY");
        displayAllBooks();
    }

    Book searchByTitle(String title) {
        Book exists = new Book();
        for(String isbn : getStore().keySet()) {
            Book b = getStore().get(isbn);
            if (b.getTitle().equalsIgnoreCase(title.trim())) {
                exists = b;
                break;
            }
        }
        return exists;
    }

    void beenFound(String title) {
        Book b = searchByTitle(title);
        if (b.getTitle() != null) {
            boolean flag = b.getTitle().equalsIgnoreCase(title.trim());
            if (flag) {
                System.out.println("The book " + "\"" + b.getTitle() + "\"" + " exists in our library");
            } else {
                System.out.println("The book " + b.getTitle() + " does not exist in our library");
            }
        }
        System.out.println();
    }

    void displayAllBooks() {
        System.out.printf("%-15s %-25s %-20s %-20s%n", "ISBN", "Title", "Author", "Borrowed By");
        System.out.println("-------------------------------------------------------------------------------");

        for (String s : getStore().keySet()) {
            Book b = getStore().get(s);
            String borrowerName = "";
            String tOrS = "";

            if (b.getBorrowedId() != null) {
                for (Member m : members) {
                    if (m.getId().equals(b.getBorrowedId())) {
                        tOrS = String.valueOf(m.getId().charAt(0));
                        borrowerName = tOrS.equals("s") ? "student " : "teacher "  + m.getName();
                        break;
                    }
                }
            }
            
            System.out.printf("%-15s %-25s %-20s %-20s%n",
                    s,
                    b.getTitle(),
                    b.getAuthor(),
                    borrowerName);
        }
    }

    void borrowedBy(String memberId, String title) {
        Book b = searchByTitle(title);
        if (b.getTitle() != null) {
            boolean flag = b.getTitle().equalsIgnoreCase(title.trim());
            if (flag) {
                for (Member m : members) {
                    if (m.getId().equals(memberId)) {
                        b.setBorrowedId(m.getId());
                    }
                }
            }
        }
        System.out.println();
        displayAllBooks();
        System.out.println();
    }
}
