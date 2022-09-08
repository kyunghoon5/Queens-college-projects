//Theory of Computation - CSCI 320
//Assignment 1
//Kyunghoon Oh

import java.io.*;
import java.util.*;

public class problem1b {

   
    public static List<String> union(List<String> x, List<String> y) {
        List<String> unionList = new ArrayList<>();
        for (int i = 0; i < x.size(); i++) {
        	String xs = x.get(i);
            if (!unionList.contains(xs))
                unionList.add(xs);
        }
        for (int i = 0; i < y.size(); i++) {
        	String ys = y.get(i);
            if (!unionList.contains(ys))
                unionList.add(ys);
        }
        return unionList;
    }
    //intersection
    public static List<String> intersection(List<String> x, List <String> y){
    	List<String> interList = new ArrayList<>();
        for (int i = 0; i < x.size(); i++) {
        	String xs = x.get(i);
            if(y.contains(xs))
            	interList.add(xs);     	                
            }
        
    	
        return interList;
    	
    }

   
    public static List<String> subtraction(List<String> x, List<String> y) {
        List<String> subList = new ArrayList<>();
        for (int i = 0; i < x.size(); i++) {
        	String xs = x.get(i);
            if (!y.contains(xs))
                subList.add(xs);
        }
        return subList;
    }

    // symmetric 
    public static List<String> symmetricDifference(List<String> x, List<String> y) {
        return union(subtraction(x, y), subtraction(y, x));
    }

    // cartesian product
    public static List<List<String>> cartesianProduct(List<String> x, List<String> y) {
        List<List<String>> cartesianList = new ArrayList<>();
        for (int i = 0; i < y.size(); i++) {
        	String ys = y.get(i);
            for (int j = 0; j < x.size(); j++) {
            	String xs = x.get(j);
                cartesianList.add(new ArrayList<>() {
                    /**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					{
                        add(xs);
                        add(ys);
                    }
                });
            }
        }
        return cartesianList;
    }

    //Powerset 
    public static List<List<String>> powerSet(List<String> x) {
        List<List<String>> powerSetList = new ArrayList<>();
        for (int i = 0; i < (1<<x.size()); i ++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < x.size(); j ++) {              
                if ((i & (1 << j)) > 0)
                    list.add(x.get(j));
            }
            powerSetList.add(list);
        }
        return powerSetList;
    }

    public static void main(String[] args) throws FileNotFoundException {       
        List<String> x;
        List<String> y;
        List<String> lines = new ArrayList<>();
        File inputFile = new File("/Users/oh/eclipse-workspace/cs320Assignment1/src/input1b.txt");
        Scanner sc = new Scanner(inputFile);
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
        sc.close();
        x = Arrays.asList(lines.get(0).split(" "));
        y = Arrays.asList(lines.get(1).split(" "));

        
        System.out.printf("X = %s\n", x);
        System.out.printf("Y = %s\n", y);
        System.out.printf("XUY = %s\n", union(x, y));
        System.out.printf("X∩Y = %s\n", intersection(x, y));
        System.out.printf("X-Y = %s\n", subtraction(x, y));
        System.out.printf("XΔY = %s\n", symmetricDifference(x, y));
        System.out.printf("XxY = %s\n", cartesianProduct(x, y));
        System.out.printf("P(X) = %s\n", powerSet(x));
    }
}