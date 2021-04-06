package a05StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    // add at the end
    public void push(String item){
        this.data.add(item);
    }

    // remove & return last element
    public String pop(){
        if (isEmpty()){
            return null;
        }
        return data.remove(data.size() - 1);
    }

    // return last element
    public String peek(){
        if (isEmpty()){
            return null;
        }
        return data.get(data.size() - 1);
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }
}
