def maximum_gold(W, ws):
    values = [[0 for i in range(0, W + 1)] for i in range(0, len(ws) + 1)]
    for i in range(1, len(ws) + 1):
        for j in range(1, W + 1):
            if ws[i - 1] < j:
                values[i][j] = max(ws[i - 1] + values[i - 1][j - ws[i - 1]], values[i - 1][j])
            else:
                values[i][j] = values[i - 1][j]
    return values[len(ws)][W]


if __name__ == "__main__":
    line_1 = input()
    W = int(line_1.split(" ")[0])
    ws = [int(value) for value in input().split(" ")]
    result = maximum_gold(W, ws)
    print(result)
