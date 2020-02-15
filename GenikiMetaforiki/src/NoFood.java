
public class NoFood extends Material {
	public String code;
	public double kilometresToDestination;
	public double kilogram;
	public boolean food;
	public boolean destinationIsland;
	
	public NoFood(String code, double kilometresToDestination, double kilogram, boolean destinationIsland){
		super(code, kilometresToDestination, kilogram, destinationIsland);
	}
	
	public double calculateCharge() {
		if(destinationIsland)
			return 20 * kilometresToDestination * kilogram;
		else 
			return 15 * kilometresToDestination * kilogram;
	}
		

}
