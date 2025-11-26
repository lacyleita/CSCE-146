//Written by Lacy Leita 
// Last Edited: 11/25/2025
//courseNode class
public class CourseNode {
    int id;
    String courseName;
    boolean completed;
    CourseNode next;

    //constructor for CourseNode
    public CourseNode(int id, String n){
        this.id = id;
        this.courseName = n;
        this.completed = false;
        this.next = null;
    }
}
