# Uses python3
import sys


def compare(array, pivot, condition):
    elements = list()
    for number in array:
        if condition == "smaller" and number < pivot:
            elements.append(number)
        elif condition == "greater" and number > pivot:
            elements.append(number)
        elif condition == "equal" and number == pivot:
            elements.append(number)
    return elements


def quicksort(array):
    if len(array) > 1:
        pivot = array[0]
        left_array = compare(array, pivot, "smaller")
        right_array = compare(array, pivot, "greater")
        same_array = compare(array, pivot, "equal")
        return quicksort(left_array) + same_array + quicksort(right_array)
    return array


if __name__ == "__main__":
    n = int(input())
    numbers = [int(element) for element in input().split()]
    result = quicksort(numbers)
    for element in result:
        print(element, end=' ')