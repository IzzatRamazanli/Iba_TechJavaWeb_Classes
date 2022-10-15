package lesson2;

import lombok.Getter;

@Getter
public class Student {
    String name;
    Integer age;
    String group;

    public Student(String name, Integer age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }
}
