# Uses python3
import sys

def get_optimal_value(capacity,details):
    value = 0.
    for i in range(len(details)):
        if capacity==0:
            return value
        quantity=min(capacity,details[i]['weight'])
        currentValue=quantity*details[i]['value']/details[i]['weight']
        value+=currentValue
        capacity-=quantity
    return value

def my_compare(e):
    return e['value']/e['weight']

if __name__ == "__main__":
    data = input().split()
    n=int(data[0])
    capacity=int(data[1])
    details=list()
    for i in range(n):
        data = input().split()
        value=int(data[0])
        weight=int(data[1])
        details.append({"value":value,"weight":weight})
    details.sort(key=my_compare,reverse=True)
    opt_value = get_optimal_value(capacity, details)
    print("{:.4f}".format(opt_value))

