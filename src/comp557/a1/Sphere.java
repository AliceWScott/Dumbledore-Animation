package comp557.a1;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

import mintools.viewer.FancyAxis;

//Alice Scott, #260631443
public class Sphere extends DAGNode {
	
	Double x;
	Double y;
	Double z;
	Double radius;
	double[] colour;
	
	public Sphere(String name, Double radius, double[] colour){
		super(name);
		this.radius = radius;
		this.colour = colour;
	}
	
	// overloading constructor in case we want an elongated sphere instead
	public Sphere(String name, Double x, Double y, Double z, Double radius, double[] colour) {
		super(name);
		this.x = x;
		this.y = y;
		this.z = z;
		this.radius = radius;
		this.colour = colour;
	}
	public void display(GLAutoDrawable d) {
		super.display(d);
		GL2 gl = d.getGL().getGL2();
	    	gl.glPushMatrix();
	    	if(this.colour != null) {
	    	 	gl.glColor3d(this.colour[0], this.colour[1], this.colour[2]);
	    	}
	    	if((this.x != null)  && (this.y != null) && (this.z != null)) {
	    		 gl.glScaled(this.x, this.y, this.z);
	    	}
		glut.glutSolidSphere(this.radius, 100, 100);
		gl.glPopMatrix();
	}
}
