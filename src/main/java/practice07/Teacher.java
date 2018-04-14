package practice07;

public class Teacher extends Person {
    private Klass klass;

    public Teacher(String name, int age,Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Klass getKlass() {
        return klass;
    }
    public String introduce() {
        if (klass!= null ) {
            return (super.introduce() + " I am a Teacher. I teach Class " + getKlass().getNumber() + ".");
        } else {
            return (super.introduce() + " I am a Teacher. I teach No Class.");
        }
    }
    public String introduceWith(Student student ) {
        if (this.klass.getNumber()!= student.getKlass().getNumber()) {
            return (super.introduce()+" I am a Teacher. I don't teach "+student.getName()+".");
        } else {
            return (super.introduce() + " I am a Teacher. I teach " + student.getName() + ".");
        }
    }
}
