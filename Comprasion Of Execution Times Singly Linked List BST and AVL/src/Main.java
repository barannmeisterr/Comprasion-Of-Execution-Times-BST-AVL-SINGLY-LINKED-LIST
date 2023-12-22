import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int[] sizes = { 10000, 100000, 1000000 };
		
		int secim;                                 
		Scanner sc = new Scanner(System.in);

		System.out.println(" ====================================================================================");
		System.out.println("|    Press 1 to test manually the codes work well                                   |");
		System.out.println("|    Press 2 to see execution times of insertion,search and deletion for datasets.  |");
		System.out.println(" ====================================================================================");
		System.out.println("");
		System.out.print("Choice: ");
		secim = sc.nextInt();

		switch (secim) {
		case 1:
			BstOperations bsT = new BstOperations();
			AvlOperations avL = new AvlOperations();
			LinkedListOperations lisT = new LinkedListOperations();

			bsT.insertInBst(10);
			bsT.insertInBst(5);
			bsT.insertInBst(20);
			bsT.insertInBst(30);
			bsT.insertInBst(40);
			bsT.insertInBst(50);
			bsT.insertInBst(25);

			avL.insertInAvl(10);
			avL.insertInAvl(5);
			avL.insertInAvl(20);
			avL.insertInAvl(30);
			avL.insertInAvl(40);
			avL.insertInAvl(50);
			avL.insertInAvl(25);

			System.out.println(" BST TRAVERSALS ");
			System.out.println();
			bsT.PreOrder();
			bsT.PostOrder();
			bsT.InOrder();

			System.out.println(" AVL TRAVERSALS ");
			avL.PreOrder();
			avL.PostOrder();
			avL.InOrder();

			System.out.println();
			System.out.println("Enter the number you want to search in bst ?");
			int searchbst = sc.nextInt();
			System.out.println(bsT.searchInBst(searchbst));

			System.out.println("Enter the number you want to search in avl ? ");
			int searchavl = sc.nextInt();
			System.out.println(avL.searchInAvl(searchavl));

			System.out.println("Enter the number you want to delete in bst and avl ?");
			int delete = sc.nextInt();

			bsT.deleteInBst(delete);
			avL.deleteInAvl(delete);

			System.out.println(delete + " is deleted if presents in the tree from bst and avl... ");
			System.out.println(" BST TRAVERSALS ");
			bsT.PreOrder();
			bsT.PostOrder();
			bsT.InOrder();

			System.out.println(" AVL TRAVERSALS");
			avL.PreOrder();
			avL.PostOrder();
			avL.InOrder();

			System.out.println();

			lisT.insertAtEndInList(10);
			lisT.insertAtEndInList(5);
			lisT.insertAtEndInList(20);
			lisT.insertAtEndInList(30);
			lisT.insertAtEndInList(40);
			lisT.insertAtEndInList(50);
			lisT.insertAtEndInList(25);

			System.out.println("\nLIST TRAVERSAL\n");
			lisT.printList();
			System.out.println("Enter the number you want to search in list ? ");
			int sl = sc.nextInt();

			System.out.println(sl + " is searched. " + lisT.searchInList(sl));
			System.out.println("Enter the number you want to delete in list ? ");
			int dl = sc.nextInt();
			lisT.deleteInList(dl);
			lisT.printList();

			break;

		case 2:
			Random rand = new Random();

			BstOperations bst = new BstOperations();
			AvlOperations avl = new AvlOperations();
			LinkedListOperations list = new LinkedListOperations();

			System.out.println("N\tBST Insert\tAVL Insert\tSingly Linked List Insert");
			for (int size : sizes) {
				// BST Insert
				long start = System.currentTimeMillis();
				for (int i = 0; i < size; i++) {
					bst.insertInBst(rand.nextInt(1000000));
				}
				long finish = System.currentTimeMillis();
				long bstInsertTime = finish - start;

				// AVL Insert
				start = System.currentTimeMillis();
				for (int i = 0; i < size; i++) {
					avl.insertInAvl(rand.nextInt(1000000));
				}
				finish = System.currentTimeMillis();
				long avlInsertTime = finish - start;

				// Singly Linked List Insert
				start = System.currentTimeMillis();
				for (int i = 0; i < size; i++) {
					list.insertAtEndInList(rand.nextInt(1000000));
				}
				finish = System.currentTimeMillis();
				long listInsertTime = finish - start;

				System.out.printf("%d\t%d ms\t\t%d ms\t\t%d ms\n", size, bstInsertTime, avlInsertTime, listInsertTime);
			}

			System.out.println("\nN\tBST Search\tAVL Search\tSingly Linked List Search");
			for (int size1 : sizes) {
				int keyToSearch = rand.nextInt(1000000);

				// BST Search
				long start = System.currentTimeMillis();
				for (int i = 0; i < size1; i++) {
					bst.searchInBst(keyToSearch);
				}
				long finish = System.currentTimeMillis();
				long bstSearchTime = finish - start;

				// AVL Search
				start = System.currentTimeMillis();
				for (int i = 0; i < size1; i++) {
					avl.searchInAvl(keyToSearch);
				}
				finish = System.currentTimeMillis();
				long avlSearchTime = finish - start;

				// Singly Linked List Search
				start = System.currentTimeMillis();
				for (int i = 0; i < size1; i++) {
					list.searchInList(keyToSearch);
				}
				finish = System.currentTimeMillis();
				long listSearchTime = finish - start;

				System.out.printf("%d\t%d ms\t\t%d ms\t\t%d ms\n", size1, bstSearchTime, avlSearchTime, listSearchTime);
			}

			System.out.println("\nN\tBST Delete\tAVL Delete\tSingly Linked List Delete");
			for (int size2 : sizes) {
				int keyToDelete = rand.nextInt(1000000);

				// BST Delete
				long start = System.currentTimeMillis();
				for (int i = 0; i < size2; i++) {
					bst.deleteInBst(keyToDelete);
				}
				long finish = System.currentTimeMillis();
				long bstDeleteTime = finish - start;

				// AVL Delete
				start = System.currentTimeMillis();
				for (int i = 0; i < size2; i++) {
					avl.deleteInAvl(keyToDelete);
				}
				finish = System.currentTimeMillis();
				long avlDeleteTime = finish - start;

				// Singly Linked List Delete
				start = System.currentTimeMillis();
				for (int i = 0; i < size2; i++) {
					list.deleteInList(keyToDelete);
				}
				finish = System.currentTimeMillis();
				long listDeleteTime = finish - start;

				System.out.printf("%d\t%d ms\t\t%d ms\t\t%d ms\n", size2, bstDeleteTime, avlDeleteTime, listDeleteTime);
			}
			break;

		default:
			System.out.println("Wrong Number!");
		}
	}
}