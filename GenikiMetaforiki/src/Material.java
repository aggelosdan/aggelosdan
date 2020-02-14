
public class Material {
	
	public String code;
	public double kilometresToDestination;
	public double kilogram;
	public boolean food;
	public boolean destinationIsland;
	
	public Material(String code, double kilometresToDestination, double kilogram, boolean food, boolean destinationIsland){
		this.code = code;
		this.kilometresToDestination = kilometresToDestination;
		this.kilogram = kilogram;
		this.food = food;
		this.destinationIsland = destinationIsland;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public Double getKilometresToDestination() {
		return kilometresToDestination;
	}
	
	public Double getKilogram() {
		return kilogram;
	}
	
	public boolean isFood() {
		return food;
	}
	
	public boolean isDestinationIsland() {
		return destinationIsland;
	}
	
	/*public double calculateCharge() {
		if(food) {
			if(destinationIsland)
				return 100 * kilometresToDestination * kilogram;
			else 
				return 50 * kilometresToDestination * kilogram;
		}
		else {
			if(destinationIsland)
				return 20 * kilometresToDestination * kilogram;
			else 
				return 15 * kilometresToDestination * kilogram;
		}
	}*/
}
