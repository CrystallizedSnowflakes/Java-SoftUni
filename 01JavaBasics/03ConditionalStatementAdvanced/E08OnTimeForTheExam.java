package bg.softuni.javabasics;

import java.util.Scanner;

public class E08OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int examHour = Integer.parseInt(scanner.nextLine());
        int examMinutes = Integer.parseInt(scanner.nextLine());
        int arriveHour = Integer.parseInt(scanner.nextLine());
        int arriveMinutes = Integer.parseInt(scanner.nextLine());

        int examTimeInMinutes = examHour * 60 + examMinutes;
        int arriveTimeInMinutes = arriveHour * 60 + arriveMinutes;

        // Late
        if (arriveTimeInMinutes > examTimeInMinutes){
            System.out.println("Late");
            int lateMinutes = arriveTimeInMinutes - examTimeInMinutes;
            if (lateMinutes < 60){
                System.out.printf("%d minutes after the start", lateMinutes);
            }else{
                int hour = lateMinutes / 60;
                int minutes = lateMinutes % 60;
                System.out.printf("%d:%02d hours after the start", hour, minutes);
            }
        // On time
        }else if(arriveMinutes == examTimeInMinutes || examTimeInMinutes - arriveTimeInMinutes <= 30){
            System.out.println("On time");
            if (examTimeInMinutes - arriveTimeInMinutes <= 30 && arriveTimeInMinutes != examTimeInMinutes){
                System.out.printf("%d minutes before the start", examTimeInMinutes - arriveTimeInMinutes);
            }
        // Early
        }else if(examTimeInMinutes - arriveTimeInMinutes > 30){
            System.out.println("Early");
            int earlyMinutes = examTimeInMinutes - arriveTimeInMinutes;
            if (earlyMinutes < 60){
                System.out.printf("%d minutes before the start", earlyMinutes);
            }else{
                int hour = earlyMinutes / 60;
                int minutes = earlyMinutes % 60;
                System.out.printf("%d:%02d hours before the start", hour, minutes);
            }
        }
    }
}
