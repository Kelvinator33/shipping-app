package Test;
import containers.*;
import items.*;
import methods.*;
import java.util.*;

public class test {

	public static void main(String[] args) {
		
		
		//create an array list to store the products available for shipping
		
		ArrayList<item> Aproducts= new ArrayList<>();
		Calculation c=new Calculation();
		Aproducts.addAll(Arrays.asList(
			    new item("laptop"),
			    new item("mouse"),
			    new item("Desktop"),
			    new item("lcdscreens")
			));
			Scanner p=new Scanner(System.in);
			Scanner q=new Scanner(System.in);
			Scanner a=new Scanner(System.in);
		boolean addMoreItems = true;
		while (addMoreItems) {
		System.out.println("These are a list of products we have select by entering the number : ");
		int j=1;
		for(item i: Aproducts) {
			
			System.out.println(j+" "+i.getItemName());
			j++;
		}
		
		int nitem=p.nextInt();
		if (nitem >= 1 && nitem <= 4) {
            System.out.println("Enter the quantity: ");
            int quantity = q.nextInt();

            c.addItems(Aproducts.get(nitem - 1));
            c.addOrder(quantity);
        } else {
            System.out.println("Invalid selection. Please try again.");
        }
		
		System.out.println("This is your oder: ");
		System.out.println(c.printItem());
		System.out.println("Would you like to add more items?");
	    String choice = a.nextLine();
	    if (choice.toUpperCase().equals("NO")) {
	        addMoreItems = false;
	    }
	    else {
	    	addMoreItems=true;
	    }
		
		
			}
	
		System.out.println(c.printOrder());
		

		}
	}
