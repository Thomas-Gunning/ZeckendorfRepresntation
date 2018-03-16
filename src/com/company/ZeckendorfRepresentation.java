package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Thomas
 * <p>
 * Problem set by Adam Micthell to create a zeckendorf sequence from the Fibonnaci numbers
 * Giving an upper bound and lower bound
 */
public class ZeckendorfRepresentation {

    private final List<Integer> fibonacci;
    private List<List<Integer>> allZeckendorfs;
    private List<Integer> bounds;
    private List<Integer> fibNumbs;
    private int lowerBound = 0;
    private int upperBound = 10;

    public static void main(String[] args) throws IOException {
        ZeckendorfRepresentation zeck = new ZeckendorfRepresentation();
        zeck.getBounds();
        zeck.setFibonacciSequence();
        zeck.getZeckendorfSequence();
    }

    /**
     * This gets the bounds of upper and lower bounds
     *
     * @throws IOException
     */

    private void getBounds() throws IOException {
        boolean incorrectBounds = true;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (incorrectBounds) {
            lowerBound = getLowerBound(lowerBound, br);
            upperBound = getUpperBound(upperBound, br);
            if (lowerBound >= upperBound) {
                System.out.println("Please enter the lower bound lower than the upper bound!");
                incorrectBounds = true;
            } else {
                incorrectBounds = false;
            }

        }

    }

    /**
     * @param upperBound
     * @param br
     * @return
     * @throws IOException
     */
    public int getUpperBound(int upperBound, BufferedReader br) throws IOException {
        boolean upperBoundsIncorrect = true;
        while (upperBoundsIncorrect) {
            System.out.print("Enter Upper Bound: ");
            try {
                upperBound = Integer.parseInt(br.readLine());
                upperBoundsIncorrect = false;
            } catch (NumberFormatException nfe) {
                System.err.println("Please enter a integer");
                upperBoundsIncorrect = true;
            }
        }
        return upperBound;
    }

    /**
     * @param lowerBound
     * @param br
     * @return
     * @throws IOException
     */
    public int getLowerBound(int lowerBound, BufferedReader br) throws IOException {
        boolean lowerBoundIncorrect = true;

        while (lowerBoundIncorrect) {
            System.out.print("Enter Lower Bound: ");
            try {
                lowerBound = Integer.parseInt(br.readLine());
                lowerBoundIncorrect = false;
            } catch (NumberFormatException nfe) {
                System.err.println("Please enter a integer");
                lowerBoundIncorrect = true;
            }

        }
        return lowerBound;
    }

    /**
     * initialises the lists
     */
    public ZeckendorfRepresentation() {
        fibonacci = new ArrayList<>();
        bounds = new ArrayList<>();
        fibNumbs = new ArrayList<>();
        allZeckendorfs = new ArrayList<>();
    }

    /**
     * returns the fibonacci sequence up until the upper bound
     */
    public void setFibonacciSequence() {

        int oldNumber = 1;
        int newNumber = 1;
        int tempNumber;
        while (newNumber <= upperBound && checkIntegerWrapAround(newNumber)) {
            tempNumber = newNumber;
            newNumber = oldNumber + newNumber;
            oldNumber = tempNumber;
            fibonacci.add(oldNumber);
        }

    }

    public List<Integer> getFibonacci() {
        return fibonacci;
    }

    /**
     * returns the zeckendorf sequence starting from the lowerbound going up to the upper bound
     */
    public void getZeckendorfSequence() {
        List zeckendorfSequence = new ArrayList<>();
        int lowerBoundTemp = lowerBound;
        int upperBoundTemp = upperBound;
        while (upperBoundTemp >= lowerBoundTemp && checkIntegerWrapAround(lowerBoundTemp)) {
            int lower = lowerBoundTemp;
            for (int i = fibonacci.size() - 1; i > -1; i--) {
                if (fibonacci.get(i) <= lower) {
                    lower -= fibonacci.get(i);
                    zeckendorfSequence.add(1);
                } else {
                    zeckendorfSequence.add(0);
                }
            }
            System.out.print(lowerBoundTemp + ": ");
            zeckendorfSequence.forEach(x -> System.out.print(x));
            allZeckendorfs.add(new ArrayList<>(zeckendorfSequence));
            System.out.println();
            lowerBoundTemp++;
            zeckendorfSequence.clear();
        }
    }

    public void setLowerbound(int lower) {
        lowerBound = lower;
    }

    public void setUpperBound(int upper) {
        upperBound = upper;
    }

    public List<List<Integer>> getAllZeckendorfs() {
        return allZeckendorfs;
    }

    public boolean checkIntegerWrapAround(int fibonnaciNumber){
        return fibonnaciNumber > 0;
    }
    /**
     * This method is not used, however it is used for building streams
     *
     * @param upperBound
     * @param lowerBound
     * @return
     */


    public List AddBounds(int upperBound, int lowerBound) {

        //IntStream.range(lowerBound, upperBound + 1).forEach(i -> bounds.add(i));
        IntStream.range(0, bounds.size() - 1).forEach(index -> {
            int oldNumber = 1;
            int  newNumber = 1;
            int tempNumber;
            while (newNumber < bounds.get(index)) {
                tempNumber = newNumber;
                newNumber = oldNumber + newNumber;
                oldNumber = tempNumber;
                //fibNumbs.add(oldNumber);
            }
        });
        return bounds;
    }
}
