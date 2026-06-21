import java.util.*;
public class sumofdigits {
public static void main(String args[]){

    Scanner sc = new Scanner(System.in);

    if(!sc.hasNextInt()){
        return;
    }   

    int n = sc.nextInt();
    int sum = 0;

    while(n>0){
        int digit = n%10;
        sum = sum+digit;
        n = n/10;
    }

    System.out.println(sum);

    sc.close();
        
    }
    
}
