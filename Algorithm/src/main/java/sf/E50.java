package sf;

public class E50 {
    //Pow(x,n)
    public double myPow(double x, Long n) {
        Long p = n;
        if (p<0){
            p=-p;
        }
        double v = myPowPositive(p, n);
        return v<0?1/v:v;
    }

    public double myPowPositive(double x, Long n) {
        if (n==0){
            return 1.0;
        }
        double y = myPowPositive(x, n / 2);
        if ((n&1)==0){
            //偶数
            return y*y;
        }else {
            return x*y*y;
        }
    }
}
