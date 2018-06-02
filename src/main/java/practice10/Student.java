package practice10;

public class Student extends Person {
    private Klass klass;

    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    public Student(int id, String name, int age,Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public void setKlass(Klass klass) {
        this.klass=klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public String introduce() {
        if (klass.getLeader() == this) {
            return (super.introduce() + " I am a Student. I am Leader of Class " + getKlass().getNumber() + ".");
        } else {
            return (super.introduce() + " I am a Student. I am at Class " + getKlass().getNumber() + ".");
        }
    }
}
