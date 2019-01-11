import java.util.ArrayList;

public class primeCalculation {

    public void prime(int input){
        int maxRow = (input-1)/10;
        int lastCol = (input-1)%10;

        ArrayList<ArrayList<Integer>> sieve = new ArrayList<>(maxRow);

        for(int row = 0; row <= maxRow; row++){
            sieve.add(new ArrayList<>());
            for(int col = 0; col < 10; col++){
                if((row == maxRow)&&(col > lastCol)){
                    break;
                }
                if((row==0)&&(col==0)){
                    sieve.get(row).add(col,null);
                }
                else{
                    sieve.get(row).add(col, col + row * 10 + 1);
                }
            }
        }

        int number = 0;
        int startRow = 0;
        int primeCount = 0;
        while(true)
        {

            for(int row = startRow; row <= maxRow; row++){
                for(int col = 0; col < 10; col++) {
                    if((row == maxRow)&&(col > lastCol)){
                        break;
                    }
                    if ((sieve.get(row).get(col) != null)&&((sieve.get(row).get(col)) > number)) {
                        number = sieve.get(row).get(col);
                        startRow = row;
                        row = maxRow + 1;
                        col = 10;
                    }
                }
            }
            int i = 2;
            int multiplication = number*i;
            if((number*number > input)||(number==0)) {
                break;
            }
            else{
                while (multiplication <= input) {
                    sieve.get((multiplication-1) / 10).set((multiplication-1) % 10, null);
                    multiplication = number*i++;
                }
            }
        }

        System.out.print(input+" ");

        for(int row = 0; row <= maxRow; row++){
            for(int col = 0; col < 10; col++){
                if((row == maxRow)&&(col > lastCol)){
                    break;
                }
                if(sieve.get(row).get(col)!=null) {
                    primeCount++;
                    System.out.print(sieve.get(row).get(col) + " ");
                }
                if((row == maxRow)&&(col == lastCol)){
                    break;
                }
            }
        }
        System.out.print("\n"+primeCount+"\n");
    }
}
