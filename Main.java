import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Library {
     ArrayList<String> queue = new ArrayList<String>(); //string arraylist
     public void addItem(String item){ queue.add(item); } //adds item
     public void removeItem(String item){ queue.remove(item); } //removes item
     public String getNextItem(){ return queue.size() > 0 ? queue.get(0) : ""; } //gets the next item and if there isnt any return nothing
     public void skipNextItem(){ if(queue.size() > 0) queue.remove(0); } // skips next item if it exists
     public void sortAlphabet(){ queue.sort((a, b) -> a.compareTo(b)); } //sorts in alphabetical order
     public void shuffle(){ queue.sort((a, b) -> new Random().nextInt()); } //sorts it randomly
     public int find(String item){ return queue.indexOf(item); } //gets the index of an item
}

public class Main {
  public static void main(String args[]) {
    Library l = new Library();
    Scanner s = new Scanner(System.in);
    
    //user option
    System.out.println("Play - Now Playing: (Item).\nSkip - Skips the current item in the library.\nAdd - Adds a new item to the end of the library.\nRemove - Removes an item from the library, if it exists.\nSort - Sorts the library alphabetically.\nShuffle - Randomizes the library\nFind - Returns the position of the item, or indicates that item does not exist.\nExit - Quits the program.");
    String option = s.nextLine().toLowerCase();
    
    //options
    if(option == "play"){
        String song = l.getNextItem();
        l.skipNextItem();
        System.out.println("Now playing: " + song);
    }
    if(option == "skip"){
        l.skipNextItem();
    }
    if(option == "add"){
        System.out.print("Enter song: ");
        String song = s.nextLine();
        l.addItem(song);
    }
    if(option == "remove"){
        System.out.print("Enter song: ");
        String song = s.nextLine();
        l.removeItem(song);
    }
    if(option == "sort"){
        l.sortAlphabet();
    }
    if(option == "shuffle"){
        l.shuffle();
    }
    if(option == "find"){
        //finds position of song. if -1 then not found
        System.out.print("Enter song: ");
        String song = s.nextLine();
        int i = l.find(song);
        if(i > 0) System.out.println("position: " + i);
        else System.out.println("item doesnt exist");
    }
    if(option == "exit"){
        System.exit(0);
    }
    
  }
}
