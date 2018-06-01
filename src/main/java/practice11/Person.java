package practice11;

import java.util.Observable;
import java.util.Observer;

public class Person {
    private int id;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person(int id, String name, int age) {
        this.name = name;
        this.age = age;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String introduce() {
        return ("My name is "+name+". I am "+age+" years old.");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        if (id != person.id) return false;
        if (age != person.age) return false;
        if (name == null) {
            if (person.name != null) {
                return false;
            }
        }else if (!name.equals(person.name)) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + id;
        result = prime * result + ((name ==null) ? 0 :name.hashCode());
        return result;
    }

}
