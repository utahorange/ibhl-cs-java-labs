import java.util.*;

 /*
 * This class is meant to complete multiple functions of sets such as union, intersection, and difference.
 * @author Tai-Yu Chen
 * @version 9/25/2023
 * @see N/A
 */ 
public class SetWithArray
{
  private int[] x;

  public SetWithArray(int[] num)
  {
    x = num;
  }

/*
 * returns an Set (array) containing all elements in x OR y
 */
  public int[] union(int[] y)
  {
    int[] diff = difference(y);
    int[] ans = new int[y.length+diff.length];
    for(int i=0;i<diff.length;i++){
        ans[i]=diff[i];
    }
    for(int j=0;j<y.length;j++){
        ans[j+diff.length]=y[j];
    }
    return ans;
  }

/*
 * returns an Set (array) containing all elements in x AND y
 * 
 *      if the intersection is empty, return an arrray of length 0
 * 
 */
public boolean isIn(int n, int[] y){
    for(int j:y){
        if(n==j){
            return true;
        }
    }
    return false;
}
  public int[] intersection(int[] y)
  {
    int n=0;
    boolean b = false;
    for(int i=0;i<x.length;i++){
        for(int j=0;j<y.length;j++){
            if(y[j]==x[i])b=true;
        }
        if(b){n++;}
        b= false;
    }
    int[] ans = new int[n];
    int k=0;
    for(int i=0;i<x.length;i++){
        for(int j=0;j<y.length;j++){
            if(x[i]==y[j]){ans[k]=x[i];k++;break;}
        }
    }
    return ans;
  }

/*
 * returns an Set (array) containing all elements in x that are not in y
 * 
 *      if the intersection is empty, return an arrray of length 0
 */
  public int[] difference(int[] y)
  {
      int copies = 0;
      for(int i=0;i<x.length;i++){
          for(int j=0;j<y.length;j++){
            if(y[j]==x[i]){
                copies++;
            }
            }
        }
        int[] ans = new int[x.length-copies];
        int k=0;
        for(int i=0;i<x.length;i++){
            if(!isIn(x[i],y)){
                ans[k]=x[i];
                k++;
            }
        }
        return ans;
  }

/*
 * returns true if all elements of x are contained in y
 */
  public boolean isSubSetOf(int[] y)
  {
    boolean found = false;
    for(int i=0;i<x.length;i++){  
        for(int j = 0;j<y.length;j++){
            if(y[j]==x[i]){
                found=true;
            }
        }
        if(found==false){return false;}
        found=false;
    }
    return true;
  }

/*
 * returns true if all elements in y are contained in x
 *              and if all elements in x are contained in y
 */
  public boolean isEqualTo(int[] y)
  {
    boolean found = false;
    for(int i=0;i<x.length;i++){  
        for(int j = 0;j<y.length;j++){
            if(y[j]==x[i]){
                found=true;
            }
        }
        if(found==false){return false;}
        found=false;
    }
    boolean found2 = false;
    for(int i=0;i<y.length;i++){  
        for(int j = 0;j<x.length;j++){
            if(y[j]==x[i]){
                found2=true;
            }
        }
        if(found2==false){return false;}
        found2=false;
    }
    return true;
  }

/*
 * returns the set of elements which are in one of the set
 *         that is:  (x - y) union (y - x)
 * 
 *      if the union is empty, return an arrray of length 0
*/
  public int[] symmetricDifference(int[] y)
  {
      int and = 0;
      int[] u = union(y);
      for(int i=0;i<x.length;i++){
          for(int j=0;j<y.length;j++){
              if(x[i]==y[j]){
                and++;
                }
            }
        }
        int[] ans = new int[u.length-and];
        boolean b = true;
        int a=0;
        for(int k=0; k<u.length; k++){
            for(int i=0;i<x.length;i++){
              for(int j=0;j<y.length;j++){
                  if(u[k]==x[i] && x[i]==y[j]){
                    b=false;
                    }
                }
            }
            if(b){
                ans[a]=u[k];
                a++;
            }
            b=true;
        }
        return ans;
        }
public void print(int[] y){
    for(int i=0;i<y.length;i++){
        System.out.print(y[i]+" ");
    }
}
/*
 * returns true if all the collection sets in s form a partition of x
 *         you may assume that x is a universal set.
 *         
 *         You might have to look up the definition of a partition and 
 */
  public boolean isPartition(List<int[]> s)
  {
      int c=0;
      for(int i=0;i<x.length;i++){ // for every item in x
          for(int j=0;j<s.size();j++){ // for every array in s
              for(int k=0;k< s.get(j).length;k++){ // for every element in a list of s
                if(s.get(j)[k]==x[i]){
                    c++;
                }
              }
            }
            if(c!=1){
                return false;
            }
            c=0;
        }
    return true;
  }
}