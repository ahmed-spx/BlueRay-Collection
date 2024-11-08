import java.util.Scanner;

class BlueRayDisk{
    public String title;
    public String director;
    public int year;
    public double cost;

    public BlueRayDisk (String title, String director, int year, double cost){
        this.title = title;
        this.director = director;
        this.year = year;
        this.cost = cost;
    }
    @Override
    public String toString(){
        return "$"+cost+" "+year+" "+title+", "+director;
    }
}
class Node{
    public BlueRayDisk data;
    public Node next;
    public Node (BlueRayDisk data){
        this.data = data;
        this.next = null;
    }

}
class BlueRayCollection{
    private Node head;
    public BlueRayCollection(){
        head = null;
    }
    public void add(String title, String director, int year, double cost){
        BlueRayDisk newBlueRayDisk = new BlueRayDisk(title,director,year,cost);
        Node newNode = new Node(newBlueRayDisk);
        if (head == null){
            head = newNode;
        } else {
            Node currentlyMain = head;
            while (currentlyMain.next != null){
                currentlyMain = currentlyMain.next;
            }
            currentlyMain.next = newNode;
        }
    }
    public void show_all(){
        Node rightNow = head;
        while (rightNow != null){
            System.out.println(rightNow.data.toString());
            rightNow = rightNow.next;
        }
    }
}
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BlueRayCollection collection = new BlueRayCollection();
        boolean quit = false;

        do {
            System.out.println("0. Quit" +
                    "\n1. Add BlueRay to collection" +
                    "\n2. See collection");
            int choice = sc.nextInt();
            switch (choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("What is the title?");
                    String title = sc.next();
                    System.out.println("What is the director? ");
                    String director = sc.next();
                    System.out.println("What is the year of release? ");
                    int year = Integer.parseInt(sc.next());
                    System.out.println("What is the cost? ");
                    double cost = Double.parseDouble(sc.next());
                    collection.add(title,director,year,cost);
                    break;
                case 2:
                    collection.show_all();
                    break;
                default: System.out.println("Invalid number. Choose valid number from menu.");
                break;
            }
        }while (!quit);
    sc.close();
    }
}
