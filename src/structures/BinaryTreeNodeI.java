package structures;

public class BinaryTreeNodeI<T> implements BinaryTreeNode<T>{

	BinaryTreeNode<T>[] children = (BinaryTreeNode<T>[])(new BinaryTreeNode[2]);
	T data;
	boolean active;
	
	public BinaryTreeNodeI() {
		active=true;
	}
	public BinaryTreeNodeI(T data) {
		this.data=data;
		active=true;
	}
	public BinaryTreeNodeI(T data, BinaryTreeNode left,BinaryTreeNode right) {
		this.data=data;
		children[0]=left;
		children[1]=right;
		active=true;
	}

	@Override
	public T getData() {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public void setData(T data) {
		// TODO Auto-generated method stub
		this.data=data;

	}

	@Override
	public boolean hasLeftChild() {
		// TODO Auto-generated method stub
		return (children[0]!=null);
	}

	@Override
	public boolean hasRightChild() {
		// TODO Auto-generated method stub
		return (children[1]!=null);
	}

	@Override
	public BinaryTreeNode<T> getLeftChild() {
		// TODO Auto-generated method stub
		if(children[0]==null)
			throw new IllegalStateException();
		
			return children[0];
	}

	@Override
	public BinaryTreeNode<T> getRightChild() {
		// TODO Auto-generated method stub
		if(children[1]==null)
			throw new IllegalStateException();
		
		return children[1];
	}

	@Override
	public void setLeftChild(BinaryTreeNode<T> left) {
		// TODO Auto-generated method stub
		children[0]=left;
	}

	@Override
	public void setRightChild(BinaryTreeNode<T> right) {
		// TODO Auto-generated method stub
		children[2]=right;
	}
	
	public void Deactivate () {
		active=false;
	}
	
	public boolean active () {
		return this.active;
	}

}
