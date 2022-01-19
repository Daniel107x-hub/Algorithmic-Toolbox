import sys

def merge(array, start, end, q):
    left_array = array[start:q+1]
    right_array = array[q+1:end+1]
    i = 0
    j = 0
    k = start
    inversions = 0
    while i < len(left_array) and j < len(right_array):
        if left_array[i] <= right_array[j]:
            array[k] = left_array[i]
            i += 1
        else:
            array[k] = right_array[j]
            inversions += q - i + 1
            j += 1
        k += 1
    if i < len(left_array):
        while i < len(left_array):
            array[k] = left_array[i]
            k += 1
            i += 1
    elif j < len(right_array):
        while j < len(right_array):
            array[k] = right_array[j]
            k += 1
            j += 1
    return inversions


def merge_sort(array, start, end):
    if start < end:
        q = (start + end) // 2
        inversions_1 = merge_sort(array, start, q)
        inversions_2 = merge_sort(array, q+1, end)
        result = inversions_1 + inversions_2 + merge(array, start, end, q)
        return result
    return 0


def inversions(numbers):
    result = merge_sort(numbers, 0, len(numbers)-1)
    return result


if __name__ == "__main__":
    n = int(input())
    numbers = [int(element) for element in input().split()]
    result = inversions(numbers)
    print(result)
