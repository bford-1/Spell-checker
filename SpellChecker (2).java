import java.io.*;
import java.util.Scanner;
public class SpellChecker{
	public static void main(String[] args){	
		LList i = new LList();
		BinarySearchTree BST = new BinarySearchTree();
		try{
			FileInputStream f = null;
			Scanner out = new Scanner(System.in);
			Scanner in = null;
			f = new FileInputStream(args[0]);
			in = new Scanner(f);
			while(in.hasNext() == true){
				BST.insert(in.next());
			
			}
			System.out.println("Loaded the words into a tree with height = " + BST.printHeight());
			boolean yo = false;
			while (yo == false){
				String words = out.next();
				if (words.equals("END")){
					yo = true;
				}
				else{
					int s = 0;
					int con = words.length();
					String word = "";
					String[] wordlist = words.split(" ");
					int c = wordlist.length;
					while (s < c){
						if (BST.search(wordlist[s]) == null){
							System.out.println(wordlist[s] + " is spelled wrong!");
							s = s + 1;
						}
						else if (BST.search(wordlist[s]) != null){
							s = s + 1;
						}
					}
				}
			}
		}
		catch(FileNotFoundException e){
			System.out.println("invalid");
			
		}
	}

}
