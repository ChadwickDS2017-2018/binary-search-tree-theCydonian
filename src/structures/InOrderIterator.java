package structures;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class InOrderIterator<T> implements Iterator<T>  {

	boolean returnElements = false;

	private final LinkedList<BinaryTreeNode<T>> stack;

	public InOrderIterator(BinaryTreeNode<T> root){
		stack = new LinkedList<BinaryTreeNode<T>>();
		stack.add(root);
	}

	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	@Override
	public T next() {
		T elem = inorder((BinaryTreeNodeI<T>)(stack.getLast()));
		return elem;

	}

	private T inorder (BinaryTreeNodeI<T> node)
	{
			if(node.hasLeftChild()) {
				System.out.println("l");
				return inorder ((BinaryTreeNodeI<T>)(node.getLeftChild()));
			}
			
			if(node.active) {
				node.Deactivate();
				System.out.println("hello");
				return node.getData();
			}

			if(node.hasRightChild()) {
				System.out.println("r");
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
