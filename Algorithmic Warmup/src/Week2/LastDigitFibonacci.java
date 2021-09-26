package Week2;

public class LastDigitFibonacci {
    public int getLastDigitFibonacci(int n){
        int[] digits=new int[n+2];
        digits[0]=0;
        digits[1]=1;
        for(int i=2;i<=n;i++){
            digits[i]=(digits[i-1]+digits[i-2])%10;
        }
        return digits[n];
    }

    public void testGetLastDigitFibonacci(){
        int result=getLastDigitFibonacci(3);
        if(result!=2){
            System.out.println("Error: "+result);
        }
        System.out.println("OK");
        result=getLastDigitFibonacci(331);
        if(result!=9){
            System.out.println("Error: "+result);
        }
        System.out.println("OK");
        result=getLastDigitFibonacci(327305);
        if(result!=5){
            System.out.println("Error: "+result);
        }
        System.out.println("OK");
    }
}
