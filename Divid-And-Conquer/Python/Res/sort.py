import math
import random


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


def partition(arr, low, high):
    i = (low - 1)  # index of smaller element
    pivot = arr[high]  # pivot
    for j in range(low, high):
        # If current element is smaller than or equal to pivot
        if arr[j] <= pivot:
            # increment index of smaller element
            i = i + 1
            arr[i], arr[j] = arr[j], arr[i]
    arr[i + 1], arr[high] = arr[high], arr[i + 1]
    return (i + 1)


def quickSort(arr, low, high):
    if len(arr) == 1:
        return arr
    if low < high:
        # pi is partitioning index, arr[p] is now
        # at right place
        pi = partition(arr, low, high)
        # Separately sort elements before
        # partition and after partition
        quickSort(arr, low, pi - 1)
        quickSort(arr, pi + 1, high)



if __name__ == '__main__':
    A=[0,4,2,1]
    quickSort(A,0,len(A)-1)
    #result=mergesort(A,0,len(A)-1)
    print(A)