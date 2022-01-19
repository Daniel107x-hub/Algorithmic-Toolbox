# Uses python3
import sys

def binary_search(list, start, end, number):
    if start <= end:
        q = int((start + end) / 2)
        if list[q] == number:
            return q
        elif list[q] > number:
            return binary_search(list, start, q-1, number)
        else:
            return binary_search(list, q+1, end, number)
    return -1

def solver(list, numbers):
    results = []
    for number in numbers:
        result = binary_search(list, 0, len(list)-1, number)
        results.append(result)
    return results

if __name__ == '__main__':
    first_line = input().split()
    n_elements = int(first_line.pop(0))
    list = [int(element) for element in first_line]
    second_line = input().split()
    k_elements = int(second_line.pop(0))
    numbers = [int(element) for element in second_line]
    result = solver(list, numbers)
    [print(element,end=' ') for element in result]

