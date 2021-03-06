// Tui Popenoe
// Doubly Linked List

public class DoublyLinkedList implements LinearList{
    // data members
    protected ChainNode firstNode;
    protected ChainNode lastNode;
    protected int size;

    // Constructors
    // Create an empty list
    public Chain(int initialCapacity){
        // default initial values for protected members are null and 0
    }

    public Chain(){
        this(0);
    }

    // methods
    // @return true iff list is empty
    public boolean isEmpty(){
        return size == 0;
    }

    // @return current number of elements in list
    public boolean size(){
        return size;
    }

    // @throws IndexOutOfBoundsException when
    // index is not between 0 and size - 1
    void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException(
                "index = " + index + " size = " + size);
        }
    }

    public Object get(int index){
        checkIndex(index);

        //move to desired node
        ChainNode currentNode = firstNode;
        for(int i = 0; i < index; i++){
            currentNode = currentNode.next;
        }
        return currentNode.element;
    }

    public int indexOf(Object theElement){
        // search the chain for theElement
        ChainNode currentNode = firstNode;
        int index = 0;
        while(currentNode != null && !currentNode.element.equals(theElement)){
            // move to next node
            currentNode = currentNode.next;
            index ++;
        }

        // Ensure matching element
        if(currentNode == null){
            return -1;
        }
        else{
            return index;
        }
    }

    public Object remove(int index){
        checkIndex(index);

        Object removedElement;
        if(index == 0){ // remove first node
            firstNode = firstNode.next;
        }
        else{
            // use q to get to predecessor of desired node
            ChainNode q = firstNode;
            for(int i = 0; i < index - 1; i++){
                q = q.next;
            }

            removedElement = q.next.element;
            q.next = q.next.next; // remove desired node
        }
        size--;
        return removedElement;
    }

    public void add(int index, Object theElement){
        if(index < 0 || index > size){
            // invalid list position
            throw new IndexOutOfBoundsException(
                "index = " + index + " size = " + size);
        }
        if(index == 0){
            // insert at front
            firstNode = new ChainNode(theElement, firstNode);
        }
        else{
            // find predecessor of new element
            ChainNode p = firstNode;
            for(int i = 0; i < index - 1; i++){
                p = p.next;
            }
            // insert after p
            p.next = new ChainNode(theElement, p.next);
        }
        size++;
    }

    // Convert to a string
    public String toString(){
        StringBuffer s = new StringBuffer("[");
        // put elements into the buffer
        ChainNode currentNode = firstNode;
        while(currentNode != null){
            if(currentNode.element == null){
                s.append("null, ");
            }
            else{
                s.append(currentNode.element.toString() + ", ");
            }
            currentNode = currentNode.next;
        }
        if(size > 0){
            s.delete(s.length() - 2, s.length()); // remove last ", "
        }
        s.append("]");
        // create equivalent String
        return new String(s);
    }

    public DoublyLinkedList join(DoublyLinkedList lst1, DoublyLinkedList lst2){
        lst1.lastNode.next = lst2.firstNode;
        lst2.lastNode.next = lst1.firstNode;
    }
}