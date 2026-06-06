import java.util.*;

public class Main01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        if(!sc.hasNextInt()){
            return;
        }

        int n = sc.nextInt();

        if(n<=1){
            System.out.println("Not Prime");
            sc.close();
            return;
        }

        boolean isPrime = true;

        for(int i = 2;i*i <=n;i++){
            if(n%2 == 0){
                isPrime = false;
                break;
            }
        }

        if(isPrime){
            System.out.println("Prime");
        }

        else{
            System.out.println("Not Prime");
        }

        sc.close();
    }
    
}

/*so the core logic of for loop here is that,if a number would be prime it'll have a number less than
n itself only */

//take example of 7,for n=7 if we run the loop,theloop will run till i<=n(7),if reminder gets 0 its not prime,if its prime,there will be reminder

