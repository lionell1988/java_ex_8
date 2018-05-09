/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8_exe1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Leonardo
 */
public class Person {
    private final int age;
    private final String name;
    private final String surname;
    private final List<Person> relation;
    
    
    public Person(int age, String name, String surname, Person... relation){
        this.age = age;
        this.name = name;
        this.surname = surname;
        this.relation = new ArrayList<>(Arrays.asList(relation));
    }
    
    public int getAge(){
        return this.age;
    }
    public String getName(){
        return this.name;
    }
    public String getSurname(){
        return this.surname;
    }
    public List<Person> getRelation(){
        return this.relation;
    }
    
}
