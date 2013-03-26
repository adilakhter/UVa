import org.junit.Test;
import static org.junit.Assert.*;

class TreeNode{
	public int value; 
	public TreeNode left;  // points to the left subtree 
	public TreeNode right; // points to the right subtree
	
	public TreeNode ( int value, TreeNode left, TreeNode right){
		this.value = value; 
		this.left = left;
		this.right = right;
	}
	
	public static TreeNode newTreeNode (int value, TreeNode left, TreeNode right) {return new TreeNode(value, left, right);}
	
	public static TreeNode newTreeNode ( int value){ return newTreeNode(value, null, null);}
	
}
public class TreeBoundary {
	
	public static TreeNode constructTree() {
		/*
               20
           ____|_____
           8		22
        ___|___   ___|___
		4     12        25
		    ___|__   
		   10    14
		
		*/
	
		TreeNode root = TreeNode.newTreeNode(20);
		root.left =  TreeNode.newTreeNode(8);
		root.left.left = TreeNode.newTreeNode(4);
		root.left.right = TreeNode.newTreeNode(12);
		root.left.right.left = TreeNode.newTreeNode(10);
		root.left.right.right = TreeNode.newTreeNode(14);
		root.right = TreeNode.newTreeNode(22);
		root.right.right = TreeNode.newTreeNode(25);
	
		return root;
	
	}
	
	public static void PrintBoundaryRightSubtree(TreeNode node){
		
		if (node == null)
			return ; 
		
		
		if ( node.right!=null){
			PrintBoundaryRightSubtree(node.right);
			printNode(node);
		}
		else if ( node.left != null){
			
			PrintBoundaryRightSubtree(node.left);
			printNode(node);
		}
		
	} 

	
	public static void PrintLeftNodes(TreeNode node){
		
		if (node == null)
			return ;
		
		if (node.left != null){
			printNode(node);
			PrintLeftNodes(node.left);
		}
		else if ( node.right != null){
			// in case there is no left node. Then the right node will be considered 
			// as the boundary node.
			printNode(node);
			PrintLeftNodes(node.right);
		}
	}
	
	public static void PrintLeaves (TreeNode node){
		
		if (node != null){
			
			PrintLeaves ( node.left);
			
			if ( (node.left== null) && (node.right == null)){
				printNode(node); 
			}
			
			PrintLeaves(node.right);
		}
	}
	
	public static void TraverseInorder(TreeNode node){
		
		// base condition 
		if ( node == null)
			return;
		
		TraverseInorder(node.left);     // traversing left tree 
		System.out.print(node.value + " "); // traversing value 
		TraverseInorder(node.right);    // traversing right tree 
	}
	
	private  static void printNode(TreeNode node){
		System.out.print(node.value + " "); // traversing value
	} 
	
	@Test
	public void testTreeLeftNodes(){
		
		PrintLeftNodes(constructTree());
	}
	
	@Test
	public void testTreeInOrderTraversal() {
		TraverseInorder(constructTree());
	}
	
	@Test
	public void testPrintLeaves() {
		PrintLeaves(constructTree());
	}

	
	@Test public void testPrintBoundaryNodes(){
		
		TreeNode root = constructTree();
		System.out.println();
		PrintLeftNodes(root);
		System.out.print(" | ");
		PrintLeaves(root);
		System.out.print(" | " );
		PrintBoundaryRightSubtree(root);
	}
	
}
