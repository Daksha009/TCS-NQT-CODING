import java.util.*;
public class TargetTrafficCount {
    public static void main(String[] args){
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
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1); //base case: one way to get a sum of 0

        int currentSum = 0;
        int totalSubarrays = 0;

        for(int i = 0;i<n;i++){
            currentSum += arr[i];

            int neededPrefix = currentSum - k;
            if(map.containsKey(neededPrefix)) {
                totalSubarrays += map.get(neededPrefix);

            }
            map.put(currentSum,map.getOrDefault(currentSum,0)+1);
        }
        System.out.println(totalSubarrays);
        sc.close();
    }
    
}
