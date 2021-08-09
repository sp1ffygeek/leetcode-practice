package edu.practice.leetcode.medium;


//Given a string s, find the length of the longest substring without repeating characters.
//
//
//
//Example 1:
//
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//
//Example 2:
//
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//
//Example 3:
//
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
//
//Example 4:
//
//Input: s = ""
//Output: 0
//
//
//
//Constraints:
//
//    0 <= s.length <= 5 * 104
//    s consists of English letters, digits, symbols and spaces.

//Method 2 (Better : O(n2)) The idea is to use window sliding. Whenever we see repitition,
// we remove the pervious occurrance and slide the window.
public class LongestSubstringSimpleNSquare {
    public static void main(String[] args) {
        LongestSubstringSimpleNSquare substring = new LongestSubstringSimpleNSquare();
        int size = substring.lengthOfLongestSubstring("abcabcbb");
        System.out.println("Result: " + size);
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        boolean[] visited = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (visited[c-'a']) {
                    break;
                } else {
                    max = Math.max(max, (j - i) + 1);
                    visited[c-'a'] = true;
                }
            }
            visited[s.charAt(i)-'a'] = false;
        }
        return max;
    }
}
