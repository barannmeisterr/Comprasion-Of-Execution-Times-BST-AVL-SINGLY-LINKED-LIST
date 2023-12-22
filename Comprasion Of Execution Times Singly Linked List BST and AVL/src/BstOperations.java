
public class BstOperations {
BstNode root;
public BstOperations () {
	this.root=null;
}
public BstNode insertInBst(BstNode root,int key) {//Insert method to add element.Recursive calls,setter and getter are used.
	if(root == null) {
		return new BstNode(key);
	}//if the tree is empty , inserted element can be considered as root.

    if(key < root.getData()) {//if key smaller than the value of root 
	root.setLeft(insertInBst(root.getLeft(),key));//insert to the left side
}else if(key > root.getData()) { //if key greater than the value of root 
	root.setRight(insertInBst(root.getRight(),key));//insert to the right side
}
return root;//return the unchanged BstNode pointer

}
public void insertInBst(int key) {//Wrapper Method to add easily to BST Tree
	root = insertInBst(root,key);
}
public boolean searchInBst(BstNode root,int key) {
	if(root==null) {//if root is null or the value of root data equals to the key
		return false;//then return root. 
	}
	if(key==root.getData()) {
		return true;
	}
	if( key < root.getData()) {//if key smaller than root and the left side of root not empty
		return searchInBst(root.getLeft(),key);//then search and return true or false
	}else  {//if key is grater than root 
		return searchInBst(root.getRight(),key);//then search and return true or false on the right side of the root recursively 
	}
	
	
}
public boolean searchInBst(int key) {
	return searchInBst(root, key);
	
}
public BstNode findMinimumForDeleteOperation(BstNode root) {
	if (root == null) {
        return null;
    }
    if (root.getLeft() == null) {
        // If left is empty but right side is not empty, minimum value is root
        return root;
    } else {
        // If left side of the root is not empty, return the minimum value on the left side
        return findMinimumForDeleteOperation(root.getLeft());
    }

}
public BstNode deleteInBst(BstNode root,int key) {
if(root==null) {
	return null;
}
if(key < root.getData()) {//if key smaller than data of the root
	root.setLeft(deleteInBst(root.getLeft(),key));//recursive call is made to left side
}else if (key > root.getData()) {//if key greater than data of root
	root.setRight(deleteInBst(root.getRight(),key));//recursive call is made to right side
}else {
	
	if(root.getLeft()==null && root.getRight() == null) { // if deleted node is leaf
		root=null;
	    return null;
	}
	else if(root.getLeft()==null || root.getRight() == null) {//if deleted node has one child
		
		BstNode temp ;
		if(root.getLeft()==null) {
		temp = root.getRight();
		}else {
			temp = root.getLeft();
		}
		root=null; 
	    return temp ;
	}else {//if deleted node has two child
		
		BstNode temp = findMinimumForDeleteOperation(root.getRight());//min value of right subtree
		root.setData(temp.getData());
		root.setRight(deleteInBst(root.getRight(),temp.getData()));		
	}	
}
	return root;
	
}
public void deleteInBst(int key) {
	root = deleteInBst(root,key);
}

public void PreOrder(BstNode root) {
	if(root!=null) {
	System.out.print(root.getData() + " ");	
	PreOrder(root.left);
	PreOrder(root.right);
	}

}
public void PostOrder(BstNode root) {
	if(root!=null) {
	
		PostOrder(root.left);
		PostOrder(root.right);
		System.out.print(root.getData() + " ");
	}
}
public void InOrder(BstNode root) {
	if(root!=null) {
		InOrder(root.left);
	System.out.print(root.getData() + " ");
	InOrder(root.right);
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
