import java.util.*;
public class securePacket {
public static void main(String[] args){
 Scanner sc = new Scanner(System.in);

if(!sc.hasNext()){
    return;
}

String s = sc.next();

int [] freq = new int[26];

for(int i = 0;i<s.length();i++){
    freq[s.charAt(i) - 'a']++;
}
int oddCount = 0;

for(int i = 0;i<26 ; i++){
    if(freq[i] % 2 != 0){
        oddCount++;
    }
    
}
//if there are more than one char with odd freq
if(oddCount>1){
    System.out.println("NO");

}
else{
    System.out.println("YES");
}
sc.close();
}
}





//Lexicographical frequency counter
/*The Math Trick: A string can be rearranged into a palindrome if and only if at most ONE character has an odd frequency count. (e.g., in "tacocat", 'a' appears 2 times, 'c' appears 2 times, 't' appears 2 times, and only 'o' appears 1 time).

The Pattern: Create an int[26] frequency array. Iterate through the string and count character occurrences. Then, iterate through the 26 slots. If you find more than one odd number, it is impossible to form a palindrome. */
