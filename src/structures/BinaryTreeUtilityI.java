package structures;

import java.util.Iterator;

public class BinaryTreeUtilityI implements BinaryTreeUtility{

	@Override
	public <T> Iterator<T> getPreOrderIterator(BinaryTreeNode<T> root) {
		// TODO Auto-generated method stub
		//Iterator<T> test = new Iterator<T>();
		return null;
	}

	@Override
	public <T> Iterator<T> getInOrderIterator(BinaryTreeNode<T> root) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Iterator<T> getPostOrderIterator(BinaryTreeNode<T> root) {
		// TODO Auto-generated method stub
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
			leftDepth=getDepth(root.getLeftChild(), 1); System.out.println("left "+leftDepth);
			if(root.hasRightChild())
				rightDepth=getDepth(root.getRightChild(), 1); System.out.println("right "+rightDepth);

				if(leftDepth>rightDepth)
					return leftDepth;
				else
					return rightDepth;
	}

	public <T> int getDepth(BinaryTreeNode<T> root, int depth) {
		// TODO Auto-generated method stub
		int ldepth = 0;
		int rdepth = 0;
		if(root.hasLeftChild()) {
			System.out.println("Increased ldepth");
				ldepth=getDepth(root.getLeftChild(), depth+1);
		}
		if(root.hasRightChild()) {
			//System.out.println("Increased rdepth");
			rdepth=getDepth(root.getRightChild(), depth+1);
		}
		if(rdepth>ldepth) {
			return rdepth;
		}else {
			return ldepth;
		}
	}

	@Override
	public <T> boolean isBalanced(BinaryTreeNode<T> root, int tolerance) {
		// TODO Auto-generated method stub
		if(tolerance<0)
			throw new IllegalArgumentException();
		return false;
	}

	@Override
	public <T extends Comparable<? super T>> boolean isBST(BinaryTreeNode<T> root) {
		// TODO Auto-generated method stub
		return false;
	}

}
