package E08PetClinic;

import java.util.Iterator;

public class Clinic implements Iterable<Pet>{
    private String name;
    private Pet[] pets; // rooms

    public Clinic(String name, int roomsCount) {
        this.name = name;
        setRooms(roomsCount);
    }

    public Pet[] getPets() {
        return pets;
    }

    private void setRooms(int roomsCount) {
        if (roomsCount % 2 == 0){
            throw new IllegalArgumentException("Invalid Operation!");
        } else {
            this.pets = new Pet[roomsCount];
        }
    }

    public boolean add(Pet pet){
        int room = this.pets.length / 2;

        for (int i = 0; i < this.pets.length; i++) {
            if (i % 2 == 0){
                room += i;
            } else {
                room -= i;
            }

            if (this.pets[room] == null){
                this.pets[room] = pet;
                return true;
            }
        }
        return false;
    }

    public boolean release(){
        int middle = this.pets.length / 2;

        for (int i = middle; i < this.pets.length; i++) {
            if (this.pets[i] != null){
                this.pets[i] = null;
                return true;
            }
        }
        for (int i = 0; i < middle; i++) {
            if (this.pets[i] != null){
                this.pets[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean hasEmptyRooms(){
        for (Pet pet : pets) {
            if (pet == null){
                return true;
            }
        }
        return false;
    }

    public void printClinicRoomInfo(int room){
        if (pets[room - 1] == null){
            System.out.println("Room empty");
        } else {
            System.out.println(pets[room - 1].toString());
        }
    }

    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }
        };
    }
}
