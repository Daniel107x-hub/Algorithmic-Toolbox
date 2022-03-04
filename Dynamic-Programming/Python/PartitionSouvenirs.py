def partition3(values):
    s = sum(values)
    if s % 3 != 0:
        return False
    results = [[False for i in range(0, s + 1)] for i in range(0, len(values) + 1)]
    for i in range(0, len(values) + 1):
        results[i][0] = True
    for j in range(1, s + 1):
        for i in range(1, len(values) + 1):
            if values[i - 1] <= j:
                results[i][j] = results[i - 1][j] or results[i - 1][j - values[i - 1]]
            else:
                results[i][j] = results[i - 1][j]
    return results[len(values)][s // 3] and results[len(values)][2 * s // 3] and results[len(values)][s]


if __name__ == "__main__":
    n = input()
    numbers = [int(number) for number in input().split(" ")]
    result = partition3(numbers)
    print(1 if result is True else 0)
