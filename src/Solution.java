import java.util.Objects;

/**
 * Created by Marissa on 3/13/14.
 */
public class Solution {
    public String weapon;
    public String person;
    public String room;

    public Solution (String person, String room, String weapon){
        this.person = person;
        this.room = room;
        this.weapon = weapon;

    }

    @Override
    public boolean equals (Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Solution))return false;

        Solution c = (Solution)other;
        if(c.weapon.equals(weapon) &&c.person.equals(person)&&c.room.equals(room))
            return true;
        return false;

    }
}