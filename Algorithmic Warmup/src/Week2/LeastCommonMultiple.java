package Week2;

public class LeastCommonMultiple {
    public int naiveGetLCM(int number1,int number2){
        int i=number1+number2;
        while(true){
            if(i%number1==0 && i%number2==0){
                return i;
            }
            i++;
        }
    }

    public Long getLCM(int number1, int number2){
        GCD gcd=new GCD();
        int mcd=gcd.euclidGCD(number1,number2);
        Long mcm=(Long.valueOf(number1)*Long.valueOf(number2))/mcd;
        return mcm;
    }

    public void testGetLCM(){
        Long result=getLCM(6,8);
        if(result!=24){
            System.out.println("Error: "+result);
        }
        System.out.println("OK");
        result=getLCM(761457,614573);
        if(!result.equals(467970912861L)){
            System.out.println("Error: "+result);
        }
        System.out.println("OK");
    }
}
