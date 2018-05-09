/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8_exe1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Leonardo
 */
public class Java8_exe1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Person marco = new Person(18, "Marco", "Bianchi");
        Person giuseppe = new Person(10, "Giuseppe", "Rossi");
        Person antonio = new Person(35, "Antonio", "Bianchi", marco);
        Person leonardo = new Person(30, "Leonardo", "Avena");
        Person giuseppeA = new Person(60, "Giuseppe", "Avena");
        Person luigi = new Person(27, "Luigi", "Luigi", leonardo, giuseppeA);
        Person mario = new Person(25, "Mario", "Rossi", giuseppe);

        List<Person> myList = new ArrayList<>();
        myList.add(marco);
        myList.add(giuseppe);
        myList.add(antonio);
        myList.add(leonardo);
        myList.add(giuseppeA);
        myList.add(luigi);
        myList.add(mario);

        myList.stream()
                .filter(person -> person.getAge() > 18)
                .map(Person::getName) //.map(person->person.getName())
                .forEach(System.out::println);

        //salvo in lista
        List<Person> maggiorenni = myList
                .stream()
                .filter(person -> person.getAge() > 18)
                .collect(Collectors.toList());

        System.out.println("---Maggiorenni:---");
        maggiorenni.forEach(person -> System.out.printf("Name:%s, Age:%d; ", person.getName(), person.getAge()));
        System.out.println("");
        //stampiamo tutte le persone in relazione con i maggiorenni
        System.out.println("---In relazione con---");
        maggiorenni.parallelStream()//l'elaborazione è ripartita tra più worker
                .flatMap(person->person.getRelation().stream())
                .map(Person::getName)
                .forEach(n->System.out.println(n))//metodo alternativo a System.out::pritln che inferisce da sé su cosa lavorare
                ;
        
        //Altro esempio
        List<Integer> listInteger = Arrays.asList(2,1,9,8,5,4,10);
        listInteger.forEach(System.out::println);//anziché n->System.out.println(n)
        
        //ordinamento
        listInteger.stream()
                .sorted()
                .forEach(System.out::println);
//        System.out.println(giuseppe.getName());
    }

}
