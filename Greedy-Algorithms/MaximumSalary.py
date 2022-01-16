def gives_more_or_equal_value(number1, number2):
    option1 = int(number1 + number2)
    option2 = int(number2 + number1)
    return option1 >= option2

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

