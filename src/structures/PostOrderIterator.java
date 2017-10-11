package structures;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class PostOrderIterator<T> implements Iterator<T>  {

	boolean returnElements = false;

	private final BinaryTreeNode<T> root;

	T prev;
	T next;


	public PostOrderIterator(BinaryTreeNode<T> root){
		this.root=root;

		prev=next=null;
	}

	@Override
	public boolean hasNext() {
		return !((next==null)&&(prev!=null));
	}

	@Override
	public T next() {
		T elem;
		if(prev==null) {
			elem = inorder((BinaryTreeNodeI<T>)(root));
			prev=elem;
			next=inorder((BinaryTreeNodeI<T>)(root));
		} else {
			elem = next;
			next=inorder((BinaryTreeNodeI<T>)(root));
		}
		return elem;

	}

	private T inorder (BinaryTreeNodeI<T> node)
	{
		if(node.hasLeftChild()) {
				T returned = inorder ((BinaryTreeNodeI<T>)(node.getLeftChild()));
				if(returned!=null)
					return returned;
		}

		if(node.active()) {
			node.Deactivate();
			return node.getData();
		}

		if(node.hasRightChild()) {
			return inorder ((BinaryTreeNodeI<T>)(node.getRightChild()));
		}

		return null;
	}

	private T InOrderActive (BinaryTreeNodeI<T> node)
	{
		if(node.hasLeftChild()) {
			System.out.println("l");
			return inorder ((BinaryTreeNodeI<T>)(node.getLeftChild()));
		}

		if(node.active()) {
			return node.getData();
		}

		if(node.hasRightChild()) {
			return inorder ((BinaryTreeNodeI<T>)(node.getRightChild()));
		}

		return null;
	}


	private boolean isLeaf(BinaryTreeNode<T> node) {
		return !node.hasLeftChild()&&!node.hasRightChild();
	}
	private boolean isRightOnly(BinaryTreeNode<T> node) {
		return !node.hasLeftChild()&&node.hasRightChild();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
