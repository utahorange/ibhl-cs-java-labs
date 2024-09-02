/**    implewment (almost) ALL the methods in this class.
 * 
 *    But first, you need to finish implementing the OrderedPair class
 *    
 *    The first tester provided test the OrderedPair class methods equals and hashCode
 *    which I believe are important methods that you may use or I use in the tester when I create
 *    a HashSet.  This tester method is only for your benefit as it is not included the stipulator tester.
 */
import java.util.*;
import java.lang.Math;
/**
 *
 * @author Tai-Yu Chen 
 * @version (a version number or a date)
 */
public class FunctionsChapter3Style
{
    private Set<String> domain = new HashSet<String>();
    private Set<String> codomain = new HashSet<String>();
    private Set<OrderedPair> rel = new HashSet<OrderedPair>();
    public FunctionsChapter3Style(Set<String> d, Set<String> co)
    {
        domain = d;
        codomain = co;
    }

    public FunctionsChapter3Style(Set<String> d, Set<String> co, Set<OrderedPair> r)
    {
        domain = d;
        codomain = co;
        rel = r;
    }

    /**
     *    Not tested.
     *    
     *    I admit that I did use this method a couple of times.
     *    It came in very handy and SHORTEN my code and GREATLY simplified some methods
     *    I will let you figure out which ones and how
     *    
     *    @return a String of the form: [(a,b), (c,d), ...(v,w)]
     */
    public String getRelString()
    {
        if (rel.size() == 0) {
            return "[]";
        }
        StringBuilder a = new StringBuilder();
        a.append("[");
        for (int i = 0; i < rel.size(); i++) {
            a = a.append((rel.toArray()[i].toString()).concat(","));
        }
        a.deleteCharAt(a.length() - 1);
        a = a.append("]");
        return a.toString();
    }

    /**
     *    replaces the current relation instance variable with op
     *    
     *    YES - this method gets used in the my (stipulator) tester
     */
    public void setRelation(Set<OrderedPair> op)
    {
        rel = op;
    }

    /**
     *      Access the relation instance variable
     *    @return the current relation instance variable 
     */
    public Set<OrderedPair> getRelation()
    {  
        return rel;
    }

    /**
     * Method size
     *
     *     @return the number of Order Pairs in the relation
     */
    public int size()
    {
        return rel.size();
    }

     public Set<OrderedPair> xLookup(String val)
    {
        Set<OrderedPair> a = new HashSet<OrderedPair>();
        Iterator<OrderedPair> it = rel.iterator();
        while(it.hasNext()) {
            OrderedPair temp = it.next();
            if (temp.getX().equals(val))
            {
                a.add(temp);
            }
        }
        return a;
    }
    
    public Set<OrderedPair> yLookup(String val)
    {
        Set<OrderedPair> a = new HashSet<OrderedPair>();
        Iterator<OrderedPair> it = rel.iterator();
        while(it.hasNext()) {
            OrderedPair temp = it.next();
            if (temp.getY().equals(val))
            {
                a.add(temp);
            }
        }
        return a;
    }

    /**
     *    Checks if Order Pairs forms a function
     *    @return true if the array of Order Pairs forms a function
     *    returns false otherwise
     */
    public boolean isFunction()
    {
        Iterator<String> it = domain.iterator();
        while(it.hasNext()) {
            String temp = it.next();
            if (xLookup(temp).size() != 1) {
                return false;
            }
        }
        return true;
    }

    /** 
     *    A function f from X to Y is said to be one to one if 
     *    for each y in Y, there is at most one x in X with f(x) = y
     *
     *    @return true if array of order Pairs is a function and the function is one to one
     *    returns false otherwise
     */
    public boolean is1To1()
    {
        Iterator<String> it = codomain.iterator();
        while(it.hasNext()) {
            String temp = it.next();
            if (yLookup(temp).size() > 1)
            {
                return false;
            }
        }
        return isFunction();
    }

    /**
     *    A function from X to Y is said to be onto if
     *    the range of f == Y
     *
     *    @return true if array of order Pairs is a function and the function is onto
     *    returns false otherwise
     */
    public boolean isOnTo()
    {
        Iterator<String> it = codomain.iterator();
        while(it.hasNext()) {
            String temp = it.next();
            if (yLookup(temp).size() == 0)
            {
                return false;
            }
        }
        return isFunction();
    }

    /**
     *      Checks the order Pairs are a function and the function is bijective
     *              that is both one to one and onto
     *     @return true if the array of order Pairs is a function and the function is bijective
     *              that is both one to one and onto
     *     returns false otherwise
     */
    public boolean isBijective()
    {
        return is1To1() && isOnTo();
    }

    /**
     *   precondition:  getRelation() and op (the parameter) are both functions.  
     *                  Domain of op is a subset of coDomain of getRelation()
     *   
     *   @return a new FunctionsChapter3Style Object.
     *   The domain of new FunctionsChapter3Style Object is this.domain
     *   The coDomain is opCoDomain (the paramenter)
     *   
     *   The new function is the composition op( this.getRelation (this.domain) )
     */
    public FunctionsChapter3Style getComposition(Set<OrderedPair> op, Set<String> opCoDomain)
    {
        Set<String> nCoDomain = opCoDomain;
        FunctionsChapter3Style input = new FunctionsChapter3Style(codomain, nCoDomain, op);
        Set<OrderedPair> comp = new HashSet<OrderedPair>();
        for (String x: domain) {
            String outputOfFunc1 = ((OrderedPair)((xLookup(x).toArray())[0])).getY();
            String outputOfFunc2 = ((OrderedPair)((input.xLookup(outputOfFunc1).toArray())[0])).getY();
            comp.add(new OrderedPair(x,outputOfFunc2));
        }
        FunctionsChapter3Style a = new FunctionsChapter3Style(domain, nCoDomain, comp);
        return a;

    }

    /**
     *   precondition:  rel is a function.
     *   rel does not have to be both 1-1 and onto
     *   the inverse does not need to be a function
     */
    public OrderedPair[] getInverse()
    {
        OrderedPair[] a = new OrderedPair[rel.size()];
        int i = 0;
        for (OrderedPair pair: rel) {
            a[i] = new OrderedPair(pair.getY(), pair.getX());
            i++;
        }
        return a;
    }

    /**
     * A relation is reflexive if (x, x) in R for every x in X. X is the domain
     * 
     *       @return true if the current relation is reflexive
     *       returns false otherwise
     */
    public boolean isReflexive()
    {
        Iterator<String> it = domain.iterator();
        while(it.hasNext()) {
            String temp = it.next();
            if (!xLookup((String)(temp)).contains(new OrderedPair((String)(temp), (String)(temp))))
            {
                return false;
            }
        }
        return true;
    }

    /**
     *       A relation is symmetric if
     *       for all x, y in X, if (x,y) in R, then (y,x) in R
     * 
     *       @return true if the current relation is symmetric
     *       returns false otherwise
     */
    public boolean isSymmetric()
    {
        for (OrderedPair pair: rel) {
            if (!rel.contains(new OrderedPair(pair.getY(),pair.getX()))) {
                return false;
            }
        }
        return true;
    }

    /**
     *       A relation is Antisymmetric if
     *       for all x, y in X, if (x,y) in R, and (y,x) in R, then x = y
     * 
     *    @return true if the current relation is Antisymmetric
     *    returns false otherwise
     */
    public boolean isAntiSymmetric()
    {
        for (OrderedPair i: rel) {
            for (OrderedPair j: rel) {
                if (i.getX().equals(j.getY()) && i.getY().equals(j.getX()))
                {
                    if(!(i.getX().equals(i.getY()))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     *       A relation is transitive:
     *       for all x, y, z in X, if (x,y) and (y,z) in R, then (x,z) in R
     * 
     *       @return false if there is current relation which is not transitive
     *       returns true otherwise
     */
    public boolean isTransitive()
    {
        for (OrderedPair i: rel) {
            for (OrderedPair j: rel) {
                if (i.getY().equals(j.getX())) {
                    if (!rel.contains(new OrderedPair(i.getX(), j.getY()))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     *      Checks relation is an Equivalence Relation
     *    @return true is the relation is an Equivalence Relation
     *    returns false otherwise
     */
    public boolean isEquivalenceRelation()
    {
        return isSymmetric() && isReflexive() && isTransitive();
    }

    /**
     *    
     *    return true is the relation is an Partially Order
     *    returns false otherwise
     */
    public boolean isPartiallyOrder()
    {
        return isAntiSymmetric() && isReflexive() && isTransitive();
    }

    /**
     *      Checks if Function with the same domain as getRelation with getY().equals(s)
     *      @return a Function with the same domain as getRelation,
     *       with getY().equals(s)
     */
    public FunctionsChapter3Style getConstant(String s)
    {
        Set<OrderedPair> nrel = new HashSet<OrderedPair>();
        for (String d: domain) {
            nrel.add(new OrderedPair(d, s));
        }
        FunctionsChapter3Style a = new FunctionsChapter3Style(domain, codomain, nrel);
        return a;
    }

    /**
     *      not tested.
     *      Not sure why it is here.  I think I needed/used this functionality more than once,
     *      and therefore created a helper method
     */
    public ArrayList<OrderedPair> getRel(String s)
    {
        ArrayList<OrderedPair> a = new ArrayList<OrderedPair>();

        return a;
    }
}