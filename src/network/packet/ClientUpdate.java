package network.packet;

import java.util.ArrayList;

import game.math.Vector2D;

public class ClientUpdate {
	private ArrayList<Vector2D> positions;
	private ArrayList<Double> radii;
	
	public ClientUpdate(){
		positions = new ArrayList<Vector2D>();
		radii = new ArrayList<Double>();
	}
	
	public void addPos(Vector2D vec){
		positions.add(vec);
	}
	
	public void addRadius(double radius){
		radii.add(radius);
	}
}
