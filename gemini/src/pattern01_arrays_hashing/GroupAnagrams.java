package pattern01_arrays_hashing;

import java.util.*;

/*
    📝 מה השאלה?
    קלט: מערך של מחרוזות.
    משימה: קבץ יחד כל מחרוזות שהן אנגרמה זו של זו (כל קבוצה מכילה מילים שמורכבות מאותן אותיות בדיוק, כל אחת אולי בסדר אחר).
    הפלט: רשימה של רשימות - כל רשימה פנימית היא קבוצת אנגרמות.

    דוגמא:
    קלט: ["eat", "tea", "tan", "ate", "nat", "bat"]
    פלט אפשרי (הסדר הפנימי לא משנה): [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]

    ---
    💡 רמז לגישה:
    - כל אנגרמות, כאשר נבצע להן מיון תווים (sort), מקבלות אותה "תבנית" בסיסית.
    - אפשר להשתמש ב-HashMap: מפתח = המילה אחרי מיון תווים, ערך = רשימת כל המילים שהן אנגרמה.
    - בסוף נאסוף את כל הקבוצות ל-List של קבוצות.
*/

public class GroupAnagrams {

    public static void main(String[] args) {
        // Test 1: המקרה הקלאסי
        String[] input1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Test 1 Input: " + Arrays.toString(input1));
        System.out.println("Test 1 Result: " + groupAnagrams(input1));
        // צפוי (סדר לא משנה): [[eat, tea, ate], [bat], [tan, nat]] 

        System.out.println("-------------------");

        // Test 2: מחרוזת ריקה (מקרה קצה נפוץ)
        String[] input2 = {""};
        System.out.println("Test 2 Input: " + Arrays.toString(input2));
        System.out.println("Test 2 Result: " + groupAnagrams(input2));
        // צפוי: [[""]]

        System.out.println("-------------------");

        // Test 3: אות אחת
        String[] input3 = {"a"};
        System.out.println("Test 3 Input: " + Arrays.toString(input3));
        System.out.println("Test 3 Result: " + groupAnagrams(input3));
        // צפוי: [["a"]]
        
        System.out.println("-------------------");

        // Test 4: ללא אנגרמות בכלל
        String[] input4 = {"hello", "world", "java"};
        System.out.println("Test 4 Input: " + Arrays.toString(input4));
        System.out.println("Test 4 Result: " + groupAnagrams(input4));
        // צפוי: [[hello], [world], [java]]
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        // נסה ליישם על פי הרמזים: מפתח=סידור (sort) של המילה, ערך=רשימה של מילים תואמות
        // תוכל לבדוק את עצמך לפי הדוגמאות למעלה
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());


    }
}