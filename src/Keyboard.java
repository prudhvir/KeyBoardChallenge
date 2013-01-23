
public class Keyboard {

	private char[][] layout;
	public Keyboard(char in[][]) {
		this.layout = new char[in.length][in[0].length];
		setLayout(in);
	}
	public char[][] getLayout() {
		return layout;
	}
	public void setLayout(char[][] layout1) {
		for(int i = 0;i < layout1.length;i++){
	         for(int j = 0;j < layout1[0].length;j++){  
	        	 this.layout[i][j] = layout1[i][j]; 
	         }
	     }
	}
	
	public void horizontal_flip() {
		char[][] in = getLayout();
		for(int row = 0; row < layout.length; row++) {
			h_flip(in[row]);
		}
		setLayout(in);
		/*for(int i = 0;i < in.length;i++){
	         for(int j = 0;j < in[0].length;j++){  
	        	System.out.print(in[i][j]);                             
	         }
	         System.out.println();
	     }*/
	}
	
	
	
	private void h_flip(char[] row) {
		int length = row.length;
		for(int index = 0; index < length/2; index++) {
			char temp = row[index];
			row[index] = row[length - 1 - index];
			row[length - 1 - index] = temp;
		}
	}
	
	public void vertical_flip() {
		char[][] in = getLayout();
		int length = in.length;
		for(int index = 0; index < length/2; index++) {
			char[] temp = in[index];
			
			/*for(int i = 0; i < temp.length; i++) {
				
			}*/
			in[index] = in[length - 1 - index];
			in[length - 1 - index] = temp;
		}
		
		setLayout(in);
		/*for(int i = 0;i < in.length;i++){
	         for(int j = 0;j < in[0].length;j++){  
	        	System.out.print(in[i][j]);                             
	         }
	         System.out.println();
	     }*/
	}
	
	
	public void shift_right(int num) {
		char[][] in = getLayout();
		int row = in.length;
		int col = in[0].length;
		//System.out.println(row + " " + col);
		char[][] final_layout = new char[row][col];
	     for(int i = 0;i < in.length;i++){
	         for(int j = 0;j < in[0].length;j++){  
	        	 //System.out.println(((i+ ((j+num)/col))  % row) + " " + ((j+num) % col)  );
	        	 final_layout[  (i+ ((j+num)/col))  % row][(j+num) % col] = in[i][j];                             
	         }
	     }
	     setLayout(final_layout);
	}
	
	
	public void shift_left(int num) {
		 char[][] in = getLayout();
			int row = in.length;
			int col = in[0].length;
			char[][] final_layout = new char[row][col];
		     for(int i = 0;i < in.length;i++){
		         for(int j = 0;j < in[0].length;j++){              
		        	 final_layout[ (row+(i+((j-col-num+1)/col)))%row ][(col + ((j-num)%col))%col] = in[i][j];                             
		         }
		     }
	     setLayout(final_layout);
	}
}
