import java.util.Arrays;
import java.util.List;

public class LambdaConcept {

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new Runnable() {
            public void run() {
                System.out.println("Thread with inner class!");
            }
        };
        new Thread(r).start();
        Thread.sleep(1000);
        new Thread(r).start();
        Thread.sleep(1000);
        new Thread(() -> System.out.println("hello world")).start();

        //print items from list
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

        //Order list


    }
}
