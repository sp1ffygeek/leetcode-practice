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
public class LongestPalindromicSubstringSimpleNCube {

  public static String longestPalindrome(String s) {
    if (s.length() == 1) {
      return s;
    }

    int size = 0;
    String result = null;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        String subStr = s.substring(i, j);
        System.out.println("subStr: " + subStr);
        if (isPalindrome(subStr) && subStr.length() >= size) {
          size = subStr.length();
          result = subStr;
        }
      }
    }
    return result;
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

  public static void main(String[] args) {
    LongestPalindromicSubstringSimpleNCube longestPalindromicSubstringSimpleNCube =
        new LongestPalindromicSubstringSimpleNCube();
    String s = longestPalindromicSubstringSimpleNCube.longestPalindrome("a");
    System.out.println("Result: " + s);
  }
}
