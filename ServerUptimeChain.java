import java.util.*;
public class ServerUptimeChain {
    public static void main(String[] args){

    
    Scanner sc = new Scanner(System.in);
    if(!sc.hasNextInt()){
        return;
    }

    int n = sc.nextInt();
    int [] arr = new int[n];
    HashSet<Integer> set = new HashSet<>();

    for(int i = 0;i<n;i++){
        arr[i] = sc.nextInt();
        set.add(arr[i]); //add to hashset
    }
    int longestStreak = 0;

    for(int i = 0;i<n;i++){
        //only check if it is the beginning of a sequence
        if(!set.contains(arr[i] - 1)){
            int currentNum = arr[i];
            int currentStreak = 1;

        //count upwards in 0{1} lookups
        while(set.contains(currentNum+1)){
            currentNum += 1;
            currentStreak += 1;
        }

        longestStreak = Math.max(longestStreak,currentStreak);
    }
    
}

System.out.println(longestStreak);
sc.close();
}
}
