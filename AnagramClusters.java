import java.util.*;
public class AnagramClusters {
    public static void main(String[]args){

    
    Scanner sc = new Scanner(System.in);

    if(!sc.hasNextInt()){
        return;
    }

    int n = sc.nextInt();

    //hashmap stores <sorted string key,count of anagrams>
    HashMap<String,Integer> map = new HashMap<>();

    for(int i = 0;i<n;i++){
        String word = sc.next();
           //generating the sorted key
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        String sortedKey = new String(chars);

        //incerement count in map
        map.put(sortedKey,map.getOrDefault(sortedKey,0)+1);

    }
    for(int count : map.values()){
        System.out.println(count);
    }
    sc.close();
}
}
