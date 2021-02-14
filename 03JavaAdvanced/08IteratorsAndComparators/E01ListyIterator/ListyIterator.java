package E01ListyIterator;

import java.util.List;

public class ListyIterator {
    private List<String> data;
    private int index;

    public ListyIterator(List<String> data) {
        this.data = data;
        if (this.data.size() != 0){
            this.index = 0;
        } else {
            this.index = -1; // invalid value
        }
    }

    public boolean move(){
        if (hasNext()){     // this.index < this.data.size() - 1
            this.index++;
            return true;
        }
        return false;
    }

    public boolean hasNext(){
        return this.index < this.data.size() - 1;
    }

    public void print(){
        validatePrint();
        System.out.println(this.data.get(this.index));
    }

    private void validatePrint() {
        //if (this.index == -1){
        if (this.data.isEmpty()){
            throw new IllegalStateException("Invalid Operation!");
        }
    }
}
