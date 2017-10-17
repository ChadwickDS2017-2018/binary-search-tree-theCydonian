package structures;

import java.util.Iterator;

public class BinarySearchTreeI<T extends Comparable<? super T>> implements BinarySearchTree<T>{

	BinaryTreeNodeI<T> root=null;
	int size = 0;

	@Override
	public BinarySearchTree<T> add(T toAdd) {
		// TODO Auto-generated method stub
		if(toAdd==null)
			throw new NullPointerException();
		size++;
		if(root==null) {
			root = new BinaryTreeNodeI<T>(toAdd);

		} else {
			if(toAdd.compareTo(root.getData())<=0) {
				if(root.hasLeftChild())
					add(toAdd, root.getLeftChild());
				else
					root.setLeftChild(new BinaryTreeNodeI<T>(toAdd));
			}else {
				if(root.hasRightChild())
					add(toAdd, root.getRightChild());
				else
					root.setRightChild(new BinaryTreeNodeI<T>(toAdd));
			}
		}
		return this;
	}
	private BinarySearchTree<T> add(T toAdd, BinaryTreeNode<T> node) {
		// TODO Auto-generated method stub
		if(toAdd.compareTo(node.getData())<=0) {
			if(node.hasLeftChild())
				add(toAdd, node.getLeftChild());
			else
				node.setLeftChild(new BinaryTreeNodeI<T>(toAdd));
		}else {
			if(node.hasRightChild())
				add(toAdd, node.getRightChild());
			else
				node.setRightChild(new BinaryTreeNodeI<T>(toAdd));
		}
		return this;
	}

	@Override
	public boolean contains(T toFind) {
		// TODO Auto-generated method stub
		if(toFind==null)
			throw new NullPointerException();
		if(root==null)
			return false;

		boolean x=false;
		boolean y=false;
		if(root.getData().equals(toFind))
			return true;
		if(root.hasLeftChild())
			x=contains(toFind, false, root.getLeftChild());
		if(root.hasRightChild())
			y=contains(toFind, false, root.getRightChild());

		return (x||y);
	}
	private boolean contains(T toFind, boolean val, BinaryTreeNode<T> node) {
		// TODO Auto-generated method stub
		boolean x=false;
		boolean y=false;
		if(node.getData().equals(toFind)) {
			return true;
		}
		if(node.hasLeftChild())
			x=contains(toFind, false, node.getLeftChild());
		if(node.hasRightChild())
			y=contains(toFind, false, node.getRightChild());

		return (x||y);
	}

	@Override
	public boolean remove(T toFind) {
		if(isEmpty())
			return false;
		else {
			if(toFind.equals(root.getData())) {
				root=(BinaryTreeNodeI<T>) replacement(root);
				size--;
				return true;
			} else {
				if(toFind.compareTo(root.getData())<0) {
					if(root.hasLeftChild())
						return remove(toFind, root.getLeftChild(), root);
				}else {
					if(root.hasRightChild()) {
						return remove(toFind, root.getRightChild(), root);
					}
				}
			}
		}
		return false;
	}
	private boolean remove(T toFind, BinaryTreeNode<T> node, BinaryTreeNode<T> parent) {
		// TODO Auto-generated method stub
		if(node==null)
			return false;
		if(toFind.equals(node.getData())) {
			BinaryTreeNode<T> temp = replacement(node);
			if(parent.hasRightChild()) {
				if(parent.getRightChild()==node)
					parent.setRightChild(temp);
				else
					parent.setLeftChild(temp);
			}else
				parent.setLeftChild(temp);
			size--;
			return true;
		}else {
			if(toFind.compareTo(node.getData())<0) {
				if(node.hasLeftChild())
					return remove(toFind, node.getLeftChild(), node);
			}else {
				if(node.hasRightChild())
					return remove(toFind, node.getRightChild(), node);
			}
		}
		return false;
	}
	private BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) {
		// TODO Auto-generated method stub
		BinaryTreeNode<T> result = null;

		if(!node.hasLeftChild() && !node.hasRightChild())
			result=null;
		else if(node.hasLeftChild() && !node.hasRightChild())
			result=node.getLeftChild();
		else if(!node.hasLeftChild() && node.hasRightChild())
			result=node.getRightChild();
		else {
			BinaryTreeNode<T> current = node.getRightChild();
			BinaryTreeNode<T> parent = node.getRightChild();
			while (current.hasLeftChild()) {
				parent=current;
				current=parent.getLeftChild();
			}
			current.setLeftChild(node.getLeftChild());
			if(!node.getRightChild().equals(current)) {
				if(current.hasRightChild())
					parent.setLeftChild(current.getRightChild());
				else
					parent.setLeftChild(null);

				current.setRightChild(node.getRightChild());
			}
			result=current;
		}

		return result;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (root==null);
	}

	@Override
	public T getMinimum() {
		// TODO Auto-generated method stub
		if(root==null)
			throw new IllegalStateException();
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
		if(root==null)
			throw new IllegalStateException();
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
