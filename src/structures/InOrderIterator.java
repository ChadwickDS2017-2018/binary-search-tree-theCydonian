package structures;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class InOrderIterator<T> implements Iterator<T>  {

	boolean returnElements = false;

	private final LinkedList<BinaryTreeNode<T>> stack;

	public InOrderIterator(BinaryTreeNode<T> root){
		stack = new LinkedList<BinaryTreeNode<T>>();
		inorder(root);
	}

	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	@Override
	public T next() {
		T elem = stack.get(0).getData();
		stack.remove(0);
		return elem;

	}

	private void inorder (BinaryTreeNode<T> node)
	{
			if(node.hasLeftChild())
				inorder (node.getLeftChild());
			
			stack.add(node);

			if(node.hasRightChild())
				inorder (node.getRightChild());
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
