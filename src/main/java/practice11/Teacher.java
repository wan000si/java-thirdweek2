package practice11;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.*;

public class Teacher extends Person {
    private HashSet<Klass> klasses = new HashSet<>();

    public Teacher(int id,String name, int age) {
        super(id,name, age);
    }

    public Teacher(int id,String name, int age,HashSet<Klass> klasses) {
        super(id,name, age);
        this.klasses = klasses;
        klasses.stream().forEach(item->item.attach(this));
    }

    public HashSet<Klass> getClasses() {
        return klasses;
    }

    public String introduce() {
        String content = "No Class";
        if (klasses.size() > 0) {
            List<String> classList = new ArrayList<>();
            content = "Class " + combine(klasses.stream().mapToInt(item -> item.getNumber()).sorted().toArray(), ", ");
        }
        return super.introduce() + " I am a Teacher. I " + "teach " + content + ".";
    }

    public String combine(int[] array, String separator) {
        int len = array.length;
        StringBuilder buf = new StringBuilder(len * 16);
        for (int i = 0; i < len; i++) {
            if (i > 0) {
                buf.append(separator);
            }
            buf.append(array[i]);
        }
        return buf.toString();
    }
    public String introduceWith(Student student ) {
        if (klasses.contains(student.getKlass())) {
            return (super.introduce() + " I am a Teacher. I teach " + student.getName() + ".");
        } else {
            return (super.introduce()+" I am a Teacher. I don't teach "+student.getName()+".");
        }
    }

    public boolean isTeaching(Student student) {
        return klasses.contains(student.getKlass());
    }

    public void update( Student student,Klass klass,int flag) {
        if (flag == Klass.ASSIGN_LEADER) {
            System.out.print("I am " + getName() + ". I know " + student.getName() + " become Leader of Class " + klass.getNumber() + ".\n");
        } else {
            System.out.print("I am "+getName()+". I know "+student.getName()+" has joined Class "+klass.getNumber()+".\n");
        }
    }
}
