
import java.util.ArrayList;
import java.util.Scanner;

public class listMaker
{
    public static ArrayList<String> myArrList = new ArrayList<>();
    public static Scanner in = new Scanner(System.in);
    public static boolean query = false;
    public static int index = 1;
    public static void main(String[] args)
    {

        String menuCommand;
        do {
            printMyList("Current list:");
            menuCommand = SafeInput.getRegExString(in,"Select a menu command\n" +
                    "A – Add an item to the list\n" +
                    "D – Delete an item from the list\n" +
                    "I – Insert an item into the list\n" +
                    "P – Print the list\n" +
                    "Q – Quit the program\n", "[AaDdIiPpQq]");

            if(menuCommand.equalsIgnoreCase("a"))
                addItem("You selected A");
            if(menuCommand.equalsIgnoreCase("d"))
                delete("You selected D");
            if(menuCommand.equalsIgnoreCase("I"))
                insert("You selected I");
            if(menuCommand.equalsIgnoreCase("p"))
                printMyList("You selected P");
            if(menuCommand.equalsIgnoreCase("q"))
                query = quit(in,"You selected Q");


        }while(!query);




    }

    public static void addItem (String echo){
        System.out.println(echo);
        myArrList.add((SafeInput.getNonZeroLenString(in,"Enter a new element to add to the list")));
        index++; // start at one but subtract one in code for delete method
    }
    public static void delete (String echo){
        System.out.println(echo);
        index = SafeInput.getRangedInt(in,"Select an element from the list to delete",1,myArrList.size())-1;
        myArrList.remove(index);
    }
    public static void insert(String echo){
        System.out.println(echo);
        index =  SafeInput.getRangedInt(in,"Select where you want to put this new element",1,myArrList.size())-1;
        myArrList.add(index,(SafeInput.getNonZeroLenString(in,"Enter a new element for this position in the list")));

    }
    public static void printMyList(String echo){
        System.out.println(echo);
        for(index=1; index<=myArrList.size();index++){
            System.out.println(index + ". "+myArrList.get(index-1));
        }
        System.out.println();
    }
    public static boolean quit (Scanner pipe,String echo){
        System.out.println(echo);
        return SafeInput.getYNConfirm(pipe,"Are you sure you want to quit the program");

    }
}