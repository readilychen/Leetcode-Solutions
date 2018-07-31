class Solution(object):
    def flipAndInvertImage(self, A):
        """
        :type A: List[List[int]]
        :rtype: List[List[int]]
        """
        final_list=[]
        for item_list in A:
            print (item_list)
            reversed_item_list = []
            for i in reversed(item_list):
                if i == 1 :
                    reversed_item_list.append(0)
                else:
                    reversed_item_list.append(1)
            final_list.append(reversed_item_list)
        return final_list

if __name__ =="__main__":
    s = Solution()
    A = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
    final_list = s.flipAndInvertImage(A)
    print(final_list)
    

