package com.company;



import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 *
 * @author Thomas
 */
public class ZeckendorfRepresentation {

    private final List<Integer> fibonacci;
    private List<Integer> zeckendorfs;
    private List<Integer> bounds;
    private List<Integer> fibNumbs;
    public static void main(String[] args) {
        int lowerBound;
        int upperBound;
        try (Scanner reader = new Scanner(System.in)) {
            lowerBound = getLowerBound(reader);
            upperBound = getUpperBound(reader);
            ZeckendorfRepresentation zeck = new ZeckendorfRepresentation();
            zeck.getFibonacciSequence(upperBound);
            zeck.AddBounds(upperBound, lowerBound);
            while(upperBound >= lowerBound){

                zeck.zeckendorfs = zeck.getZeckendorfSequence(lowerBound);
                System.out.print(lowerBound + ": ");
                zeck.zeckendorfs.forEach(x -> System.out.print(x));
                System.out.println();
                lowerBound++;
            }
        }catch(InputMismatchException ex){
            System.out.println("Please enter a number");
        }

    }

    private static int getUpperBound(final Scanner reader) {
        int upperBound;
        System.out.println("Upper Bound: ");
        upperBound = reader.nextInt();
        return upperBound;
    }

    private static int getLowerBound(final Scanner reader) {
        int lowerBound;
        System.out.println("Lower Bound: ");
        lowerBound = reader.nextInt();
        return lowerBound;
    }

    public ZeckendorfRepresentation() {
        fibonacci = new ArrayList<>();
        zeckendorfs = new ArrayList<>();
        bounds = new ArrayList<>();
        fibNumbs = new ArrayList<>();
    }

    public List getFibonacciSequence(int upperBound ){

        int oldNumber = 1;
        int newNumber =1;
        int tempNumber;
        while( newNumber < upperBound){
            tempNumber = newNumber;
            newNumber = oldNumber + newNumber;
            oldNumber = tempNumber;
            fibonacci.add(oldNumber);
        }
        return fibonacci;
    }

    public List getZeckendorfSequence(int upperBound){
        int upper = upperBound;
        boolean firstNum = false;
        List fibNumbers = new ArrayList<>();
        for(int i = fibonacci.size() - 1; i > -1; i--){
            if(fibonacci.get(i) <= upper){
                upper -= fibonacci.get(i);
                fibNumbers.add(1);
                firstNum = true;
            }else{
                if(firstNum || upper == 0){
                    fibNumbers.add(0);
                }

            }
        }
        return fibNumbers;
    }

    /**
     * This method is not used, however it is used for building streams
     * @param upperBound
     * @param lowerBound
     * @return
     */



    public List AddBounds(int upperBound, int lowerBound){
        IntStream.range(lowerBound, upperBound + 1).forEach(i -> bounds.add(i));
        IntStream.range(0, bounds.size() -1).forEach(index -> {
            int oldNumber = 1;
            int newNumber = 1;
            int tempNumber;
            while(newNumber < bounds.get(index )){
                tempNumber = newNumber;
                newNumber = oldNumber + newNumber;
                oldNumber = tempNumber;
                fibNumbs.add(oldNumber);
            }

        });
        return bounds;
    }
}
