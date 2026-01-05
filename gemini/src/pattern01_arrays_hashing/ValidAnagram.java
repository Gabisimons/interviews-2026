package pattern01_arrays_hashing;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String[] args) {
        // טסטים לבדיקה עצמית
        String s1 = "anagram", t1 = "nagaram";
        String s2 = "rat", t2 = "car";

        System.out.println("Test 1 (Expected: true): " + isAnagram(s1, t1));
        System.out.println("Test 2 (Expected: false): " + isAnagram(s2, t2));
    }

    public static boolean isAnagram(String s, String t) {
        // --- כאן תכתוב את הפתרון שלך ---
        if (s.length() != t.length()) {
            return false;            
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (int value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}