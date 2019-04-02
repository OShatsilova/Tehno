public interface IContainer<T> {

    void add(T element);

    T get(int index);

    void printAll();

    T[] toArray();

    void delete(int elementIndex);

    AbstractDevice getElementFromContainer(int elementIndex);

    void update(int elementIndex, T element);

    void printAllWithNum();

}
