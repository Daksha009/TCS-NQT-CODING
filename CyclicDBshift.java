import java.util.*;
public class CyclicDBshift {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        if(!sc.hasNext()){
            return;
        }
        String s1 = sc.next();
        String s2 = sc.next();

        if(s1.length() != s2.length()){
            System.out.println("NO");
            return;
        }

        String doubled = s1 + s1;

        if(doubled.contains(s2)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

        sc.close();
    }
    
}
