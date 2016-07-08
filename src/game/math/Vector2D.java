package game.math;

import game.math.Vector2D;

public class Vector2D {
	public double x;
	public double y;
	
	public Vector2D(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public Vector2D(Vector2D v){
		set(v);
	}
	
	public double len(){
		return Math.sqrt(x * x + y * y);
	}
	
	public Vector2D set(double x, double y){
		this.x = x;
		this.y = y;
		return this;
	}
	
	public Vector2D set(Vector2D v){
		x = v.x;
		y = v.y;
		return this;
	}
	
	public Vector2D sub(Vector2D vec){
		x -= vec.x;
		y -= vec.y;
		return this;
	}
	
	/** @return the distance between this and given Vector */
	public double dist(Vector2D vec){
		final double x_d = x - vec.x;
		final double y_d = y - vec.y;
		return Math.sqrt(x_d * x_d + y_d * y_d);
	}
	
	public Vector2D mulAdd(Vector2D vec, double scalar){
		x += vec.x * scalar;
		y += vec.y * scalar;
		return this;
	}
	
	public Vector2D mulSub(Vector2D vec, double scalar){
		x -= vec.x * scalar;
		y -= vec.y * scalar;
		return this;
	}
	
	public Vector2D add(Vector2D vec){
		x += vec.x;
		y += vec.y;
		return this;
	}
	
	public Vector2D scl(double scalar){
		x *= scalar;
		y *= scalar;
		return this;
	}
	
	public Vector2D nor(){
		double len = len();
		if (len != 0){
			x /= len;
			y /= len;
		}
		return this;
	}
	
	public double dot (Vector2D v) {
		return x * v.x + y * v.y;
	}

	public double dot (double ox, double oy) {
		return x * ox + y * oy;
	}
	
	public double dist(double xN, double yN){
		return Math.sqrt(Math.pow(this.x-xN,2) + Math.pow(this.y-yN, 2));
	}
}

