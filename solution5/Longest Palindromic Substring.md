# 5. Longest Palindromic Substring
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:
Input: "cbbd"
Output: "bb"

# Solution:
add a * to between each char, because the middle char of Palindromic Substring can be a nothing, so the cbba becomes c\*b\*b\*a,
Solution 1:
Iterate each character, including the "*", and treat the current as the middle element and spread form that character out, keep a max as the longest substring.
Solution 2:
Using a 2d dp array dp[i][j] represents whether has a palindromic substring that the middle element is at index i and the last element is at j, if exists then the dp[i][j] is 1, if not then the dp[i][j] becomes 0, then iterate the dp array, get the max (j - i).


