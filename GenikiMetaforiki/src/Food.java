
public class Food extends Material {
	public String code;
	public double kilometresToDestination;
	public double kilogram;
	public boolean food;
	public boolean destinationIsland;
	
	public Food(String code, double kilometresToDestination, double kilogram, boolean destinationIsland){
		super(code, kilometresToDestination, kilogram, destinationIsland);
	}
	
	public double calculateCharge() {
		if(destinationIsland)
			return 100 * kilometresToDestination * kilogram;
		else 
			return 50 * kilometresToDestination * kilogram;
	}
		

}
