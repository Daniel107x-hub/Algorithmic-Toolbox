# Uses python3
import math
import sys


def count(numbers, start, end,  x):
    counter = 0
    for number in numbers[start:end+1]:
        if number == x:
            counter += 1
    return counter


def find_majority(numbers, start, end):
    if start < end:
        q = (start + end) // 2
        left_majority = find_majority(numbers, start, q)
        right_majority = find_majority(numbers, q+1, end)
        if left_majority == right_majority:
            return left_majority
        counter_left = count(numbers, start, end, left_majority)
        counter_right = count(numbers, start, end, right_majority)
        if counter_left > counter_right:
            return left_majority
        elif counter_right > counter_left:
            return right_majority
        return -1
    return numbers[start]


if __name__=="__main__":
    n = int(input())
    numbers = [int(number) for number in input().split()]
    result = find_majority(numbers, 0, len(numbers)-1)
    if result == -1:
        print(0)
    else:
        print(1)
