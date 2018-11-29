import java.util.*;

public class Chapter_5 {

    Chapter_5(){
       Exercise_5_1 answer = new Exercise_5_1(42281);
       Exercise_5_2 answer = new Exercise_5_2();
       int[] unsorted_list = new int[]{1,3,7,2,2,5,1,5,9};
       Exercise_5_3 answer = new Exercise_5_3(unsorted_list);

       int[] sorted_list = new int[]{1,2,2,3,5,6,6,7,8,9,9,10};
       Exercise_5_4 answer = new Exercise_5_4(sorted_list);
       System.out.println(answer.binary_search(5, 0,11));

       Exercise_5_6 answer = new Exercise_5_6(sorted_list, 6);

       int[] sorted_list_with_index_match = new int[]{-3, -2, -1, 3, 5, 9, 11};
       Exercise_5_7 answer = new Exercise_5_7(sorted_list_with_index_match);
       System.out.print("The answer " + answer.findIndexWithEqualValue(0, 6));

       int[] listOfEvensAndOdds = new int[]{2,4,-2, 12,8,9, 7, 5, 11};
       Exercise_5_8 answer = new Exercise_5_8(listOfEvensAndOdds);
       System.out.print("The answer " + answer.determineGreatestEvenIndex(0, 8));

       Exercise_5_9 answer = new Exercise_5_9(2, 2.5);
       System.out.println(answer.determineApproximation(2, 9));
    }
}

class Exercise_5_1 {

    Exercise_5_1(int number){
        System.out.print(findOddDigit(number));
    }

    public Boolean findOddDigit(int n){

        if (n == 0){
            return false;
        }

        int leastSignificantDigit = n % 10;

        if (leastSignificantDigit % 2 == 1){
            return true;
        }

        return findOddDigit(n/10 );
    }
}


class Exercise_5_2 {
    private String formattedPolynomial;
    private int degree = 0;

    Exercise_5_2(){
        int[] polynomialCoefficients = new int[]{2,-4,7,0,1};
        formatPolynomial(polynomialCoefficients);
    }

    public String formatPolynomial(int[] coefficients){

        if (coefficients.length == 0){
            System.out.print("The polynomial" + formattedPolynomial);
            return formattedPolynomial;
        }

        if (coefficients[0] == 0){
            degree += 1;
            return formatPolynomial(Arrays.copyOfRange(coefficients, 1, coefficients.length));
        }
        String operator = coefficients[0] > 0 ? "+" : "";

        if (degree == 0){
            formattedPolynomial = operator + Integer.toString(coefficients[0]);
        } else {
            formattedPolynomial = operator +  Integer.toString(coefficients[0]) + "x^" +Integer.toString(degree) + formattedPolynomial;
        }

        degree += 1;

        return formatPolynomial(Arrays.copyOfRange(coefficients, 1, coefficients.length));


    }
}


class Exercise_5_3 {

    private int[] frequencyCounts;
    private int[] sortedList;
    Exercise_5_3(int[] unsortedList){
        int length = determineHighestValue(unsortedList) + 1;
        countFrequency(unsortedList, length);
        createSortedList(unsortedList.length);

    }

    public int determineHighestValue(int[] unsortedList){
       int highest = 0;
       for (int integer : unsortedList) {
           if (integer > highest){
               highest = integer;
           }
       }
       return highest;
    }

    public void countFrequency(int[] unsortedList, int length){

        System.out.println("the length" + length);

        frequencyCounts = new int[length];
        for (int integer : unsortedList){
            System.out.println("each integer" + integer);
            frequencyCounts[integer] +=1;
        }

    }
    public void createSortedList(int length){
        int value = 0;
        int index = 0;
        sortedList = new int[length];
        for (int count : frequencyCounts){
            while(count > 0){
                sortedList[index++] = value;
                count--;
            }
            ++value;
        }

        System.out.println("the sorted list" + Arrays.toString(sortedList));

    }
}



class Exercise_5_4 {

    int[] searchList;
    Exercise_5_4(int[] sortedList){
        searchList = Arrays.copyOf(sortedList, sortedList.length);
    }

    public int binary_search(int valueToSearch, int lo, int hi){

        int mid = (hi-lo)/2 + lo;

        if (searchList[mid] == valueToSearch) return mid;

        if (valueToSearch > searchList[mid]) {
            return binary_search(valueToSearch, mid +1, hi);
        } else {
            return binary_search(valueToSearch, lo, mid-1);
        }

    }

}



class Exercise_5_6 {

    Exercise_5_6(int[] sortedList, int searchValue){
        System.out.print(booleanBinarySearch(sortedList, searchValue));
    }

    public boolean booleanBinarySearch(int[] list, int searchValue){

        if (list.length == 0) return false;

        int mid = list.length/2;

        if (searchValue == list[mid]) {
            return true;
        }

        if (searchValue < list[mid]){
            int[] newArray = Arrays.copyOfRange(list, 0, mid);
            return booleanBinarySearch(newArray, searchValue);
        } else {

            int[] newArray = Arrays.copyOfRange(list, mid+1, list.length);
            return booleanBinarySearch(newArray, searchValue);
        }

    }

}


class Exercise_5_7 {
    int []integers;
    Exercise_5_7(int[] integer_array){
         this.integers= integer_array;
    }

    public int findIndexWithEqualValue( int lo, int high) {

        if (lo == high) return -1;

        int mid = lo + (high-lo)/2;

        if (mid == this.integers[mid]) {
            return mid;
        }
        if (mid < this.integers[mid]){
            return findIndexWithEqualValue(lo, mid-1);
        }
        if (mid > this.integers[mid]){
            return findIndexWithEqualValue(mid + 1, high);
        }

        return -1;
    }
}


class Exercise_5_8 {
    int[] integers;
    Exercise_5_8(int[] list){
        this.integers = list;
    }

    int determineGreatestEvenIndex(int lo, int high){

        if (lo == high) return -1;

        int mid = lo + (high-lo)/2;

        if (this.integers[mid] % 2 == 0){

            if (this.integers[mid + 1] % 2 ==1) {
                return mid;
            }
            return determineGreatestEvenIndex(mid+1, high);
        }
        if (this.integers[mid] % 2 == 1){
            return determineGreatestEvenIndex(lo, mid-1);
        }

        return -1;

    }
}


class Exercise_5_9{
    int soughtValue;
    double approximation;
    Exercise_5_9(int desiredValue, double approximation ){
        this.soughtValue = desiredValue;
        this.approximation = approximation;
    }

    double determineApproximation(int n, double value){
        if (n == 0) return this.approximation;

            return this.determineApproximation(n-1, value) - this.implementFunction(n, value)/ this.implementDerivative(n, value);

    }

    double implementFunction(int n, double value){
        return Math.pow(this.determineApproximation(n-1, value), 2) - value;
    }

    double implementDerivative(int n, double value){
        return 2*this.determineApproximation(n-1, value);
    }

}