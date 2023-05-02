public class ListTestClient {

	public static void ListTest(List l) {

		System.out.println("LINKED LIST");
		
		System.out.println();

		//Is is Empty? (T/F) - true expected
		System.out.println("Is it Empty? (T/F): " +  l.isEmpty());
		
		System.out.println();

		l.addToTail("A");
		
		l.addToTail("L");
		
		l.addToTail("E");
		
		l.addToTail("X");
		

		//Test add at locations
		l.addAt(0,"|"); //Add to head index
		
		l.addAt(7,"|"); //Add to tail index
		
		l.addAt(-100,"BEGINNING"); //Add out of bound front
		
		l.addAt(100,"END");    //Add out of bound back

		l.printFwd(); //Expected: START | A L E X | END 
		
		System.out.println();

		l.printRev(); //Expected: END | X E L A | START 
		
		System.out.println();
		
		System.out.println();

		//Test getAt method
		//Expected: START | A L E X | END null
		for (int i = 0; i < 9; i++) {
			
			System.out.print(l.getAt(i) + " ");
			
		}
		
		System.out.println();
		
		System.out.println();
		

		//Test deletions
		l.deleteAt(7); //deletes value "END"
		
		l.deleteAt(0); //deletes value "START"
		
		l.printFwd(); //Expected: | A L E X |
		
		System.out.println();
		
		l.printRev(); //Expected: | X E L A |
		
		System.out.println();
		
		System.out.println();
		

		//Is it Empty? (T/F) - false expected
		System.out.println("Is it Empty? (T/F): " +  l.isEmpty());
		
		System.out.println();
		
		System.out.println();

		//Clear list and make sure it is empty
		System.out.println("No Output after this point. ");
		
		System.out.println();
		
		while (!l.isEmpty()) {
			
			l.deleteAt(0);
			
		}
		
		l.printFwd(); // No output expected
		
		System.out.println();
		
		l.printRev(); // No output expected
		
		System.out.println();
	}

}