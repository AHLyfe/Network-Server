package game;

import game.math.Vector2D;

public abstract class Object {
	private Vector2D position;
	private Vector2D velocity;
	private Vector2D acceleration;
	
	
	public void setPos(float x, float y){
		position.set(x, y);
	}
	
	//Update position and velocity with timestep dt
	abstract void update(double dt);
}
