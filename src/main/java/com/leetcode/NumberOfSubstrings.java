package com.leetcode;

import java.util.HashMap;

public class NumberOfSubstrings {
    public int numberOfSubstrings(String s) {
        if (s.length() < 3) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('b', 0);
        map.put('c', 0);
        int i = 0;
        int res = 0;
        for(int j=0; j<s.length(); j++){
            map.computeIfPresent(s.charAt(j), (k,v) -> v+1);
            while(!map.containsValue(0)){
                res += s.length()-j;;
                map.computeIfPresent(s.charAt(i), (k,v) -> v-1);
                i++;
            }
        }
        return res;
    }

}
