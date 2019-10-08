public class ArrayQueue<T> implements Queue<T> {

    T[] a;
    int start;
    int end;

    ArrayQueue(){
        a = (T[]) new Object[10];
        start = 0;
        end = 0;
    }

    public void enqueue(T item){
        if (end>a.length-1){
            shift();
        }
        a[end++]=item;

    }

    public T dequeue(){
        if (empty()){
            throw new IndexOutOfBoundsException();
        }
        return a[start++];
    }

    public boolean empty(){
        if (start==end){
            return true;
        }
        else {
            return false;
        }
    }

    void shift(){
        if (start==0){
            growArray();
        }
        else{
            T[] temp = a;
            a = (T[]) new Object[temp.length];
            for (int i = 0; i<temp.length-start;i++){
                a[i]=temp[i+start];
            }
            end = end - start;
            start = 0;
        }
    }

    void growArray(){
        T[] temp = a;
        a = (T[]) new Object[temp.length*2];
        for (int i = 0; i<temp.length;i++){
            a[i]=temp[i];
        }
    }

}