
public class SinglyLinkedListNode {
     int data;
	SinglyLinkedListNode next;	
	
	public SinglyLinkedListNode(int data) {
		this.data=data;
		this.next=null;
	}
public void setData(int data) {
	this.data=data;
}
public void setNext(SinglyLinkedListNode next) {
	this.next=next;
}

public int getData() {
	return data;
}

public SinglyLinkedListNode getNext() {
		return next;
	}	
}
