package items;

public class item {
		private String ItemName;
		//all measurements are in cm and weight is in grams
		//create variables for the measurements Kelvin.Amoah
		private long ItemLength;
		private long ItemBreadth;
		private long ItemHeight;
		private long ItemWeight;
		
		public item(String item){
			//get the name of the item the user wants to buy
			this.ItemName=item.toLowerCase().replaceAll("\\s", "");
			
		//preset the variables of the item the user wants to ship
			if(this.ItemName.equals("laptop")) {
				this.ItemLength=60;
				this.ItemBreadth=50;
				this.ItemHeight=50;
				this.ItemWeight=6500;
			}
			else if(this.ItemName.equals("mouse")) {
				this.ItemLength=30;
				this.ItemBreadth=30;
				this.ItemHeight=20;
				this.ItemWeight=200;
			}
			else if(this.ItemName.equals("desktop")) {
				this.ItemLength=100;
				this.ItemBreadth=150;
				this.ItemHeight=50;
				this.ItemWeight=20000;
			}
			else if(this.ItemName.equals("lcdscreens")) {
				this.ItemLength=120;
				this.ItemBreadth=140;
				this.ItemHeight=80;
				this.ItemWeight=2600;
			}
		}
		//vreate getters and setters for the private variables
		public String getItemName() {
			return ItemName;
		}
		public void setItemName(String itemName) {
			ItemName = itemName;
		}
		public long getItemLength() {
			return ItemLength;
		}
		public void setItemLength(long itemLength) {
			ItemLength = itemLength;
		}
		public long getItemBreadth() {
			return ItemBreadth;
		}
		public void setItemBreadth(long itemBreadth) {
			ItemBreadth = itemBreadth;
		}
		public long getItemHeight() {
			return ItemHeight;
		}
		public void setItemHeight(long itemHeight) {
			ItemHeight = itemHeight;
		}
		public long getItemWeight() {
			return ItemWeight;
		}
		public void setItemWeight(long itemWeight) {
			ItemWeight = itemWeight;
		}
		
		//get the volume of the item to be shipped Kelvin.Amoah
		public long volume() {
			return this.ItemLength*this.ItemBreadth*this.ItemHeight;
		}
		//get the item info of the shipping products
		public String getItemInfo() {
	       String info = "Weight: " + ItemWeight + " g" + "\n";
	        info += "Measurements: " + ItemLength +" x "+ ItemBreadth+ " x " + ItemHeight + " cm" + "\n";
	        info += "Volume: " + volume() + " cm³ \n";
	        return info;
	    }
		
		
}
		