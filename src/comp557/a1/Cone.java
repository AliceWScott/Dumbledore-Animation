package comp557.a1;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

import mintools.viewer.FancyAxis;

//Alice Scott, #260631443
public class Cone extends DAGNode {
	
	Double base;
	Double height;
	String axis;
	Double angle;
	double[] colour;
	
	public Cone(String name, Double base, Double height, double[] colour) {
		super(name);
		this.base = base;
		this.height = height;
		this.colour = colour;
	}
	
	//String axis represents the axis the cone should point in
	public Cone(String name, Double base, Double height, String axis, Double angle, double[] colour) {
		super(name);
		this.base = base;
		this.height = height;
		this.axis = axis;
		this.angle = angle;
		this.colour = colour;
	}
	public void display(GLAutoDrawable d) {
		super.display(d);
		GL2 gl = d.getGL().getGL2();
	    	gl.glPushMatrix();
	    	gl.glColor3d(this.colour[0], this.colour[1], this.colour[2]);
	    	if (this.axis == "x") {
	    		gl.glRotated(this.angle, 1.0, 0.0, 0.0);
	    	} else if (this.axis == "y") {
	    		gl.glRotated(this.angle, 0.0, 1.0, 0.0);
	    	} else {
	    		gl.glRotated(this.angle, 0.0, 0.0, 1.0);
	    	}
		glut.glutSolidCone(this.base, this.height, 100, 100);
		gl.glPopMatrix();
	}
}