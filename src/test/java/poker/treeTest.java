package poker;

import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

/**
 * treeTest
 */
public class treeTest {

    @Test
    public void treeDupliTest() {
        SortedSet<Integer> s = new TreeSet<>();
        s.add(5);
        s.add(10);
        s.add(15);
        s.add(2);
        s.add(8);
        s.add(9);
        s.add(5);
        s.add(5);
        System.out.println("treeSet : " + s.toString());
    }
}