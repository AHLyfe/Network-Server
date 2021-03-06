package game;

import game.math.Vector2D;

public class CircularObject extends GameObject {
	private double radius;
	private double mass;

	@Override
	void update(double dt) {
		// TODO Auto-generated method stub
	}
	
	public void handleCollisionCircleObject(CircularObject cO){
		
		//Ngl copied all of this code
	    double xDist, yDist;
    	xDist = position.x - cO.position.x;
    	yDist = position.y - cO.position.y;
    	
    	double distSquared = xDist*xDist + yDist*yDist;
    	
        double xVelocity = cO.velocity.x - velocity.x;
        double yVelocity = cO.velocity.y - velocity.y;
        double dotProduct = xDist*xVelocity + yDist*yVelocity;
        //Neat vector maths, used for checking if the objects moves towards one another.
        if(dotProduct > 0){
            double collisionScale = dotProduct / distSquared;
            double xCollision = xDist * collisionScale;
            double yCollision = yDist * collisionScale;
            //The Collision vector is the speed difference projected on the Dist vector,
            //thus it is the component of the speed difference needed for the collision.
            double combinedMass = mass + cO.mass;
            double collisionWeightA = 2 * cO.mass / combinedMass;
            double collisionWeightB = 2 * mass / combinedMass;
            velocity.x += collisionWeightA * xCollision;
            velocity.y += collisionWeightA * yCollision;
            cO.velocity.x -= collisionWeightB * xCollision;
            cO.velocity.y -= collisionWeightB * yCollision;
	    }
	}
	
	public boolean collides(){
		if (!(position.x + radius > Map.mapWidth && position.x - radius > 0 && position.y + radius < Map.mapHeight && position.y - radius > 0)){
			return true;
		}
		
		for(GameObject obj : Map.gameObjects){
			if (obj instanceof CircularObject){
				CircularObject cObj = (CircularObject) obj; 
				if (this.intersects(cObj)){
					return true;
				}
			}
			else if(obj instanceof RectangularObject){
				
			}
		}
		return false;
	}
	
	public boolean intersects(CircularObject cO){
		if(position.dist(cO.position) <= radius + cO.radius){
			return true;
		}
		return false;
	}
	
	public double getRadius(){
		return radius;
	}

}
