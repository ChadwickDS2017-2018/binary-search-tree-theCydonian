package config;

import structures.BinarySearchTree;
import structures.BinarySearchTreeI;
import structures.BinaryTreeNode;
import structures.BinaryTreeNodeI;
import structures.BinaryTreeUtility;
import structures.BinaryTreeUtilityI;


/**
 * This class acts as a configuration file which tells the testing framework
 * which implementation you want us to use when we grade your assignment.
 * 
 * @author jddevaug
 * 
 */
public class Configuration {

	
	public static final String STUDENT_ID_NUMBER = "12345678";
	

	public static <T> BinaryTreeNode<T> createBinaryTreeNode(BinaryTreeNode<T> left, T elem, BinaryTreeNode<T> right){
		return new BinaryTreeNodeI(elem, left, right);
	}
	
	public static BinaryTreeUtility createBinaryTreeUtility(){
		return new BinaryTreeUtilityI();
	}
	
	public static <T extends Comparable<? super T>> BinarySearchTree<T> createBinarySearchTree(){
		return new BinarySearchTreeI<T>();
	}
	

}
