# Uses python3
import sys

def binary_search(N, start, end, k):
    mid = (start+end)//2
    if end==start:
        if N[mid]==k:
            return mid
        else:
            return -1
    elif N[mid] >= k:
        return binary_search(N, start, mid, k)
    else:
        return binary_search(N, mid+1, end, k)

def solver(N,K):
    solution=list()
    for element in K:
        index=binary_search(N,0,len(N)-1,element)
        solution.append(index)
    return solution

if __name__ == '__main__':
    number=int(input())
    n = [int(element) for element in input().split()]
    number=int(input())
    k = [int(element) for element in input().split()]
    solution=solver(n,k)
    for element in solution:
        print(element,end=' ')
