import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        System.out.println("hello world!");

        primeCalculation prime = new primeCalculation();

        //prime.prime(12);

        for(int i = 1; i <= 10001; i++){
            prime.prime(i);
        }

    }

}
