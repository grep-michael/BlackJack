/**michael knudsen
 * 11/15/2017
**/
//package blackjack;

import java.util.Scanner;

public class Main{
	static boolean uuu = true;
	public static void main(String[] args) {
		// define objects
		Deck deck = new Deck();
		convert convert = new convert();
		//convert convert2 = new convert();
		
		// debug, print out players deck
		/**
		 * for (int i = 0; i <= 52 ; i++){ System.out.println(deck.getCard(i));
		 * }
		 */

		Scanner reader = new Scanner(System.in);
		// get player info
		System.out.println("What is the players name?");
		String name = reader.next();
		System.out.println("How much cash does the player have?");
		float cash = reader.nextFloat();
		player player = new player(name, cash);
		//set dealers money
		float aaaa = 10000.00f;
		dealer dealer = new dealer(aaaa);
		
		// get dealers and players deck
		while (uuu) {
			//System.out.println("start2");
			deck.shuffle();
			for (int i = 0; i < 2; i++) {
				player.addCard(deck.draw());
				dealer.addCard(deck.draw());
			}
			// debug code for making sure decks are working
			// System.out.println(person.deck);
			// System.out.println(dealer.deck);

			System.out.println("Your Deck is: ");
			for (int A : player.deck) {
				System.out.println(deck.getCard(A));
			}
			System.out.println("Your total is: ");
			// return player deck total
			for (int A : player.deck) {
				convert.convert(deck.getCard(A));

			}
			int playerTotal = convert.total();
			convert.setTotal(0);
			System.out.println(playerTotal);
			// return dealer deck total
			for (int A : dealer.deck) {
				convert.convert(deck.getCard(A));

			}
			int dealerTotal = convert.total();
			convert.setTotal(0);
			//players bet
			System.out.println("How much does the player wish to bet?");
			float gg = reader.nextFloat();
			player.bet(gg);
			boolean aylmao = true;

			while (aylmao) {
				
				//comments here are used for debugging
				
				// System.out.println("WhileLoopStart");
				System.out.println("Do you want to Stand, Hit, or Double down?");
				String a = reader.next();
				// debug string System.out.println(a.toLowerCase());
				if (a.toLowerCase().equals("stand")) {
					aylmao = false;
					// debug lines System.out.println("stand");

				} else if (a.toLowerCase().equals("hit")) {
					// debug lines System.out.println("hit");
					boolean lmao = true;
					while (lmao) {
						player.addCard(deck.draw());
						System.out.println("You Drew a : " + deck.getCard(player.deck.get(player.deck.size() - 1))); // .get(stringArray.size()
																														// -
																														// 1)
						System.out.println("Your New total is total is: ");
						// return player deck total
						// System.out.println(deck.getCard(
						// player.deck.get(player.deck.size() -1)));
						convert.convert(deck.getCard(player.deck.get(player.deck.size() - 1)));
						System.out.println(playerTotal);
						if (playerTotal == 21) {
							// System.out.println("Your hand now equals 21! You
							// Win");
							lmao = false;
							aylmao = false;
						} else if (playerTotal > 21) {
							lmao = false;
							aylmao = false;
							break;
						} else {
							System.out.println("Do you want to hit again? ");
							a = reader.nextLine();
							if (a.toLowerCase().equals("yes")) {
								lmao = true;
								aylmao = true;

							} else {
								lmao = false;
								aylmao = false;
							}
						}
					} // while end
				} else if (a.toLowerCase().equals("double")) {
					// debug string System.out.println("double");
					player.addCard(deck.draw());
					System.out.println("You Drew a : " + deck.getCard(player.deck.get(player.deck.size() - 1))); // .get(stringArray.size()
																													// -
																													// 1)
					System.out.println("Your New total is total is: ");
					// return player deck total
					// System.out.println(deck.getCard(
					// player.deck.get(player.deck.size() -1)));
					convert.convert(deck.getCard(player.deck.get(player.deck.size() - 1)));
					System.out.println(playerTotal);
					aylmao = false;

				} else {

					aylmao = false;

				}

				// System.out.println("WhileLoopEnd");
			} // while loop end
				// debug string
			//System.out.println("end");

			if (playerTotal == 21) {
				System.out.print("You win with a hand of " + playerTotal + "\n");
				System.out.print("The dealer loses with a hand of " + dealerTotal + "\n");
				System.out.print("You won " + player.getBet() + "\n");
				player.setMoney(player.getMoney() + player.getBet());
				System.out.println("Play again? (yes/no)");
				if (reader.next().toLowerCase().equals("yes")) {
					//System.out.println("yes");
					uuu = true;
					player.deck.clear();
					dealer.deck.clear();
					playerTotal =0;
					dealerTotal =0;
				} else {
					uuu = false;
				}
			
			}else if (playerTotal > 21) {
				System.out.print("You lose with a hand of " + playerTotal + "\n");
				System.out.print("The dealer Wins with a hand of " + dealerTotal + "\n");

				player.setMoney(player.getMoney() - player.getBet());
				System.out.println("Play again? (yes/no)");
				if (reader.next().toLowerCase().equals("yes")) {
					//System.out.println("yes");
					uuu = true;
					player.deck.clear();
					dealer.deck.clear();
					playerTotal =0;
					dealerTotal =0;
				} else {
					uuu = false;
				}
			} else if (dealerTotal > playerTotal && dealerTotal <= 21) {
				System.out.print("You lose with a hand of " + playerTotal + "\n");
				System.out.print("The dealer Wins with a hand of " + dealerTotal + "\n");

				player.setMoney(player.getMoney() - player.getBet());
				System.out.println("Play again? (yes/no)");
				if (reader.next().toLowerCase().equals("yes")) {
					//System.out.println("yes");
					uuu = true;
					player.deck.clear();
					dealer.deck.clear();
					playerTotal =0;
					dealerTotal =0;
				} else {
					player.deck.clear();
					dealer.deck.clear();
					playerTotal =0;
					dealerTotal =0;
					uuu = false;
					aylmao = false;
				}
			} else {
				System.out.print("You win with a hand of " + playerTotal + "\n");
				System.out.print("The dealer loses with a hand of " + dealerTotal + "\n");

				player.setMoney(player.getMoney() + player.getBet());
				System.out.println("Play again? (yes/no)");
				if (reader.next().toLowerCase().equals("yes")) {
					//System.out.println("yes");
					uuu = true;
					player.deck.clear();
					dealer.deck.clear();
					playerTotal =0;
					dealerTotal =0;
				} else {
					player.deck.clear();
					dealer.deck.clear();
					playerTotal =0;
					dealerTotal =0;
					uuu = false;
					aylmao = false;
				
			}

		}
		}

		// System.out.print(player.getMoney());
		//System.out.println("end2");
	}// main
}// class

/**copied from google 
 * 
 * Stand – If the player is happy with the total they’ve been dealt they can
 * stand, taking no further action and passing to the next player. The player
 * can take this action after any of the other player actions as long as their
 * hand total is not more than 21. The hand signal to Stand is waving a flat
 * hand over the cards.
 * 
 * Hit – If the player wishes to take another card they signal to the dealer to
 * by scratching the felt beside their hand or pointing to their hand. A single
 * card is then played face up onto their hand. If the hand total is less than
 * 21 the player can choose to Hit again or Stand. If the total is 21 the hand
 * automatically stands. If the total is over 21 the hand is bust, the player’s
 * bet is taken by the house and the turn to act passes to the next player.
 * 
 * Double Down – If the player considers they have a favourable hand, generally
 * a total of 9, 10 or 11, they can choose to 'Double Down'. To do this they
 * place a second wager equal to their first beside their first wager. A player
 * who doubles down receives exactly one more card face up and is then forced to
 * stand regardless of the total. This option is only available on the player's
 * two-card starting hand. Some casinos will restrict which starting hand totals
 * can be doubled.
 **/
