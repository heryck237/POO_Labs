package ObjectList;

public class Test {

    public static void Assert(boolean p, String msg) {
        if (!p) {
            throw new RuntimeException("Assertion failed - " + msg);
        }
    }

    public static void Assert(boolean p) {
        if (!p) {
            Assert(p, "");
        }
    }

    public static ObjectList fromArray(Object[] arr) {
        var ls = new ObjectList();
        for (var x : arr) {
         //   ls.append(x);
        }
        return ls;
    }

    public static boolean compare(ObjectList ls, Object[] arr) {
        if (ls.size() != arr.length) return false;

        int i = 0;

        Examinator ex = ls.examinator();

        while (ex.hasNext()) {
            if (arr[i++] != ex.next()) return false;
        }
        return true;
    }

    public static void testCompare() {
        Assert(compare(new ObjectList(), new Object[] {}));

        var array = new Integer[] {1, 2, 3};
        Assert(compare(fromArray(array), array));
    }

    public static void testIsEmpty() {
        var ls = new ObjectList();
        Assert(ls.isEmpty());

        ls = fromArray(new Integer[] {1});
        Assert(!ls.isEmpty());

        ls = fromArray(new Integer[] {1, 2, 3});
        Assert(!ls.isEmpty());
    }

    public static void testSize() {
        var ls = new ObjectList();
        Assert(ls.size() == 0);

        ls = fromArray(new Integer[] {1, 2, 3});

        Assert(ls.size() == 3);
    }

    public static void testToString() {
        var ls = new ObjectList();
        Assert(ls.toString() == "");

        ls = fromArray(new Integer[] {1, 2, 3});

        Assert(ls.toString().equals("1, 2, 3"));
    }

    public static void testGet() {
        var ls = new ObjectList();

        boolean hasThrown = false;
        try {
            ls.get(0);
            ls.get(-1);
            ls.get(1);
        } catch (IndexOutOfBoundsException ex) {
            hasThrown = true;
        }
        Assert(hasThrown);

        var arr = new Integer[] {1, 2, 3};

        ls = fromArray(arr);
        for (int i = 0; i < arr.length; ++i) Assert(ls.get(i) == arr[i]);
    }

    public static void testAppend() {
        var ls = new ObjectList();

        ls.append(1);
        Assert(ls.size() == 1);

        ls.append(2);
        Assert(ls.size() == 2);

        ls.append(4);
        Assert(ls.size() == 3);

        Assert((int) ls.get(0) == 1);
        Assert((int) ls.get(1) == 2);
        Assert((int) ls.get(2) == 4);
    }

    public static void testRemove() {
        var ls = new ObjectList();
        ls.remove(5); // shouldn't throw.
        Assert(ls.size() == 0);

        var arr = new Object[] {1, 2, 6, 3, 4, 5, 6, 6, 6, 7, 8};
        ls = fromArray(arr);

        // removing non existent doesn't affect size
        Assert(ls.size() == arr.length);
        ls.remove(944);
        compare(ls, arr);
        Assert(ls.size() == arr.length);

        // remove from head
        ls.remove(1);
        compare(ls, new Object[] {2, 6, 3, 4, 5, 6, 6, 6, 7, 8});

        // remove from tail.
        ls.remove(8);
        compare(ls, new Object[] {2, 6, 3, 4, 5, 6, 6, 6, 7});

        // remove an element in the middle
        ls.remove(5);
        compare(ls, new Object[] {2, 6, 3, 4, 6, 6, 6, 7});

        // remove a repeat element
        ls.remove(6);
        compare(ls, new Object[] {2, 3, 4, 7});
    }

    public static void testInsert() {
        var ls = new ObjectList();
        ls.insert(1);
        Assert(ls.size() == 1);

        ls.insert(2);
        Assert(ls.size() == 2);

        ls.insert(4);
        Assert(ls.size() == 3);

        Assert((int) ls.get(0) == 4);
        Assert((int) ls.get(1) == 2);
        Assert((int) ls.get(2) == 1);
    }

    public static void testExaminator() {
        var ls = new ObjectList();

        var examinator = ls.examinator();

        Assert(!examinator.hasNext());

        var arr = new Integer[] {1, 2, 3};
        ls = fromArray(arr);
        examinator = ls.examinator();

        Assert(examinator.hasNext());
        Assert((int) examinator.next() == 1);
        Assert(examinator.hasNext());
        Assert((int) examinator.next() == 2);
        Assert(examinator.hasNext());
        Assert((int) examinator.next() == 3);
        Assert(!examinator.hasNext());

        examinator = ls.examinator();
        Assert(examinator.hasNext());
        Assert((int) examinator.next() == 1);
    }

    public static void main(String[] args) {
     //   testCompare();
 //       System.out.println("[PASSED] testCompare");
        testIsEmpty();
        System.out.println("[PASSED] testIsEmpty");
        testSize();
        System.out.println("[PASSED] testSize");
        testToString();
        System.out.println("[PASSED] testToString");
        testGet();
        System.out.println("[PASSED] testGet");
        testAppend();
        System.out.println("[PASSED] testAppend");
        testRemove();
        System.out.println("[PASSED] testRemove");
        testExaminator();
       System.out.println("[PASSED] testExaminator");
    }
}
