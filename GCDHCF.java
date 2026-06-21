import java.util.*;

public class GCDHCF {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        if(!sc.hasNextInt()){
            return;
        }

        int a = sc.nextInt();

        if(!sc.hasNextInt()){
            return;
        }

        int b = sc.nextInt();

        int x = a;
        int y = b;

        while(y!=0){
            int rem = x%y;
            x = y;
            y = rem;
        }

        System.out.println(x);

        sc.close();
    }
    
}
