package NoDuplicates;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class NoDup {

    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>(Arrays.asList(args));

        Iterator<String> iterator = set.iterator();

        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }

    }
}
