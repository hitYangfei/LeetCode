class Solution:
    # @return a list of lists of integers
    def generate(self, numRows):
        if numRows==0:
            return []
        if numRows==1:
            return [[1]]
        if numRows==2:
            return [[1],[1,1]]
        listResult=[[1],[1,1]]
        currentRow = [1,1]
        for i in range(2,numRows):
            tmpList = []
            for j in range(i+1):
                if j==0:
                    tmpList.append(1)
                    continue
                if j==i:
                    tmpList.append(1)
                    continue
                tmpList.append(currentRow[j]+currentRow[j-1])
            listResult.append(tmpList)
            currentRow=tmpList
        return listResult

if __name__=="__main__":
    s = Solution()
    print s.generate(6)
            
                
                
