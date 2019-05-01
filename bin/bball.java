public class bball{


public static final double dt = 1.e-3;    //time interval in s
public static final double Tmax = 50.;    //max time in s

// Parameters of the equations
  public static final double gravity = -9.8;    	// acceleration in m/s*s
  public static final double Mass = 149;		// mass in grams
  public static final double Spin;
  public static final double CL =0.22 ; // lift coefficient
  public static final double Cd =0.40 ; // Drag coefficient
  public static final double V; //velocity of ball  (m/s)
  public static final double Radius;
  public static final double P = 1.23; //density of air  (kg/m3 )
  public static final double Fm=0.5*CL*P*A*Math.pow(V,2); // Magnus force
  public static final double Fd= - 0.5*Cd*P*A*Math.pow(V,2); //drag force
  public static final double A = 0.00426; //cross section area of ball (m2)

  public static void main(String[] args)
  {

  xInitial = 50;
  yInitial = 60;
  VxInitial = 60;
  VyInitial = 60;
  epsilon = 0.0001;	//Small variation in position

  // Calculate length of arrays
  int imax = (int)(Tmax/DT);		// Maximal index


x[i+1]=x[i] + Vx[i]*dt;
y[i+1]= y[i] + Vy[i]*dt;
z[i+1]=z[i] + Vz[i]*dt;

Vx[i+1]=Vx[i] + Ax[i]*dt;
Vy[i+1]=Vy[i] + Ay[i]*dt;
Vz[i+1]=Vz[i] + Az[i]*dt;

}


public static double Forcey(double gravity, double mass, double Fm){

int Weight= gravity*mass;

Fy = Math.abs(Weight - Fm);
}

public static double Forcex(double Drag , double Velocity){

  Fx=Math.abs(Drag-Velocity);

}

public static double Forcez(double gravity, double mass){



}

public static double AccelerationY(double Forcey, double mass){

  Ay = Forcey/mass;
}

public static double AccelerationX(double Forcex, double mass){

  Ax = Forcex/mass;

}
}
