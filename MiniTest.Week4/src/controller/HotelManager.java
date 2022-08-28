package controller;
import storage.CSV;
import model.Imanager;
import java.util.List;
public class HotelManager implements Imanager{
    @Override
    public void add(List arr, Object element) {
        arr.add(element);
    }

    @Override
    public void edit(int index, List arr, Object element) {
        arr.set(index,element);
    }

    @Override
    public void remove(int index, List arr) {
        arr.remove(index);
    }


}
