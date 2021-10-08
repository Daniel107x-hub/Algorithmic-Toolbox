# Uses python3
import math
import sys

def merge(izq,der):
    result = list()
    while len(izq) > 0 and len(der) > 0:
        if izq[0] < der[0]:
            result.append(izq.pop(0))
        else:
            result.append(der.pop(0))
    result.extend(izq if len(izq) > 0 else der)
    return result

def mergesort(A,start,end):
    if start==end:
        return [A[start]]
    mid=math.floor((start+end)/2)
    izq=mergesort(A,start,mid)
    der=mergesort(A,mid+1,end)
    return merge(izq,der)

def findMajority(A):
    A = mergesort(A,0,len(A)-1)
    curr_element = -1
    curr_freq = 0
    for element in A:
        if curr_element == -1 or curr_element != element:
            curr_element = element
            curr_freq = 0
        if element == curr_element:
            curr_freq += 1
        if curr_freq  > len(A)/2:
            return 1
    return 0

if __name__ == '__main__':
    A=[4,4,2,1,3,4,4,2,4]
    result = findMajority(A)
    print(result)
