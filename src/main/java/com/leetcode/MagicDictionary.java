package com.leetcode;

import java.util.HashMap;
import java.util.Map;

class MagicDictionary {

    private HashMap<String, Integer> map;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        this.map = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String s:dictionary) {
            map.put(s, 1);
            for (int i=1; i<=s.length(); i++) {
                String mutate = s.substring(0,i-1)+'*'+s.substring(i);
                if (map.containsKey(mutate)) {
                    map.computeIfPresent(mutate, (k,v) -> v+1);
                } else {
                    map.put(mutate, 1);
                }
            }
        }
    }

    public boolean search(String searchWord) {
        for (int i=1; i<=searchWord.length(); i++) {
            String mutate = searchWord.substring(0,i-1)+'*'+searchWord.substring(i);
            if (!map.containsKey(searchWord) && map.containsKey(mutate) && map.get(mutate) > 0) {
                return true;
            } else if (map.containsKey(searchWord) && map.get(mutate) > 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[] {"hello", "leetcode"});
        System.out.println(magicDictionary.search("hello"));
        System.out.println(magicDictionary.search("hhllo"));
        System.out.println(magicDictionary.search("hell"));
        System.out.println(magicDictionary.search("leetcoded"));
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */