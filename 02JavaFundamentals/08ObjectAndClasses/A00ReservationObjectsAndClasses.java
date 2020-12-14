package bg.softuni.javafundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A00ReservationObjectsAndClasses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Reservation>reservations = new ArrayList<>();

        while(!input.equals("end")){

            String[]nameAndSeats = input.split(" ");

            Reservation r = new Reservation();
            r.holderName = nameAndSeats[0];
            r.seats = Integer.parseInt(nameAndSeats[1]);
            reservations.add(r);

            input = scanner.nextLine();
        }

        String guestName = scanner.nextLine();

        int reservationIndex = -1;
        for (int i = 0; i < reservations.size(); i++) {
            Reservation reservation = reservations.get(i);
            if (guestName.equals(reservation.holderName)){
                reservationIndex = i;
            }
        }

        if (reservationIndex != -1){
            Reservation reservation = reservations.get(reservationIndex);
            System.out.println(reservation.seats);
        }else{
            System.out.println("Sorry, no reservation for " + guestName);
        }
    }

    static class Reservation{
        //* FIELDS
        String holderName;
        int seats;
    }
}
