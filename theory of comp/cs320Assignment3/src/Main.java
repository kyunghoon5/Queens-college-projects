//Theory of Computation - CSCI 320
//Assignment 3
//Ali Tavoli, Kyunghoon Oh

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        State startState = new State(0);
        State finalState = new State(6);
        ArrayList<String> alphabets = new ArrayList<>(Arrays.asList("a", "b", "c"));
        ArrayList<String> tapeAlphabets = new ArrayList<>(Arrays.asList("B", "#"));
        ArrayList<String> firstTape = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            firstTape.add("B");
        }
        ArrayList<String> secondTape = new ArrayList<>(Arrays.asList("B", "B", "B", "a","a","b","b", "c","c"));
        TuringMachine machine = new TuringMachine(startState, finalState, alphabets, tapeAlphabets, firstTape, secondTape);
        machine.processInput();
    }

}
