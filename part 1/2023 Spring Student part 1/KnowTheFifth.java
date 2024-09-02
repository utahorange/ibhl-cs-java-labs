import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * @author  Don Allen
 * @version 2023 Wittry Contest
 */
public class KnowTheFifth
{
    static String[] suitOrder = {"club","diamond","heart","spade"};
    /*
     *    precondition:  !c1.equals(c2)
     */
    public static Card isSmaller(Card c1, Card c2)
    {
        /*suitOrder.add("club");
        suitOrder.add("diamond");
        suitOrder.add("heart");
        suitOrder.add("spade");*/
        if (c1.getRank() < c2.getRank()){
            return c1;
        }
        if (c1.getRank() > c2.getRank()){
            return c2;
        }
        if (indexOf(suitOrder, c1.getSuit()) < indexOf(suitOrder,c2.getSuit())) {
            return c1;
        }
        return c2;
    }

    public static int indexOf(String[] arr, String x){
        for (int i = 0; i < arr.length; i++){
            if (x.equals(arr[i])) return i;
        }
        return -1;
    }

    public static Card isLarger(Card c1, Card c2){
        if (isSmaller(c1,c2).equals(c1))return c2;
        return c1;
    }

    /*
     *    preCondition: cards.length() == 5
     *    
     *    return the proper arrangement of the four Cards which indicate the fifth card
     *    if multiple arrangements exist, return any of the arrangements
     */
    public static Card[] arrangeCards(Card[] cards)
    {
        int[] suitCount = {0,0,0,0};
        ArrayList<Card> temp = new ArrayList<Card>();
        Card hidden;
        Card notHidden;
        for (Card c : cards){
            for (int i = 0; i < 4; i++){
                if (c.getSuit().equals(suitOrder[i])) suitCount[i]++;
            }
        }
        for (int i = 0; i < 4; i++){
            if (suitCount[i] == 2){
                for (Card c : cards){
                    if (c.getSuit().equals(suitOrder[i])) temp.add(c);
                }
            }
        }

        int diff = isLarger(temp.get(0),temp.get(1)).getRank() - isSmaller(temp.get(0),temp.get(1)).getRank();

        if (diff > 6){
            hidden = isSmaller(temp.get(0),temp.get(1));
            notHidden = isLarger(temp.get(0),temp.get(1));
        }
        else {
            hidden = isLarger(temp.get(0),temp.get(1));
            notHidden = isSmaller(temp.get(0),temp.get(1));
        }

        temp.clear();
        for (Card c : cards){
            if (!c.equals(hidden) && !c.equals(notHidden)) temp.add(c);
        }

        Card low = isSmaller(isSmaller(temp.get(0),temp.get(1)),isSmaller(temp.get(1),temp.get(2)));
        Card middle = isLarger(isSmaller(temp.get(0),temp.get(1)),isSmaller(temp.get(1),temp.get(2)));
        Card high = isLarger(isLarger(temp.get(0),temp.get(1)),isLarger(temp.get(1),temp.get(2)));

        if (diff > 6) diff = 13 - diff;

        if (diff == 1) return new Card[] {notHidden,low,middle,high};
        if (diff == 2) return new Card[] {notHidden,low,high,middle};
        if (diff == 3) return new Card[] {notHidden,middle,low,high};
        if (diff == 4) return new Card[] {notHidden,middle,high,low};
        if (diff == 5) return new Card[] {notHidden,high,low,middle};
        return new Card[] {notHidden,high,middle,low};
    }

    /*
     *      cs.size() == 3
     */
    public int evaluateOrder(Card[] cs)
    {
        //h,d,s (middle low high)
        Card low = isSmaller(isSmaller(cs[0],cs[1]),isSmaller(cs[1],cs[2]));
        Card high = isLarger(isLarger(cs[0],cs[1]),isLarger(cs[1],cs[2]));
        Card middle = low;
        for (Card c : cs){
            if (!low.equals(c)&&!high.equals(c)) middle = c;
        }

        if (cs[0].equals(low)){
            if (cs[1].equals(middle)) return 1;
            return 2;
        }
        if (cs[0].equals(middle)){
            if (cs[1].equals(low)) return 3;
            return 4;
        }
        if (cs[1].equals(low)) return 5;
        return 6;
    }

    /*
     *    cards.length() == 4
     *    
     *    return the card indicate by the four cards in Cards
     */
    public Card name5thCard(Card[] cards)
    {
        Card[] three = {cards[1],cards[2],cards[3]};
        int num = evaluateOrder(three)+cards[0].getRank();
        if (num > 13) num %=13;
        return new Card(cards[0].getSuit(),num);
    }
}