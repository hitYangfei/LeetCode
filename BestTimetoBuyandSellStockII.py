class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
        length = len(prices)
        maxSum=0
        if length<2:
            return 0
        for i in range(1,length):
            if prices[i]>prices[i-1]:
                maxSum+=(prices[i]-prices[i-1])
        return maxSum

        
if __name__=="__main__":
    nums=[1,3,5,7,9,10]
    s=Solution()
    print s.maxProfit(nums)
