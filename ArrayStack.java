public class ArrayStack<T> implements Stack<T> {

    T[] a;
    int top;

    ArrayStack(){
        a = (T[]) new Object[10];
        top = -1;
    }

    public T pop(){
        if (empty()){
            throw new IndexOutOfBoundsException();
        }
        return a[top--];
    }

    public void push(T item){
        if (top==a.length-1){
            growArray();
        }
        a[++top]=item;
    }

    public T peek(){
        if (empty()){
            throw new IndexOutOfBoundsException();
        }
        return a[top];
    }

    public boolean empty(){
        if (top==-1){
            return true;
        }
        else{
            return false;
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
