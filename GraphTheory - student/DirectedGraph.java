import java.util.*;
import java.lang.*;

/*
 *     all vertices are numbered with Strings of length 1
 *     
 *     Edges are of the form (a, b), a and b are String with length 1
 *     
 *     Edges are assumed to be directed, which implies (1,3) is different from Edge (3,1)
 * @ author Tai-Yu Chen

 */

public class DirectedGraph 
{
    /*
     *   No duplicates vertices
     */
    private Set<String> myVertices;
    /*
     *   No duplicates edges
     */
    private Set<Edge> myEdges;

    /**
     * Constructor for objects of class DirectedGraph
     */
    public DirectedGraph(Set<String> vertices)
    {
        myVertices = vertices;
        myEdges = new HashSet<Edge>();
    }

    /*
     * precondition
     *   myVertices.contains(e.getA()) == true
     *   && myVertices.contains(e.getB()) == true
     *   myEdges.contains(e) == false
     * postcondtion:  myEdges.contains(e) == true
     */
    public void addEdge(Edge e)
    {
        myEdges.add(e);
    }

    /*
     * precondition
     *   for every edge in edges,
     *     myVertices.contains(edge.getA()) == true
     *     && myVertices.contains(edge.getB()) == true
     *   myEdges.contains(edge) == false
     * postcondtion:  every edge in edges is added to myEdges
     */
    public void addEdges(Set<Edge> edges)
    {
        myEdges.addAll(edges);
    }

    public Set<String> getVertices(){
        return myVertices;
    }
    public Set<Edge> getEdges(){
        return myEdges;
    }
    /*
     *  precondition
     *    myVertices.contains(s) == false
     *    
     *  postcondition
     *    myVertices.contains(s) == true
     */
    public void addVertex(String s)
    {
        myVertices.add(s);
    }

    /*
     *     According to http://webwhompers.com/graph-theory.html
     *     
     *     Two vertices are called adjacent if they share a common edge,   (direction of edge not important)
     *     
     *     precondition myVertices.contains(s) == true  && myVertices.contains(t)
     *     
     *     returns true iff vertex s and vertex t share a common edge (in either direction)
     *                  
     *         yes, you can be adjacent to your self
     */
    public boolean isAdjacent(String s, String t)
    {
        for(Edge e:myEdges){
            if((e.getA().equals(s) && e.getB().equals(t))||(e.getB().equals(s)&&e.getA().equals(t))){return true;}
        }
        return false;
    }

    /*
     *     According to http://webwhompers.com/graph-theory.html
     *     
     *     The neighborhood of a vertex v in a graph G is the set of vertices adjacent to v.
     *                      Use the definition of adjacent from isAdjacent above
     *                      i.e. - direction is NOT important
     *     
     *     precondition myVertices.contains(s) == true
     *     
     *     returns a Set of all neighbors of s
     *     The neighborhood does not include itself.
     */
    public Set<String> getNeighbors(String s)
    {
        Set<String> n = new HashSet<String>();
        for(Edge e: myEdges){
            if(e.getA().equals(s) && !e.getB().equals(s)){
                n.add(e.getB());
            }
            if(e.getB().equals(s) && !e.getA().equals(s)){
                n.add(e.getA());
            }
        }
        return n;
    }

    /*
     *   two graphs are equal iff both graphs have the same vertices and the same edges.
     */
    public boolean equals(Object obj)
    {
        DirectedGraph tmp = (DirectedGraph)obj;
        Set<Edge> otherEdges = tmp.getEdges();
        for(Edge e1: myEdges){
            int found =0;
            for(Edge e2: otherEdges){
                if((e2.getA().equals(e1.getA())&&(e2.getB().equals(e1.getB())))||(e2.getB().equals(e1.getA())&&e2.getA().equals(e1.getB()))){
                    found = 1;
                }
            }
            if(found != 1){return false;}
        }
        return true;
    }

    /*
     *   see top of page 379 for defintion of loop:
     *   
     *   An edge incident on a single vertex is called a loop.
     */
    public boolean hasLoop()
    {
        for(Edge e: myEdges){
            if(e.getA().equals(e.getB())){
                return true;
            }
        }
        return false;
    }

    /*
     *   see top of page 379 for defintion of loop:
     *   
     *   Two Edges associated with the same vertices are said to be parallel edges
     */
    public boolean hasParallelEdges()
    {
        for(Edge e1:myEdges){
            for(Edge e2: myEdges){
                if((!e1.equals(e2)) && (e1.getA().equals(e2.getA())&&e1.getB().equals(e2.getB()))||(e1.getB().equals(e2.getA())&&e1.getA().equals(e2.getB()))){
                    return true;
                }
            }
        }
        return false;
    }

    /*
     *   see top of page 379 for defintion of loop:
     *   
     *   A vertex not incident on any edge is called an isolated vertex
     *   A vertex incident on itself (i.e., a loop) is NOT isolated
     *   
     *   returns a List of all Isolted Vertices.  If there are not Isolated vertices, return an empty List
     *   
     *   an isolated vertex is one that does not contain any edges besides direct loops
     */
    public List<String> getAllIsolatedVertices()
    {
        ArrayList<String> ans = new ArrayList<String>();
        for(String v: myVertices){
            int isIso = 1;
            for(Edge e: myEdges){
                if((e.getA().equals(v)|| e.getB().equals(v))&&(!e.getA().equals(e.getB()))){
                    isIso = 0;
                    break;
                }
            }
            if(isIso ==1){
                ans.add(v);
            }
        }
        return ans;
    }

    /*
     *  precondition:   myVertices.contains(v) == true
     *  postcondition:  no side effects
     *    returns the number of edges incident on v
     *    
     *  note the sentence that states:
     *      (By definition, each loop on v contributes 2 to the degree of v)
     *    
     *    see page 392
     */
    public int getVertexDegree(String v)
    {
        if(! myVertices.contains(v)){
            return 0;
        }
        int n =0;
        if(myEdges.size()==0){
            return 0;
        }
        for(Edge e: myEdges){
            if(e.getA().equals(v) && e.getB().equals(v)){
                n=n+2;
            } else if(e.getA().equals(v) || e.getB().equals(v)){
                n++;
            }
        }
        return n;
    }

    /*
     *     A graph is said to be even if every vertex has even degree
     *     
     *     returns true every vertex has even degree
     *             false otherwise
     */
    public boolean isEvenGraph()
    {
        for(String v: myVertices){
            if(getVertexDegree(v) % 2==1){
                return false;
            }
        }
        return true;
    }

    /*
     *   returns the union DirectGraoh this . and DirectedGraph g
     *   return a DirectedGraph with:
     *        myVertices = union of this.myVertices and g.myVertices
     *        myEdges = union of this.myEdges and g.myEdges
     */
    public DirectedGraph union(DirectedGraph g)
    {
        HashSet<String> vert = new HashSet<String>();
        for(String v: myVertices){
            vert.add(v);
        }
        for(String v: g.getVertices()){
            if(!vert.contains(v)){
                vert.add(v);
            }
        }
        DirectedGraph ans = new DirectedGraph(vert);
        
        for(Edge e:myEdges){
            ans.addEdge(new Edge(e.getA(),e.getB()));
        }
        for(Edge e:g.getEdges()){
            if(!myEdges.contains(e)){
                ans.addEdge(new Edge(e.getA(),e.getB()));
            }
        }
        return ans;
    }

    /*
     *   returns the intersection DirectGraoh this . and DirectedGraph g
     *   return a DirectedGraph with:
     *        myVertices = intersection of this.myVertices and g.myVertices
     *        myEdges = intersection of this.myEdges and g.myEdges
     */
    public DirectedGraph intersection(DirectedGraph g)
    {
        HashSet<String> vert = new HashSet<String>();
        for(String v1: myVertices){
            for(String v2: g.getVertices()){
                if(v1.equals(v2)){
                    vert.add(v1);
                }
            }
        }
        DirectedGraph ans = new DirectedGraph(vert);
        
        for(Edge e1:myEdges){
            for(Edge e2:g.getEdges()){
                if(e1.getA().equals(e2.getA()) && e1.getB().equals(e2.getB())){
                    ans.addEdge(new Edge(e1.getA(),e1.getB()));
                }
            }
        }
        return ans;
    }

    /*
     *    use definition of Bipartite on page 383
     *       intersection is empty
     *       union == this
     *    Each edge in this.myEdges has one vertex in v1 and one vertex in v2   
     *    
     *    returns true if v1 and v2 form a Biparitite of this Directed Graph
     *    
     *    returns false otherwise
     */
    public boolean isBipartite(Set<String> v1, Set<String> v2)
    {
        for(Edge e:myEdges){
            if(!(v1.contains(e.getA()) && v2.contains(e.getB()))&&!(v2.contains(e.getA()) && v1.contains(e.getB()))){
                return false;
            }
        }
        return true;
    }
    public Set<Edge> AdjacentEdges(String v){
        Set<Edge> ans = new HashSet<Edge>();
        for(Edge e: myEdges){
            if(e.getA().equals(v)||e.getB().equals(v)){
                ans.add(e);
            }
        }
        return ans;
    }
    /*
     *   see page 388
     *   
     *   precondition:  myVertices.contains(v) == true  && myVertices.contains(w) == true
     *                  v and w may be the same vertex, i.e. v.equals(w) may be true
     *                  
     *                  A path must contain at least two different vertices.
     *                  This imples that a single isolated vertex is not a path
     *                  and a loop by itself is not a path
     *                  
     *   returns true iff there exist a path from v to w of any length and the path contains two different vertices.
     *   
     *       v and w
     */
    public boolean hasPath(String v, String w)
    {
        List<String> visitedNodes = new ArrayList<String>();
        if(v.equals(w)){
            return false;
        }
        return checkPath(visitedNodes, v, w);
    }
    public boolean checkPath(List<String> visitedNodes, String v, String w){
        if(v.equals(w)){
        return true;
        }
        visitedNodes.add(v);
        for(String n: adjacentNodes(v)){
            if(!visitedNodes.contains(n)){
                if(checkPath(visitedNodes,n,w)){
                    return true;
                }
            }
        }
        return false;
    }
    public Set<String> adjacentNodes(String v){
        Set<String> nodes = new HashSet<String>();
        for(Edge e: myEdges){
            if(e.getA().equals(v)){
                nodes.add(e.getB());
            }
        }
        return nodes;
    }
    /*
     *   see page 388 for definition
     *   
     *   A graph is connected if given any two vertices v and w, there exist a path from v to w
     */
    public boolean isConnectedGraph() // relies on hasPath to work properly
    {
        for(String v1: myVertices){
            for(String v2:myVertices){
                if(!v2.equals(v1)){
                    if(!hasPath(v1,v2)){return false;}
                }
            }
        }
        return true;
    }

    /*
     *    See page 391
     *    
     *    precondition:
     *       myVertices.contains(p.get(k)) == true for all k, 0 <= k < p.size()
     *       p.get(k).length() == 1 for all k, 0 <= k < p.size()
     *    postcondition:
     *       myVertices & myEdges are not altered
     *       
     *    returns true iff there is a path from p.get(0) to p.get(p.size()-1) with no repeated Vertices
     *            yes, you need to make sure myEdges contains the Edges required in p
     */
    public boolean isSimplePath(List<String> p) //wrong
    {
        for(int x = 0;x<p.size();x++){
            for(int y =0;y<p.size();y++){
                if(x!=y&& p.get(x).equals(p.get(y))){
                    return false;
                }
            }
        }
        boolean pathFound = false;
        for(int i=0;i<p.size()-1;i++){
            for(Edge e: myEdges){
                if(e.getA().equals(p.get(i))&& e.getB().equals(p.get(i+1))){
                    pathFound = true;
                }
            }
            if(!pathFound){
                return false;
            }
            pathFound = false;
        }
        return true;
    }

    /*
     *    See page 391
     *    
     *    precondition:
     *       c.get(0).equals(c.get(c.size()-1)) == true
     *       myVertices.contains(c.get(k)) == true for all k, 0 <= k < c.size()
     *       c.get(k).length() == 1 for all k, 0 <= k < c.size()
     *    postcondition:
     *       myVertices & myEdges are not altered
     *
     *    returns true iff there is a path of nonzerolength from c.get(0) to c.get(c.size()-1) with no repeated edges
     *            yes, you need to make sure myEdges contains the Edges required in c
     */
    public boolean isCycle(List<String> c)
    {
        if(c.size()<2){
            return false;    
        }
        Set<Edge> edges = new HashSet<Edge>();
        edges.addAll(myEdges);
        for(int i =0;i<c.size()-1;i++){
            if(!edges.contains(new Edge(c.get(i),c.get(i+1)))){
                return false;
            }else{
                edges.remove(new Edge(c.get(i),c.get(i+1)));
            }
        }
        return true;
    }

    /*
     *    See page 391
     *    
     *    precondition:
     *       c.get(0).equals(c.get(c.size()-1)) == true
     *       myVertices.contains(c.get(k)) == true for all k, 0 <= k < c.size()
     *       c.get(k).length() == 1 for all k, 0 <= k < c.size()
     *    postconditino:
     *       myVertices & myEdges are not altered
     *
     *    returns true iff there is a cycle from c.get(0) to c.get(c.size()-1) in which, except for beginning and ending vertices, 
     *                     there are no repeated vertices.
     *            yes, you need to make sure myEdges contains the Edges required in c
     */
    public boolean isSimpleCycle(List<String> sc)
    {
        for(int i =1;i<sc.size()-1;i++){
            if(!(i==sc.lastIndexOf(sc.get(i)))){
                return false;
            }
        }
        return isCycle(sc);
    }

    /*
     *   precondition:
     *       v.length() == 1;
     *       myVertices.contains(v) == true
     *
     *   See page 391 for defintion of a cycle
     *      A cycle (or circuit) is a path of nonzero length from v to v with no repeated edges
     *      loops can form a simple cycle, that is, the path "vv" is consider a simple cycle in this method
     *
     *   return
     *       A String containing a list vertices which form a simple cycle from v to v
     *          The first and last vertice of the String should be v, e.g.:  "v.....v"
     *              and no other vertice should be repeated in the String
     *       null if a simple cycle does not exist.
     */
    public String getSimpleCycle(String v)
    {
        String ans = "";
        List<String> tmp = new ArrayList<String>();tmp.add(v);tmp.add(v);
        if(isSimpleCycle(tmp)){
            return v+v;
        }
        List<String> testPath = new ArrayList<String>();
        List<Edge> visitedEdges = new ArrayList<Edge>();
        testPath.add(v);
        while(){
            for(String n: adjacentNodes(testPath.get(testPath.size()-1))){
                
            }
        }
        return ans;
    }
}