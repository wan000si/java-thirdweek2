package practice11;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Klass {

    public static final int APPEND_MEMBER=0;
    public static final int ASSIGN_LEADER=1;
    private int number;
    private Student leader;
    private List<Student> member = new ArrayList<>();
    private List<Teacher> teachers= new ArrayList<>();

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName() {
        return ("Class "+getNumber());
    }

    public void attach(Teacher teacher){
        teachers.add(teacher);
    }

    public void notifyObservers(Student student, int flag) {
        for (Teacher teacher : teachers) {
            teacher.update(student,this,flag);
        }
    }

    public void assignLeader(Student student) {
        if (this.member != null && member.contains(student)) {
            this.leader = student;
            notifyObservers(student,ASSIGN_LEADER);
//            setChanged();
//            notifyObservers(student);
        } else {
            System.out.print("It is not one of us.\n");
        }
    }

    public Student getLeader() {
        return leader;
    }

    public void appendMember(Student student) {
        member.add(student);
        notifyObservers(student,APPEND_MEMBER);
//        setChanged();
//        notifyObservers(student);

    }
}
