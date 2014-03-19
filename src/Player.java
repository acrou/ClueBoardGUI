import java.awt.*;
import java.util.ArrayList;

/**Abstracts qualities of both types of Players
 * Created by Marissa on 3/10/14.
 */

public class Player {
    protected String name;
    protected ArrayList<Card> myCards;
    protected BoardCell location;
    protected RoomCell prevRoom;
    protected Card proof;
    protected Color color;
    public Player (){
       myCards = new ArrayList<Card>();
    }
    //getters
    public BoardCell getLocation (){
        return location;
    }
    public String getName (){
        return name;

    }
    public ArrayList<Card> getMyCards (){
        return myCards;
    }
    public RoomCell getPrevRoom (){
        return prevRoom;
    }
    public Card getProof (){
        return proof;
    }
    public  Color getColor(){
        return color;

    }
    //setters
    public void setColor (Color  c){
        this.color = c;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setLocation(int loc, Board b){
        location = b.getCellAt(loc);
    }
    public void addCard(Card c){
        myCards.add(c);
    }

    public Card makeSuggestion (){
        Card suggestion = new Card();
        if(suggestion.getType()==Card.CardType.ROOM && location.isRoom()) //ensure the room is the same
            if(!(((RoomCell)location).getFullName().equals(suggestion.getName())))
                //do something
                return null;
        return null;

    }
    public int indexOfSuggestion(Card suggestion){
        for(int i = 0; i<myCards.size(); i++){
            if(myCards.get(i).getName().equals(suggestion.getName())){
                proof = myCards.get(i);
                return i;
            }
        }
        return -1;
    }
    public Card disproveSuggestions(Card suggestion){
        if(indexOfSuggestion(suggestion)<0)
            return proof;
        else
            return null;

    }


}
