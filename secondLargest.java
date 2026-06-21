import java.util.*;

public class secondLargest {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        if(!sc.hasNextInt()){
            return;
        }
        int n = sc.nextInt();

        int arr[] = new int[n];

        for(int i = 0;i<=n-1;i++){
            if(sc.hasNextInt()){
                arr[i] = sc.nextInt();
            }
        }

        int largest = Integer.MIN_VALUE;
        int secondlargest = Integer.MIN_VALUE;


        for(int i = 0;i<=n-1;i++){
            if(arr[i]>largest){
                secondlargest = largest;
                largest = arr[i];
            }
            else if(arr[i]>secondlargest && arr[i]<largest){
                secondlargest = arr[i];
            }
        }

        if(secondlargest == Integer.MIN_VALUE){
            System.out.println(-1);
        }

        else{
            System.out.println(secondlargest);
        }

        sc.close();
    }
    
}
