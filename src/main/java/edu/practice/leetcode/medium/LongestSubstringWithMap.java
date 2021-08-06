package edu.practice.leetcode.medium;


import java.util.HashMap;
import java.util.Map;

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
public class LongestSubstringWithMap {

    public static void main(String[] args) {
        LongestSubstringWithMap substring = new LongestSubstringWithMap();
        int size = substring.lengthOfLongestSubstring("");
        System.out.println("Result: " + size);

    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Integer, Character> uniqueChars = new HashMap<>();
        int mSize = uniqueChars.size();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (uniqueChars.containsValue(c)) {
                int finalI = i;
                uniqueChars.entrySet().removeIf(e -> e.getKey() <= finalI);
                max = Math.max(max, uniqueChars.size());
            } else {
                uniqueChars.put(i, c);
                max = Math.max(max, uniqueChars.size());
            }
        }
        return max;
    }
}
