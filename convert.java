/**michael knudsen
 * 11/15/2017
**/

//this class returns the value of your deck
//all print statments are used for debugging
//package blackjack;

public class convert {
	public int BB = 0;
	public void setTotal(int a){
		this.BB = a;
	}
	
	public void convert(String A){
		String[] B = A.split(" ");
		
		//System.out.println("|"+B[0]+"|");
		
		if (B[0].equals("1")){
			//System.out.println(BB);
			BB += + 1;
		
		}else if (B[0].equals("2")){
			//System.out.println(BB);
			BB += + 2;
		
		}else if (B[0].equals("3")){
			//System.out.println(BB);
			BB += + 3;		
		
		}else if (B[0].equals("4")){
			//System.out.println(BB);
			BB += + 4;
		
		}else if (B[0].equals("5")){
			//System.out.println(BB);
			BB += + 5;
		
		}else if (B[0].equals("6")){
			//System.out.println(BB);
			BB += + 6;
		
		}else if (B[0].equals("7")){
			//System.out.println(BB);
			BB += + 7;
		
		}else if (B[0].equals("8")){
			//System.out.println(BB);
			BB += + 8;
		
		}else if (B[0].equals("9")){
			//System.out.println(BB);
			BB += 9;
		
		}else if (B[0].equals("10")){
			//System.out.println(BB);
			BB += + 10;
		
		}else if (B[0].equals("Jack")){
			//System.out.println(BB);
			BB += + 10;
		
		}else if (B[0].equals("King")){
			//System.out.println(BB);
			BB += + 10;
		
		}else if (B[0].equals("Queen")){
			//System.out.println(BB);
			BB += + 10;
		
		}else{
			BB += + 11;
		}
		//System.out.println("BB = "+ BB);
		
			
	}
	public int total(){
		return BB;
	}
	
}
/** list of cards
 * Ace of Clubs
2 of Clubs
3 of Clubs
4 of Clubs
5 of Clubs
6 of Clubs
7 of Clubs
8 of Clubs
9 of Clubs
10 of Clubs
Jack of Clubs
Queen of Clubs
King of Clubs
Ace of Spades
2 of Spades
3 of Spades
4 of Spades
5 of Spades
6 of Spades
7 of Spades
8 of Spades
9 of Spades
10 of Spades
Jack of Spades
Queen of Spades
King of Spades
Ace of Diamonds
2 of Diamonds
3 of Diamonds
4 of Diamonds
5 of Diamonds
6 of Diamonds
7 of Diamonds
8 of Diamonds
9 of Diamonds
10 of Diamonds
Jack of Diamonds
Queen of Diamonds
King of Diamonds
Ace of Hearts
2 of Hearts
3 of Hearts
4 of Hearts
5 of Hearts
6 of Hearts
7 of Hearts
8 of Hearts
9 of Hearts
10 of Hearts
Jack of Hearts
Queen of Hearts
King of Hearts*/
