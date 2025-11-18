// Written By Lacy Leita (Last Edited: 09/11)

public class GroceryList {
      //instance variables
      static ListNode head;
      ListNode curr;
      ListNode previous;
    
    //internal class ListNode
      private class ListNode{
        //instance variables
        public ListNode link; //same use as 'next'
        public GroceryItem data;

        //default constructor
        public ListNode(){
            data = null;
            link = null;
        }

        //parameterized constructor
        public ListNode(GroceryItem i, ListNode n){
            this.data = i;
            this.link = n;
        }}

        //constructor for GroceryList
        public GroceryList(){
        head = new ListNode(); //initializes head to an empty ListNode
        curr = head; //sets curr to head
        previous = head; } //sets previous to head

        // goToNext method (for GroceryList)
        // moves current node forward by one node.
        public void gotoNext(){
        if (curr != null){ //doesn't move forward if that node is null
            previous = curr;
            curr = curr.link;
        }}

        // getCurrent method (for GroceryList)
        // returns the data at the current node
        public GroceryItem getCurrent(){
        if (curr == null) return null; //checks to see if current is null
        if (curr.data == null && curr.link != null){ //checks to see if current is null
        return curr.link.data;
    }
    return curr.data; //returns the data at the current node
}

        // setCurrent method (for GroceryList)
        public  void setCurrent(GroceryItem i){
        if(curr != null){ //checks to see if the current node is null
            curr.data = i; //sets the data at the current node to that value 
        }
    }
    
        //addItem method (for GroceryList)
        public void addItem(GroceryItem g){
        if(g == null){
            return;
        }
    
        ListNode temp = head; //creates a new ListNode with data assigned to provided item
        while(temp.link != null){ //checks is node is null
            temp = temp.link;
        }
        temp.link = new ListNode(g, null); //adds a new list node to the end of the list

        if(curr == head && head.data == null){
            curr = head.link;
            previous = head;
        }
    
    }

        // addItemAfterCurrent method (for GroceryList)
        public void addItemAfterCurrent(GroceryItem i){
        ListNode newNode = new ListNode(i, null); //creates a new node based on data from parameter.
        if(i == null || head == null){ //checks to see if list is empty/null.
            return;
        }
        else{
            curr.link = newNode; //puts that node after the current position.
        } 
    }
        
        // removeCurrent method (forGroceryList)
        public void removeCurrent(){
        if (curr == null || curr.data == null){ //if curr is null, nothing to remove; if curr.data is null nothing to do.
            return;
        }
        if (curr == head && head.data == null){ //handles remove current if there is a dummy head - which there is in the first item. 
            if(head.link != null ){
                head.link = head.link.link; 
                curr = head;
            } 
            return;
        }  
        if (curr == head){ 
            head = head.link; //removing curr by moving the head to the next node
            curr = head; //move curr to new head
            previous = null; //move previous to null since there is nothing before head.
            return;
        } 
        if(previous != null){ 
            previous.link = curr.link; //skips over curr so the previous node points to the node after it
            curr = curr.link; //advances curr so it points to the next node
        }
        }
    
        //showList method (for GroceryList)
        public  void showList(){
        ListNode temp = head; 
        while(temp!= null){
            if(temp.data!=null){
            System.out.println(temp.data); //prints out the contents of the list
            System.out.println(" ");
        }
        temp = temp.link;
    }
        
    }

        // contains method (for GroceryList)
        public  boolean contains(GroceryItem i){
        ListNode current = head;
        while(current!=null){
            if (current.data != null && current.data.equals(i)){ //checks if current is in linked list
                return true;
            
            }
            current = current.link;
        }
        return false; //if current is not in linked list, return false.
    }

        // totalCost method (for GroceryList)
        public static double totalCost(){
        ListNode temp = head; 
        double sum = 0;
        while(temp!= null){ //adding all the values of the elements in the linked list. 
            if(temp.data != null){
            sum += temp.data.getValue(); //adding to the sum
            }
            temp = temp.link; 
        }
        return sum;
    }

    }

    

    