package bg.softuni.javabasics;

import java.util.Scanner;

public class E04MetricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        String inputUnit = scanner.nextLine();
        String outputUnit = scanner.nextLine();

        double result = 0;
        if (inputUnit.equals("mm") && outputUnit.equals("m")){
            result = number * 0.001;
        }else if(inputUnit.equals("mm") && outputUnit.equals("cm")){
            result = number * 0.1;
        }else if(inputUnit.equals("cm") && outputUnit.equals("mm")){
            result = number * 10;
        }else if(inputUnit.equals("cm") && outputUnit.equals("m")){
            result = number * 0.01;
        }else if(inputUnit.equals("m") && outputUnit.equals("mm")){
            result = number * 1000;
        }else if(inputUnit.equals("m") && outputUnit.equals("cm")){
            result = number * 100;
        }

        System.out.printf("%.3f", result);
    }
}
