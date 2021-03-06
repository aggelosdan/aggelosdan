import java.util.ArrayList;

public class Pool {
	private String noOfTruck;
	private double maxKilos;
	public boolean destinationIsland;
	private ArrayList<Material> things;
	private ArrayList<Pool> trucks = new ArrayList<Pool>();
	
	public Pool(String noOfTruck, double maxKilos, boolean destinationIsland) {
		this.noOfTruck = noOfTruck;
		this.maxKilos = maxKilos;
		this.destinationIsland = destinationIsland;
		things = new ArrayList<Material>();
	}
	
	public String getNoOfTruck() {
		return noOfTruck;
	}
	public double getMaxKilos() {
		return maxKilos;
	}
	public boolean isDestinationIsland() {
		return destinationIsland;
	}
	
	public void addTruck(Material m, Pool p) {
		if(m.isDestinationIsland() & p.isDestinationIsland()) {
			if(m.getKilogram() < maxKilos) {
				things.add(m);
				p.maxKilos -= m.getKilogram();
			}
			else
				System.out.println("The truck is Full !!!");
		}
		else {
			if (p.isDestinationIsland())
				System.out.println("The truck is for Island !!!");
			else
				System.out.println("The truck is not for Island !!!");
		}
	}
	
	public double getTotalCharge() {
		double sum = 0;
		for(int i=0; i<things.size(); i++)
			sum = sum + things.get(i).calculateCharge();
		
		return sum;
	}

}
