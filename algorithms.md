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
depth(n) = 1 if n is the root.
		 = 1 + depth(paent(n)) otherwise
```
* **Important terminalogy**: tree, root, child, subtree, leaf, internal node, branch, parent, grand parent, sibling, ancestor, descendant, depth, level.
* A tree is a *binary tree* in which every node has at most two children, usually named *left* and *right*.

* **Expression Tree** is a binary tree which translates each binary operation to a tree with its operator as the root and its two operands as the left and right children.
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