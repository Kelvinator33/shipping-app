package containers;

public class bigcontainer extends Container {
	//use the constractor to preset the values in the container Kelvin.Amoah
				public bigcontainer() {
					super("bigcontainer",1201,243,259);
				}
				
				@Override
				//calculate the volume of the big container
				public long volume() {
					return getLength()*getBreadth()*getHeight();
				}
}
