//Written by Lacy Leita 
// Last Edited: 11/25/2025
//CourseList class
public class CourseList{
    CourseNode head;
    private int nextId = 0;

    //add method, adds course
    public void add(String name){
        CourseNode newNode = new CourseNode(nextId++, name);
        if(head == null){
            head = newNode;
        } else {
            CourseNode curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    //markComplete method, marks a course complete
    public boolean markComplete(String name){
        CourseNode curr = head;
        while (curr != null){
            if (curr.courseName.equalsIgnoreCase(name)){
                curr.completed = true;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }   

    //printIncomplete method, prints the courses you still need
    public void printIncomplete(){
        CourseNode curr = head;
        boolean courses0 = false;
        while(curr!=null){
            if(!curr.completed){
                System.out.println(curr.courseName);
                courses0 = true;
            }
            curr = curr.next;
        }
        if(!courses0){
            System.out.println("No courses! you have completed all the required courses! YAY!");
        }
    }
    
    public void printComplete(){
        CourseNode curr = head;
        boolean courses0 = false;
        while( curr !=head){
            if(curr.completed){
                System.out.println(curr.courseName);
                courses0 = true;
            }  
            curr = curr.next;
         }
         if(!courses0){
            System.out.println("None completed yet!");
         }
}}