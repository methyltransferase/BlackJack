import java.util.*;

/**
 * The Deck class creates an array of 52 Cards and demonstrates the 
 * shuffle() method and getTopCard() method.
 * 
 * @author Lily Naoudom
 * @version 8-5-2015
 *
 */
public class Deck {

	Card [] myDeck = new Card [52];				//declare and create array of 52 Cards
	
	private int topCardIndex;					//holds the subscript of the card at the top of the deck
	
	Random rand = new Random();					//create a Random object to be used in the shuffle() method

	/**
	 * This constructor creates and populates the myDeck array with 52 Cards.
	 */
	public Deck()
	{
		//populate deck of hearts
		Card [] tempH = new Card[13];			//declare and create array of 13 cards
		int vH = 1;								//holds data for the value of cards in the Hearts deck
		int fH = 1;								//holds data for the face of cards in the Hearts deck
		for (int k = 0; k<tempH.length; k++)
		{	
			tempH[k] = new Card(vH++, "Hearts", Integer.toString(fH++));
			tempH[0] = new Card(1, "Hearts", "Ace");
			tempH[10] = new Card(10, "Hearts", "Jack");
			tempH[11] = new Card(10, "Hearts", "Queen");
			tempH[12] = new Card(10, "Hearts", "King");
		}
		
		//populate deck of diamonds
		Card [] tempD = new Card[13];			//declare and create array of 13 cards
		int vD = 1;								//holds data for the value of cards in the Diamonds deck
		int fD = 1;								//holds data for the face of cards in the Diamonds deck

		for (int k =0; k<tempD.length; k++)
		{
			tempD[k] = new Card(vD++, "Diamonds", Integer.toString(fD++));
			tempD[0] = new Card(1, "Diamonds", "Ace");
			tempD[10] = new Card(10, "Diamonds", "Jack");
			tempD[11] = new Card(10, "Diamonds", "Queen");
			tempD[12] = new Card(10, "Diamonds", "King");
		}
	
		//populate deck of clubs
		Card [] tempC = new Card[13];			//declare and create array of 13 cards
		int vC = 1;								//holds data for the value of cards in the Clubs deck
		int fC = 1;								//holds data for the face of cards in the Clubs deck

		for (int k =0; k<tempC.length; k++)
		{
			tempC[k] = new Card(vC++, "Clubs", Integer.toString(fC++));
			tempC[0] = new Card(1, "Clubs", "Ace");
			tempC[10] = new Card(10, "Clubs", "Jack");
			tempC[11] = new Card(10, "Clubs", "Queen");
			tempC[12] = new Card(10, "Clubs", "King");
		}
		
		//populate deck of spades
		Card [] tempS = new Card[13];			//declare and create array of 13 cards
		int vS = 1;								//holds data for the value of cards in the Spades deck
		int fS = 1;								//holds data for the face of cards in the Spades deck
			
		for (int k =0; k<tempS.length; k++)
		{
			tempS[k] = new Card(vS++, "Spades", Integer.toString(fS++));
			tempS[0] = new Card(1, "Spades", "Ace");
			tempS[10] = new Card(10, "Spades", "Jack");
			tempS[11] = new Card(10, "Spades", "Queen");
			tempS[12] = new Card(10, "Spades", "King");		
		}
		
		//copy elements of each array into new array of 52 elements
		for (int k=0; k<tempH.length; k++)
			myDeck[k] = tempH[k];

		for (int k=0; k<tempD.length; k++)
			myDeck[k+13] = tempD[k];
			
		for (int k=0; k<tempC.length; k++)
			myDeck[k+26] = tempC[k];
		
		for (int k=0; k<tempS.length; k++)
			myDeck[k+39] = tempS[k];
	
		topCardIndex = 51;						//subscript for the card at the top of the deck
		
	}

	/**
	 * This method swaps or "shuffles" the elements of the myDeck array.
	 */
	public void shuffle()
	{
		int counter = 0;
		
			for (int k=0; k<myDeck.length; k++)
			{
				do{												//do-while loop to swap elements 1000 times
				int newPlace = rand.nextInt(myDeck.length);		//generate new subscript (place) for myDeck element
		
				Card temp = myDeck[k];
				myDeck[k] = myDeck[newPlace];
				myDeck[newPlace] = temp;
				
				counter++;
				
				} while(counter<1001);
			}

	}

	/**
	 * This method returns a copy of the Card at the top of the myDeck array.
	 * @return new Card object - the Card at the top of the array
	 */
	public Card getTopCard()
	{
		Card tempTop = myDeck[topCardIndex];					//assign Card at the top of the deck to a Card reference variable
		topCardIndex--;					
		
		return new Card(tempTop);
	}
	
	
}//end of class definition
