# 🧠 TCS NQT – DSA Prep (Java)

Quick-revision cheat sheet for every problem in this repo.  
Each entry covers the **core algo/pattern**, the **key trick**, and the **time & space complexity**.

---

## 1. Dominant Signal — `DominantSignal.java`

| | |
|---|---|
| **Pattern** | Boyer-Moore Majority Vote |
| **Problem** | Find the element that appears more than ⌊n/2⌋ times (majority element). |
| **Logic** | Keep a `candidate` and a `votes` counter. If `votes == 0`, pick current element as new candidate. If next element matches → `votes++`, else → `votes--`. The majority element always survives. |
| **Why it works** | Every "wrong" vote cancels out one "right" vote. Since majority has > n/2 count, it can never be fully cancelled. |
| **Complexity** | `O(n)` time · `O(1)` space |

> 💡 **Revision tip:** Think of it as a battle — the majority element always has more soldiers left standing.

### Full Problem Statement
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊n/2⌋ times. You may assume that the majority element always exists in the array. Your algorithm must run in O(N) time and use strictly O(1) auxiliary space.

### Code
```java
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
```
### Line-by-Line Explanation
1-2: Imports utility classes and declares the main class `DominantSignal`.
3-12: Standard I/O setup using `Scanner`. Reads the size of the array `n` and populates the array `arr`.
14-16: Initializes variables for Boyer-Moore algorithm: `candidate` to store the current majority candidate, and `votes` to track its count.
18-27: Iterates through the array. If `votes` is 0, the current element becomes the new `candidate` and `votes` is set to 1. If the current element matches the `candidate`, `votes` is incremented. Otherwise, `votes` is decremented.
28: Prints the `candidate`, which is guaranteed to be the majority element as per problem constraints.
30-31: Closes the scanner and ends the main method.

---

## 2. GCD / HCF — `GCDHCF.java`

| | |
|---|---|
| **Pattern** | Euclidean Algorithm |
| **Problem** | Find the Greatest Common Divisor of two numbers. |
| **Logic** | Repeatedly replace `(x, y)` with `(y, x % y)` until `y == 0`. The answer is `x`. |
| **Why it works** | `gcd(a, b) == gcd(b, a % b)` — the GCD doesn't change when you subtract multiples. |
| **Complexity** | `O(log(min(a,b)))` time · `O(1)` space |

> 💡 **Revision tip:** Just remember the loop — `while(y != 0) { rem = x%y; x = y; y = rem; }`

### Full Problem Statement
Given two positive integers a and b, find their Greatest Common Divisor (GCD) or Highest Common Factor (HCF). The GCD is the largest positive integer that divides both a and b without leaving a remainder.

### Code
```java
import java.util.*;

public class GCDHCF {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        if(!sc.hasNextInt()){
            return;
        }

        int a = sc.nextInt();

        if(!sc.hasNextInt()){
            return;
        }

        int b = sc.nextInt();

        int x = a;
        int y = b;

        while(y!=0){
            int rem = x%y;
            x = y;
            y = rem;
        }

        System.out.println(x);

        sc.close();
    }
    
}
```
### Line-by-Line Explanation
1-3: Imports utility classes and declares the main class `GCDHCF`.
4-17: Sets up `Scanner` and reads two integers `a` and `b`.
19-20: Initializes variables `x` and `y` with the values of `a` and `b`.
22-26: The Euclidean algorithm loop. Runs as long as `y` is not 0. In each iteration, it calculates the remainder `rem = x % y`, updates `x` to the previous `y`, and `y` to the `rem`.
28: Once `y` reaches 0, `x` contains the Greatest Common Divisor (GCD), which is printed.
30-31: Closes the scanner and ends the main method.

---

## 3. LCM — `LCM.java`

| | |
|---|---|
| **Pattern** | GCD-based formula |
| **Problem** | Find the Least Common Multiple of two numbers. |
| **Logic** | `LCM(a, b) = (a * b) / GCD(a, b)` — compute GCD first using Euclidean algo, then plug into formula. |
| **Why it works** | LCM × GCD = product of the two numbers (fundamental identity). |
| **Complexity** | `O(log(min(a,b)))` time · `O(1)` space |

> 💡 **Revision tip:** Always compute GCD first. LCM is just one division away.

### Full Problem Statement
Given two positive integers a and b, find their Least Common Multiple (LCM). The LCM of two integers is the smallest positive integer that is perfectly divisible by both the given numbers.

### Code
```java
import java.util.*;
public class LCM {
    //LCM = (a*b)/GCD
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        if(!sc.hasNextInt()){
            return;
        }

        
    }
    
}
```
### Line-by-Line Explanation
1-2: Imports utility classes and declares the main class `LCM`.
4-11: Sets up `Scanner` and checks for integer input. (Note: The provided code snippet is incomplete and missing the logic to read `a` and `b` and compute the LCM using the formula `(a * b) / GCD(a, b)`).

---

## 4. Server Block Allocation — `ServerBlockAlloc.java`

| | |
|---|---|
| **Pattern** | Custom Sorting & Interval Merging |
| **Problem** | Merge overlapping contiguous server blocks. |
| **Logic** | Sort the 2D array of blocks by `start_time`. Iterate and maintain a list of merged blocks. If a block overlaps with the last merged block (`current_start <= last_end`), extend `last_end` to `max(last_end, current_end)`. Else, add as a new block. |
| **Why it works** | Sorting guarantees that any overlapping intervals will be adjacent to each other, allowing a single sweep. |
| **Complexity** | `O(n log n)` time · `O(n)` space |

> 💡 **Revision tip:** Sort by start time first! Then merge by checking if `current_start <= last_end`.

### Full Problem Statement
You are given an array of server block allocations where each interval is represented as `[start_time, end_time]`. Some of these server blocks may overlap. Merge all overlapping blocks and return an array of the non-overlapping blocks that cover all the time intervals originally given.

### Code
```java
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
```
### Line-by-Line Explanation
1-2: Imports utility classes and declares the main class `ServerBlockAlloc`.
3-16: Sets up `Scanner`, reads the number of intervals `n`, and populates a 2D array `intervals` where each row represents `[start_time, end_time]`.
18-19: Sorts the `intervals` array based on the start time using a custom comparator.
21-22: Initializes a dynamic `ArrayList` named `merged` to store the final merged intervals.
24-33: Iterates through each `currentInterval`. If `merged` is empty or there is no overlap (the start time of `currentInterval` is greater than the end time of the last merged interval), it adds `currentInterval` to `merged`. Otherwise, it resolves the overlap by updating the end time of the last merged interval to the maximum of the two end times.
34-40: Iterates through the `merged` list and prints the combined intervals.
41-42: Closes the scanner and ends the main method.

---

## 5. Target Sum (Two Sum – Sorted) — `TargetSum.java`

| | |
|---|---|
| **Pattern** | Two Pointer (on sorted array) |
| **Problem** | Check if any two elements in a sorted array add up to a target `k`. |
| **Logic** | Place `left` at start, `right` at end. If `sum == k` → found. If `sum > k` → `right--`. If `sum < k` → `left++`. |
| **Why it works** | Array is sorted, so moving pointers narrows the search space deterministically — no pair is skipped. |
| **Complexity** | `O(n)` time · `O(1)` space |

> 💡 **Revision tip:** Two pointers on sorted = guaranteed O(n). If unsorted, use a HashSet instead.

### Full Problem Statement
Given a 1-indexed array of integers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number `k`. Return YES if such a pair exists, otherwise return NO. You must use exactly O(1) extra space.

### Code
```java
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
```
### Line-by-Line Explanation
1-3: Imports utility classes and declares the main class `TargetSum`.
4-16: Sets up `Scanner`, reads the size of the array `n` and the target sum `k`, and populates the array `arr`.
17-19: Initializes two pointers: `left` at the beginning (0) and `right` at the end (`n-1`). `found` is a boolean flag to track if the target sum is found.
21-32: A `while` loop that runs as long as `left` is less than `right`. It calculates the `currsum`. If it equals `k`, the pair is found and the loop breaks. If `currsum` is greater than `k`, it means the sum needs to be smaller, so `right` is decremented. If `currsum` is less than `k`, it means the sum needs to be larger, so `left` is incremented.
34: Prints "YES" if found, otherwise "NO" using a ternary operator.
35-36: Closes the scanner and ends the main method.

---

## 6. Armstrong Number — `armstrong.java`

| | |
|---|---|
| **Pattern** | Digit Extraction + Math Check |
| **Problem** | Check if a number equals the sum of cubes of its digits (3-digit Armstrong). |
| **Logic** | Extract each digit with `n % 10`, cube it, accumulate sum. Chop last digit with `n / 10`. Compare sum to original. |
| **Key formula** | `153 → 1³ + 5³ + 3³ = 1 + 125 + 27 = 153 ✅` |
| **Complexity** | `O(d)` time where d = number of digits · `O(1)` space |

> 💡 **Revision tip:** `% 10` gives last digit, `/ 10` removes it. This pattern is reused in reverse, palindrome, sum of digits — master it once.

### Full Problem Statement
Given an integer `n`, write a program to check if it is an Armstrong number or not. An Armstrong number is a number that is equal to the sum of cubes of its digits. For example, 153 is an Armstrong number because 1^3 + 5^3 + 3^3 = 153.

### Code
```java
import java.util.*;

public class armstrong {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        if(!sc.hasNextInt()){
            return;
        }
    

    int n = sc.nextInt();

    int orignal = n;
    int sum = 0;

    while(n>0){
        int digit = n%10; // remainder = last digit
        sum = sum + digit * digit * digit;
        n = n/10; // updating the value of n for next loop to get next digit.


    }

    if(orignal == sum){
        System.out.println("Armstrong");
    }
    else {
        System.out.println("Not Armstrong");
    }

    sc.close();
    
}
}
```
### Line-by-Line Explanation
1-3: Imports utility classes and declares the main class `armstrong`.
4-12: Sets up `Scanner` and reads an integer `n`.
14-15: Stores the `orignal` value of `n` to compare later and initializes `sum` to 0.
17-23: A `while` loop extracts digits. `n % 10` gets the last digit. The cube of the digit is added to `sum`. `n / 10` removes the last digit.
25-30: Compares the accumulated `sum` with the `orignal` number. If they match, prints "Armstrong", else "Not Armstrong".
32-34: Closes the scanner and ends the main method.

---

## 7. Palindrome Number — `palindrome.java`

| | |
|---|---|
| **Pattern** | Reverse & Compare |
| **Problem** | Check if a number reads the same forwards and backwards. |
| **Logic** | Build the reversed number digit-by-digit: `rev = rev * 10 + (n % 10)`, then `n /= 10`. Compare `rev` with original. |
| **Key insight** | Same digit-extraction loop as reverse — just with a comparison at the end. |
| **Complexity** | `O(d)` time · `O(1)` space |

> 💡 **Revision tip:** Palindrome = Reverse + equals check. Save original before the loop!

### Full Problem Statement
Given an integer `n`, determine if it is a palindrome. An integer is a palindrome when it reads the same backward as forward. For example, 121 is a palindrome while 123 is not.

### Code
```java
import java.util.*;
public class palindrome {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        if(!sc.hasNextInt()){

            return;
        }
        int n = sc.nextInt();

        int orignal = n;
        int rev = 0;

        while(n>0){
           int  digit = n%10;
            rev = rev*10 + digit;
            n = n/10;
        }
        if(orignal == rev ){
            System.out.println("Palindrome");
        }
        else{
            System.out.println("Not Palindrome");
        }

        sc.close();
    }

    
}
```
### Line-by-Line Explanation
1-2: Imports utility classes and declares the main class `palindrome`.
4-11: Sets up `Scanner` and reads an integer `n`.
13-14: Stores the `orignal` value of `n` and initializes `rev` to 0 to build the reversed number.
16-20: A `while` loop extracts digits. `n % 10` gets the last digit. `rev = rev * 10 + digit` shifts existing digits left and adds the new digit. `n / 10` removes the last digit.
21-26: Compares the `orignal` number with the reversed number `rev`. Prints "Palindrome" if they match, else "Not Palindrome".
28-29: Closes the scanner and ends the main method.

---

## 8. Reverse a Number — `reverseAnum.java`

| | |
|---|---|
| **Pattern** | Digit Extraction & Reconstruction |
| **Problem** | Reverse the digits of an integer. |
| **Logic** | `rev = rev * 10 + (n % 10)` builds the number from the last digit forward. `n /= 10` strips the last digit each iteration. |
| **Complexity** | `O(d)` time · `O(1)` space |

> 💡 **Revision tip:** `rev * 10` shifts digits left to "make room" for the next one. This one-liner is the foundation for palindrome checks too.

### Full Problem Statement
Given an integer `n`, write a program to reverse its digits. For example, if the input is 1234, the output should be 4321.

### Code
```java
import java.util.*;

public class reverseAnum {
    public static void main(String[] args) {
        
    
    Scanner sc =  new Scanner(System.in);

    if(!sc.hasNextInt()){
        return;
    }

    int n = sc.nextInt();

    int rev  = 0;

    while(n>0){
        int digit = n%10;
        rev = rev*10 + digit;
        n = n/10;
    }

    System.out.println(rev);

    sc.close();

}
}
```
### Line-by-Line Explanation
1-3: Imports utility classes and declares the main class `reverseAnum`.
4-13: Sets up `Scanner` and reads an integer `n`.
15: Initializes `rev` to 0 to store the reversed number.
17-21: A `while` loop extracts digits. `n % 10` gets the last digit. `rev = rev * 10 + digit` shifts existing digits left and adds the new digit. `n / 10` removes the last digit.
23: Prints the fully reversed number `rev`.
25-27: Closes the scanner and ends the main method.

---

## 9. Second Largest — `secondLargest.java`

| | |
|---|---|
| **Pattern** | Single-pass tracking (two variables) |
| **Problem** | Find the second largest distinct element in an array. |
| **Logic** | Track `largest` and `secondLargest`. If `arr[i] > largest` → demote largest to second, update largest. Else if `arr[i] > secondLargest && arr[i] < largest` → update secondLargest. |
| **Edge case** | If all elements are equal, `secondLargest` stays at `MIN_VALUE` → output `-1`. |
| **Complexity** | `O(n)` time · `O(1)` space |

> 💡 **Revision tip:** The "demote" step (`secondLargest = largest`) is the key move — don't forget it before updating `largest`.

### Full Problem Statement
Given an array of integers of size `n`, find the second largest distinct element in the array. If no such element exists (for example, if all elements are the same), print -1.

### Code
```java
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
```
### Line-by-Line Explanation
1-3: Imports utility classes and declares the main class `secondLargest`.
4-18: Sets up `Scanner`, reads `n`, and populates the array `arr`.
20-21: Initializes `largest` and `secondlargest` with `Integer.MIN_VALUE`.
24-32: Iterates through the array. If the current element is greater than `largest`, `largest` is demoted to `secondlargest`, and the current element becomes the new `largest`. Else, if the current element is less than `largest` but greater than `secondlargest`, it updates `secondlargest`.
34-40: If `secondlargest` remains `Integer.MIN_VALUE` (meaning no second distinct element exists), it prints `-1`. Otherwise, it prints the `secondlargest`.
42-43: Closes the scanner and ends the main method.

---

## 10. Sum of Digits — `sumofdigits.java`

| | |
|---|---|
| **Pattern** | Digit Extraction + Accumulation |
| **Problem** | Find the sum of all digits of a number. |
| **Logic** | `digit = n % 10` → `sum += digit` → `n /= 10`. Repeat until `n == 0`. |
| **Complexity** | `O(d)` time · `O(1)` space |

> 💡 **Revision tip:** Simplest form of the `% 10` / `/ 10` loop. If you get this, you get Armstrong, Palindrome, and Reverse for free.

### Full Problem Statement
Given an integer `n`, write a program to calculate the sum of all its digits. For example, if the input is 123, the output should be 1 + 2 + 3 = 6.

### Code
```java
import java.util.*;
public class sumofdigits {
public static void main(String args[]){

    Scanner sc = new Scanner(System.in);

    if(!sc.hasNextInt()){
        return;
    }   

    int n = sc.nextInt();
    int sum = 0;

    while(n>0){
        int digit = n%10;
        sum = sum+digit;
        n = n/10;
    }

    System.out.println(sum);

    sc.close();
        
    }
    
}
```
### Line-by-Line Explanation
1-2: Imports utility classes and declares the main class `sumofdigits`.
3-12: Sets up `Scanner`, reads the integer `n`, and initializes `sum` to 0.
14-18: A `while` loop extracts digits. `n % 10` gets the last digit, which is added to `sum`. `n / 10` removes the last digit for the next iteration.
20: Prints the accumulated `sum` of the digits.
22-24: Closes the scanner and ends the main method.

---

## 11. Secure Packet (Palindrome Check) — `securePacket.java`

| | |
|---|---|
| **Pattern** | Lexicographical Frequency Counter |
| **Problem** | Check if a string can be rearranged into a palindrome. |
| **Logic** | Create an `int[26]` frequency array to count character occurrences. If more than one character has an odd frequency, it cannot form a palindrome. |
| **Why it works** | A palindrome reads the same forwards and backwards. Characters must occur in pairs, with at most one character having an odd count (the middle element). |
| **Complexity** | `O(n)` time · `O(1)` space |

> 💡 **Revision tip:** Count the frequencies. If `oddCount > 1`, return NO.

### Full Problem Statement
You are given a string `s` representing a packet of data. Check if the characters of the string can be rearranged to form a palindrome. Print YES if it is possible, and NO otherwise.

### Code
```java
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
```
### Line-by-Line Explanation
1-2: Imports utility classes and declares the main class `securePacket`.
3-10: Sets up `Scanner` and reads the input string `s`.
12: Initializes an integer array `freq` of size 26 to act as a frequency counter for the lowercase alphabet.
14-16: Iterates through each character of the string `s`. `s.charAt(i) - 'a'` calculates the alphabetical index (0 for 'a', 25 for 'z') and increments its count.
17-24: Initializes `oddCount` to track how many characters have an odd frequency. Iterates through the `freq` array and increments `oddCount` for any odd value.
25-32: According to palindrome rules, at most one character can have an odd count. If `oddCount > 1`, prints "NO", otherwise prints "YES".
33-34: Closes the scanner and ends the main method.

---

## 12. Anagram Clusters — `AnagramClusters.java`

| | |
|---|---|
| **Pattern** | HashMap with Sorted Keys |
| **Problem** | Group and count frequencies of anagrams. |
| **Logic** | Convert each string to a char array, sort it, and use the sorted string as a key in a HashMap. Increment the count for that key. |
| **Why it works** | Anagrams contain exactly the same characters, so sorting them always yields the identical string key. |
| **Complexity** | `O(n * k log k)` time (k = max word length) · `O(n * k)` space |

> 💡 **Revision tip:** Sort the word to create a canonical signature, then use it as a HashMap key.

### Full Problem Statement
You are given an integer `n` followed by `n` words. An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once. Your task is to group all the words that are anagrams of each other and print the count of words in each anagram cluster.

### Code
```java
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
```
### Line-by-Line Explanation
1-2: Imports utility classes and declares the main class `AnagramClusters`.
3-12: Sets up `Scanner` and reads the integer `n` (number of words).
14-15: Initializes a `HashMap` named `map` to store the sorted version of a string as the key and its frequency count as the value.
17-27: Iterates `n` times to read each `word`. Converts the `word` to a character array, sorts it, and reconstructs it into a `sortedKey`. This acts as a canonical signature for anagrams. It then increments the count for this `sortedKey` in the `map`.
28-30: Iterates through the values of the `map` and prints the count of each anagram cluster.
31-32: Closes the scanner and ends the main method.

---

## 13. Legacy Encrypter (Reverse Vowels) — `LegacyEncrypter.java`

| | |
|---|---|
| **Pattern** | Two Pointers |
| **Problem** | Reverse only the vowels in a given string. |
| **Logic** | Use `left` and `right` pointers. Advance `left` until a vowel is found, and `right` backwards until a vowel is found. Swap them, then move both inward. |
| **Why it works** | Consonants stay in their original positions, and the two pointers efficiently pair vowels from opposite ends for swapping. |
| **Complexity** | `O(n)` time · `O(n)` space (for char array) |

> 💡 **Revision tip:** Just like reversing an array, but with `while(!isVowel)` checks before swapping.

### Full Problem Statement
You are given a string `s`. Your task is to reverse only the vowels in the string while keeping the consonants in their original positions. Vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases.

### Code
```java
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
```
### Line-by-Line Explanation
1-2: Imports utility classes and declares the main class `LegacyEncrypter`.
3-10: Sets up `Scanner`, reads the string `s`, and converts it into a character array `arr` to allow in-place modifications.
12-13: Initializes two pointers: `left` at the start and `right` at the end of the array.
15-33: A `while` loop that runs as long as `left < right`. Inside, it advances `left` until a vowel is found, and decrements `right` until a vowel is found. Then, it swaps the vowels at `left` and `right` and moves both pointers inward.
35-37: Converts the modified character array back to a `String` and prints it.
42-45: A private helper method `isVowel` that checks if a given character (case-insensitive) is a vowel ('a', 'e', 'i', 'o', 'u').

---

## 14. Server Uptime Chain — `ServerUptimeChain.java`

| | |
|---|---|
| **Pattern** | HashSet for O(1) lookups |
| **Problem** | Find the length of the longest consecutive sequence in an unsorted array. |
| **Logic** | Add all elements to a HashSet. For each element, check if it's the start of a sequence (`!set.contains(num - 1)`). If yes, count upwards as long as `set.contains(num + 1)`. |
| **Why it works** | The HashSet provides O(1) lookups. By only starting a streak when `num - 1` is absent, we ensure O(n) total time instead of O(n²). |
| **Complexity** | `O(n)` time · `O(n)` space |

> 💡 **Revision tip:** Only start counting if `num - 1` is NOT in the set! This avoids redundant work.

### Full Problem Statement
You are given an unsorted array of integers representing server uptimes. Find the length of the longest consecutive elements sequence. You must write an algorithm that runs in O(n) time.

### Code
```java
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
```
### Line-by-Line Explanation
1-2: Imports utility classes and declares the main class `ServerUptimeChain`.
3-12: Sets up `Scanner`, reads the size `n`, and creates an array `arr` and a `HashSet` named `set`.
15-18: Populates the array `arr` and adds all elements into the `set` for O(1) lookups.
19: Initializes `longestStreak` to keep track of the maximum sequence length.
21-36: Iterates through the array. It checks if `arr[i] - 1` is NOT in the `set`. If true, `arr[i]` is the start of a sequence. A `while` loop then counts upwards, checking if `set` contains `currentNum + 1`, and increments `currentStreak`. Finally, it updates `longestStreak` using `Math.max`.
38-40: Prints the `longestStreak`, closes the scanner, and ends the main method.

---

## 🔁 Common Patterns Cheat Sheet

| Pattern | Used In | Core Idea |
|---|---|---|
| **Digit Extraction** (`% 10` / `/ 10`) | Reverse, Palindrome, Armstrong, Sum of Digits | Process a number digit-by-digit from right to left |
| **Two Pointers** | Target Sum, Legacy Encrypter | Squeeze from both ends (or under specific conditions) |
| **Boyer-Moore Voting** | Dominant Signal | Cancel-out approach to find majority element |
| **Euclidean GCD** | GCD, LCM | `gcd(a,b) = gcd(b, a%b)` until remainder is 0 |
| **Single-pass Min/Max Tracking** | Second Largest | Track top-k values in one traversal |
| **Custom Sorting & Merge** | Server Block Allocation | Sort by start time, then merge adjacent overlaps |
| **Frequency Array** | Secure Packet | Count character occurrences using a fixed-size array |
| **HashMap w/ Canonical Keys** | Anagram Clusters | Sort string characters to use as a unified key |
| **HashSet Lookups** | Server Uptime Chain | O(1) existence checks to find consecutive sequences |

---

*Keep grinding 🔥 — Daksh*
