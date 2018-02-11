package comp557.a1;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.gl2.GLUT;

import mintools.viewer.FancyAxis;

//Alice Scott, #260631443
public class Cube extends DAGNode {
	
	Double x;
	Double y;
	Double z;
	double[] colour;
	
	public Cube(String name, Double x, Double y, Double z, double[] brown) {
		super(name);
		this.x = x;
		this.y = y;
		this.z = z;
		this.colour = brown;
	}
	public void display(GLAutoDrawable d) {
		super.display(d);
		GL2 gl = d.getGL().getGL2();
	    	gl.glPushMatrix();	
	    	gl.glColor3d(this.colour[0], this.colour[1], this.colour[2]);
	    	gl.glScaled(this.x, this.y, this.z);
		glut.glutSolidCube(1);
		gl.glPopMatrix();
	}
}
