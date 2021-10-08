def fib(n):
    if n==0:
        return 0
    elif n==1:
        return 1
    else:
        return fib(n-1)+fib(n-2)

def factorial(n):
    if n==0:
        return 1
    return n*factorial(n-1)

if __name__ == '__main__':
    print(fib(6))
    print(factorial(5))