package edu.practice.leetcode.medium;

// Given a string s, return the longest palindromic substring in s.
//
//
//
// Example 1:
//
// Input: s = "babad"
// Output: "bab"
// Note: "aba" is also a valid answer.
//
// Example 2:
//
// Input: s = "cbbd"
// Output: "bb"
//
// Example 3:
//
// Input: s = "a"
// Output: "a"
//
// Example 4:
//
// Input: s = "ac"
// Output: "a"
//
//
//
// Constraints:
//
//    1 <= s.length <= 1000
//    s consist of only digits and English letters.
public class LongestPalindromicSubstringDynamicProg {

  public static int longestPalSubstr(String str) {
    // get length of input string
    int n = str.length();

    // table[i][j] will be false if
    // substring str[i..j] is not palindrome.
    // Else table[i][j] will be true
    boolean table[][] = new boolean[n][n];

    // All substrings of length 1 are palindromes
    int maxLength = 1;
    for (int i = 0; i < n; ++i) {
      table[i][i] = true;
    }

    // check for sub-string of length 2.
    int start = 0;
    for (int i = 0; i < n - 1; ++i) {
      if (str.charAt(i) == str.charAt(i + 1)) {
        table[i][i + 1] = true;
        start = i;
        maxLength = 2;
      }
    }

    // Check for lengths greater than 2.
    // k is length of substring
    for (int k = 3; k <= n; ++k) {

      // Fix the starting index
      for (int i = 0; i < n - k + 1; ++i) {
        // Get the ending index of substring from
        // starting index i and length k
        int j = i + k - 1;

        // checking for sub-string from ith index to
        // jth index iff str.charAt(i+1) to
        // str.charAt(j-1) is a palindrome
        if (table[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
          table[i][j] = true;

          if (k > maxLength) {
            start = i;
            maxLength = k;
          }
        }
      }
    }
    System.out.print("Longest palindrome substring is; ");
    printSubStr(str, start, start + maxLength - 1);

    // return length of LPS
    return maxLength;
  }

  public static boolean isPalindrome(String str) {
    if (str.length() == 0) {
      return false;
    }

    int startIndex = 0;
    int endIndex = str.length() - 1;
    while (str.charAt(startIndex) == str.charAt(endIndex)) {
      if (startIndex == endIndex || (startIndex + 1) == endIndex) {
        return true;
      }

      startIndex++;
      endIndex--;
    }
    return false;
  }

  // A utility function to print
  // a substring str[low..high]
  static void printSubStr(String str, int low, int high) {
    System.out.println(str.substring(low, high + 1));
  }

  public static void main(String[] args) {
    LongestPalindromicSubstringDynamicProg longestPalindromicSubstringDynamicProg =
        new LongestPalindromicSubstringDynamicProg();
    int size = longestPalindromicSubstringDynamicProg.longestPalSubstr("geeksforgeeks");
    System.out.println("Result: " + size);
  }
}
