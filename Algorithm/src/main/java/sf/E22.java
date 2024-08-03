package sf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class E22 {
    //
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        reverse(n,res,0,0,"");
        return res;
    }

    private void reverse(int n, List<String> res,int open , int close, String path) {
        if (open>n||close>open) return ;

        if (path.length()==n*2){
            res.add(path);
        }

        reverse(n,res,open+1,close,path+"(");
        reverse(n,res,open,close+1,path+")");

    }
}
