package structures;

import java.util.Iterator;

public class BinarySearchTreeI<T extends Comparable<? super T>> implements BinarySearchTree<T>{

	BinaryTreeNodeI<T> root = new BinaryTreeNodeI<T>();
	
	@Override
	public BinarySearchTree<T> add(T toAdd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T toFind) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(T toRemove) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T getMinimum() {
		// TODO Auto-generated method stub
		return getMinimum(root);
	}
	
	public T getMinimum(BinaryTreeNode<T> root) {
		// TODO Auto-generated method stub
		if(root.hasLeftChild())
			return getMinimum(root.getLeftChild());
		else
			return root.getData();
	}

	@Override
	public T getMaximum() {
		// TODO Auto-generated method stub
		return getMaximum(root);
	}
	
	public T getMaximum(BinaryTreeNode<T> root) {
		// TODO Auto-generated method stub
		if(root.hasRightChild())
			return getMaximum(root.getRightChild());
		else
			return root.getData();
	}

	@Override
	public BinaryTreeNode<T> toBinaryTreeNode() {
		// TODO Auto-generated method stub
		return root;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		Iterator<T> it = new InOrderIterator<T>(root);
		return it;
	}


}
