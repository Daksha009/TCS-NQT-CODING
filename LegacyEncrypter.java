import java.util.*;
public class LegacyEncrypter {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNext()){
            return;
        }

        String s = sc.next();
        char[] arr = s.toCharArray(); //s.toCharArray() takes a locked String and shatters it into a flexible Array of Characters.

        int left = 0;
        int right = arr.length-1;

        while(left<right){

            while(left<right && !isVowel(arr[left])){
                left++;
            }

            while(left<right && !isVowel(arr[right])){
                right--;
            }

            if(left<right){
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }

        }
        
        //convert char back to string and print
        System.out.println(new String(arr));
        sc.close();
    }

    

private static boolean isVowel(char c){
    c = Character.toLowerCase(c);
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
}
}
