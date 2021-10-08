import math


def binary_search(A,n,low,up):
    if low>up:
        return -1
    mid=math.floor((up+low)/2)
    if A[mid]==n:
        return mid
    elif A[mid]>n:
        return binary_search(A,n,low,mid-1)
    else:
        return binary_search(A,n,mid+1,up)

def maximo(A,start,end):
    if start==end:
        return A[start]
    mid=math.floor((start+end)/2)
    max_izq=maximo(A,start,mid)
    max_der=maximo(A,mid+1,end)
    return max_izq if max_izq>max_der else max_der


if __name__ == '__main__':
    A=[1,2,35,4,5,6,7,8,9,10,4,12,3,1,5,2]
    result=maximo(A,0,len(A)-1)
    print(result)