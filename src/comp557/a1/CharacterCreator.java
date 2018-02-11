package comp557.a1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;

public class CharacterCreator {

	static public String name = "Albus Dumbledore";
	private static GLUT glut = new GLUT();
	
	/** 
	 * Creates a character.
	 * @return root DAGNode
	 */
	static public DAGNode create() {

		//COLOURS
		double[] black = {0.0, 0.0, 0.0};
		double[] white = {1.0, 1.0, 1.0};
		double[] gray = {0.4, 0.4, 0.4};
		double[] khaki = {0.858824,  0.576471, 0.439216};
		double[] brown = {0.36, 0.20,0.09} ;
		double[] plum = {0.309804,0.184314,0.309804};
		
		// MAIN BODY PARTS
		FreeJoint character = new FreeJoint("character");
		Sphere torso = new Sphere("torso", 1.0, 1.5, 1.0, 1.0, black);
		Sphere pelvis = new Sphere("Pelvis", 0.9, plum);
		HingeJoint waist = new HingeJoint("waist", 0.0, 1.2, 0.0, 0.0, 0.0, "x");
		
		character.add(pelvis);
		pelvis.add(waist);
		waist.add(torso);

		// HEAD & OTHER RELATED HEAD THINGS
		Sphere head = new Sphere("head", 0.7, khaki);
		HingeJoint neck = new HingeJoint("neck", 0.0, 2.0, 0.0, -90.0, 90.0, "y");
		NoRotationJoint scalp = new NoRotationJoint("scalp", 0.0, 0.3, 0.0);
		HingeJoint crown = new HingeJoint("crown", 0.0, -1.0, -0.8, 10.0, 10.0, "x");
		Sphere hair = new Sphere("hair", 1.0, 1.5, 0.3, 1.0, white);
		Sphere right_hair = new Sphere("right hair", 0.6, 1.2, 0.2, 1.0, white);
		HingeJoint right_crown = new HingeJoint("right crown", 0.6, -0.6, 0.0, -85.0, -85.0, "y");
		Sphere left_hair = new Sphere("left hair", 0.6, 1.2, 0.2, 1.0, white);
		HingeJoint left_crown = new HingeJoint("left crown", -0.6, -0.6, 0.0, 85.0, 85.0, "y");
		
		Cone hat = new Cone("hat",0.8, 1.7, "x", -90.0, black);
		Cone hatbrim = new Cone("hatbrim", 1.5, 0.1, "x", -90.0, black);
		
		Sphere right_eye = new Sphere("Right Eye", 0.1, black);
		Sphere left_eye = new Sphere("Left Eye", 0.1, black);
		NoRotationJoint right_eye_socket = new NoRotationJoint("Right Eye Socket", 0.2, 0.0, 0.6);
		NoRotationJoint left_eye_socket = new NoRotationJoint("Left Eye Socket", -0.2, 0.0, 0.6);
		
		Sphere beard = new Sphere("beard", 0.5, 1.0, 0.2, 1.0, white);
		Sphere nose = new Sphere("nose", 0.1, 0.1, 0.5, 1.0, khaki);
		HingeJoint beard_to_face = new HingeJoint("beard to face", 0.0, -0.9, 0.7, -20.0, -20.0, "x");
		NoRotationJoint nose_to_face = new NoRotationJoint("nose to face", 0.0, -0.2, 0.5);
		Sphere left_mustache = new Sphere("left mustache", 0.3, 0.1, 0.1, 1.0, white);
		Sphere right_mustache = new Sphere("right mustache", 0.3, 0.1, 0.1, 1.0, white);
		NoRotationJoint left_mustache_conn = new NoRotationJoint("left mustache conn", -0.2, -0.1, 0.2);
		NoRotationJoint right_mustache_conn = new NoRotationJoint("right mustache conn", 0.2, -0.1, 0.2);
		
		neck.add(head);
		head.add(scalp);
		head.add(crown);
		head.add(right_crown);
		head.add(left_crown);
		left_crown.add(left_hair);
		right_crown.add(right_hair);
		crown.add(hair);
		head.add(right_eye_socket);
		head.add(left_eye_socket);
		right_eye_socket.add(right_eye);
		left_eye_socket.add(left_eye);
		head.add(beard_to_face);
		beard_to_face.add(beard);
		head.add(nose_to_face);
		nose_to_face.add(nose);
		nose.add(left_mustache_conn);
		nose.add(right_mustache_conn);
		left_mustache_conn.add(left_mustache);
		right_mustache_conn.add(right_mustache);
		scalp.add(hat);
		scalp.add(hatbrim);
		torso.add(neck);	
		
		
		// RIGHT ARM
		BallJoint right_armpit_joint = new BallJoint("Right Armpit Joint", 1.0, 0.7, 0.0);
		Sphere right_armpit = new Sphere("Right Armpit", 0.4, black);
		NoRotationJoint right_upperarm_joint = new NoRotationJoint("Right Upper Arm Joint", 0.0, -0.4, 0.0);
		Sphere right_upper_arm = new Sphere("Right Upper Arm", 0.3, 0.8, 0.3, 1.0, black);
		HingeJoint right_elbow = new HingeJoint("Right Elbow", 0.0, -0.8, 0.0, -90.0, 0.0, "x");
		Sphere right_elbow_conn = new Sphere("Right Elbow Connector", 0.3, black);
		NoRotationJoint right_forearm_joint = new NoRotationJoint("Right Forearm Joint", 0.0, -0.5, 0.0);
		Sphere right_forearm = new Sphere("Right Forearm", 0.3, 0.8, 0.3, 1.0, black);
		BallJoint right_wrist = new BallJoint("Right Wrist", 0.0, -0.8, 0.0);
		Sphere right_hand = new Sphere("Right Hand", 0.3, khaki);
		NoRotationJoint grip = new NoRotationJoint("grip", 0.0, -0.6, 0.0);
		Cube wand = new Cube("Magic Wand", 0.1, 1.0, 0.1, brown);
		
		torso.add(right_armpit_joint);
		right_armpit_joint.add(right_armpit);
		right_armpit.add(right_upperarm_joint);
		right_upperarm_joint.add(right_upper_arm);
		right_upper_arm.add(right_elbow);
		right_elbow.add(right_elbow_conn);
		right_elbow_conn.add(right_forearm_joint);
		right_forearm_joint.add(right_forearm);
		right_forearm.add(right_wrist);
		right_wrist.add(right_hand);
		right_hand.add(grip);
		grip.add(wand);

		
		// LEFT ARM 
		BallJoint left_armpit_joint = new BallJoint("Left Armpit Joint", -1.0, 0.7, 0.0);
		Sphere left_armpit = new Sphere("Left Armpit", 0.4, black);
		NoRotationJoint left_upper_arm_joint = new NoRotationJoint("Left Upper Arm Joint", 0.0, -0.4, 0.0);
		Sphere left_upper_arm = new Sphere("Left Upper Arm", 0.3, 0.8, 0.3, 1.0,black);
		HingeJoint left_elbow = new HingeJoint("Left Elbow", 0.0, -0.8, 0.0, -90.0, 0.0, "x");
		Sphere left_elbow_conn = new Sphere("Left Elbow Connector", 0.3, black);
		NoRotationJoint left_forearm_joint = new NoRotationJoint("Left Forearm Joint", 0.0, -0.5, 0.0);
		Sphere left_forearm = new Sphere("Left Forearm", 0.3, 0.8, 0.3, 1.0, black);
		BallJoint left_wrist = new BallJoint("Left Wrist", 0.0, -0.8, 0.0);
		Sphere left_hand = new Sphere("Left Hand", 0.3,khaki);
		
		torso.add(left_armpit_joint);
		left_armpit_joint.add(left_armpit);
		left_armpit.add(left_upper_arm_joint);
		left_upper_arm_joint.add(left_upper_arm);
		left_upper_arm.add(left_elbow);
		left_elbow.add(left_elbow_conn);
		left_elbow_conn.add(left_forearm_joint);
		left_forearm_joint.add(left_forearm);
		left_forearm.add(left_wrist);
		left_wrist.add(left_hand);
		
		
		// RIGHT LEG
		BallJoint right_hip_joint = new BallJoint("Right Hip Joint", 0.6, -0.6, 0.0);
		Sphere right_hip_flexor = new Sphere("Right Hip Flexor", 0.3, plum);
		NoRotationJoint right_thigh_joint = new NoRotationJoint("Right Thigh Joint", 0.0, -0.8, 0.0);
		Sphere right_thigh = new Sphere("Right Thigh", 0.3, 1.0, 0.3, 1.0, plum);
		HingeJoint right_knee = new HingeJoint("Right Knee", 0.0, -1.0, 0.0, 0.0, 90.0, "x");
		Sphere right_knee_conn = new Sphere("Right Knee Connector", 0.3, plum);
		NoRotationJoint right_knee_to_calf = new NoRotationJoint("Right Knee To Calf", 0.0, -0.7, 0.0);
		Sphere right_calf = new Sphere("Right Calf", 0.3, 1.0, 0.3, 1.0, plum);
		HingeJoint right_ankle = new HingeJoint("Right Ankle", 0.0, -1.0, 0.2, 0.0, 75.0, "x");
		Sphere right_foot = new Sphere("Right Foot", 0.3, 0.3, 0.5, 1.0, gray);
		
		pelvis.add(right_hip_joint);
		right_hip_joint.add(right_hip_flexor);
		right_hip_flexor.add(right_thigh_joint);
		right_thigh_joint.add(right_thigh);
		right_thigh.add(right_knee);
		right_knee.add(right_knee_conn);
		right_knee_conn.add(right_knee_to_calf);
		right_knee_to_calf.add(right_calf);
		right_calf.add(right_ankle);
		right_ankle.add(right_foot);
		
		// LEFT LEG
		BallJoint left_hip_joint = new BallJoint("Left Hip Joint", -0.6, -0.6, 0.0);
		Sphere left_hip_flexor = new Sphere("Left Hip Flexor", 0.3, plum) ;
		NoRotationJoint left_thigh_joint = new NoRotationJoint("Left Thigh Joint", 0.0, -0.8, 0.0);
		Sphere left_thigh = new Sphere("Left Thigh", 0.3, 1.0, 0.3, 1.0, plum);
		HingeJoint left_knee = new HingeJoint("Left Knee", 0.0, -1.0, 0.0, 0.0, 90.0, "x");
		Sphere left_knee_conn = new Sphere("Left Knee Connector", 0.3, plum);
		NoRotationJoint left_knee_to_calf = new NoRotationJoint("Left Knee To Calf", 0.0, -0.7, 0.0);
		Sphere left_calf = new Sphere("Left Calf", 0.3, 1.0, 0.3, 1.0, plum);
		HingeJoint left_ankle = new HingeJoint("Left Ankle", 0.0, -1.0, 0.2, 0.0, 75.0, "x");
		Sphere left_foot = new Sphere("Left Foot", 0.3, 0.3, 0.5, 1.0, gray);
		
		pelvis.add(left_hip_joint);
		left_hip_joint.add(left_hip_flexor);
		left_hip_flexor.add(left_thigh_joint);
		left_thigh_joint.add(left_thigh);
		left_thigh.add(left_knee);
		left_knee.add(left_knee_conn);
		left_knee_conn.add(left_knee_to_calf);
		left_knee_to_calf.add(left_calf);
		left_calf.add(left_ankle);
		left_ankle.add(left_foot);
		
		
		return character;
	}
}
