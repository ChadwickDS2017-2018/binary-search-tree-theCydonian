package structures;

import java.util.Iterator;

public class BinaryTreeUtilityI implements BinaryTreeUtility{

	@Override
	public <T> Iterator<T> getPreOrderIterator(BinaryTreeNode<T> root) {
		// TODO Auto-generated method stub
		if(root==null)
			throw new NullPointerException();
		
		return null;
	}

	@Override
	public <T> Iterator<T> getInOrderIterator(BinaryTreeNode<T> root) {
		// TODO Auto-generated method stub
		if(root==null)
			throw new NullPointerException();
		
		return null;
	}

	@Override
	public <T> Iterator<T> getPostOrderIterator(BinaryTreeNode<T> root) {
		// TODO Auto-generated method stub
		if(root==null)
			throw new NullPointerException();
		
		return null;
	}

	@Override
	public <T> int getDepth(BinaryTreeNode<T> root)  {
		// TODO Auto-generated method stub
		if (root==null) {
			throw new NullPointerException();
		}
		int leftDepth = 0;
		int rightDepth = 0;
		if(root.hasLeftChild())
			leftDepth=getDepth(root.getLeftChild(), 1); 
			if(root.hasRightChild())
				rightDepth=getDepth(root.getRightChild(), 1); 

				if(leftDepth>rightDepth)
					return leftDepth;
				else
					return rightDepth;
	}

	private <T> int getDepth(BinaryTreeNode<T> root, int depth) {
		// TODO Auto-generated method stub
		int ldepth = 0;
		int rdepth = 0;
		if(root.hasLeftChild()) {
			ldepth=getDepth(root.getLeftChild(), depth+1);
		}
		if(root.hasRightChild()) {
			rdepth=getDepth(root.getRightChild(), depth+1);
		}
		if(rdepth>ldepth && rdepth>depth) {
			depth=rdepth;
		} else if(ldepth>=rdepth && ldepth>depth) {
			depth=ldepth;
		}
		return depth;
	}
	
	
	private <T> int getMinDepth(BinaryTreeNode<T> root)  {
		// TODO Auto-generated method stub
		if (root==null) {
			throw new NullPointerException();
		}
		int leftDepth = 0;
		int rightDepth = 0;
		if(root.hasLeftChild())
			leftDepth=getMinDepth(root.getLeftChild(), 1); 
			if(root.hasRightChild())
				rightDepth=getMinDepth(root.getRightChild(), 1); 

				if(leftDepth<rightDepth)
					return leftDepth;
				else
					return rightDepth;
	}

	private <T> int getMinDepth(BinaryTreeNode<T> root, int depth) {
		// TODO Auto-generated method stub
		int ldepth = 0;
		int rdepth = 0;
		if(root.hasLeftChild()) {
			ldepth=getMinDepth(root.getLeftChild(), depth+1);
		}
		if(root.hasRightChild()) {
			rdepth=getMinDepth(root.getRightChild(), depth+1);
		}
		if(rdepth<ldepth && rdepth>depth) {
			depth=rdepth;
		} else if(ldepth<=rdepth && ldepth>depth) {
			depth=ldepth;
		}
		return depth;
	}

	@Override
	public <T> boolean isBalanced(BinaryTreeNode<T> root, int tolerance) {
		// TODO Auto-generated method stub
		if(tolerance<0)
			throw new IllegalArgumentException();
		
		int min=getMinDepth(root);
		int max=getDepth(root);
		
		
		return (max-min<=tolerance);
	}

	@Override
	public <T extends Comparable<? super T>> boolean isBST(BinaryTreeNode<T> root) {
		// TODO Auto-generated method stub
		if(root==null)
			throw new NullPointerException();
		
		boolean x=true;
		boolean y=true;
		if(root.hasLeftChild()) {
			if((Integer)(root.getLeftChild().getData())<=(Integer)(root.getData()))
				x=isBST(root.getLeftChild());
			else
				return false;
	}
		if(root.hasRightChild()) {
			if((Integer)(root.getRightChild().getData())>(Integer)(root.getData()))
				y=isBST(root.getRightChild());
			else
				return false;
	}
		return x&&y;
		
	}

}
