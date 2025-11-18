// Written By Lacy Leita (Last Edited: 09/11)

public class GroceryItem {
    private String groceryItemName;
    private double Value;

    public GroceryItem(){
        this.groceryItemName = "none";
        this.Value = 0.0;
    }

    public GroceryItem(String name, double v){
        this.groceryItemName = name; 
        this.Value = v;
    }

    public String getGroceryItemName(){
        return groceryItemName;
    }

    public double getValue(){
        return Value;
    }

    public void setGroceryItem(String name){
        groceryItemName = name;
    }

    public void setPrice(double val){
        Value = val;
    }

    @Override
    public String toString(){
        return "Grocery Item Name: " + groceryItemName + ", Value:  " + Value;
    }

    public boolean equals(GroceryItem item){
            if (this.getGroceryItemName().equals(item.getGroceryItemName()) &&(this.getValue() == item.getValue())){
                return true; 
            }

            return false;
    }
    





    } 
    




