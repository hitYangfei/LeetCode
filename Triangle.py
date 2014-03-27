class Solution:
    # @param triangle, a list of lists of integers
    # @return an integer
    def minimumTotal(self, triangle):
        if triangle==None:
            return 0
        length=len(triangle)
        if length==0:
            return 0
        if length==1:
            return triangle[0][0]
        listTmp=[10000000000]*length
        for i in range(length-1):
            listTmp[i]=min(triangle[length-1][i],triangle[length-1][i+1])
        for i in range(length-2,-1,-1):
            tmp=triangle[i]
            for j in range(len(tmp)):
                listTmp[j]=listTmp[j]+tmp[j]
            for j in range(len(tmp)-1):
                listTmp[j]=min(listTmp[j],listTmp[j+1])
          
        return listTmp[0]
        


if __name__=="__main__":
    a=[[2]]
    s=Solution()
    print s.minimumTotal(a)
        
