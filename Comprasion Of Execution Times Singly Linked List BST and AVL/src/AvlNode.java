
public class AvlNode {
int data;
AvlNode left;
AvlNode right;
int height;
public AvlNode(int data) {
	this.data=data;
	this.height=1;
this.right=null;
this.left=null;
}
public void setData(int data) {
this.data=data;	
}
public void setLeft(AvlNode left) {
this.left=left;	
}
public void setRight(AvlNode right) {
this.right=right;	
}
public int getData() {
	return data;
}
public AvlNode getLeft() {
	return left;
}
public AvlNode getRight() {
	return right;
}



}
