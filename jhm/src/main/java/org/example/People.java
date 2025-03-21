package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class People implements Comparable<People>{
    private String name;
    private int age;

    public People(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static List<People> getSample(int size){
        List<People> result = new ArrayList<>();
        String nomes[] = {"Ana","Bruna","Cintia","Daniele","Fernanda","Ana Clara"};
        Random random = new Random();
        for (int i = 0; i < size; i++ ){
            People p = new People(nomes[random.nextInt(0,5)], random.nextInt(1,100));
        }
        return result;
    }

    public static List<People> getSample(){
        List<People> result = new ArrayList<>();
        People p = new People("Ana", 22);
        result.add(p);
        p = new People("Bruna", 21);
        result.add(p);
        p = new People("Cintia", 25);
        result.add(p);
        p = new People("Daniele", 29);
        result.add(p);
        p = new People("Fernanda", 24);
        result.add(p);
        p = new People("Ana Clara", 18);
        result.add(p);
        p = new People("Ana Maria", 19);
        result.add(p);
        p = new People("Jessica", 22);
        result.add(p);
        p = new People("Carol", 17);
        result.add(p);
        p = new People("Melina", 23);
        result.add(p);
        p = new People("Melissa", 27);
        result.add(p);
        return result;
    }

    @Override
    public int compareTo(People o) {
        return this.getName().compareTo(o.getName());
    }
}
