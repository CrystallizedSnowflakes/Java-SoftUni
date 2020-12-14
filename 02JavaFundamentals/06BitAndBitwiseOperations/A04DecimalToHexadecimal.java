package bg.softuni.javafundamentals;

public class A04DecimalToHexadecimal {
    public static void main(String[] args) {

        int num = 500;
        // 500 / 16 = 31 (4) last digit
        //  31 / 16 = 1  (15) = "F"
        //   1 / 16 = 0  (1) first digit

        // 0x1F4
        String result = "";
        // divide to the base (16) until 0 is reached
        while(num >0)

        {
            int lastDigit = num % 16;
            result = getHexDigit(lastDigit) + result; // last digit goes first + previous result
            num = num / 16;
        }
        System.out.println(result);
    }

    private static String getHexDigit(int lastDigit) {
        String hexDigit = "";
        if (lastDigit < 10){
            hexDigit += lastDigit;
        }else if(lastDigit == 10){
            hexDigit = "A";
        }else if(lastDigit == 11){
            hexDigit = "B";
        }else if(lastDigit == 12){
            hexDigit = "C";
        }else if(lastDigit == 13){
            hexDigit = "D";
        }else if(lastDigit == 14){
            hexDigit = "E";
        }else if(lastDigit == 15){
            hexDigit = "F";
        }else{
            try {
                throw new Exception("Invalid digit");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hexDigit;
    }
}
