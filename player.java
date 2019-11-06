/**michael knudsen
 * 11/15/2017
**/
//package blackjack;
import java.util.ArrayList;
public class player {
	  private String name;
	  private float cash;
	  private float bet;
	  static ArrayList<Integer> deck = new ArrayList<Integer>();
	  //defines characteristcs of player
	  public player(final String name, final float cash) {
		  this.name = name;
	      this.cash = cash;
	  }
	  //set the players bet
	  public void bet(float bet){
		this.bet = bet;
	  }
	  //methods for returning player values
	  public String getName() { return this.name; }
	  public float getMoney() { return this.cash; }
	  public float getBet()   { return this.bet;  }
	  public void addCard(int a){
			deck.add(a);
		}
	  public void setMoney(float a){
		  this.cash = a;
	  }
	
	
}
