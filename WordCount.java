import TreePackage.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class WordCount{
	Scanner input = new Scanner(System.in); 
	private static String filePath;
	BinarySearchTree tree = new BinarySearchTree();
	
	
	
	WordCount() throws IOException{
		System.out.println("Please input file name: ");
		filePath  = input.next();
		createTree(filePath);
	}
	
	WordCount(String fp) throws IOException{
		filePath  = fp;
		createTree(filePath);
	}
	
	public void createTree(String fileName) throws IOException{
        try {
    			String line;
    			String words[];
    			FileReader fileReader = new FileReader(fileName); 
    			BufferedReader bufferedReader = new BufferedReader(fileReader);
    			while((line = bufferedReader.readLine()) != null) { //read in each line
    				words = line.split(" "); //split line by words
    				for(int i = 0; i < words.length;i++) {
    					System.out.println(words[i]);
    					tree.insert(words[i]); //add each words
    				}
    			}
    	        bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
            System.out.println("Please Input another file name: ");
            filePath = input.next();
            createTree(filePath);
        }
	}
	
	
	public void display() {
		if(tree.getRoot() != null) 
			displayInOrder(tree.getRoot());
		else 
			System.out.println("Nothing to Display");
	}
	
	private void displayInOrder(BinaryNode root) {
		if(root != null) {
			displayInOrder(root.getLeft());
			System.out.println(root.getWord() + ": " + root.getCount() + " times.");
			displayInOrder(root.getRight());	
		}
	}


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WordCount wc;
		try {
			wc = new WordCount(args[0]);
		}catch(ArrayIndexOutOfBoundsException ex) {
			wc = new WordCount();
		}
		wc.display();
	}



}		

