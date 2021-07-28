import java.util.Iterator;

/**
 * Created by Hayk on 28.07.2021.
 */
public class MyLinkedList<T> implements Iterable<T>{
    private int size;
    private MyLinkedList.Node<T> first;

    public MyLinkedList() {
        size = 0;
    }

    public int size() {
        return this.size;
    }

    public void add(T elem) {
        first = new Node<>(first,elem);
        ++size;
    }

    public void add(T elem,int index){

            MyLinkedList.Node<T> current=get(index,this);
            MyLinkedList.Node<T> var;
            var=new MyLinkedList.Node<T>(current.next,elem);
            current.next=var;

    }

    private MyLinkedList.Node<T> get(int index,MyLinkedList list){
        if (index>=size||index<0){
            throw new IndexOutOfBoundsException();
        }else{
            MyLinkedList.Node<T> current=first;
            for (int i=0;i<index;i++){
                current=current.next;
            }
            return current;
        }
    }

    public T get(int index){
        return get(index,this).elem;
    }
    public void delete(){
        if (size>1) {
            this.first = first.next;
        }else{
            this.first=null;
        }
    }
    public void delete(int index){
        if (index==0){
            delete();
        }else{
        MyLinkedList.Node<T> elem=get(index-1,this);
        elem.next=elem.next.next;
        }
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator=new Iterator<T>() {
            private int currentIndex = 0;
            private MyLinkedList.Node<T> current=first;
            @Override
            public boolean hasNext() {
                return  currentIndex < size && current.next!=null;
            }

            @Override
            public T next() {
                T result=current.elem;

                    current=current.next;

                return result;
            }
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return iterator;
    }

    private static class Node<T>{
        T elem;
       MyLinkedList.Node<T> next;
        public Node(MyLinkedList.Node<T> var1, T var2){
            this.elem = var2;
            this.next=var1;
        }
    }
}
