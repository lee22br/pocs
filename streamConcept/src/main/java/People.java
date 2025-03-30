import java.util.ArrayList;
import java.util.List;

public class People implements Comparable<lambdaConcept.People>{
    private String name;
    private int age;

    public People (String name, int age){
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

    public static List<lambdaConcept.People> getSample(){
        List<lambdaConcept.People> result = new ArrayList<>();
        lambdaConcept.People p = new lambdaConcept.People("Ana", 22);
        result.add(p);
        p = new lambdaConcept.People("Bruna", 21);
        result.add(p);
        p = new lambdaConcept.People("Cintia", 25);
        result.add(p);
        p = new lambdaConcept.People("Daniele", 29);
        result.add(p);
        p = new lambdaConcept.People("Fernanda", 24);
        result.add(p);
        p = new lambdaConcept.People("Ana Clara", 18);
        result.add(p);
        p = new lambdaConcept.People("Ana Maria", 19);
        result.add(p);
        return result;
    }

    @Override
    public int compareTo(lambdaConcept.People o) {
        return this.getName().compareTo(o.getName());
    }
}
