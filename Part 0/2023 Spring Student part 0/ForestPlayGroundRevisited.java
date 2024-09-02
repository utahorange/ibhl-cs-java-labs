/**
 * @author:   Mr. Allen
 *            2023 Wittry contest
 */
import java.io.*;
import java.util.*;
import java.math.*;
public class ForestPlayGroundRevisited  
{
    int[] myTree;

    /*
     *   PreConditions
     *        tree is a valid represntation fo a binary tree
     *        tree != null
     *        tree.size() >= 0
     *        tree[tree.length - 1] > 0
     */
    public ForestPlayGroundRevisited(int[] tree)
    {
        myTree = tree;
    }

    /*
     *    Precondition:  0 <= lev
     *                   myTree contains at least one node on level lev
     */
    public int[] getLevel(int lev)
    {
        List<Integer>a=new ArrayList<Integer>();
        for(int i=(int)Math.pow(2,(lev-1));i<(int)Math.pow(2,(lev-1))*2;i++){
            if(i<myTree.length&&myTree[i]!=-1){
                a.add(myTree[i]);
            }
        }
        int[]ans=new int[a.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=a.get(i);
        }
        return ans;
    }

    /*
     *    returns the level number with the largest average
     */
    public int getLevelWithHighestAverage()
    {
        int a=myTree[1];
        int b=1;
        int c=1;
        int lowestAvg=Integer.MIN_VALUE;
        int ans=-1;
        while(b<myTree.length){
            b*=2;
            c++;
        }
        for(int i=1;i<c;i++){
            double qwe=0;
            int q[]=getLevel(i);
            for(int po:q){
                qwe+=(double)po;
            }
            qwe/=q.length;

            if(qwe>lowestAvg){
                lowestAvg=(int)qwe;
                ans=i;
            }
        }
        return ans;
    }

    /*
     *     rotate each node level one to the left
     *     
     *     all null (non-positive values remain in same index.
     */
    public int[] shiftLevelLeft()
    {
        List<Integer>a=new ArrayList<Integer>();
        a.add(-1);
        int b=1;
        int c=1;
        while(b<myTree.length){
            b*=2;
            c++;
        }
        for(int i=1;i<c;i++){
            for(int shi:shifter(getBrokenLevel(i))){
                a.add(shi);
            }
        }
        int[]ans=new int[a.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=a.get(i);
        }
        return ans;
    }

    public int[]shifter(int[]a){
        int[]q=new int[a.length];
        for(int i=0;i<a.length;i++){
            if(a[i]!=-1){
                int w=i-1;
                if(w==-1){
                    w=a.length-1;
                }
                while(a[w]==-1){
                    w--;
                    if(w==-1){
                        w=a.length-1;
                    }
                }
                q[w]=a[i];
            }
            else{
                q[i]=-1;
            }
        }
        return q;
    }

    public int[] getBrokenLevel(int lev)
    {
        List<Integer>a=new ArrayList<Integer>();
        for(int i=(int)Math.pow(2,(lev-1));i<(int)Math.pow(2,(lev-1))*2;i++){
            if(i<myTree.length){
                a.add(myTree[i]);
            }
        }
        int[]ans=new int[a.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=a.get(i);
        }
        return ans;
    }

}