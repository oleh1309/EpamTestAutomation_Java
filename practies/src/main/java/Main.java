import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Father father = new Father();
        Product product = new Product();
        Apple apple = new Apple();

        List<? super
                Product> list = new ArrayList<>();



        //list.add(father);
        list.add(product);
        list.add(apple);
        Integer[] arr = {1,2,3};
        List<Integer> list1 = Arrays.asList(arr);
        System.out.println(list1.getClass());
        list1.remove(1);
        System.out.println(list1.getClass());

    }
}
