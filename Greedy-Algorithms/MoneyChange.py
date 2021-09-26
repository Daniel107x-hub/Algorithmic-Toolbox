# Uses python3
import sys
coins=[10,5,1]

def get_change(m):
    quantities=[0,0,0]
    for i in range(len(coins)):
        quantities[i]=m//coins[i]
        m=m%coins[i]
    return sum(quantities)

if __name__ == '__main__':
    m = int(input())
    print(get_change(m))
 