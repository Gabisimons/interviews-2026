# ☕ Java Interview Cheat Sheet 🚀
> סיכום פקודות, תחביר וטיפים לראיונות עבודה בג'אווה

---

## 1. 🧵 Strings (מחרוזות)

**חשוב:** מחרוזות הן `Immutable`. כל שינוי יוצר אובייקט חדש.

| פעולה           | קוד                          | הערות                   |
|-----------------|-----------------------------|-------------------------|
| **אורך**        | `str.length()`              | עם סוגריים!             |
| **גישה לתו**    | `str.charAt(i)`             | לא `str[i]`             |
| **חיתוך**       | `str.substring(start, end)` | ה-`end` לא נכלל         |
| **השוואה**      | `str.equals(other)`         | **אסור** ב-`==`         |
| **מערך תווים**  | `str.toCharArray()`         | המרה ל-`char[]`         |
| **פיצול**       | `str.split(" ")`            | מחזיר `String[]`        |
| **ניקוי רווחים**| `str.trim()`                | מסיר מהתחלה/סוף         |

### ⚡ יעילות (StringBuilder)
אם בונים מחרוזת בלולאה, **חובה** להשתמש ב-`StringBuilder` כדי להימנע מסיבוכיות $O(N^2)$.

```java
StringBuilder sb = new StringBuilder();
sb.append("Hello");
sb.append(123);
sb.reverse();       // שימושי לשאלות היפוך!
String res = sb.toString();
```

---

## 2. 📦 Collections (מבני נתונים)

### 📋 List (רשימה דינמית)
```java
List<Integer> list = new ArrayList<>();
list.add(5);           // הוספה
list.get(0);           // שליפה (אינדקס)
list.size();           // גודל
list.remove(index);    // מחיקה לפי אינדקס
list.contains(5);      // O(N) - חיפוש איטי
```

### 🗺️ Map (מילון / Hash) - ⭐ הכי חשוב
```java
Map<String, Integer> map = new HashMap<>();
map.put("Key", 100);         // הכנסה
map.get("Key");              // שליפה (null אם לא קיים)
map.containsKey("Key");      // O(1)

// 🔥 ספירת מופעים חכמה
map.put(key, map.getOrDefault(key, 0) + 1);

// לולאה על map
for (String key : map.keySet()) {
    int value = map.get(key);
}
```

### 🦄 Set (קבוצה ייחודית)
```java
Set<Integer> set = new HashSet<>();
set.add(1);        // true אם נוסף חדש, false אם כבר קיים
set.contains(1);   // O(1)
```

### 📚 Stack & Queue (מחסנית ותור)
```java
// Stack (LIFO)
Deque<Integer> stack = new ArrayDeque<>();
stack.push(1);     // דחיפה
stack.pop();       // שליפה והסרה
stack.peek();      // הצצה

// Queue (FIFO)
Queue<Integer> queue = new LinkedList<>();
queue.offer(1);    // הוספה לסוף
queue.poll();      // שליפה מההתחלה
```

### 🔝 PriorityQueue (Heap)
ברירת מחדל: Min Heap (הכי קטן למעלה).
```java
// Min Heap
PriorityQueue<Integer> minHeap = new PriorityQueue<>();

// Max Heap
PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

minHeap.offer(10);
minHeap.poll();    // מוציא את הקיצון
```

---

## 3. 🔢 Arrays (מערכים רגילים)
שימו לב: למערך יש `length` (בלי סוגריים), למחרוזת יש `length()`.

```java
int[] arr = new int[5];            // {0, 0, 0, 0, 0}
Arrays.sort(arr);                  // מיון O(N log N)
Arrays.fill(arr, -1);              // מילוי כל התאים בערך
Arrays.toString(arr);              // להדפסה יפה
int[] copy = Arrays.copyOf(arr, 3); // חיתוך/העתקה
```

---

## 4. 🔀 Conversions (המרות)
נקודת נפילה נפוצה בראיונות.  
| המרה                | קוד                               |
|---------------------|-----------------------------------|
| String ➔ int        | `Integer.parseInt("123")`         |
| int ➔ String        | `String.valueOf(123)`             |
| char ➔ int          | `Character.getNumericValue('5')`<br/>או `'5' - '0'` |
| Array ➔ List        | `Arrays.asList("a", "b")` (רשימה בגודל קבוע)        |

---

## 5. 🧮 Math & Numbers

```java
int max = Math.max(a, b);
int min = Math.min(a, b);
int abs = Math.abs(-5);
double pow = Math.pow(2, 3); // 2^3

// אתחול למציאת מינימום/מקסימום
int minVal = Integer.MAX_VALUE;   // מתחילים מהכי גדול
int maxVal = Integer.MIN_VALUE;   // הכי קטן
```

---

## 6. ⚖️ Comparators (מיון מותאם אישית)
שימושי למיון אובייקטים, מערכים דו-ממדיים, או סדר מיוחד.

```java
// מיון אינטרוולים [start, end] לפי start
Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

// מיון יורד (Descending)
Arrays.sort(arr, (a, b) -> b - a);
```
> **טיפ:** השתמשו ב-`Integer.compare(a, b)` במקום `a - b` כדי למנוע Overflow במספרים גדולים.

---

## 🧠 תבניות נפוצות (Patterns)

- **Two Pointers:** מערך ממוין, חיפוש זוגות, היפוך מערך.
- **Sliding Window:** תת-מערך רציף (Subarray), מקסימום/מינימום בגודל K.
- **HashMap:** ספירת תדרים, מציאת כפילויות, Two Sum (לא ממוין).
- **Binary Search:** מערך ממוין, $O(\log N)$.

---