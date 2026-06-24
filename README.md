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

---

## 8. Reverse a Number — `reverseAnum.java`

| | |
|---|---|
| **Pattern** | Digit Extraction & Reconstruction |
| **Problem** | Reverse the digits of an integer. |
| **Logic** | `rev = rev * 10 + (n % 10)` builds the number from the last digit forward. `n /= 10` strips the last digit each iteration. |
| **Complexity** | `O(d)` time · `O(1)` space |

> 💡 **Revision tip:** `rev * 10` shifts digits left to "make room" for the next one. This one-liner is the foundation for palindrome checks too.

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

---

## 10. Sum of Digits — `sumofdigits.java`

| | |
|---|---|
| **Pattern** | Digit Extraction + Accumulation |
| **Problem** | Find the sum of all digits of a number. |
| **Logic** | `digit = n % 10` → `sum += digit` → `n /= 10`. Repeat until `n == 0`. |
| **Complexity** | `O(d)` time · `O(1)` space |

> 💡 **Revision tip:** Simplest form of the `% 10` / `/ 10` loop. If you get this, you get Armstrong, Palindrome, and Reverse for free.

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

---

## 🔁 Common Patterns Cheat Sheet

| Pattern | Used In | Core Idea |
|---|---|---|
| **Digit Extraction** (`% 10` / `/ 10`) | Reverse, Palindrome, Armstrong, Sum of Digits | Process a number digit-by-digit from right to left |
| **Two Pointers** | Target Sum | Squeeze from both ends on sorted data |
| **Boyer-Moore Voting** | Dominant Signal | Cancel-out approach to find majority element |
| **Euclidean GCD** | GCD, LCM | `gcd(a,b) = gcd(b, a%b)` until remainder is 0 |
| **Single-pass Min/Max Tracking** | Second Largest | Track top-k values in one traversal |
| **Custom Sorting & Merge** | Server Block Allocation | Sort by start time, then merge adjacent overlaps |
| **Frequency Array** | Secure Packet | Count character occurrences using a fixed-size array |

---

*Keep grinding 🔥 — Daksha*
