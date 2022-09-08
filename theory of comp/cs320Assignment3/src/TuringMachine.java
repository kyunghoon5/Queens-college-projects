//Theory of Computation - CSCI 320
//Assignment 3
//Ali Tavoli, Kyunghoon Oh


import java.lang.reflect.Array;
import java.util.ArrayList;

public class TuringMachine {
    //1- States
    //2- Alphabets and tape alphabets
    //3- trsansition function
    //4- start and final
    private State startState;
    private State finalState;
    private ArrayList<String> alphabets;
    private ArrayList<String> tapeAlphabets;
    private ArrayList<State> states;
    private ArrayList<String> firstTape;
    private ArrayList<String> secondTape;
    private final static String MOVE_LEFT_SYMBOL = "L";
    private final static String MOVE_RIGHT_SYMBOL = "R";
    private final static String STAY_SYMBOL = "S";
    private int firstTapeheadIndex = 0;
    private int secondTapeheadIndex = 0;

    public TuringMachine(State startState, State finalState,
                         ArrayList<String> alphabets, ArrayList<String> tapeAlphabets,
                         ArrayList<String> firsttape, ArrayList<String> secondTape) {
        this.startState = startState;
        this.finalState = finalState;
        this.alphabets = alphabets;
        this.tapeAlphabets = tapeAlphabets;
        this.firstTape = firsttape;
        this.secondTape = secondTape;
    }

    public boolean processInput() {
        reportTuringMachine(startState);
        State currentState = startState;
        int counter = 0;
        while (true) {
            counter++;
            currentState = trasitionFunction(currentState);
            reportTuringMachine(currentState);
            if (accept(currentState)) {
                break;
            }
        }
        System.out.println("number of steps: " + counter);

        return false;
    }

    public boolean accept(State currentState) {
        //TODO
        if (currentState.getNumber() == finalState.getNumber() &&
                firstTape.get(firstTapeheadIndex).equals("B") &&
                secondTape.get(secondTapeheadIndex).equals("B")) {
            return true;
        }
        return false;
    }

    public void reportTuringMachine(State currentState) {
        System.out.println("current state: " + currentState.getNumber());
        System.out.println("Tape 1: ");
        for (int i = 0; i < firstTape.size(); i++) {
            System.out.print(firstTape.get(i) + " ");
        }
        System.out.println("\nTape 2: ");
        for (int i = 0; i < secondTape.size(); i++) {
            System.out.print(secondTape.get(i) + " ");
        }
        System.out.println("\n======================================");
    }

    public State trasitionFunction(State state) {
        if (state.getNumber() == 0) {
            if (firstTape.get(firstTapeheadIndex).equals("B")
                    && secondTape.get(secondTapeheadIndex).equals("B")) {
                doFirstTapeAction("B", MOVE_RIGHT_SYMBOL);
                doSecondTapeAction("B", MOVE_RIGHT_SYMBOL);
                return new State(1);
            }
        } else if (state.getNumber() == 1) {
            if (firstTape.get(firstTapeheadIndex).equals("B")
                    && secondTape.get(secondTapeheadIndex).equals("B")) {
                doFirstTapeAction("#", MOVE_RIGHT_SYMBOL);
                doSecondTapeAction("a", STAY_SYMBOL);
                return new State(2);
            }
        } else if (state.getNumber() == 2) {
            if (firstTape.get(firstTapeheadIndex).equals("B")
                    && secondTape.get(secondTapeheadIndex).equals("a")) {
                doFirstTapeAction("#", MOVE_RIGHT_SYMBOL);
                doSecondTapeAction("a", STAY_SYMBOL);
                return new State(3);
            }
        } else if (state.getNumber() == 3) {
            if (firstTape.get(firstTapeheadIndex).equals("B")
                    && secondTape.get(secondTapeheadIndex).equals("B")) {
                doFirstTapeAction("B", STAY_SYMBOL);
                doSecondTapeAction("B", MOVE_LEFT_SYMBOL);
                return new State(4);
            } else if (firstTape.get(firstTapeheadIndex).equals("B")
                    && secondTape.get(secondTapeheadIndex).equals("a")) {
                doFirstTapeAction("a", MOVE_RIGHT_SYMBOL);
                doSecondTapeAction("a", MOVE_RIGHT_SYMBOL);
                return new State(3);
            }
        } else if (state.getNumber() == 4) {
            if (firstTape.get(firstTapeheadIndex).equals("B")
                    && secondTape.get(secondTapeheadIndex).equals("B")) {
                doFirstTapeAction("B", STAY_SYMBOL);
                doSecondTapeAction("B", MOVE_RIGHT_SYMBOL);
                return new State(5);
            } else if (firstTape.get(firstTapeheadIndex).equals("B")
                    && secondTape.get(secondTapeheadIndex).equals("a")) {
                doFirstTapeAction("b", MOVE_RIGHT_SYMBOL);
                doSecondTapeAction("a", MOVE_LEFT_SYMBOL);
                return new State(4);
            }
        } else if (state.getNumber() == 5) {
            if (firstTape.get(firstTapeheadIndex).equals("B")
                    && secondTape.get(secondTapeheadIndex).equals("B")) {
                doFirstTapeAction("B", STAY_SYMBOL);
                doSecondTapeAction("a", MOVE_LEFT_SYMBOL);
                return new State(6);
            } else if (firstTape.get(firstTapeheadIndex).equals("B")
                    && secondTape.get(secondTapeheadIndex).equals("a")) {
                doFirstTapeAction("c", MOVE_RIGHT_SYMBOL);
                doSecondTapeAction("a", MOVE_RIGHT_SYMBOL);
                return new State(5);
            }
        } else if (state.getNumber() == 6) {
            if (firstTape.get(firstTapeheadIndex).equals("B")
                    && secondTape.get(secondTapeheadIndex).equals("B")) {
                doFirstTapeAction("#", MOVE_RIGHT_SYMBOL);
                doSecondTapeAction("B", MOVE_RIGHT_SYMBOL);
                return new State(3);
            } else if (firstTape.get(firstTapeheadIndex).equals("B")
                    && secondTape.get(secondTapeheadIndex).equals("a")) {
                doFirstTapeAction("B", STAY_SYMBOL);
                doSecondTapeAction("a", MOVE_LEFT_SYMBOL);
                return new State(6);
            }
        }
        return state;
    }

    private void doFirstTapeAction(String writingAlphabet, String direction) {
        firstTape.set(firstTapeheadIndex, writingAlphabet);
        switch (direction) {
            case MOVE_RIGHT_SYMBOL:
                firstTapeheadIndex++;
                break;
            case MOVE_LEFT_SYMBOL:
                firstTapeheadIndex--;
                break;
            case STAY_SYMBOL:
                firstTapeheadIndex = firstTapeheadIndex;
                break;
            default:
                break;
        }
    }

    private void doSecondTapeAction(String writingAlphabet, String direction) {
        secondTape.set(secondTapeheadIndex, writingAlphabet);
        switch (direction) {
            case MOVE_RIGHT_SYMBOL:
                secondTapeheadIndex++;
                break;
            case MOVE_LEFT_SYMBOL:
                secondTapeheadIndex--;
                break;
            case STAY_SYMBOL:
                secondTapeheadIndex = secondTapeheadIndex;
                break;
            default:
                break;
        }
    }

    private void getStateNumber() {
        return;
    }

    public ArrayList<String> getFirstTape() {
        return firstTape;
    }

    public void setFirstTape(ArrayList<String> firstTape) {
        this.firstTape = firstTape;
    }

    public ArrayList<String> getSecondTape() {
        return secondTape;
    }

    public void setSecondTape(ArrayList<String> secondTape) {
        this.secondTape = secondTape;
    }

    public ArrayList<State> getStates() {
        return states;
    }

    public void setStates(ArrayList<State> states) {
        this.states = states;
    }

    public State getStartState() {
        return startState;
    }

    public void setStartState(State startState) {
        this.startState = startState;
    }

    public State getFinalState() {
        return finalState;
    }

    public void setFinalState(State finalState) {
        this.finalState = finalState;
    }

}
