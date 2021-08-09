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

//Method 1 (Simple : O(n3)): We can consider all substrings one by one and check for each substring whether it contains
// all unique characters or not. There will be n*(n+1)/2 substrings. Whether a substring contains all unique characters
// or not can be checked in linear time by scanning it from left to right and keeping a map of visited characters.
// Time complexity of this solution would be O(n^3).

public class LongestSubstringSimpleNCube {
    public static void main(String[] args) {
        LongestSubstringSimpleNCube substring = new LongestSubstringSimpleNCube();
        int size = substring.lengthOfLongestSubstring("abcabcbb");
        System.out.println("Result: " + size);
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String subStr = s.substring(i, j);
                //System.out.println("Index: " + i + " : " + j + ". SubString: " + subStr);
                if (areAllDistinct(subStr)) {
                    max = Math.max(max, subStr.length());
                }
            }
        }
        return max;
    }

    public static boolean areAllDistinct(String subString) {
        //maintain a boolean index for chars. Default value is set to false.
        boolean[] visited = new boolean[26];

        for (int k = 0; k < subString.length(); k++) {
            char c = subString.charAt(k);
            //since char a is 97, subtract a from the char value to determine the index and mark it true if not visited.
            if (visited[c - 'a']) {
                return false;
            } else {
                visited[c - 'a'] = true;
            }
        }
        return true;
    }
}
