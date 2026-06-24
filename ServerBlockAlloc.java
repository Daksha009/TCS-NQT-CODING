import java.util.*;
public class ServerBlockAlloc {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        if(!sc.hasNextInt()){
            return;
        }
        int n = sc.nextInt();
        int [] [] intervals = new int[n][2];

        for(int i = 0;i<n;i++){
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();

        }

        //Custom sort 2d array based on start time
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));

        //use arraylist to store dynamic merged results
        List<int[]> merged = new ArrayList<>();

        for(int[] currentInterval : intervals){
            //If empty OR no overlap with the last merged interval
            if(merged.isEmpty() || merged.get(merged.size() - 1 )[1] < currentInterval[0]){
                merged.add(new int[]{currentInterval[0],currentInterval[1]});

            }else{
                //overlap detected:merge them by extending the end time
                merged.get(merged.size() -1 )[1] = Math.max(merged.get(merged.size() -1)[1],currentInterval[1]);
            }
        }
        //output formatting
        for(int i = 0;i<merged.size();i++){
             System.out.print(merged.get(i)[0] + " " + merged.get(i)[1]);
             if(i<merged.size() -1 ){
                System.out.println();
             }
        }
        sc.close();
    }
    
}






//Pattern : custom sorting and interval merging
/*
The Digital Logic (Algorithm Breakdown)
The Trap: Trying to merge intervals while they are out of order requires $O(N^2)$ checks and massive conditional logic. It is a nightmare to code and will fail the time limits.The Prime Pattern (Sort & Sweep): 1. Sort: First, sort the 2D array based strictly on the start_time. (This brings overlapping intervals right next to each other). Time complexity: $O(N \log N)$.2. Sweep: Create an empty ArrayList to hold the final merged blocks. Iterate through the sorted intervals.3. The Condition: If the ArrayList is empty, or if the current interval's start_time is strictly greater than the last merged block's end_time, there is NO overlap. Add it as a new block.4. The Merge: If there IS an overlap,
 update the last merged block's end_time to be the maximum of the two overlapping ends. */