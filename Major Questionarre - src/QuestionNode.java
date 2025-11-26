//Written by Lacy Leita 
// Last Edited: 11/25/2025
//QuestionNode class
public class QuestionNode {

    int id;
    String questionText;
    boolean isMajor;
    QuestionNode yes;
    QuestionNode no;
    String major;
    //boolean isMajor; 

    //Constructor for question node
    public QuestionNode(int id, String t, boolean m){
        this.id = id;
        this.isMajor = m;
        this.yes = null;
        this.no = null;

        if(m){
            this.major = t;
            this.questionText = null;
        } else {
            this.questionText = t;
            this.major = null;
        }
    }

    //isLeaf method, checks if a node is a leaf
    public boolean isLeaf(){
        return (yes == null && no == null);
    }
    
    //toString method
    @Override
    public String toString(){
        if(isLeaf()){
            return major;
        } else {
            return questionText;
        }
    }
}
