import java.util.*;

public class Chapter_5 {

    Chapter_5(){
//       Exercise_5_1 answer = new Exercise_5_1(42281);
        Exercise_5_2 answeer = new Exercise_5_2();
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