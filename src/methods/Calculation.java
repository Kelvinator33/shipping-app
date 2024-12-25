package methods;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

import containers.*;

import items.item;

public class Calculation {
		//create arraylist to hold the items to be shipped and their quantities
	private ArrayList<item> items= new ArrayList<>();
	private ArrayList<Integer> basket= new ArrayList<>();
	//store the cost od the shipping method
	private int ecost;
	
	//create method to get the items selected
	public List<item> getItems() {
		return items;
	}
	
	
	
	public long totalVolume() {
		//set initial volume
		 long v = 0;
		 //iterate through item volume of each item and multiply that with the number of orders and add to total volume of other items
		    for (item i : getItems()) {
		        v += i.volume() * basket.get(getItems().indexOf(i));
		    }
		    //return total voulume of items bought
		    return v;
	}
	public long totalWeight() {
		//initialize total weight
		 long w = 0;
		 //iterate through the items selected and multiply their weight by the quantity to get the total weight
		    for (item i : getItems()) {
		        w += i.getItemWeight() * basket.get(getItems().indexOf(i));
		    }
		    return w;
	}
	
	public ArrayList<Container> bestShipping() {
		//create variables to store the best shipping option and its cost
		ArrayList<Container> bestoption=new ArrayList<>();
		int currentcost = 0 ;
		
		
		//create conditions to find best shipping option Kelvin.Amoah
		if(totalWeight()<=500000 ) {
			//let the best shipping option be small container if the total weight is less than 500kg
			bestoption.add(new smallcontainer());
			currentcost=1000;
			ecost=currentcost;
		}
		
		
		else if(totalVolume()<= new smallcontainer().volume() && totalWeight()>500000) {
			//let the best shipping option be small container if the total weight is more than 500kg
			// but total volume is less than the volume of the small container

			bestoption.add(new smallcontainer());
			currentcost=1200;
			ecost=currentcost;
		}
		
		
		else {
			//create variables to store the best combinations of shipping containers Kelvin.Amoah
			ArrayList<Container> selectedcontainers = new ArrayList<>();
			//create variable to store the remaining volume as the iteration goes on
			double remainingVolume = totalVolume();
			Container small=new smallcontainer();
			Container big=new bigcontainer();
			

        while (remainingVolume>0) {
        	//create a condition to select a big container if the remaining volume is greater than the volume of a small container
            	if(remainingVolume> small.volume()) {
                selectedcontainers.add(big);
                currentcost += 1800;
                remainingVolume -=big.volume();
            	}

            	//create a condition to select a small container if the remaining volume is less than or equal the volume of a small container

            	else if (remainingVolume > 0 && remainingVolume<= small.volume()) {
                    selectedcontainers.add(small);
                    currentcost += 1200;
                    remainingVolume -= small.volume();
                   
            		}
            	
            	else {
            		//if none apply break out of the condition
            		break;
            		}
            	
            	}
        //store the selected containers in the best option variable
            bestoption = selectedcontainers;
            //set the current cost to the efficient cost variable Kelvin.Amoah
            ecost = currentcost;
            
        	}
		//return the best container option
        return bestoption;
    
		}
		//calculate shipping pricee
		public double shippingPrice() {

			return ecost;
		}
		//method for adding items
		//takes input the item you want to add 
		public void addItems (item item) {
			getItems().add(item);
		}
		//method for adding order quantity
		//takes input the quantity of the item
		public void addOrder(int q) {
			basket.add(q);
		}
		//method for printing item info
		public String printItem() {
			String details="";
			//iterate through each item selected and print their name and quantity
			for (int i = 0; i < getItems().size(); i++) {
	            details+=("Item: " + getItems().get(i).getItemName() +"\n"+ " Quantity: " + basket.get(i)+"\n");
	            details+=new item(getItems().get(i).getItemName()).getItemInfo();
	            details+="\n";
	        }
			 details+=("total volume:" + totalVolume());
			 details+="\n";
	            details+=("total weight: "+ totalWeight());
	            details+="\n";
			return details;
		}
		//method for printing order
		public String printOrder() {
			String order;
			order=("Your Order:");
			//print item info
			order+=(printItem());
			order+=("Shipping Option Available:");
			ArrayList<Container> selected=bestShipping();
			
			//set counters to know how many big and small containers are needed
				int bc=0;
				int sc=0;
				for(Container i:selected) {
		        i.getName();
		        if(i.getName().equals("bigcontainer")) {
		        	bc++;
		        }
		        if(i.getName().equals("smallcontainer")) {
		        	sc++;
		        }
				}
				if (bc==0 && sc!=0) {
					order+=(sc+" small container");
				}
				else if (sc==0 && bc!=0) {
					order+=(bc+" big containers");
				}
				else {
					order+=(bc+" big containers and "+sc+" small container");
				}
				//print container info
				if(order.contains("big containers")) {
					order+="\n";
					order+="big container ";
					order+=new bigcontainer().Info();
					order+="\n";
				}
				if(order.contains("small container")) {
					order+="\n";
					order+="small container ";
					order+=new smallcontainer().Info();
					order+="\n";
				}
									//print total cost
			order+=("Total Price: €" + ecost);
			return order;
		}
		
		//method for clearing item and quantity
		public void clear() {
			items.clear();
			basket.clear();
		}
	
	}

