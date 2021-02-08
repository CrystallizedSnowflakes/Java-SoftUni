package E08CustomListSorter;

public class Sorter{

    // Bubble sort
    public static <T extends Comparable<T>> void sort(CustomList<T> customList){
        for (int i = 0; i < customList.customSize(); i++) {
            T element = customList.customGet(i);
            for (int j = i + 1; j < customList.customSize(); j++) {
                T nextElement = customList.customGet(j);
                if (element.compareTo(nextElement) > 0){
                    customList.swap(i, j);
                }
            }
        }
    }
}
