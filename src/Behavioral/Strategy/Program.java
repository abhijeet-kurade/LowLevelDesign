package Behavioral.Strategy;

public class Program {
    public static void main(String[] args) {
        Sort s = new Sort(new InsertionSort());
        s.sortData(new int[]{});
    }
}

class Sort{
    ISorter sorter;

    public Sort(ISorter sorter) {
        this.sorter = sorter;
    }

    public void sortData(int[] data){
        sorter.sort(data);
    }
}

interface ISorter{
    void sort(int[] data);
}

class BubbleSort implements ISorter{

    @Override
    public void sort(int[] data) {

    }
}

class InsertionSort implements ISorter{

    @Override
    public void sort(int[] data) {

    }
}


