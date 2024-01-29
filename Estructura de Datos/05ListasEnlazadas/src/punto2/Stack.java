package punto2;

public class Stack<ELEMENT> {
 
    SimpleLinkedList<ELEMENT> list = new SimpleLinkedList();
 
    public Stack() {
    }

 

    //region Stack Methods
 
    // Test if this stack is empty.
    public boolean empty() {
    	return this.list.count <= 0;
    }
 
    // Looks at the object at the top of this stack without removing it from the stack.

 
    // Removes the object at the top of this stack and returns that object as the value of this function.
    public ELEMENT pop() {
        if (this.empty()) {
            throw new RuntimeException("La pila está vacía...");
        }
        
        return this.list.removeFirst();
    }
 
    // Pushes an item onto the top of this stack.
    public boolean push (ELEMENT element) {
    	list.addFirst(element);
        return true;
    }
 
    // Returns the 1-based position where an object is on this stack.

    //endregion
 
    //region Inherited Methods
 
    // Returns the number of components in this vector.
    public int size() {

    	return this.list.size();
        
    }
 
    //endregion
    
    
    
  
 
    public String toString() {
        return this.list.toString();
    }

}
 