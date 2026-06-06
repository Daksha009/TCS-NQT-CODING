import java.util.*;

public class fibonacci {
    public static void main(String[] args){
     Scanner sc = new Scanner(System.in);

     if(!sc.hasNextInt()){
        return;
     }

     int n = sc.nextInt();

     int a = 0;
     int b = 1;

     for(int i = 1;i<=n;i++){
        System.out.println(a);

        if(i<n){
            System.out.println(" ");
        }

        int c = a+b;
        a=b;
        b=c;
     }

     sc.close();
    }

    
}
