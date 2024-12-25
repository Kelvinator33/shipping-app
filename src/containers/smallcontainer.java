package containers;

public class smallcontainer extends Container{
	//use the constractor to preset the values in the container Kelvin.Amoah
		public smallcontainer() {
			super("smallcontainer",606,243,259);
		}
		
		@Override
		//calculate the volume of the small container
		public long volume() {
			return getLength()*getBreadth()*getHeight();
		}
}
