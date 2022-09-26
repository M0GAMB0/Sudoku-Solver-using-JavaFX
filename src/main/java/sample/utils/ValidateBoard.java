package sample.utils;

import java.util.HashSet;
import java.util.Set;

public class ValidateBoard {
    private Set<Integer> checker;
    public ValidateBoard() {
        checker=new HashSet<>();
        for(Integer i=1;i<=9;i++){
            checker.add(i);
        }
    }
    public boolean validRow(Board b,int r){
        Set<Integer> n=new HashSet<>(checker);
        for(int c=0;c<9;c++){
            Integer i =b.get(c,r);
            if(i!=null){
                if(!n.contains(i)){
                    return false;
                }
                else{
                    n.remove(i);
                }
            }
        }
        return true;
    }
    public boolean validAllRows(Board b){
        for(int r=0;r<9;r++){
            if (!validRow(b, r)) {
                return false;
            }
        }
        return true;
    }
    public boolean validColumn(Board b,int c){
        Set<Integer> n=new HashSet<>(checker);
        for(int r=0;r<9;r++){
            Integer i =b.get(c,r);
            if(i!=null){
                if(!n.contains(i)){
                    return false;
                }
                else{
                    n.remove(i);
                }
            }
        }
        return true;
    }
    public boolean validAllColumns(Board b){
        for(int c=0;c<9;c++){
            if (!validColumn(b, c)) {
                return false;
            }
        }
        return true;
    }

    public boolean validSquare(Board b,int ac,int ar){
        Set<Integer> n=new HashSet<>(checker);
        for(int r=0;r<3;r++){
            for(int c=0;c<3;c++){
                Integer i= b.get(ac+c,ar+r);
                if(i!=null){
                    if(!n.contains(i)){
                        return false;
                    }
                    else{
                        n.remove(i);
                    }
                }
            }
        }
        return true;
    }
    public  boolean validAllSquare(Board b){
        for(int r=0;r<9;r+=3){
            for(int c=0;c<9;c+=3){
                if(!validSquare(b,c,r)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean valid(Board b){
        //System.out.println(validAllRows(b) +" "+ validAllColumns(b) +" "+ validAllSquare(b));
        return validAllRows(b) && validAllColumns(b) && validAllSquare(b);
    }
    public boolean complete(Board b){
        for (int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                if(b.get(c,r)==null){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean completeAndValid(Board b){
        return valid(b) && complete(b);
    }

    //Implementing Backtracking
    public Board solve(Board partial){
        if(!valid(partial)){
            return null;
        }
        if(completeAndValid(partial)){
            return partial;
        }
        Board b = new Board(partial);
        for (int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                Integer i=b.get(c,r);
                if(i==null){
                    Set<Integer> tryUs=new HashSet<>(checker);
                    for(Integer number:tryUs){
                        b.set(c,r,number);
                        //System.out.println("b["+r+"]["+c+"] = "+number);
                        Board solution=solve(b); //   recursion;
                        if(solution!=null){
                            //System.out.println("Valid");
                            return solution;
                        }
//                        else{
//                            //System.out.println("Not Valid");
//                        }
                    }
                    return null;
                }
            }
        }
        return null;
    }
}
