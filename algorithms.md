# Algorithms

* `Non decreasing` vs ascending

## Sorting

### Insertion Sort
* Time complexity: n * (n-1)/2 => O(n^2)

```java
import java.util.Random;

class Main{
	public static void randomFill(int[] data, int max){
		Random gen = new Random();
		for(int i = 0; i < data.length; i++){
			data[i] = gen.nextInt(max);
			//data[i] = gen.nextInt(); //Pick an integer from entire range.
		}
	}

	public static void printArray(int[] data){
		System.out.println("[");
		for(int i = 0; i < data.length - 1; i++){
			System.out.print(data[i] + ", ");
		}
		System.out.println(data[data.length - 1] + "]");
	}

	public static void main(String a[]){
		int data[] = new int[300];
		randomFill(data, 100);
		printArray(data);
		for(int i = 1; i < data.length; i++){
			int key = data[i];

			for(int j = i - 1; j >=0 && key < data[j]; j--){
				data[j+1] = data[j];
			}
			data[j+1] = key;
		}
		printArray(data);
	}
}
```

### Trees
* A *tree* is a (possibly empty) set of elements called *nodes* with one node designated as *root*.
* The *root* is connected via edges to some number of *child* nodes, each of which itself the root of a *subtree*.
* Trees are naturally recursive.
* A *leaf* is a node with no children.
* An *internal node* is any non-leaf.
* A *branch* in a tree is a path of connected edges starting at the root and ending in a leaf.
* The *depth* or *level* of a node *n* in a tree is defined recursively.
* The *height* of a tree is its maximum depth.
```
depth(n) 	= 1 if n is the root.
	    	= 1 + depth(paent(n)) otherwise
```
* **Important terminalogy**: tree, root, child, subtree, leaf, internal node, branch, parent, grand parent, sibling, ancestor, descendant, depth, level.
* A tree is a *binary tree* in which every node has at most two children, usually named *left* and *right*.

* **Expression Tree** or **Parse Tree** is a binary tree which translates each binary operation to a tree with its operator as the root and its two operands as the left and right children.
```
Expression: (A + B) * C
					    *
					   / \
					  /   \
					 +     C
					/ \
				    /   \
				   A     B
```

A **binary search tree** is a tree containing comparable values in which the following property is true at every node *p*: 
```
Every value in left subtree of p < Value at p < Every value in right subtree of p
```
* Binary search trees do not contain duplicate elements.

### Traversals
* Traversal of a tree is a method that visits every node in the tree.
* **Depth-First**: There are 3 ways to traverse a binary tree. Following are the *depth-first* tranversal methods as they traverse all the way down some branch before backtracking to reach other nodes. *Depth-First* traversals are recursive.
* **Preorder (node, left, right)**: Visit the node, traverse the left subtree, and traverse the right subtree.

```java
void preorder(Node node){
	if(node == null) return;
	System.out.println(node.value); //Visit node.
	preorder(node.left);
	preorder(node.right);
}
```

* **Inorder (left, node, right)**:

```java
void inorder(Node node){
	if(node == null) return;
	inorder(node.left);
	System.out.println(node.value); //Visit node.
	inorder(node.right);
}
```

* **Postorder(left, right, node)**:

```java
void postorder(Node node){
	if(node == null) return;
	postorder(node.left);
	postorder(node.right);
	System.out.println(node.value); //Visit node.
}
```

* **Breadth-First** traversal visits nodes in level order. Level 1 first, then level 2 and so on. This is not recursive. Following is an algorithm, that uses *Queue* data structure to do *Breadth-First* traversal.

```java
void breadthFirst(Node node){
	if(node == null) return;
	queue.push(node);
	while(!queue.isEmpty()){
		Node n = queue.pop();
		System.out.println(node.value); //Visit node.
		if(n.left != null) queue.push(n.left);
		if(n.right != null) queue.push(n.right);
	}
}
```

## BinaryTree class
* Following is an abstract implementation of a binary tree.
```java
public abstract class BinaryTree{
	protected Node root;
	private String preorder(Node n){
		if(n == null) return "";
		return (n + " " + preorder(n.left) + " " + preorder(n.right)).trim();
	}
	private String postorder(Node n){
		if(n == null) return "";
		return (postorder(n.left) + " " + postorder(n.right) + " " + n).trim();
	}
	private String inorder(Node n){
		if(n == null) return "";
		return (inorder(n.left) + " " + n + " " + inorder(n.right)).trim();
	}

	public String preorder(){ return preorder(root);	}
	public String postorder(){ return postorder(root);	}
	public String inorder(){ return inorder(root);	}

	protected static class Node{
		protected int data;
		protected Node left, right, parent;

		protected Node(int data, Node parent){
			this.data = data;
			this.parent = parent;
		}
		public String toString(){
			return data.toString();
		}
	}
}
```

## Binary Search Trees
* Binary search trees are built for fast searching
* Binary search trees contains no duplicates.

**Search**:
```java
public Node findNode(int item, Node root){
	if(root == null) return null; //Empty tree

	if(item == root.data) return root;
	if(item < root.data) return findNode(item, root.left);
	return findNode(item, root.left);
}
```

**Minimum**: The smallest element is found by following left links as far as possible.
```java
public Node smallest(Node root){
	if(root == null) return null;
	if(root.left == null) return root; //This is the left most leaf.
	return smallest(root.left);
}
```
**Maximum**: It is found by following right links as far as possible.
```java
public Node largest(Node root){
	if(root == null) return null;
	if(root.right == null) return root; //This is the left most leaf.
	return largest(root.right);
}
```