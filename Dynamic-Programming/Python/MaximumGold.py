def maximum_gold(W, ws):
    values = [[0 for i in range(0, W + 1)] for i in range(0, len(ws) + 1)]
    for i in range(0, len(ws)):
        for j in range(1, W + 1):
            if ws[i] <= j:
                values[i + 1][j] = max(ws[i] + values[i - 1][j - ws[i]], values[i-1][j])
    return values[len(ws)][W]


if __name__ == "__main__":
    line_1 = input()
    W = int(line_1.split(" ")[0])
    ws = [int(value) for value in input().split(" ")]
    result = maximum_gold(W, ws)
    print(result)
