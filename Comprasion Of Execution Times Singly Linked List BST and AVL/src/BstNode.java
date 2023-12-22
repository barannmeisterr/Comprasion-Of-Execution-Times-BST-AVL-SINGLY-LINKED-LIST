
public class BstNode {
int data;
BstNode left;
BstNode right;
public BstNode(int data) {
	this.data=data;
	this.left=null;
	this.right=null;	
}
public void setData(int data) {
	this.data=data;
}
public void setLeft(BstNode left) {
	this.left=left;
}
public void setRight(BstNode right) {
	this.right=right;
}
public int getData() {
	return data;
}
public BstNode getLeft() {
	return left;
}
public BstNode getRight() {
	return right;
}



}
