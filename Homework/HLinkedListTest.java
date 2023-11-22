import javax.xml.transform.Source;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class HLinkedListTest {
    public static void main(String[] args) {
        HLinkedList list = new HLinkedList();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Sedef DÖNMEZ\\workplace\\data2024\\Homework\\Source.txt"))) {
            String line;
            while((line = bufferedReader.readLine()) != null)  {
                String[] values = line.split(",");
                for(String value :values) {
                    if(value.trim().isEmpty()) {
                        continue;
                    }
                    int intValue = Integer.parseInt(value.trim());
                    if(!list.search1(intValue)) {
                        list.addEndForSource((intValue));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        HLinkedList list2 = new HLinkedList();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Sedef DÖNMEZ\\workplace\\data2024\\Homework\\Search.txt"))) {
            String line;
            while((line = bufferedReader.readLine()) != null)  {
                String[] values = line.split(",");
                for(String value :values) {
                    if(value.trim().isEmpty()) {
                        continue;
                    }
                    int intValue = Integer.parseInt(value.trim());
                    list2.addEndForSearch((intValue));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        // for 4th question--------------------
        long startTimeSearch = System.nanoTime();
        list2.search(2);
        long endTimeSearch = System.nanoTime();
        long time = endTimeSearch - startTimeSearch;


        long startTimeQuestion3 = System.nanoTime();
        list2.question3(2);
        long endTimeQuestion = System.nanoTime();
        long time2 = endTimeQuestion - startTimeQuestion3;

        System.out.println("Time for question3: " + time2 + " nanoseconds");
        System.out.println("Time for search: " + time + " nanoseconds");

        if (time2 < time) {
            System.out.println("question3 is faster.");
        } else if (time2 > time) {
            System.out.println("search is faster.");
        } else {
            System.out.println("Both methods have similar execution times.");
        }
        // ----------------------------------------------------------


        System.out.println("Linked List after adding values form Source.txt");
        list.display();

        System.out.println("Trying addEnd Method");
        list.addEndSource(1526);
        list.display();
        System.out.println("Trying to add a node that already inserted");
        list.addEndSource(1526);



    }


}
