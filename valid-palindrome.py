
def isPalindrome(str):
    s = str.replace(" ", "")
    if len(s)==0 or len(s)==1:
        return True
    s=s.lower()
    i=0
    j=len(s)-1
    
    while i<=j:
        if not s[i].isalnum():
            i+=1
            continue
        if not s[j].isalnum():
            j-=1
            continue
        if i>j:
            break
        if s[i]==s[j]:
            i+=1
            j-=1
        else:
            return False
        
    return True

if __name__=="__main__":
    s="A man, a plan, a canal: Panama"
    print isPalindrome(s)
