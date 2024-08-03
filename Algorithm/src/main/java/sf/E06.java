package sf;

import java.util.ArrayList;
import java.util.List;

public class E06 {
    public String convert(String s, int numRows) {
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i <numRows ; i++) {
            list.add(new StringBuilder());
        }
        int i = 0;
        int flag =-1;
        for (char c : s.toCharArray()) {
            StringBuilder sb = list.get(i);
            sb.append(c);
            if (i==0||i==numRows-1){
                flag = -flag;
            }
            i+=flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            res.append(stringBuilder);
        }

        return res.toString();
    }
}
