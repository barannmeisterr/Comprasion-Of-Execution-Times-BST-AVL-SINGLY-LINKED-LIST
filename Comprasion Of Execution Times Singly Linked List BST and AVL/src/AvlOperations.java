
public class AvlOperations {//the only difference inserting and deleting operations are updating height and returning balanced node
AvlNode root ;               //search operation is same with bst  
public AvlOperations() {
	this.root=null;
}
public int findMax(int a , int b ) {
	return Math.max(a, b);
}

public int getHeight(AvlNode node) {// return the height of node
	return (node==null) ? 0 : node.height;
}
public void updateHeight(AvlNode node) { // updates the height as maximum of heights between leftChild and rightChild then adds 1.
int leftChild = getHeight(node.getLeft());	
int rightChild = getHeight(node.getRight());
node.height = findMax(leftChild,rightChild) + 1 ;
}
public AvlNode rightRotation(AvlNode node) {
	AvlNode leftChild =node.getLeft();//create a node named leftChild which will be rotated to right and assign node.getLeft()
    node.setLeft(leftChild.getRight());//set the left child of the node as right child of leftChild 
    leftChild.setRight(node);//set the node as right child of leftChild
 updateHeight(node);
updateHeight(leftChild);
//updates heights of node and LeftChild
return leftChild;
}
public AvlNode leftRotation(AvlNode node) {
AvlNode rightChild = node.getRight();//create a node named rightChild which will be rotated to left and assign node.getRight()
	node.setRight(rightChild.getLeft());//set the right child of the node as left child of rightChild
	rightChild.setLeft(node);//set the node as left child of rightChild
	updateHeight(node);
	updateHeight(rightChild);
	//updates heights of node and rightChild
	
	return rightChild;	
}
public int getBalance(AvlNode node) {
	return (node == null ) ? 0 : getHeight(node.getLeft()) - getHeight(node.getRight());
}
public AvlNode balance(AvlNode node) {
	int balanceFactor = getBalance(node);
	if(balanceFactor > 1 && getBalance(node.getLeft())>=0) {//left - left case 
		return rightRotation(node);
	}
	if(balanceFactor > 1 && getBalance(node.getLeft()) < 0) {//left - right case
	
		//first apply left rotation to make the case left - left case ,then fix the case with right rotation 
		node.setLeft(leftRotation(node.getLeft()));
	return rightRotation(node);
	}
	if(balanceFactor < -1 && getBalance(node.getRight()) <= 0) {//right - right case
		return leftRotation(node);
	}
if(balanceFactor < -1 && getBalance(node.getRight()) > 0) {//right - left case
	//first apply right rotation to make the case right - right case ,then fix the case with left rotation 
	node.setRight(rightRotation(node.getRight()));
	return leftRotation(node) ; 
	
}
return node;
}
public AvlNode insertInAvl(AvlNode node,int key) {
	
	if(node == null) {
		return new AvlNode(key);
	}
	if(key < node.getData()) {
		node.setLeft(insertInAvl(node.getLeft(),key));
	}else if (key > node.getData()) {
		node.setRight(insertInAvl(node.getRight(),key));
	}//from begginning to this point , same with bst 
	updateHeight(node);
return balance(node);
}
public void insertInAvl(int key) {
	root = insertInAvl(root,key);
}
public boolean searchInAvl(AvlNode node , int key) {//same with bst 
if(node == null ) {
	return false;
}
	if(node.getData()==key) {
		return true;
	}
  

	if(key < node.getData()) {
	return searchInAvl(node.getLeft(),key);
}else {
	return searchInAvl(node.getRight(),key);
}

}
	
public boolean searchInAvl(int key) {
	return searchInAvl(root, key);
}
public AvlNode findMinimumForDelete(AvlNode node) {
	if(node == null) {
		return null;
	}
if(node.getLeft()==null) {
	return node;
}else {
	return findMinimumForDelete(node.getLeft());
}

}
public AvlNode deleteInAvl(AvlNode node,int key) {
	if(node==null) {
		return null;
	}
	if(key < node.getData()) {
		node.setLeft(deleteInAvl(node.getLeft(),key));
	}else if(key > node.getData()) {
		node.setRight(deleteInAvl(node.getRight(),key));
	}else {
		if(node.getLeft()==null&&node.getRight()==null) {
			node =null;
		return null;
		}else if(node.getLeft()==null||node.getRight()==null) {
			AvlNode temp;
			if(node.getLeft()==null) {
				temp = node.getRight();
			}else {
				temp = node.getLeft();
			}
             node =null;
             return temp;
		}else {
			AvlNode temp = findMinimumForDelete(node.getRight());
		node.setData(temp.getData());
		node.setRight(deleteInAvl(node.getRight(),temp.getData()));
		}		
	}//from begginning to this point , same with bst 
	updateHeight(node);
	return balance(node);
		
}
public void deleteInAvl(int key) {
	root = deleteInAvl(root,key);
}

public void PreOrder(AvlNode node) {
    if (node != null) {
        System.out.print(node.getData() + " ");
        PreOrder(node.getLeft());
        PreOrder(node.getRight());
    }
}



public void PostOrder(AvlNode node) {
    if (node != null) {
        PostOrder(node.getLeft());
        PostOrder(node.getRight());
        System.out.print(node.getData() + " ");
    }
}



public void InOrder(AvlNode node) {
    if (node != null) {
        InOrder(node.getLeft());
        System.out.print(node.getData() + " ");
        InOrder(node.getRight());
    }
}
public void InOrder() {
	System.out.print("In-Order Traversal: ");
	InOrder(root);
System.out.println();
}
public void PostOrder() {
	System.out.print("Post-Order Traversal: ");
	PostOrder(root);
System.out.println();
}
public void PreOrder() {
  
	System.out.print("Pre-Order Traversal: ");
	PreOrder(root);
System.out.println();
}

}
