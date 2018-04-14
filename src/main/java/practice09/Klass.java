package practice09;

import java.util.ArrayList;

public class Klass {
    private int number;
    private Student leader;
    private ArrayList<Student> member;

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName() {
        return ("Class "+getNumber());
    }
    public void assignLeader(Student student) {
        if (this.member != null && member.contains(student)) {
            this.leader = student;
        } else {
            System.out.print("It is not one of us.\n");
        }
    }

    public Student getLeader() {
        return leader;
    }

    public void appendMember(Student student) {
        member = new ArrayList<Student>();
        member.add(student);
    }
}
