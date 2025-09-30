public class Member {
    protected String name;
    protected String id;

    void setId(String s) {
        this.id = s;
    }
    void setName(String name) {
        this.name = name;
    }

    String getId() {
        return id;
    }
    String getName() {
        return name;
    }

    void displayMemberInfo() {
//        System.out.printf("Member ID: %s%nName: %s%n", id, name);
        System.out.printf("%-10s %-20s%n", id, name);
    }
}
class Student extends Member {
    @Override
    void setId(String s) {
        this.id = "s-" + s;
    }
}

class Teacher extends Member {
    @Override
    void setId(String s) {
        this.id = "t-" + s;
    }
}
