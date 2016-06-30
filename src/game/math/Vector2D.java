package game.math;

public class Vector2D {
	public float x;
	public float y;
	
	public Vector2D(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public Vector2D(Vector2D v){
		set(v);
	}
	
	public Vector2D set(float x, float y){
		this.x = x;
		this.y = y;
		return this;
	}
	
	public Vector2D set(Vector2D v){
		x = v.x;
		y = v.y;
		return this;
	}
	
	public Vector2D mulAdd(Vector2D vec, double scalar){
		this.x += vec.x * scalar;
		this.y += vec.y * scalar;
		return this;
	}
	
	
	
}
