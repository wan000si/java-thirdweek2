package practice10;

import java.util.*;
import java.util.stream.Collectors;

import static com.sun.xml.internal.fastinfoset.vocab.Vocabulary.PREFIX;

public class Teacher extends Person {
    private HashSet<Klass> klasses = new HashSet<>();

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
//        if (klasses!= null ) {
//            Iterator<Klass> it = klasses.iterator();
//            String s = it.next().getNumber()+"";
//            while (it.hasNext()) {
//                s =s + ", " +   it.next().getNumber() ;
//                //s =   it.next().getNumber() + ", " + s;
//            }
//            return (super.introduce() + " I am a Teacher. I teach Class " + s + ".");
//        } else {
//            return (super.introduce() + " I am a Teacher. I teach No Class.");
//        }
//    }
        String content = "No Class";
        if (klasses.size() > 0) {
            List<String> classList = new ArrayList<>();
            content = "Class " + conbine(klasses.stream().mapToInt(item -> item.getNumber()).sorted().toArray(), ", ");
        }
        return super.introduce() + " I am a Teacher. I "+ "teach " + content + ".";
    }

    public String conbine(int[] array, String separator) {
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
}
