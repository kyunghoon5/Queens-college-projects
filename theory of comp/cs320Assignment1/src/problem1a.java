//Theory of Computation - CSCI 320
//Assignment 1
//Kyunghoon Oh 
//collaborated with Vivian Xia and Rishav Gupta

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class problem1a {

    public static double diagonalNumber(List<Double> nums){
        double result = 0;
        int placement = 10;

        for(int i = 0; i < nums.size(); i++){
            int x = (int)(nums.get(i)*placement)%10;
            if(x == 1) {
                x = 0;
            }
            else{
                x = 1;
            }
            result = result*10+x;
            placement = placement * 10;
        }
        placement = placement / 10;
        result = result / placement;
        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<String> input = new ArrayList<>();
        List<Double> array = new ArrayList<>();
        
        File myObj = new File("/Users/oh/eclipse-workspace/cs320Assignment1/src/input1a.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            input.add(data);
        }
        myReader.close();

        for(int i = 0; i < input.size(); i++){
            array.add(Double.parseDouble(input.get(i)));
        }
        System.out.println(diagonalNumber(array));
    }
}