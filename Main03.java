import java.util.*;

public class Main03 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        if(!sc.hasNextInt()){
            return;
        }

        int n = sc.nextInt();

        long fact = 1;

        for(int i=1;i<=n;i++){
            fact = fact*i;
        }

        System.out.println(fact);

        sc.close();
    }
    
}

/*core logic - for factorial of any number run a for loop
in which fact = fact*i
say i run a  loop for n=4
it'll run 4 times and each time --
fact = fact*i will execute */
