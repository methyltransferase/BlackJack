import java.util.Scanner;

/**
 * The Game21 class creates a game of BlackJack between the computer and the player 
 * and keeps a running total of the number of hands won by each.
 * 
 * @author Lily Naoudom
 * @version 8-5-2015
 *
 */
public class Game21 {
	
	public static void main (String [] args) {
	
	Scanner input = new Scanner(System.in);				//create a Scanner object
	
	Deck d1 = new Deck();								//create a Deck object
	
	int STAND_VALUE = 17;								//declare reference variable for dealer's stand value
	int DHV = 0;										//holds data for the dealer's current hand value
	int PHV = 0;										//holds data for the player's current hand value
	int FHV_dealer = 0;									//holds data for the dealer's final hand value after standing
	int FHV_player = 0;									//holds data for the player's final hand value after standing
	char deal = 'd';									//holds data for whether the player decides to deal another card
	char again = 'a';									//holds data for whether the player decides to play another hand
	int numWins_dealer = 0;								//holds data for the number of hands won by the dealer
	int numWins_player = 0;								//holds data for the number of hands won by the player
	
	Card c1, c2, c3, p1, p2, p3;						//declare Card objects for the dealer's cards (c1,c2,c3) and player's cards (p1,p2,p3)
	
	System.out.println("LET'S PLAY BACKJACK!");
	System.out.println(" ");
	
	while (again == 'a'){								//while loop for the player to play another hand

	d1.shuffle();										//shuffle the deck of cards
	
	System.out.println("=======DEALER=======");
	c1 = d1.getTopCard();								//deal and print two cards for the computer (dealer)
	c2 = d1.getTopCard();
	System.out.println(c1);
	System.out.println(c2);
	
	DHV = c1.getValue() + c2.getValue();				//calculate the dealer's current hand value
	
	//determine value of Ace card
	if (DHV < 12 && c1.getFace() == "Ace")				//Ace can have value of 1 or 11 depending on the hand value
	{
		DHV = 11 + c2.getValue();
	}
	else if (DHV < 12 && c2.getFace() == "Ace")
	{
		DHV = 11 + c1.getValue();
	}
		
	System.out.println("HAND VALUE: " + DHV);			//print the dealer's current hand value
	
	//hit 21 first try
	if (DHV == 21)
	{
		System.out.println("BLACKJACK!");				//print "BLACKJACK" if dealer gets 21 
	}
	System.out.println(" ");
	
	System.out.println("======PLAYER 1====== ");
	p1 = d1.getTopCard();								//deal and print two cards for the player
	p2 = d1.getTopCard();
	System.out.println(p1);
	System.out.println(p2);
	
	PHV = p1.getValue() + p2.getValue();				//calculate the player's current hand value
	
	//determine value of Ace card
	if (PHV < 12 && p1.getFace() == "Ace")				//Ace can have value of 1 or 11 
	{
		PHV = 11 + p2.getValue();
	}
	else if (PHV < 12 && p2.getFace() == "Ace")
	{
		PHV = 11 + p1.getValue();
	}
	
	System.out.println("HAND VALUE: " + PHV);			//print the player's current hand value
	
	//hit 21 first try					
	if (PHV == 21)			
	{
		System.out.println("BLACKJACK!");				//print "BLACKJACK" if dealer gets 21 
	}
	System.out.println(" ");
	
	System.out.print("Press d to deal another card, or any other key to stand. ");		//allow user to deal another card
	deal = input.next().charAt(0);
	input.nextLine(); 
	
	while (deal == 'd' && PHV < 21)						//while the player's current hand value is still less than 21,
	{													//the player can continue to deal another card if they choose
		p3 = d1.getTopCard();				
		System.out.println(p3);
		PHV = PHV + p3.getValue();						//update player's hand value after a new card is dealt
		
		//determine value of Ace card
		if (PHV < 12 && p3.getFace() == "Ace")
		{
			PHV = 11 + p2.getValue() + p1.getValue();
		}
		
		System.out.println("NEW HAND VALUE: " + PHV);	//print player's updated hand value 
		FHV_player = PHV;
		
		if (PHV < 21)
		{
			System.out.print("Press d to deal another card, or any other key to stand. ");
			deal = input.next().charAt(0);
			input.nextLine(); 
		}
		else if (PHV > 21)
		{
			System.out.println("PLAYER BUST!");			//if player deals another card and their hand value exceeds 21,
		}												//player busts
		
	}

	FHV_player = PHV;									//assign the player's updated hand value to their final hand value after
	System.out.println(" ");							//deciding to deal no more cards (stand) 
	
	//check if dealer stands
	System.out.println("====NEW DEALER HAND====");		
	if (DHV < STAND_VALUE)								//while the dealer's hand value is less than the stand value, the dealer
	{													//must be dealt another card from the deck
		do{
			c3 = d1.getTopCard();
			System.out.println(c3);
			DHV = DHV + c3.getValue();					//calculate and print the dealer's updated hand value
			System.out.println("NEW HAND VALUE: " + DHV);
		} while(DHV < STAND_VALUE);
		
		FHV_dealer = DHV;								//assign the dealer's updated hand value to their final hand value after
														//no more cards can be dealt
		if (DHV > 21)
		{
			System.out.println("DEALER BUST!");			//if the dealer is dealt another card and their hand value exceeds 21,
		}												//the dealer busts
	}
	else
	{
		FHV_dealer = DHV;
		System.out.println("DEALER STANDS AT: " + FHV_dealer);	//if dealer's initial two cards has a hand value that exceeds the
	}															//stand value, the dealer must stand
	
	System.out.println(" ");
	System.out.println("PLAYER FINAL HAND VALUE: " + FHV_player);	//print the final hand values of both the player and dealer
	System.out.println("DEALER FINAL HAND VALUE: " + FHV_dealer);
	
	//determine winner and accumulate number of wins by each case
	if (FHV_dealer > 21)										
	{
		System.out.println("PLAYER WINS!");						//if the dealer busts, the player wins
		numWins_player++;
	}
	else if (FHV_player > 21)
	{
		System.out.println("DEALER WINS!");						//if the player busts, the dealer wins
		numWins_dealer++;
	}
	else if (FHV_dealer < FHV_player)
	{
		System.out.println("PLAYER WINS!");						//if the player's hand value is closer to 21 than the dealer's,
		numWins_player++;										//the player wins
	}	
	else if (FHV_player < FHV_dealer)
	{
		System.out.println("DEALER WINS!");						//if the dealer's hand value is closer to 21 than the player's,
		numWins_dealer++;										//the dealer wins
	}
	else if (FHV_dealer > 21 && FHV_player > 21)				//if both the dealer and player bust, neither win
	{
		System.out.println("NO WINNER DETERMINED");
	}
	else														//if any other scenario (i.e. both the dealer and player tie at 21,
	{															//neither win
		System.out.println("NO WINNER DETERMINED");
	}
	
	System.out.println(" ");
	System.out.println("======SCOREBOARD======");				//display running total of hands won by the dealer and player
	System.out.println("DEALER: " + numWins_dealer);
	System.out.println("PLAYER: " + numWins_player);
	System.out.println(" ");
	System.out.print("Press a to play another hand.");			//allow player to play another hand
	again = input.next().charAt(0);
	input.nextLine();
	System.out.println(" ");
	}
	
	System.out.println("GOODBYE!");								//display message if player quits the game
	System.out.println(" ");
	
	}//end main

}//end of class definition
