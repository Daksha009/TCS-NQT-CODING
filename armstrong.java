import java.util.*;

public class armstrong {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        if(!sc.hasNextInt()){
            return;
        }
    

    int n = sc.nextInt();

    int orignal = n;
    int sum = 0;

    while(n>0){
        int digit = n%10; // remainder = last digit
        sum = sum + digit * digit * digit;
        n = n/10; // updating the value of n for next loop to get next digit.


    }

    if(orignal == sum){
        System.out.println("Armstrong");
    }
    else {
        System.out.println("Not Armstrong");
    }

    sc.close();
    
}
}
