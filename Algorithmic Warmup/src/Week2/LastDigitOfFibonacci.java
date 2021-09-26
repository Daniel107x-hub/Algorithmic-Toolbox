package Week2;

import java.math.BigInteger;

public class LastDigitOfFibonacci {
    private BigInteger getFibonacciNumber(Long n){
        BigInteger fib0=BigInteger.valueOf(0);
        BigInteger fib1=BigInteger.valueOf(1);
        BigInteger fibN=BigInteger.valueOf(0);
        for(int i=2;i<=n;i++){
            fibN=fib0.add(fib1);
            fib0=fib1;
            fib1=fibN;
        }
        return fibN;
    }

    private int getLastDigit(Long n){
        BigInteger fibonacciSum=getFibonacciNumber(n+2L);
        return fibonacciSum.subtract(BigInteger.valueOf(1)).mod(BigInteger.valueOf(10)).intValue();
    }

    public void testLastFibonacciDigitSum(){
        int result=getLastDigit(3L);
        if(result!=4){
            System.out.println("Error: "+result);
        }
        System.out.println("OK");
        result=getLastDigit(100L);
        if(result!=5){
            System.out.println("Error: "+result);
        }
        System.out.println("OK");
    }
}
