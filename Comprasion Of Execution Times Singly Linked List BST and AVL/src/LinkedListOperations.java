
public class LinkedListOperations {
	
	    SinglyLinkedListNode head;
	    SinglyLinkedListNode tail;

	    public LinkedListOperations() {
	        this.head = null;
	        this.tail = null;
	    }

	    // Insert at the end of the list
	    public void insertAtEndInList(int data) {
	        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
	        if (tail == null) {
	            // if the list is empty, then both head and tail point to the new node.
	            head = newNode;
	            tail = newNode;
	        } else {
	            // inserts the new node to the end then update the tail reference.
	            tail.setNext(newNode);
	            tail = newNode;
	        }
	    }

	    // Search for an element
	    public boolean searchInList(int key) {
	        SinglyLinkedListNode current = head;
	        while (current != null) {
	            if (current.getData() == key) {
	                return true; // return true if the element is found
	            }
	            current = current.getNext();
	        }
	        return false; //return false the Element is not found
	    }

	    // Deletes an element
	    public void deleteInList(int key) {
	        SinglyLinkedListNode current = head;
	        SinglyLinkedListNode previous = null;

	        // Searches key and keep track of the previous node.
	        while (current != null && current.getData() != key) {
	            previous = current;
	            current = current.getNext();
	        }

	        if (current == null) {
	            // Element not found so this function does not do anything
	            return;
	        }

	        if (previous == null) {
	            // key is found on  head which means beginning at the list
	            head = current.getNext();
	            if (head == null) {
	                // If the list become  empty now, update the tail reference.
	                tail = null;
	            }
	        } else {
	            // The key is in the middle or at the end of the list.
	            previous.setNext(current.getNext());

	            // If the key is found on the end of the list which means tail, update the tail reference.
	            if (current.getNext() == null) {
	                tail = previous;
	            }
	        }
	    }

	    // Display the elements of the list
	    public void printList() {
	        SinglyLinkedListNode current = head;
	        while (current != null) {
	            System.out.print(current.getData() + " ");
	            current = current.getNext();
	        }
	        System.out.println();
	    }

}
