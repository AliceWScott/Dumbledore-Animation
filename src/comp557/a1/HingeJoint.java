package comp557.a1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

import mintools.parameters.DoubleParameter;
import mintools.viewer.EasyViewer;
import mintools.viewer.FancyAxis;

//Alice Scott, #260631443
public class HingeJoint extends DAGNode {
	
	DoubleParameter rx;
	DoubleParameter ry;
	DoubleParameter rz;
	Double tx;
	Double ty;
	Double tz;
	String axis;
		
	public HingeJoint( String name, Double tx, Double ty, Double tz, Double minangle, Double maxangle, String axis ) {
		
		super(name);
		this.axis = axis;
		this.tx = tx;
		this.ty = ty;
		this.tz = tz;
		
		// check that we allow an angle range
		if(maxangle != minangle) {
			if(this.axis == "x") {
				dofs.add( rx = new DoubleParameter( name+" rx", 0, minangle, maxangle ) );
			} else if(this.axis == "y") {
				dofs.add( ry = new DoubleParameter( name+" ry", 0, minangle, maxangle ) );

			} else if(this.axis == "z") {
				dofs.add( rz = new DoubleParameter( name+" rz", 0, minangle, maxangle ) );
			}
		}
	}
	
	@Override
	public void display(GLAutoDrawable drawable) {
		
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glPushMatrix();
			gl.glTranslated(this.tx, this.ty, this.tz);
			if(this.axis == "x" ) {
				gl.glRotated(rx.getValue(), 1.0, 0.0, 0.0);
			}
			if (this.axis == "y") {
				gl.glRotated(ry.getValue(),0.0, 1.0, 0.0);
			}
			if (this.axis == "z") {
				gl.glRotated(rz.getValue(),0.0, 0.0, 1.0);
			}
			super.display(drawable);
		gl.glPopMatrix();
		
	
	}
	
}
