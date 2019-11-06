/**michael knudsen	
 * 11/15/2017
**/
//package blackjack;
import java.util.ArrayList;
public class dealer {
	static ArrayList<Integer> deck = new ArrayList<Integer>();
	//defines money for dealer
	private float cash;
	public dealer( final float cash) {
		this.cash = cash;
		}
	public float getMoney() { return this.cash; }
	public void addCard(int a){
		deck.add(a);
	}
	
}
