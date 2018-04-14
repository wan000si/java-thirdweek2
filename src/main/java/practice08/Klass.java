package practice08;

public class Klass {
    private int number;
    private Student leader;

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName() {
        return ("Class "+getNumber());
    }
    public boolean assignLeader(Student student) {
        this.leader = student;
        return true;
    }

    public Student getLeader() {
        return leader;
    }
}
