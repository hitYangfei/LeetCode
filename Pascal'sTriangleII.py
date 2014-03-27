class Solution:
    # @return a list of lists of integers
    def getRow(self, rowIndex):
        if rowIndex==0:
            return [1]
        if rowIndex==1:
            return [1,1]
        currentRow = [1,1]
        for i in range(rowIndex+1):
            tmpList = []
            for j in range(i+1):
                if j==0:
                    tmpList.append(1)
                    continue
                if j==i:
                    tmpList.append(1)
                    continue
                tmpList.append(currentRow[j]+currentRow[j-1])
            currentRow=tmpList
        return currentRow

if __name__=="__main__":
    s = Solution()
    a=s.getRow(3)
    print a
            
                
                
