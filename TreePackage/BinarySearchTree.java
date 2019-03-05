package TreePackage;

public class BinarySearchTree implements BinaryTreeInterface{
	private BinaryNode root;
	
	public BinarySearchTree(){
		root = null;
	}
	public BinarySearchTree(String wd){
		root = new BinaryNode(wd);
	}
	public BinarySearchTree(String wd, BinarySearchTree lt, BinarySearchTree rt){
		privateSetTree(wd,lt,rt);
	}
	
	public BinaryNode getRoot() {
		return root;
	}
	public void setRoot(BinaryNode node) {
		root = node;
	}
	
	
	public void setTree(String wd) {
		root = new BinaryNode(wd);
	}
	public void setTree(String wd, BinarySearchTree lt, BinarySearchTree rt) {
		privateSetTree(wd, lt, rt);
	}
	private void privateSetTree(String wd, BinarySearchTree lt, BinarySearchTree rt){
		root = new BinaryNode(wd,lt.getRoot(),rt.getRoot());
		if(lt != null) 
			root.setLeft(lt.getRoot());	
		if(rt != null)
			root.setRight(rt.getRoot());
	}
	
	public void insert(String wd) {
		if(this.getRoot() == null) {
			BinaryNode temp = new BinaryNode(wd);
			this.setRoot(temp);
		}
		else
			this.insert(getRoot(),wd);
	}
	
	 private void insert(BinaryNode node, String wd) {
		    if (node.getWord().compareToIgnoreCase(wd) > 0)
		    {
		        if (node.getLeft() != null)
		            insert(node.getLeft(), wd);
		        else
		            node.setLeft(new BinaryNode(wd));
		    } 
		    else if (node.getWord().compareToIgnoreCase(wd) < 0)
		    {
		        if (node.getRight() != null)
		            insert(node.getRight(), wd);
		        else
		            node.setRight(new BinaryNode(wd));
		    }
		    else //word already exists
		    		node.incCount();
	 }
		
	public BinaryNode search(BinaryNode node, String wd) { //search word
		if(node == null || node.getWord().compareTo(wd) == 0) //tree is empty or word found
			return node;
		else if(node.getWord().compareTo(wd) < 0)
			search(node.getLeft(),wd);//recur down left
		else //if (node.getWord().compareTo(wd) > 0)
			search(node.getRight(),wd);//recur down right
		return node;//not found
				
	}
	
	
}	
