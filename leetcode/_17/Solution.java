package _17;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 17. letter-combinations-of-a-phone-number
 * Created by didi on 20/01/2018.
 */
public class Solution {
    private static Map<Integer, String> map = new HashMap();

    static {
//        map.put(0, " ");
//        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        System.out.println("init static code block!");
    }

    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        core(digits, digits.length(), 0, "", res);
        return res;
    }

    private String getLetters(char c) {
        if (c >= '2' && c <= '9') {
            return map.get(c - '0');
        }
        return null;
    }

    /*
    cur: 本次函数中,需要解码的元素索引.
    pre: digits[0..cur-1]解码结果.
    r: 存放digits[0..n-1]解码的结果
    //把digits[cur..n-1]解码连接到pre后,放入r中.
     */
    private void core(String digits, int n, int cur, String pre, List<String> r) {
        if (pre.length() == n) {
            r.add(pre);
            return;
        }
        String letters = getLetters(digits.charAt(cur));
        for (int i = 0; i < letters.length(); i++) {
            core(digits, n, cur + 1, pre + letters.charAt(i), r);
        }
    }

    //功能测试
    @Test
    void test1() {
        List<String> r = letterCombinations("23");
        assertArrayEquals(new String[]{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"}, r.toArray());
    }

    //边界测试
    @Test
    void test2() {
        List<String> r = letterCombinations("2");
        assertArrayEquals(new String[]{"a", "b", "c"}, r.toArray());
    }

    //特殊输入测试
    @Test
    void test3() {
        List<String> r = letterCombinations("");
        System.out.println(r);
        System.out.println(r.size());

        r = letterCombinations("0");
        System.out.println(r);
        System.out.println(r.size());

        r = letterCombinations("1");
        System.out.println(r);
        System.out.println(r.size());

        r = letterCombinations("01");
        System.out.println(r);
        System.out.println(r.size());

        r = letterCombinations("10");
        System.out.println(r);
        System.out.println(r.size());
    }
}
