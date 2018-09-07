package com.hll.sb20.service;

import java.util.Arrays;

/**
 * @Author helili
 * @Create_Date 2018/9/3
 */
class Person {
    public String firstName;
    public String lastName;
    public int age;

    public static int compareFirstNames(Person lhs, Person rhs) {
        return lhs.firstName.compareTo(rhs.firstName);
    }

    // ...


    public static void main(String... args) {
        Person[] people = null;
        // Sortable by first name
        Arrays.sort(people, Person::compareFirstNames);
        for (Person p : people) {
            System.out.println(p);
        }
    }

}