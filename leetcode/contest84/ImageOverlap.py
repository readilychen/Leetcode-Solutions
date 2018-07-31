class ImageOverlap(object):
    def largestOverlap(self, A, B):
        """
        :type A: List[List[int]]
        :type B: List[List[int]]
        :rtype: int
        """
        max = 0
        rotate_list = []
        rotate_new_a = A
        if len(A) == 1:
            return self.countOverlap(A,B)
        for i in range(3):
            rotate_new_a = self.rotate90degree(rotate_new_a)
            rotate_list.append(rotate_new_a)

        
        #max = self.countOverlap(A,B) if max < self.countOverlap(A,B) else max
        for i in range(len(A)):
            fronta = [A[index] for index in range(i,len(A),1)]
            aftera = [A[index] for index in range(i)]
            fronta.extend(aftera)
            for j in range(len(A)):
                newB = []
                for row in range(len(A)):
                    frontb = [fronta[row][index] for index in range(j,len(A),1)]
                    afterb = [fronta[row][index] for index in range(0,j)]
                    frontb.extend(afterb)
                    newB.append(frontb)
                is_rotate = False
                for rotate_item in rotate_list:
                    print("rotate_item %s"%(rotate_item))
                    if rotate_item == newB:
                        is_rotate = True
                        break;
                print("newB %s"%(newB))
                print("***")
                if not is_rotate:
                    overlap_num = self.countOverlap(newB,B)
                    max = overlap_num if max < overlap_num else max
        return max

    def rotate90degree(self,A):
        newA = []
        for i in range(len(A)):
            newRow = []
            for j in range(len(A)-1,-1,-1):
                newRow.append(A[j][i])
            newA.append(newRow)
        return newA

    def countOverlap(self,A,B):
        count = 0
        for i in range(len(A)):
            for j in range(len(A[0])):
                if A[i][j] + B[i][j] == 2:
                    count+=1
        return count

if __name__ == "__main__":
    processor = ImageOverlap()
    A = list([[1,0],[0,0]])
    B = list([[0,1],[1,0]])
    print(processor.largestOverlap(A,B))
