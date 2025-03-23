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
        String[] names = {"Ana","Bruna","Cintia","Daniele","Fernanda","Ana Clara", "Ana Bia", "Ana Maria"};
        Random random = new Random();
        for (int i = 0; i < size; i++ ){
            People p = new People(names[random.nextInt(0,5)], random.nextInt(1,100));
            result.add(p);
        }

        return result;
    }

    @Override
    public int compareTo(People o) {
        return this.getName().compareTo(o.getName());
    }
}
