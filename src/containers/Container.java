package containers;

public abstract class Container {


	//all measurements are in cm and weight is in grams
	private long Length;
	private long Breadth;
	private long Height;
	private String Name;
	//use constructor to set values of private variables Kelvin.Amoah
	Container(String n, long l, long b, long h) {
		this.Name=n;
		this.Length=l;
		this.Height=h;
		this.Breadth=b;
	}
	//create getters and setters for private variables
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public long getLength() {
		return Length;
	}

	public void setLength(long length) {
		this.Length = length;
	}

	public long getBreadth() {
		return this.Breadth;
	}

	public void setBreadth(long breadth) {
		this.Breadth = breadth;
	}

	public long getHeight() {
		return this.Height;
	}

	public void setHeight(long height) {
		this.Height = height;
	}
	
	//create an abstract class of the volume to be inherited by the small and big container classes Kelvin.Amoah
	public abstract long volume();
	//create method to extract information about the container
	public	String Info() {
        String info = "Measurements: " + this.Length +" x "+ this.Breadth+ " x " + this.Height + " cm" + "\n";
        info += "Volume: " + volume() + " cm³";
        return info;
    }
}
