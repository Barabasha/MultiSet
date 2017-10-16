package MultiSet;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestMultiSet {

    @Test
    public void testSize() {
        List<TestClass> listNull = new ArrayList<TestClass>();
        MultiSet<TestClass> multiSetNull = new MultiSet<TestClass>(listNull);

        List<TestClass> list = new ArrayList<TestClass>();
        list.add(new TestClass("Ivanov", 20));
        list.add(new TestClass("Petrov", 25));
        MultiSet<TestClass> multiSet = new MultiSet<TestClass>(list);

        assertEquals(multiSetNull.size(), 0);
        assertEquals(multiSet.size(), 2);
    }

    @Test
    public void testAdd() {
        List<TestClass> list = new ArrayList<TestClass>();
        list.add(new TestClass("Ivanov", 20));
        list.add(new TestClass("Petrov", 25));
        MultiSet<TestClass> multiSet = new MultiSet<TestClass>(list);

        assertEquals(multiSet.size(), 2);
    }

    @Test
    public void testFrequencyElem() {
        List<TestClass> list = new ArrayList<TestClass>();
        TestClass person1 = new TestClass("Ivanov", 20);
        TestClass person2 = new TestClass("Petrov", 25);
        TestClass person3 = new TestClass("Sidorov", 30);
        list.add(person1);
        list.add(person1);
        list.add(person2);
        MultiSet<TestClass> multiSet = new MultiSet<TestClass>(list);

        assertEquals(multiSet.frequencyElem(person3), 0);
        assertEquals(multiSet.frequencyElem(person1), 2);
    }

    @Test
    public void testUnion() {
        List<TestClass> list1 = new ArrayList<TestClass>();
        List<TestClass> list2 = new ArrayList<TestClass>();
        List<TestClass> listUnion = new ArrayList<TestClass>();
        TestClass person1 = new TestClass("Ivanov", 20);
        TestClass person2 = new TestClass("Petrov", 25);
        TestClass person3 = new TestClass("Sidorov", 30);
        list1.add(person1);
        list1.add(person2);
        list2.add(person3);
        MultiSet<TestClass> multiSet1 = new MultiSet<TestClass>(list1);
        MultiSet<TestClass> multiSet2 = new MultiSet<TestClass>(list2);
        multiSet1.union(multiSet2);
        listUnion.add(person1);
        listUnion.add(person2);
        listUnion.add(person3);
        MultiSet<TestClass> multiSetUnion = new MultiSet<TestClass>(listUnion);

        assertEquals(multiSet1.isSubSet(multiSetUnion), true);
        assertEquals(multiSetUnion.isSubSet(multiSet1), true);
    }

    @Test
    public void testIsSubSet() {
        List<TestClass> list1 = new ArrayList<TestClass>();
        List<TestClass> list2 = new ArrayList<TestClass>();
        TestClass person1 = new TestClass("Ivanov", 20);
        TestClass person2 = new TestClass("Petrov", 25);
        list1.add(person1);
        list1.add(person2);
        list2.add(person1);
        MultiSet<TestClass> multiSet1 = new MultiSet<TestClass>(list1);
        MultiSet<TestClass> multiSet2 = new MultiSet<TestClass>(list2);

        assertEquals(multiSet2.isSubSet(multiSet1), true);
        assertEquals(multiSet1.isSubSet(multiSet2), false);
    }

    @Test
    public void testIntersect() {
        List<TestClass> list1 = new ArrayList<TestClass>();
        List<TestClass> list2 = new ArrayList<TestClass>();
        List<TestClass> listIntersect = new ArrayList<TestClass>();
        TestClass person1 = new TestClass("Ivanov", 20);
        TestClass person2 = new TestClass("Petrov", 25);
        TestClass person3 = new TestClass("Sidorov", 30);
        list1.add(person1);
        list1.add(person2);
        list2.add(person2);
        list2.add(person3);
        listIntersect.add(person2);

        MultiSet<TestClass> multiSet1 = new MultiSet<TestClass>(list1);
        MultiSet<TestClass> multiSet2 = new MultiSet<TestClass>(list2);
        MultiSet<TestClass> multiSetResult = multiSet1.intersect(multiSet2);
        MultiSet<TestClass> multiSetIntersect = new MultiSet<TestClass>(listIntersect);

        assertEquals(multiSetResult.isSubSet(multiSetIntersect), true);
        assertEquals(multiSetIntersect.isSubSet(multiSetResult), true);
    }
}

