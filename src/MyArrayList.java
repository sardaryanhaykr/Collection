import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by Hayk on 28.07.2021.
 */
public class MyArrayList<T> implements Iterable<T> {
    private static final int DEFALT_CAPACITY = 16;
    private static final Object[] EMPTY_LIST = new Object[0];
    private int size;
    private int capacity;
    private Object[] elements;
    private static final int MAX_ARRAY_SIZE = 2147483639;

    public MyArrayList(int size) {
        int multy = 1;
        if (size > 0) {
            this.elements = new Object[size];
            while (multy <= size) {
                multy *= 2;
            }
            capacity = multy;
        } else {
            if (size != 0) {
                throw new IllegalArgumentException("Illegal Capacity: " + size);
            }

            this.elements = EMPTY_LIST;
        }
    }

    public MyArrayList() {
        this.elements = new Object[DEFALT_CAPACITY];
        capacity = DEFALT_CAPACITY;
    }

    public T get(int i) {
        if (i < size && i > -1) {
            return (T) elements[i];
        } else {
            throw new IndexOutOfBoundsException("Index out of array size");
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int indexOf(T t) {
        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T t) {
        return this.indexOf(t) >= 0;
    }

    public void add(T t) {
        if (size < DEFALT_CAPACITY) {
            elements[size++] = t;
        } else {
            capacity *= 2;
            Object[] newElements = new Object[capacity];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            newElements[size++] = t;
            elements = newElements;
        }
    }

    public void delete(int index) {
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        --size;
        if (capacity > 16 && size * 4 < capacity){
            capacity/=2;
            Object[] newElements = new Object[capacity];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator=new Iterator<T>() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return  currentIndex < size &&elements[currentIndex] != null;
            }

            @Override
            public T next() {
                return (T) elements[currentIndex++];
            }
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return iterator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyArrayList<?> that = (MyArrayList<?>) o;

        if (size != that.size) return false;
        if (capacity != that.capacity) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + capacity;
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }
}
