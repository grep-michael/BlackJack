/**michael knudsen
 * 11/15/2017
**/
//package blackjack;

import java.util.Scanner;

public class Main{
	static boolean GameRun = true;
	public static void main(String[] args) {
		// define objects
		Deck deck = new Deck();
		convert convert = new convert();


		Scanner reader = new Scanner(System.in);
		// get player info
		System.out.println("What is the players name?");
		String name = reader.next();
		System.out.println("How much cash does the player have?");
		float cash = reader.nextFloat();
		player player = new player(name, cash);
		
		//set dealers money
		float dealerCash = 10000.00f;
		dealer dealer = new dealer(dealerCash);
		
		//Begin Game
		while (GameRun) {

			//shuffle deck
			deck.shuffle();
			for (int i = 0; i < 2; i++) {
				player.addCard(deck.draw());
				dealer.addCard(deck.draw());
			}
			//return players deck and value
			System.out.println("Your Deck is: ");
			for (int A : player.deck) {
				System.out.println(deck.getCard(A));
			}
			for (int A : player.deck) {
				convert.convert(deck.getCard(A));
			}

			int playerTotal = convert.getTotal();
			convert.setTotal(0);
			System.out.println("Your total is : " +playerTotal);
			
			
			// return dealer deck total
			for (int A : dealer.deck) {
				convert.convert(deck.getCard(A));

			}
			int dealerTotal = convert.getTotal();
			convert.setTotal(0);
			
			//get players bet as float
			System.out.println("How much does the player wish to bet?");
			float gg = reader.nextFloat();
			player.bet(gg);
			boolean RoundRun = true;

			while (RoundRun) {
				
				//comments here are used for debugging
				
				// System.out.println("WhileLoopStart");
				System.out.println("Do you want to Stand, Hit, or Double down?");
				String a = reader.next();
				if (a.toLowerCase().equals("stand")) {
					RoundRun = false;


				} else if (a.toLowerCase().equals("hit")) {
					//when a player hits they get another card
					//they can hit as many times as they want
					boolean hitBool = true;
					while (hitBool) {

						int card = deck.draw();

						player.addCard(card);
						convert.convert(deck.getCard(card));
						playerTotal += convert.getTotal();
						convert.total = 0;
						System.out.println("You Drew a : " + deck.getCard(card));	
						System.out.println("Your New total is total is: "+ playerTotal);
						if (playerTotal >= 21) {
							//if total is 21 player wins, round ends
							//if total is over 21 player loses, round ends
							hitBool = false;
							RoundRun = false;				
						} else {
							//if players total < 21 player can hit again
							System.out.println("Do you want to hit again? yes/no : ");
							a = reader.next();
							if (a.toLowerCase().equals("yes")) {
								hitBool = true;
								RoundRun = true;

							} else {
								hitBool = false;
								RoundRun = false;
							}
						}
					} // End of hit while loop

				} else if (a.toLowerCase().equals("double")) {
					
					//double case
					int card = deck.draw();

					player.addCard(card);
					convert.convert(deck.getCard(card));
					playerTotal += convert.getTotal();
					convert.total = 0;
					player.addCard(card);
					System.out.println("You Drew a : " + deck.getCard(card));																				
					System.out.println("Your New total is total is: " + playerTotal);
					RoundRun = false;
				} else {

					RoundRun = false;

				}

			} // end of round
			
			//calculate outcome of round

			if (playerTotal == 21) {
				//if player has a total of 21 you they win

				System.out.print("You win with a hand of " + playerTotal + "\n");
				System.out.print("The dealer loses with a hand of " + dealerTotal + "\n");
				System.out.print("You won " + player.getBet() + "\n");
				player.setMoney(player.getMoney() + player.getBet());
			
			}else if (playerTotal > 21) {
				//if player has more than 21 house winds by default
				System.out.print("You lose with a hand of " + playerTotal + "\n");
				player.setMoney(player.getMoney() - player.getBet());
			} else if (dealerTotal > playerTotal && dealerTotal <= 21) {
				//if dealer is closer to 21 than player is, dealer wins

				System.out.print("You lose with a hand of " + playerTotal + "\n");
				System.out.print("The dealer Wins with a hand of " + dealerTotal + "\n");

				player.setMoney(player.getMoney() - player.getBet());
			
			} else {
				//remaining condition: if player is closer to 21
				System.out.print("You win with a hand of " + playerTotal + "\n");
				System.out.print("The dealer loses with a hand of " + dealerTotal + "\n");
				player.setMoney(player.getMoney() + player.getBet());
			}
			
			System.out.println("Play again? (yes/no)");
			if (reader.next().toLowerCase().equals("yes")) {
				GameRun = true;
				player.deck.clear();
				dealer.deck.clear();
				playerTotal =0;
				dealerTotal =0;
			} else {
				player.deck.clear();
				dealer.deck.clear();
				playerTotal =0;
				dealerTotal =0;
				GameRun = false;
				RoundRun = false;
			}		
		}
	}// main
}// class
