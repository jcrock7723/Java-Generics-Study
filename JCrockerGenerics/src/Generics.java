import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Chapter 19 - CSC 251 - Halsey
 * Jeremy Crocker
 */


public class Generics {

    public static void main(String[] args) {

    //Create Arrays and make calls using different methods
    Integer[] intList = {1,4,5,6,7,10,11,23,42,56};
    Character[] charList = {'E', 'R', 'T', 'S', 'T', 'B', 'X', 'I'};
    String[] nameList = {"Sam", "Mary", "Kesha", "Dom", "Bill", "John", "Kevin"};

    // Create an ArrayList of Characters
    ArrayList<Character> characterArrayList = new ArrayList<>();
    characterArrayList.add('E');
    characterArrayList.add('R');
    characterArrayList.add('T');
    characterArrayList.add('S');
    characterArrayList.add('T');
    characterArrayList.add('B');
    characterArrayList.add('X');
    characterArrayList.add('I');

    //Create an ArrayList of 10 random numbers between 1-99
    Random random = new Random();
    ArrayList<Integer> integerArrayList = new ArrayList<>(); //(Collections.nCopies(10, n )) = All the same number
        for (int i = 0; i<10; i++) {
            integerArrayList.add(random.nextInt(50) +1);
        }

    //Create an ArrayList of Names in the current nameList
    ArrayList<String> nameArrayList = new ArrayList<>();
    for (String s: nameList)
    nameArrayList.add(s);

    //make calls to the different methods using different 3 different types of data
    //Calls to binarySearch Method
    printList(intList);
    System.out.println("Binary search for 7 returns an index of " + binarySearch(intList, 7) + "\n");

    printList(charList);
    System.out.println("Binary search for B returns an index of " + binarySearch(charList, 'B') + "\n");

    printList(nameList);
    System.out.println("Binary search for Dom returns an index of " + binarySearch(nameList, "Dom") + "\n");
    System.out.println();

    //Calls to shuffle  and sort method with ArrayLists
    printMe(integerArrayList);
    shuffle(integerArrayList);
    sort(integerArrayList);

    // Process Characters
    printMe(characterArrayList);
    shuffle(characterArrayList);
    sort(characterArrayList);

    //Process Strings
    printMe(nameArrayList);
    shuffle(nameArrayList);
    sort(nameArrayList);


    }



    //19.7
    //Generic Binary Search
    public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
        int index = 0;
        for (int i = 0; i< list.length; i++, index++)
            if(list[i] == key)
                break;
        return index;
    }



    //19.8
    //Shuffle ArrayList - *Hint* Use random numbers generator
    public static <E> void shuffle(ArrayList<E> list) {

        //Use Collections to shuffle to test
        //Collections.shuffle(list);

        Random randomRun = new Random();
        E current;
        int currentIndex;

        // Set a loop to run a random number of times
        for (int i = 0; i < list.size()-1; i++) {
            current = list.get(i);
            currentIndex = i;

            // use a random number for the index, has to be within range of the ArrayList
            int n = randomRun.nextInt(list.size()-1);

            //Swap the current value with current index with the randomly chosen one
            list.set(currentIndex, list.get(n));
            list.set(n, current);

        }

        System.out.println("After a shuffle it is " + list );
    }



    //19.9
    //Sort ArrayList
    public static <E extends Comparable<E>> void sort(ArrayList<E> list ) {

        // Use Collections to sort to test
        //Collections.sort(list);

        // Work it out
        E currentMin;
        int currentMinIndex;

        for (int i = 0; i < list.size() - 1; i++) {
            //Find the minimum in the list
            currentMin = list.get(i);
            currentMinIndex = i;

            for (int j = i + 1; j < list.size(); j++) {
                //Use the CompareTo
                if (currentMin.compareTo(list.get(j)) > 0) {
                    //if its not greater than set it to the min
                    currentMin = list.get(j);
                    currentMinIndex = j;
                }
            }

            //Swap and set the list.get(i) with the current min if necessary
            if (currentMinIndex != i) {
                list.set(currentMinIndex, list.get(i));
                list.set(i, currentMin);
            }
        }


        System.out.println("After a sort the list is " + list + "\n");
    }


    // Generic print method for ArrayLists
    public static <T> void printMe(ArrayList<T> x) {
        System.out.print("The Original list was ");
        for (T o : x)
            System.out.printf("%s ", o);
        System.out.println();
    }

    // Generic print method for lists
    public static <E> void printList(E[] x) {
        System.out.print("In the List ");
        for (E o : x)
            System.out.printf("%s ", o);
        System.out.println();
    }

}
