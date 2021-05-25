package org.example;

import org.example.interfaces.Action;
import org.example.interfaces.Conditional;
import org.example.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product("Laser gun", 499990.90, 10),
                new Product("Football", 39.90, 4),
                new Product("Baseball bat", 149.90, 33),
                new Product("OCP book", 590, 0),
                new Product("Handsprit", 200, 0),
                new Product("Java for dummies", 100, 3),
                new Product("Plasma rifle", 1000000, 1)
        ));

        actionOnConditional(
                products,
                p -> p.getStock() == 0,
                System.out::println
        );
        actionOnConditional(products, p -> p.getProductName().startsWith("B"), p -> System.out.println(p.getProductName()));
        actionOnConditional(products, p -> p.getPrice() > 100 && p.getPrice() < 150, System.out::println);
        actionOnConditional(products, p -> p.getStock() > 0 && p.getStock() < 10, p -> p.setPrice(p.getPrice() * 1.50));

        products.forEach(System.out::println);

    }

    public static void actionOnConditional(List<Product> productList, Conditional filter, Action action){
        for(Product p : productList){
            if(filter.test(p)){
                action.execute(p);
            }
        }
    }

}
