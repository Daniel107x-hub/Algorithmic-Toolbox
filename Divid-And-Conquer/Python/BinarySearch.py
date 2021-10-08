# Uses python3
import sys

def binary_search(N, start, end, k):
    if start>end:
        return -1
    mid = (start+end)//2
    if N[mid] == k:
        return mid
    elif N[mid] > k:
        return binary_search(N, start, mid-1, k)
    else:
        return binary_search(N, mid+1, end, k)

def solver(N,K):
    solution=list()
    for element in K:
        index=binary_search(N,0,len(N)-1,element)
        solution.append(index)
    return solution

if __name__ == '__main__':
    n = [int(element) for element in input().split()]
    k = [int(element) for element in input().split()]
    n.pop(0)
    k.pop(0)
    solution=solver(n,k)
    for element in solution:
        print(element,end=' ')

