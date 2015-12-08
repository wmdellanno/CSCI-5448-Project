/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 File:    Stack.java
 Date:    1/15/10
 Author:  Bill Dell'Anno
 Purpose: Stack Interface
 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

public interface Stack {

    boolean isEmpty();

    void push(Object x);

    Object pop();

    Object peekTop();
}
