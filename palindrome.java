import java.util.*;
public class palindrome {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        if(!sc.hasNextInt()){

            return;
        }
        int n = sc.nextInt();

        int orignal = n;
        int rev = 0;

        while(n>0){
           int  digit = n%10;
            rev = rev*10 + digit;
            n = n/10;
        }
        if(orignal == rev ){
            System.out.println("Palindrome");
        }
        else{
            System.out.println("Not Palindrome");
        }

        sc.close();
    }

    
}
