# Uses python3
import random

def swapList(A,from_1,to_1,from_2,to_2):
    if from_1>to_1 or from_2>to_2:
        return
    elif from_1==to_1 and from_2==to_2:
        A[from_1], A[from_2] = A[from_2], A[from_1]
    limit = max(to_1-from_1,to_2-from_2)
    for i in range(0,limit+1):
        if from_1>to_1:
            element = A.pop(from_2)
            A.insert(from_1-1,element)
            from_2 += 1
        elif from_2>to_2:
            element = A.pop(from_1)
            A.insert(from_2 - 1, element)
            from_1 += 1
        else:
            A[from_1], A[from_2] = A[from_2], A[from_1]
            from_1 += 1
            from_2 += 1
    return


def partition3(A,start,end):
    pivot = random.randint(start,end)
    A[pivot], A[end] = A[end], A[pivot]
    minor = start-1
    last_similar = end
    i=start
    while i<last_similar:
        while A[i] == A[last_similar] and i!=last_similar:
            last_similar -= 1
            A[i], A[last_similar] = A[last_similar], A[i]
        if A[i] < A[last_similar]:
            minor += 1
            A[i], A[minor] = A[minor], A[i]
        i += 1
    swapList(A,minor+1,last_similar-1,last_similar,end)
    right_end = minor+end-last_similar+1
    result = [minor+1,right_end]
    return result

def sort3(A,start,end):
    if start>=end:
        return
    limits = partition3(A,start,end)
    sort3(A,start,limits[0]-1)
    sort3(A,limits[1]+1,end)

if __name__ == '__main__':
    n=int(input())
    numbers=[int(element) for element in input().split()]
    sort3(numbers,0,len(numbers)-1)
    for element in numbers:
        print(element,end=' ')

