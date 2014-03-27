class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
        if prices==None or len(prices)==0:
            return 0
        return self.dividMerge(prices,0,len(prices)-1,True)
    def dividMerge(self,prices,begin,end,isLeft):
       
        if begin==end:
            if isLeft:
                self.leftMin=prices[begin]
                self.leftMax=prices[begin]
            else:
                self.rightMin=prices[begin]
                self.rightMax=prices[begin]
            return 0
        middle = (end+begin)/2
        left = self.dividMerge(prices,begin,middle,True)
        leftMin = self.leftMin
        leftMax = self.leftMax
        right = self.dividMerge(prices,middle+1,end,False)
        rightMin = self.rightMin
        rightMax = self.rightMax
        if isLeft:
            self.leftMin=min(leftMin,rightMin)
            self.leftMax=max(leftMax,rightMax)
        else:
            self.rightMin=min(leftMin,rightMin)
            self.rightMax=max(leftMax,rightMax)
        return max(left,right,rightMax-leftMin)
        

    def __init__(self):
        self.leftMin=0
        self.leftMax=0
        self.rightMin=0
        self.rightMax=0
        self.i=0

if __name__=="__main__":
    nums=[1,2]
    s=Solution()
    print s.maxProfit(nums)

