import copy


def primitive_calculator(number):
    values = [-1 for i in range(0, number+1)]
    values[0] = 0
    values[1] = 0
    intermediate = [[1] for i in range(0, number+1)]
    for i in range(2, number+1):
        if i % 2 != 0 and i % 3 != 0:
            result = values[i - 1]
        elif i % 2 == 0 and i % 3 != 0:
            result = min(values[i - 1], values[i // 2])
        elif i % 2 != 0 and i % 3 == 0:
            result = min(values[i - 1], values[i // 3])
        else:
            result = min(values[i - 1], values[i // 2], values[i // 3])

        if result == values[i-1]:
            previous = copy.deepcopy(intermediate[i - 1])
            last_value = previous[-1]
            previous.append(last_value + 1)
        elif result == values[i//2] and i % 2 == 0:
            previous = copy.deepcopy(intermediate[i // 2])
            last_value = previous[-1]
            previous.append(last_value * 2)
        else:
            previous = copy.deepcopy(intermediate[i // 3])
            last_value = previous[-1]
            previous.append(last_value * 3)
        intermediate[i] = previous

        values[i] = result + 1

    return [values[number], intermediate[number]]




if __name__ == "__main__":
    n = int(input())
    value = primitive_calculator(n)
    print(value[0])
    for element in value[1]:
        print(element, end=" ")

