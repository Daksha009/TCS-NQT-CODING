import java.util.*;
public class DominantSignal {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt()){
            return;
        }
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        //Boyer-moore voting algo
        int candidate = 0;
        int votes = 0;

        for(int i = 0;i<n;i++){
            if(votes == 0){
                candidate = arr[i];
                votes = 1;
            }else if(arr[i] == candidate){
                votes++;
            }else{
                votes--;
            }
        }
        System.out.println(candidate);

        sc.close();
    }
    
}

/*WHAT IS BOYER-MOORE ALGORITHM? */





/*Constraint Warning: To clear the hidden test cases,
 your algorithm must run in O(N) time and use strictly O(1) auxiliary space.
 You cannot use nested loops,
  and you cannot use a HashMap or frequency array to count occurrences. 
  (Assume a majority element always exists). */