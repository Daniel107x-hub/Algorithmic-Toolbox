def money_change(money):
    values = [-1 for i in range(0, 5)]
    values[0] = 0
    values[1] = 1
    values[2] = 2
    values[3] = 1
    values[4] = 1
    for i in range(5, money+1):
        values.append(min(values[i-1], values[i-3], values[i-4]) + 1)
    return values[money]


if __name__ == "__main__":
    n = int(input())
    result = money_change(n)
    print(result)
