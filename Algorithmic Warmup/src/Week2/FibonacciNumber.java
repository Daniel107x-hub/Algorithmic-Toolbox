package Week2;
import Week2.Introduction.Fibonacci;

public class FibonacciNumber {
    public int getFibonacciNumber(int n){
        int[] numbers=new int[n+2];
        numbers[0]=0;
        numbers[1]=1;
        for(int i=2;i<=n;i++){
            numbers[i]=numbers[i-1]+numbers[i-2];
        }
        return numbers[n];
    }

    public void testFibonacciNumber(){
        for(int i=0;i<=45;i++){
            int result=getFibonacciNumber(i);
            int result2= Fibonacci.recursiveFibonacci(i);
            if(result!=result2){
                System.out.println("Failed test: "+result+" "+result2);
                break;
            }
            System.out.println("Number "+i+" in sequence:");
            System.out.println(result);
        }
    }
}
