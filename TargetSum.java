import java.util.*;

public class TargetSum {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt()){
            return;
        }

        int n = sc.nextInt();
        int k = sc.nextInt();

        int [] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int left = 0;
        int right = n-1;
        boolean found = false;

        while(left<right){
            int currsum = arr[left] + arr[right];
            if(currsum == k){
                found = true;
                break;
            }
            else if(currsum>k){
                right--;
            }else{
                left++;
            }
        }

        System.out.println(found ? "YES" : "NO");
        sc.close();
    }
    
}
