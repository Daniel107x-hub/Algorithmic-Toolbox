# Uses python3
import sys

def optimal_summands(n):
    summands = []
    #write your code here
    i=1;
    difference=n
    while difference>=2*i+1:
        difference-=i
        summands.append(i)
        i+=1
    summands.append(difference)
    return summands

if __name__ == '__main__':
    n = int(input())
    summands = optimal_summands(n)
    print(len(summands))
    for x in summands:
        print(x, end=' ')
