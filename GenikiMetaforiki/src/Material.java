
public abstract class Material {
	
	public String code;
	public double kilometresToDestination;
	public double kilogram;
	public boolean destinationIsland;
	
	public Material(String code, double kilometresToDestination, double kilogram, boolean destinationIsland) {//, boolean food, boolean destinationIsland){
		this.code = code;
		this.kilometresToDestination = kilometresToDestination;
		this.kilogram = kilogram;
		//this.food = food;
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
	
	public boolean isDestinationIsland() {
		return destinationIsland;
	}
	
	public abstract double calculateCharge();
	

}
