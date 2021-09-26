package Week2.Introduction;

public class Fibonacci {
    public static int recursiveFibonacci(int n){
        if(n<=1){
            return n;
        }else{
            return recursiveFibonacci(n-1)+recursiveFibonacci(n-2);
        }
    }

    public static Long efficientFibonacci(int n){
        Long[] numbers=new Long[n+1];
        numbers[0]=0L;
        numbers[1]=1L;
        for(int i=2;i<=n;i++){
            numbers[i]=numbers[i-1]+numbers[i-2];
        }
        return numbers[n];
    }
}
