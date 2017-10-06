package structures;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class InOrderIterator<T> implements Iterator<T>  {


	private final Deque<BinaryTreeNode<T>> stack;

	public InOrderIterator(BinaryTreeNode<T> root){
		stack = new LinkedList<BinaryTreeNode<T>>();
		stack.push(root);
	}

	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	@Override
	public T next() {
		BinaryTreeNode<T> toVisit = stack.pop();
		if(toVisit.hasRightChild()) {
			stack.push(toVisit.getRightChild());
			return toVisit.getData();
		}
		if(toVisit.hasLeftChild()) {
			stack.push(toVisit.getLeftChild());
			return nextEnd();
		}
		return toVisit.getData();

	}


	public T nextEnd() {
		BinaryTreeNode<T> toVisit = stack.pop();
		if(toVisit.hasRightChild()) {
			stack.push(toVisit.getRightChild());
			return toVisit.getData();
		}
		if(toVisit.hasLeftChild()) {
			stack.push(toVisit.getLeftChild());
			return next();
		}
		return toVisit.getData();

	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
