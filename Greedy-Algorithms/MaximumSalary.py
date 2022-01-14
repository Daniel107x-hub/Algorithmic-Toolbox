def gives_more_or_equal_value(number1, number2):
    i = 0
    j = 0
    while i <= len(number1)-1 and j <= len(number2)-1:
        if int(number1[i]) > int(number2[j]):
            return True
        elif int(number1[i]) < int(number2[j]):
            return False
        else:
            if i == len(number1)-1 and j == len(number2)-1:
                return True
            if i < len(number1)-1:
                i += 1
            if j < len(number2)-1:
                j += 1

def get_maximum_salary(numbers):
    if len(numbers) > 0:
        max_index = 0
        for i in range(1, len(numbers)):
            if gives_more_or_equal_value(numbers[i], numbers[max_index]):
                max_index = i
        max_element = numbers.pop(max_index)
        return max_element + get_maximum_salary(numbers)
    return ''


if __name__ == "__main__":
    quantity = int(input())
    numbers = input().split()
    print(get_maximum_salary(numbers))

