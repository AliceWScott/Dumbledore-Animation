package comp557.a1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

import mintools.parameters.DoubleParameter;
import mintools.viewer.FancyAxis;

public class BallJoint extends DAGNode {
	
	Double tx;
	Double ty;
	Double tz;
	DoubleParameter yaw;
	DoubleParameter pitch;
	DoubleParameter roll;
		
	public BallJoint( String name, Double tx, Double ty, Double tz ) {
		super(name);
		this.tx = tx;
		this.ty = ty;
		this.tz = tz;
		dofs.add( yaw = new DoubleParameter( name+" yaw", 0, -180, 180 ) );		
		dofs.add( pitch = new DoubleParameter( name+" pitch", 0, -180, 180 ) );
		dofs.add( roll = new DoubleParameter( name+" roll", 0, -180, 180 ) );
	}
	
	@Override
	public void display(GLAutoDrawable drawable) {
		
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glPushMatrix();
			gl.glTranslated(this.tx, this.ty, this.tz);
			gl.glRotatef(yaw.getFloatValue(), 1.0f, 0.0f, 0.0f);
			gl.glRotatef(pitch.getFloatValue(), 0.0f, 1.0f, 0.0f);
			gl.glRotatef(roll.getFloatValue(), 0.0f, 0.0f, 1.0f);
			super.display(drawable);
		gl.glPopMatrix();
		
	
	}
	
}
