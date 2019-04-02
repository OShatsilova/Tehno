import java.util.Arrays;

public class ArrayContainer<T> implements IContainer<T> {

    private T[] array = (T[]) new Object[10];
    private static int count = 0;


    @Override
    public void add(T element) {
        if (count == array.length) {
            int newSize = (int) (array.length * 1.5) + 1;
            T[] newArray = (T[]) new Object[newSize];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[count] = element;
        count++;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    public static int size() {
        return count;
    }

    @Override
    public void printAll() {
        if (count == 0) System.out.println("Container is empty");
        else
            for (int i = 0; i < count; i++)
                System.out.println(array[i]);
    }

    @Override
    public T[] toArray() {
        return Arrays.copyOf(array, count);
    }

    @Override
    public void printAllWithNum() {
        if (count == 0) System.out.println("Пусто");
        else
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + " - " + array[i]);
            }

    }

    @Override
    public void delete(int elementIndex) {
        T[] newArray = (T[]) new Object[count - 1];
        if (elementIndex == 0) System.arraycopy(array, 1, newArray, 0, count - 1);
        else {
            System.arraycopy(array, 0, newArray, 0, elementIndex);
            if ((elementIndex + 1) > count)
                System.arraycopy(array, elementIndex + 1, newArray, elementIndex, count - 2);
        }
        array = newArray;
        count--;
    }

    @Override
    public void update(int elementIndex, T element) {
        array[elementIndex] = element;
    }

    @Override
    public AbstractDevice getElementFromContainer(int elementIndex) {
        return (AbstractDevice) array[elementIndex];
    }

}
