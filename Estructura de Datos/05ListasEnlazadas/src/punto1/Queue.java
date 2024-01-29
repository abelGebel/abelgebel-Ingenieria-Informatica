package punto1;

import java.util.Iterator;

public class Queue<ELEMENT> {
	
	SimpleLinkedList<ELEMENT> list = new SimpleLinkedList();
	
	Iterator<ELEMENT>iter=list.iterator(); 
 
    public Queue() {
    }

    public boolean add(ELEMENT element) {
    	list.addLast(element);
        return true;
    }
    
    public boolean offer(ELEMENT element) {return this.add(element);}
    
    public ELEMENT pool() { return this.remove();}

    public ELEMENT remove() {
        if (this.size() <= 0) {
            throw new IllegalStateException("Cola vacía ...");
        }
        return this.list.removeFirst();
    }
    
    public ELEMENT element() {return this.peek();} 

    public ELEMENT peek() {
        if (this.size() <= 0) {
            return null;
        }
        return this.list.removeFirst();
    }
    
    @Override
    public String toString() {
    	return this.list.toString();
    }

    public boolean isEmpty() {
        return this.list.count <= 0;
    }

    public int size() {
        return this.list.size();
    } 
}