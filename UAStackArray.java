/***********************************
Due Date:		April 3rd, 2020
***********************************/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UAStackArray {
	private int capacity;
	private UAStudent top;
	private int topIndex;
	private UAStudent[] array;
	
	
	UAStackArray(int size) {
		capacity = size; 
		array = new UAStudent[capacity];
		
		this.topIndex = 0;
		this.top = null;
	}
	
	public void push(UAStudent s) {
		if(s != null) {
			if(size() == capacity) {
				System.out.println("Stack is full. Resizing...");
				resize();
			} else if(top == null) {
				array[topIndex] = s;
				top = array[topIndex];
			} else {
				array[++topIndex] = s;
				top = array[topIndex];
			}
		}
	}
	
	public UAStudent pop() {
		UAStudent temp = top;
		if(isStackEmpty()) {
			System.out.println("Stack is empty");
		} else {
			top = array[--topIndex];
		}
		return temp;
	}
	
	public int size() {
		if(isStackEmpty()) {
			return 0;
		} else {
			return topIndex + 1;
		}
	}
	
	public boolean isStackEmpty() {
		if(top == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void resize() {
		UAStudent[] stResize = new UAStudent[(int)(capacity * 1.5)];
		
		for(int i = 0; i < array.length; i++) {
			stResize[i] = array[i];
			array = stResize;
		}
	}

	public static class UAStudent {
		
		private int studentId;
		private String firstName;
		private String lastName;
		
		public UAStudent(String input) {
			String[] tokens = input.split( "," );
			
			this.studentId = Integer.parseInt(tokens[2]);
			this.firstName = tokens[1];
			this.lastName = tokens[0];
		}
		
		
		public UAStudent(int id, String fName, String lName) {
			this.studentId = id;
			this.firstName = fName;
			this.lastName = lName;
			
		}

		public int getStudentId() {
			return studentId;
		}

		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		public String toString() {
			return "Student: \t" + lastName + ", " + firstName;
		}
		
	}
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {

		UAStackArray st = new UAStackArray(100);

		//...insert code to read records.txt and load into your stack
		
		String line;
		String file = "records.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		while ( (line = br.readLine()) != null) {
			
			UAStudent stu = new UAStudent(line);
			
			st.push(stu);
			
		}
		
		br.close();
		
		System.out.println("=== Start ==============================");
		System.out.println("Size of Stack:  " + st.size() );
		
		System.out.println("\n\n");
		System.out.println("=== Inserts ==============================");

		UAStudent a = new UAStudent("Mackey,Andrew,44444");
		st.push( a );	
		st.push( new UAStudent("Mackey,Andrew,55555") );
		st.push( new UAStudent("Mackey,Andrew,99999") );
		
		System.out.println("Size of Stack:  " + st.size() );
		
		System.out.println("\n\n");
		System.out.println("=== Deletes ==============================");	
		System.out.println(st.pop());
		System.out.println(st.pop());
		
		System.out.println("Size of Stack:  " + st.size() );
		
		System.out.println(st.pop());
		
		System.out.println("Size of Stack:  " + st.size() );
		
	}
	
}
