class Solution4:
    def numFactoredBinaryTrees(self, A):
       
        """
        :type A: List[int]
        :rtype: int
        """
        # str : list([tuple1,tuple2,tuple3])
        combination_dic = {}
        A = sorted(A)
        # the order form high to low
        for i in range(0,len(A)-1):
            i_square = A[i]*A[i]
            #print(i_square)
            a = self.binarySearch(A,i,len(A)-1,i_square,0)
            #print("hahha %s "%(a))
            # if i square exits in the list then get it 
            if a != -1:
                if i_square in combination_dic:
                    temp_list = combination_dic.get(i_square)
                    temp_list.append((A[i],A[i]))
                else:
                    combination_dic[i_square] = list([(A[i],A[i])])
            for j in range(i+1,len(A)):
                i_j_square = A[i] * A[j]
                #print("in")
                if self.binarySearch(A,j,len(A)-1,i_j_square,0)!= -1:
                    if i_j_square in combination_dic:
                        temp_list = combination_dic.get(i_j_square)
                        temp_list.append((A[i],A[j]))
                    else:
                        combination_dic[i_j_square] = list([(A[i],A[j])])

        return self.getcount(combination_dic)+len(A)

    def getcount(self,combination_dic):
        total_count = 0
        count_dict = {}
        items = combination_dic.items()
        items.sort()
        for key,value in items:
            #print("key is  %s,value is %s"%(key,value))
            count_dict[key] = 0
            for (v1,v2) in value:
                if v1 == v2:
                    if v1 in count_dict:
                        count_dict[key]+=(count_dict[v1]+1)*(count_dict[v1]+1)
                        total_count+=(count_dict[v1]+1)*(count_dict[v1]+1)
                    else:

                        count_dict[key]+=1
                        total_count+=1
                        #print("for debug v1 == v2 %s"%(count_dict[key]))
                else:
                    # if v1 != v2
                    flag1 = v1 in count_dict
                    flag2 = v2 in count_dict
                    if flag1 == False and flag2 == False:

                        count_dict[key]+= 2
                        total_count+= 2
                        #print("for debug v1 != v2 %s"%(count_dict[key]))
                    elif flag1 == True and flag2 == True:
                        count_dict[key]+=2*(count_dict[v1]+count_dict[v2]+count_dict[v1]*count_dict[v2])
                        total_count+=2*(count_dict[v1]+count_dict[v2]+count_dict[v1]*count_dict[v2])
                        #print("not suppose to1")
                    elif flag1 == True and flag2 == False:
                        count_dict[key]+=2*(count_dict[v1]+1)
                        total_count+=2*(count_dict[v1]+1)
                        #print("for debug v1 != v2 key = %s, count_dict = %s"%(count_dict[key],count_dict[v1]))
                    else:
                        count_dict[key]+=2*(count_dict[v2]+1)
                        total_count+=2*(count_dict[v2]+1)
                        #print("not suppose to2 %s"%(v2 in count_dict))
                    
        return total_count


    def binarySearch(self, my_list,start,end,target,count):
        if count > 30 :
            return -1
        if end <= start:
            if my_list[end] == target:
                #print("return2")
                return my_list[end]
            else:
                return -1
        middle = int((start+end)/2)
        #print("start %s , end %s, middle %s,target %s" % (start,end,middle,target))
        if my_list[middle] == target:
            #print("target %s"%(target))
            #print("return1")
            return target
        elif my_list[middle]>target:
            return self.binarySearch(my_list,start,middle-1,target,count+1)
        else:
            return self.binarySearch(my_list,middle+1,end,target,count+1)

if __name__ == "__main__":
    s4 = Solution4()
    A = list( [2,4,5,10,20])
    print("result %s"%(s4.numFactoredBinaryTrees(A)))







