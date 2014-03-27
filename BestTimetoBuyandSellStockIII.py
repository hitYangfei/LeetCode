class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
        if prices==None or len(prices)==0:
            return 0
        left=[0]*len(prices)
        currentMin = prices[0]
        for i in range(1,len(prices)):
            if prices[i]>currentMin:
                tmp=prices[i]-currentMin
                if tmp>left[i-1]:
                    left[i]=prices[i]-currentMin
                else:
                    left[i]=left[i-1]
            else:
                currentMin=prices[i]
                left[i]=left[i-1]

        right=[0]*len(prices)
        currentMax=prices[len(prices)-1]
        for i in range(len(prices)-2,-1,-1):
            if prices[i]<currentMax:
                tmp=currentMax-prices[i]
                if tmp>right[i+1]:
                    right[i]=tmp
                else:
                    right[i]=right[i+1]
            else:
                currentMax=prices[i]
                right[i]=right[i+1]
        maxSum = 0
        for i in range(0,len(prices)-1):
            tmp = left[i]+right[i]
            if tmp>maxSum:
                maxSum=tmp
        return maxSum
        
  

    def __init__(self):
        self.leftMin=0
        self.leftMax=0
        self.rightMin=0
        self.rightMax=0
        self.leftIndex=0
        self.rightIndex=1

if __name__=="__main__":
    nums=[1,2]
    s=Solution()
    print s.maxProfit(nums)
 

