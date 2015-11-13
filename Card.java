/**
 * The Card class holds data for the value, suit, and face fields. The class demonstrates
 * the get() methods, toString() method, and the compareTo() method.
 * 
 * @author Lily Naoudom
 * @version 8-5-2015
 *
 */
public class Card {

	private int value;					//holds data for the value of the card
	private String suit;				//holds data for the suit of the card
	private String face;				//holds data for the face of the card
	
	/**
	 * The constructor method takes in three arguments and sets them to the field values.
	 * @param inValue - the value of the card
	 * @param inSuit - the suit of the card
	 * @param inFace - the face of the card
	 */
	public Card(int inValue, String inSuit, String inFace)
	{
		value = inValue;
		suit = inSuit;
		face = inFace;
	}
	
	/**
	 * The copy constructor uses field values from an existing Card object to create a new Card object.
	 * @param other - reference to an existing Card object
	 */
	public Card (Card other)
	{
		this.value = other.value;
		this.suit = other.suit;
		this.face = other.face;
	}
	
	/**
	 * This method returns data stored in the value field.
	 * @return value - the value of the card
	 */
	public int getValue()
	{
		return value;
	}
	
	/**
	 * This method returns the data stored in the suit field.
	 * @return suit - the suit of the card
	 */
	public String getSuit()
	{
		return suit;
	}
	
	/**
	 * This method returns the data stored in face field.
	 * @return face - the face of the card
	 */
	public String getFace()
	{
		return face;
	}
	
	/**
	 * The toString method returns a textual representation of each of the field values.
	 * @return String - current field values for value, suit, and face
	 */
	public String toString()
	{
		return "Value: " + value + "\tSuit: " + suit +  "\tFace: " + face;
	}
	
	/**
	 * The CompareTo method uses the value field of two Card objects to determine ordering.
	 * @param other - reference to another Card object
	 * @return result - determines whether the value field of one Card object is greater, 
	 * less than, or equal to the value field of another Card object.
	 */
	public int compareTo(Card other)
	{
		int result;
		
		if (this.value > other.value)
			result = 1;
		else if (this.value < other.value)
			result = -1;
		else
			result = 0;
		
		return result;
	}
}//end of class definition
