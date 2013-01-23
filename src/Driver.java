import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;


public class Driver {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		char[][] keyboard_layout = {
				{'1','2','3','4','5','6','7','8','9','0'},
				{'q','w','e','r','t','y','u','i','o','p'},
				{'a','s','d','f','g','h','j','k','l',';'},
				{'z','x','c','v','b','n','m',',','.','/'}};
		
		Keyboard board = new Keyboard(keyboard_layout);
		
		
		IO io = new IO();
		
		String file1 = "file1.txt";
		String file2 = "file2.txt";
		ArrayList<String> transformations = io.getTransformations(file1);
		
		for(int i = 0; i < transformations.size(); i++) {
			String operation = transformations.get(i);
			if( operation.equals("H")) {
				board.horizontal_flip();
			}
			else if(operation.equals("V")) {
				board.vertical_flip();
			}
			else {
				int num = Integer.parseInt(operation);
				
				if(num < 0) {
					board.shift_left(Math.abs(num));
				}
				else {
					board.shift_right(num);
				}
			}
		}
		
		
		StringBuffer data = io.getData(file2);
		char[][] final_layout = board.getLayout();
		
		
		System.out.println("Initial keyboard layout is ");
		
		for(int i = 0;i < keyboard_layout.length;i++){
	         for(int j = 0;j < keyboard_layout[0].length;j++){  
	        	System.out.print(keyboard_layout[i][j]);                             
	         }
	         System.out.println();
	     }
		
		System.out.println("\nModified keyboard layout is ");
		
		for(int i = 0;i < final_layout.length;i++){
	         for(int j = 0;j < final_layout[0].length;j++){  
	        	System.out.print(final_layout[i][j]);                             
	         }
	         System.out.println();
	     }
		
		
		Hashtable<Character, Character> mapping = new Hashtable<Character, Character>();
		for(int i = 0; i < final_layout.length; i++) {
			for(int j = 0; j < final_layout[0].length; j++) {
				mapping.put(keyboard_layout[i][j],final_layout[i][j]);
			}
		}
		//System.out.println(mapping);
		StringBuffer result = new StringBuffer();
		for(int i = 0; i < data.length(); i++) {
			if(mapping.get(data.charAt(i)) == null)
				result.append(data.charAt(i));
			else 
				result.append(mapping.get(data.charAt(i)));
		}
		
		System.out.println("\nString after transformation is\n" + result);
	}

}
