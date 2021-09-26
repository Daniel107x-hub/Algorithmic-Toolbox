package Week2;

import java.math.BigInteger;

public class PisanoPeriodFibonacci {
    private int getPisanoPeriod(int mod){
        int period=1;
        Long pi0=-1L;
        Long pi1=-1L;
        BigInteger fib0=BigInteger.valueOf(0);
        BigInteger fib1=BigInteger.valueOf(1);
        BigInteger fibN;
        while(true){
            fibN=fib0.add(fib1);
            fib0=fib1;
            fib1=fibN;
            pi0=pi1;
            pi1=fib1.mod(BigInteger.valueOf(mod)).longValue();
            if(pi0.equals(0L) && pi1.equals(1L)){
                return period;
            }
            period++;
        }
    }

    private BigInteger getFibonacciNumber(int n){
        BigInteger[] numbers=new BigInteger[n+2];
        numbers[0]=BigInteger.valueOf(0);
        numbers[1]=BigInteger.valueOf(1);
        for(int i=2;i<=n;i++){
            numbers[i]=numbers[i-1].add(numbers[i-2]);
        }
        return numbers[n];
    }

    private Long getFibonacciMod(Long n, int mod){
        int pisanoPeriod=getPisanoPeriod(mod);
        int nTermPisano=(int)(n%pisanoPeriod);
        BigInteger fibonacciNumberPisano=getFibonacciNumber(nTermPisano);
        return fibonacciNumberPisano.mod(BigInteger.valueOf(mod)).longValue();
    }

    public void testFibonacciPisano(){
        Long result=getFibonacciMod(239L,1000);
        if(!result.equals(161L)){
            System.out.println("Error: "+result);
        }
        System.out.println("OK");
        result=getFibonacciMod(2816213588L,239);
        if(!result.equals(151L)){
            System.out.println("Error: "+result);
        }
        System.out.println("OK");
    }

    public void testGetPisanoPeriod(){
        for(int i=2;i<=12;i++){
            System.out.println("Periodo: "+i+" Resultado: "+getPisanoPeriod(i));
        }
    }
}
