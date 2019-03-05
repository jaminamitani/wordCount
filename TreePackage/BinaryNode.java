package TreePackage;

public class BinaryNode implements BinaryNodeInterface{
	private String word;
	private int count;
	private BinaryNode left;
	private BinaryNode right;
	
	BinaryNode(){
		word = "";
		count = 0;
		left = null;
		right = null;
	}
	BinaryNode(String wd){
		word = wd;
		count = 1;
		left = null;
		right = null;
	}
	BinaryNode(String wd, BinaryNode lt, BinaryNode rt){
		word = wd;
		count = 1;
		left = lt;
		right = rt;
	}
	
	
	public String getWord() {
		return word;
	}
	public int getCount() {
		return count;
	}
	
	public void setWord(String wd) {
		word = wd;
	}
	
	public void incCount() {
		++count;
	}
	
    public void setLeft(BinaryNode Node) {
    		left = Node;
    }
    public BinaryNode getLeft() {
    		return left;
    }
    public void setRight(BinaryNode Node) {
    		right = Node;
    }
    public BinaryNode getRight() {
    		return right;
    }

}
