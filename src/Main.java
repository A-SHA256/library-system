import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Library lib = new Library();
        lib.setStore();

        Student s1 = new Student();
        Student s2 = new Student();
        Teacher t1 = new Teacher();
        Teacher t2 = new Teacher();
        s1.setName("Joe");
        s2.setName("Ann");
        t1.setName("William");
        t2.setName("Lola");
        s1.setId("1");
        s2.setId("2");
        t1.setId("3");
        t2.setId("4");

        lib.members = new ArrayList<>(List.of(s1, s2, t1, t2));

        // MEMBER INFO
        System.out.printf("%-10s %-20s%n", "Member ID", "Name");
        System.out.println("------------------------------");
        for (Member m : lib.members) {
            m.displayMemberInfo();
        }
        System.out.println();

        // ADDING BOOK
        lib.addBook();

        // SHOWING ALL BOOKS INFO (TABLE)
        lib.displayAllBooks();

        // SEARCH BY TITLE
        lib.beenFound("Wuthering Heights");
        lib.beenFound("Prince");

        // SHOW THE MEMBER WHO BORROWED A BOOK
        lib.borrowedBy(lib.members.get(3).getId(), "Republic");
        lib.removeBook("prince");
    }
}