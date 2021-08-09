package edu.practice.leetcode.medium;

// Given a string s, find the length of the longest substring without repeating characters.
//
//
//
// Example 1:
//
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
//
// Example 2:
//
// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
//
// Example 3:
//
// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
//
// Example 4:
//
// Input: s = ""
// Output: 0
//
//
//
// Constraints:
//
//    0 <= s.length <= 5 * 104
//    s consists of English letters, digits, symbols and spaces.

import java.util.Arrays;

// Method 3 (Linear Time): Let us talk about the linear time solution now. This solution uses extra
// space to store the last indexes of already visited characters. The idea is to scan the string
// from left to right, keep track of the maximum length Non-Repeating Character Substring seen so
// far in res. When we traverse the string, to know the length of current window we need two
// indexes.
// 1) Ending index ( j ) : We consider current index as ending index.
// 2) Starting index ( i ) : It is same as previous window if current character was not present in
// the previous window. To check if the current character was present in the previous window or not,
// we store last index of every character in an array lasIndex[]. If lastIndex[str[j]] + 1 is more
// than previous start, then we updated the start index i. Else we keep same i.
public class LongestSubstringLinearTime {
  public static void main(String[] args) {
    LongestSubstringLinearTime substring = new LongestSubstringLinearTime();
    int size = substring.lengthOfLongestSubstring("geeksforgeeks");
    System.out.println("Result: " + size);
  }

  public int lengthOfLongestSubstring(String s) {
    int[] lastIndex = new int[26];
    Arrays.fill(lastIndex, -1);
    int i = 0;
    int res = 0; // result
    for (int j = 0; j < s.length(); j++) {
      System.out.println("[j:     " + j + "]");

      // Find the last index of str[j]
      // Update i (starting index of current window)
      // as maximum of current value of i and last
      // index plus 1

      char c = s.charAt(j);
      System.out.println("[c:     " + c + "]");

      int idx = c - 'a';
      System.out.println("[idx:   " + idx + "]");

      int z = lastIndex[idx];

      System.out.println("[z:     " + z + "]");
      i = Math.max(i, z + 1);
      System.out.println("[i:     " + i + "]");
      // Update result if we get a larger window
      res = Math.max(res, j - i + 1);

      System.out.println("[res:   " + res + "]");

      lastIndex[idx] = j;

      System.out.println("[--------------------]");
    }

    return res;
  }
}
