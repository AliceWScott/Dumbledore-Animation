package comp557.a1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

import mintools.parameters.DoubleParameter;
import mintools.viewer.EasyViewer;
import mintools.viewer.FancyAxis;

public class NoRotationJoint extends DAGNode {
	
	Double tx;
	Double ty;
	Double tz;
		
	public NoRotationJoint( String name, Double tx, Double ty, Double tz ) {
		super(name);
		this.tx = tx;
		this.ty = ty;
		this.tz = tz;
	}
	
	@Override
	public void display(GLAutoDrawable drawable) {
		
		GL2 gl = drawable.getGL().getGL2();
		
	    	gl.glPushMatrix();
			gl.glTranslated(this.tx, this.ty, this.tz);
			super.display(drawable);	
		gl.glPopMatrix();
		
	}

	
}
