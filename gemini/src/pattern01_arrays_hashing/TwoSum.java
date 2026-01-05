package pattern01_arrays_hashing;

import java.util.HashMap;
import java.util.Map;

/*
    📝 מה השאלה?  
    נתון מערך של מספרים שלמים (nums) ומספר מטרה (target).
    החזר אינדקסים של שני מספרים שסכומם שווה ל-target.
    הנחה: קיים בדיוק פתרון אחד. אסור להשתמש באותו איבר פעמיים.
    
    דוגמה:
    קלט: nums = [2, 7, 11, 15], target = 9
    פלט: [0, 1]
    הסבר: nums[0] + nums[1] == 9 (2 + 7 = 9)
    
    💡 גישה: "המשלים" (Complement) ב-HashMap
    בלולאה אחת: לכל num, נחשב מה חסר לנו (complement = target - num)
    אם המשלים כבר נמצא במפה - מצאנו זוג.
    אם לא, נכניס את המספר הנוכחי והמיקום שלו למפה.
*/

public class TwoSum {
    /**
     * פונקציה שמחזירה את האינדקסים של שני מספרים שסכומם שווה ל-target
     * @param nums מערך מספרים שלמים
     * @param target מספר מטרה
     * @return מערך בגודל 2 עם האינדקסים שמצאנו
     */
    public static int[] twoSum(int[] nums, int target) {
        // TODO: תממש כאן את האלגוריתם באמצעות HashMap (כמו בתיאור למעלה)
        // תכנון:
        // 1. ניצור HashMap<Integer, Integer> שישמור: מספר -> אינדקס
        // 2. נרוץ על המערך, ובכל איטרציה:
        //    - נחפש האם ה-complement (כלומר target - num) קיים במפה
        //    - אם כן, נחזיר [האינדקס של המשלים, האינדקס הנוכחי]
        //    - אחרת, נכניס את num והאינדקס שלו למפה
        
        // דוגמה לקוד:
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < nums.length; i++) {
        //     int complement = target - nums[i];
        //     if (map.containsKey(complement)) {
        //         return new int[] { map.get(complement), i };
        //     }
        //     map.put(nums[i], i);
        // }
        // return null; // אם לא מוצאים, נחזיר null (אבל לפי ההנחה תמיד יש פתרון)

        // כתוב כאן את הפתרון
        return null; // TODO: remove this line אחרי שתפתור
    }
    
    public static void main(String[] args) {
        // דוגמת בדיקה: זאת הדרך לבדוק את עצמך
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("תוצאה: [" + (result != null ? result[0] : "?") + ", " + (result != null ? result[1] : "?") + "]");
        // התוצאה הצפויה: [0, 1]
    }
}
