/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 File:    Stack.java
 Date:    1/15/10
 Author:  Bill Dell'Anno
 Purpose: Stack Interface
 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
import java.util.ArrayList;

public class ArrayListStack implements Stack {

    private ArrayList arr;

    public ArrayListStack(){
        arr = new ArrayList();
    }

    public boolean isEmpty(){
        return arr.size()==0;
    }

    public void push(Object x){
        arr.add(x);
    }

    public Object pop(){
        return arr.remove(arr.size() - 1);
    }

    public Object peekTop(){
        return arr.get(arr.size() - 1);
    }
}
