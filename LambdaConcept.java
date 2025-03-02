import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class LambdaConcept {

    public static void main(String[] args) throws InterruptedException {

        //Test with Runnable
        runnableLambda();

        //print items from list
        printElementsFromList();

        //Order list
        List<People> listPeople = Arrays.asList(new People("Eduardo", 29),
                new People("Luiz", 32), new People("Bruna", 40));

       orderListByName(listPeople);
       orderListByAge(listPeople);


        listPeople.sort((People p1, People p2) -> p1.getName().compareTo(p2.getName()));
        System.out.println("Order by Name (Lambda):");
        listPeople.forEach(p -> System.out.println(p.getName()));
        listPeople.sort((People p1, People p2) -> Integer.compare(p1.getAge(),p2.getAge()));
        System.out.println("Order by Age (Lambda):");
        listPeople.forEach(p -> System.out.println(p.getName()));

        System.out.println("text {$1}");
    }

    private static void orderListByAge(List<People> listPeople) {
        System.out.println("Order by Age:");
        listPeople.sort(new Comparator<>() {
            @Override
            public int compare(People p1, People p2) {
                return Integer.compare(p1.getAge(), p2.getAge());
            }
        });
        listPeople.forEach(p -> System.out.println(p.getName()));

    }

    private static void orderListByName(List<People> listPeople) {
        System.out.println("Order by Name:");

        listPeople.sort(new Comparator<>() {
            @Override
            public int compare(People p1, People p2){
                return p1.getName().compareTo(p2.getName());
            }
        });
        listPeople.forEach(p -> System.out.println(p.getName()));
    }

    private static void runnableLambda()throws InterruptedException{
        Runnable r = new Runnable() {
            public void run() {
                System.out.println("Thread with inner class!");
            }
        };
        new Thread(r).start();
        Thread.sleep(1000);

        //with Lambda
        new Thread(() -> System.out.println("hello world")).start();
        Thread.sleep(1000);
    }

    private static void printElementsFromList(){
        System.out.println("Print all elements from list");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for(Integer n: list) {
            System.out.println(n);
        }
        //print with lambda
        list.forEach((n) -> System.out.println("N= "+n));
        list.forEach((x) -> {
            if(x % 2 == 0){
                System.out.println("Even= "+x);
            }
        });
    }

}
