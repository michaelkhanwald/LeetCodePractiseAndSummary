package com.google;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/6/19
 * Talk is Cheap,Show me the Code.
 **/
public class StrobogrammaticNumberII247M {
    public List<String> findStrobogrammatic(int n) {
        List<String> ans = new ArrayList<>();
        char[] tmp = new char[n];
        helper( ans, tmp, 0, n - 1);
        return ans;
    }

    public void helper(List<String> ans, char[] tmp, int l, int r) {
        if (l > r) {
            ans.add(new String(tmp));
            return;
        }
        if (l == r) {
            tmp[l] = '0'; //这里不需要判断l == 0,不然 n = 1 case会失败,走到这里的也只有是中间的或者n =1时候才会有l == r
            ans.add(new String(tmp));
            tmp[l] = '1';
            ans.add(new String(tmp));
            tmp[l] = '8';
            ans.add(new String(tmp));
            return;
        }

        if (l != 0) {
            tmp[l] = tmp[r] = '0';
            helper( ans, tmp, l + 1, r - 1);
        }

        tmp[l] = tmp[r] = '1';
        helper( ans, tmp, l + 1, r - 1);

        tmp[l] = tmp[r] = '8';
        helper(ans, tmp, l + 1, r - 1);

        tmp[l] = '6';
        tmp[r] = '9';
        helper( ans, tmp, l + 1, r - 1);
        tmp[l] = '9';
        tmp[r] = '6';
        helper(ans, tmp, l + 1, r - 1);

    }
}
