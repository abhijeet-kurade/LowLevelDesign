package Behavioral.Strategy;

public class Program {
}

class Sort{
    ISorter sorter;

    public void sortData(int[] data){
        sorter.sort(data);
    }
}

interface ISorter{
    void sort(int[] data);
}

