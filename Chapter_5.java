public class Chapter_5 {

    Chapter_5(){
        Exercise_5_1 answer = new Exercise_5_1(42281);
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