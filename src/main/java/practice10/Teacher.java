package practice10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

public class Teacher extends Person {
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
                s =  + it.next().getNumber() + ", " + s;
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
}
