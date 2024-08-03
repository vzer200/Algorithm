package sf;

public class E76 {
    //最小覆盖子串
    //s = "ADOBECODEBANC", t = "ABC"

    static class result{
        int i ;
        int j ;

        public result(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public String minWindow(String s, String t) {
        int[] array1 = new int[128];
        int[] array2 = new int[128];
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        result res = null;
        for (int i = 0; i < chars2.length; i++) {
            array2[chars2[i]]++;
        }

        int passed = 0;
        int total =  0;
        for (int i : array2) {
            if (i!=0)
                total++;
        }


        int i = 0;
        int j = 0;
        while(j<chars1.length){
            char right = chars1[j];
            array1[right]++;
            if (array1[right]==array2[right]){
                passed++;
            }
            while (i<=j&&passed==total){
                if (res==null){
                    res = new result(i,j);
                }else {
                    if (j-i<res.j-res.i){
                        res = new result(i,j);
                    }
                }
                char left = chars1[i];
                array1[left]--;
                if (array1[left]<array2[left]){
                    passed--;
                }
                i++;
            }

            j++;
        }
        return res==null?"":new String(chars1, res.i, res.j- res.i+1);
    }
}
