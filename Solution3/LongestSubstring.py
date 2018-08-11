class LongestSubstring:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s) == 0:
            return 0
        # keep index of the lastest left element that is the same
        left = 0
        dp = []
        dp.append(1)
        for i in range (len(s)-1):
            dp.append(0)
        last_index_dict = {}
        last_index_dict[s[0]] = 0
        flage = False
        for i in range(1,len(s)):
            if s[i] in last_index_dict:
                if last_index_dict[s[i]] >= left:
                    flage = True
                    left = last_index_dict[s[i]]
                dp[i] = dp[i-1] if dp[i-1] > i - left else i - left
                #print("i-left : %s, dp[i-1] :%s"%(i-left,dp[i-1]))
            else:
                if flage == 0:
                    dp[i] = i+1
                else:
                    dp[i] =  dp[i-1] if dp[i-1] > i - left else i - left
            # update the element in last_index_dict
            last_index_dict[s[i]] = i

        # for i in dp:
        #     print i
        return dp[len(s)-1]

if __name__ == "__main__":
    ls = LongestSubstring()
    print(ls.lengthOfLongestSubstring("pwwkew")) 
   
  
    



