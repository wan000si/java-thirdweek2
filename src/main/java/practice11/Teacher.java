package practice11;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Observer;

public class Teacher extends Person implements Observer {
    private HashSet<Klass> klasses;

    public Teacher(int id,String name, int age) {
        super(id,name, age);
    }

    public Teacher(int id,String name, int age,HashSet<Klass> klasses) {
        super(id,name, age);
        this.klasses = klasses;
    }

    public HashSet<Klass> getClasses() {
        return klasses;
    }

    public String introduce() {
        if (klasses!= null ) {
            Iterator<Klass> it = klasses.iterator();
            String s = it.next().getNumber()+"";
            while (it.hasNext()) {
                //s =s + ", " +   it.next().getNumber() ;
                s =   it.next().getNumber() + ", " + s;
            }
            return (super.introduce() + " I am a Teacher. I teach Class " + s + ".");
        } else {
            return (super.introduce() + " I am a Teacher. I teach No Class.");
        }
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


//    @Override
//    public void update(Observable o, Object arg) {
//        Student student=(Student) arg;
//        //System.out.println("I am " + getName() + ". I know " + student.getName() + " has joined " + student.getKlass().getDisplayName() + ".\n");
//        System.out.println("I am Tom. I know Jerry has joined Class 2.\n");
//    }


    @Override
    public void update(java.util.Observable o, Object arg) {
        Klass klass = (Klass) o;
        Student student = (Student) arg;
        if (student == ((Klass) o).getLeader()) {
            System.out.print("I am " + getName() + ". I know " + student.getName() + " become Leader of " + student.getKlass().getDisplayName() + ".\n");
        } else {
            System.out.print("I am "+getName()+". I know "+student.getName()+" has joined "+student.getKlass().getDisplayName()+".\n");
        }
    }
}
