package structures;

import java.util.Iterator;

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
			elem = postorder((BinaryTreeNodeI<T>)(root));
			prev=elem;
			next=postorder((BinaryTreeNodeI<T>)(root));
		} else {
			elem = next;
			next=postorder((BinaryTreeNodeI<T>)(root));
		}
		return elem;

	}

	private T postorder (BinaryTreeNodeI<T> node)
	{
		if(node.hasLeftChild()) {
				T returned = postorder ((BinaryTreeNodeI<T>)(node.getLeftChild()));
				if(returned!=null)
					return returned;
		}

		if(node.hasRightChild()) {
			T returned = postorder ((BinaryTreeNodeI<T>)(node.getRightChild()));
			if(returned!=null)
				return returned;
		}
		
		if(node.active()) {
			node.Deactivate();
			return node.getData();
		}

		return null;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
