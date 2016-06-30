package game;

import game.math.Vector2D;

public abstract class GameObject {
	protected Vector2D position;
	protected Vector2D velocity;
	protected Vector2D acceleration;
	
	
	public void setPos(float x, float y){
		position.set(x, y);
	}
	
	//Update position and velocity with timestep dt
	abstract void update(double dt);
}
