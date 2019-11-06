/**Mr. William
 * 5/11/2015
**/

//package blackjack;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class Deck {
	
	private int[] deck = new int[53];
	private int type = 0;
	private int num = 1;
	private int card = 0;
	private int cardNum =0;
	
	public Deck(){
		
		for(int i = 0; i<deck.length; i++){
			
			if(i == 13){ type++; num =0;}
			
			deck[i]= type * 13 + num;
			
			num ++;	
			
			
		}
		
	}
	
	
	public void shuffle(){
		Random rnd =ThreadLocalRandom.current();
		
		for(int i = deck.length -1; i > 0; i--){
			
			int index = rnd.nextInt(i+1);
			
			int x = deck[index];
			deck[index] = deck[i];
			
			deck[i] = x;
		}
		
		
	}
	public int draw(){
	
	 
	card = deck[cardNum];
	
		cardNum++;
		
		
		return card;
	}
	
	
	
	public void getDeck(){
		
		for(int i =0 ; i<deck.length; i++){
			
			System.out.println(deck[i]);
		}
		
	}
	
	public String getCard(int card){
		String suit= null;
		String rank = null;
		String rankSuit = null;
		
		if(card> 0 && card <= 13){
			
			suit= "Clubs";
		}
		if(card> 13 && card <= 26){
			
			suit= "Spades";
		}
		if(card> 26 && card <= 39){
			
			suit= "Diamonds";
		}
		if(card> 39 && card <= 52){
			
			suit= "Hearts";
		}
		
		if(card == 1 || card == 14 || card == 27 || card == 40){
			
			rank = "Ace";
		}else if(card == 11 || card == 24 || card == 37 || card == 50){
			
			rank = "Jack";
		}else if(card == 12 || card == 25 || card == 38 || card == 51){
			
			rank = "Queen";
		}else if(card == 13 || card == 26 || card == 39 || card == 52){
			
			rank = "King";
		}else if(card <= 10){
			
			rank = Integer.toString(card);
		}else if(card > 13 && card <=23){
			
			card = card -13;
			rank = Integer.toString(card);
		}else if(card > 26 && card <= 36){
			
			card = card -26;
			rank = Integer.toString(card);
			
		}else if(card > 39 && card <= 49){
			
			card = card -39;
			rank = Integer.toString(card);
		}
		
		rankSuit = rank + " of " + suit;
		
		return rankSuit;	
		
		
	}

}
