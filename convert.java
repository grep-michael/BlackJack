/**michael knudsen
 * 11/15/2017
**/

//this class returns the value of your deck
//all print statments are used for debugging
//package blackjack;

public class convert {
	public int total = 0;
	public void setTotal(int a){
		this.total = a;
	}
	
	public void convert(String A){
		String B = A.split(" ")[0];//return first word or number of cards names
		
		try{
			//try to get the integer value of a string and add it to total
	    	total += Integer.parseInt(B);
	    }catch (NumberFormatException e){
	    	//if first word isnt a number add it to 

	    	if(B.equals("Ace")){
	    		total += 11;
	    	}else{
	    		//jack, king, queen are all worth 10 points
	    		total += 10;
	    	}
	    }
		
	}
	public int getTotal(){
		return total;
	}
	
}
