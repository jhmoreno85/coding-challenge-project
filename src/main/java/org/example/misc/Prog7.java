package org.example.misc;

import org.example.misc.model.Person;

import java.util.HashSet;
import java.util.Set;

public class Prog7 {

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("jorge");
        p1.setLastName("huerta");
        p1.setAge(37);

        Person p2 = new Person();
        p2.setName("jorge");
        p2.setLastName("huerta");
        p2.setAge(37);

        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode() == p2.hashCode());

        Set<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2);

        System.out.println(set.size());
    }
}
