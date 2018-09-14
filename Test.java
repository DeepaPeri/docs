import java.util.Random;

public abstract class BinaryTree<E>{
	protected Node<E> root;
	private String preorder(Node<E> n){
		if(n == null) return "";
		return (n + " " + preorder(n.left) + " " + preorder(n.right)).trim();
	}
	private String postorder(Node<E> n){
		if(n == null) return "";
		return (postorder(n.left) + " " + postorder(n.right) + " " + n).trim();
	}
	private String inorder(Node<E> n){
		if(n == null) return "";
		return (inorder(n.left) + " " + n + " " + inorder(n.right)).trim();
	}

	public String preorder(){ return preorder(root);	}
	public String postorder(){ return postorder(root);	}
	public String inorder(){ return inorder(root);	}

	protected static class Node<T>{
		protected T data;
		protected Node<T> left, right, parent;

		protected Node(T data, Node<T> parent){
			this.data = data;
			this.parent = parent;
		}
		public String toString(){
			return data.toString();
		}
	}
}