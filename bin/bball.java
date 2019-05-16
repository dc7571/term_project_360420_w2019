


import java.io.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class bball
{


    public static final double DT = 1.e-3;    //time interval in s
    public static final double Tmax = 50.0;    //max time in s



    // Parameters of the equations
    public static final double gravity = 9.8;    	// acceleration in m/s/s
    public static final double Mass = 0.149;		// Mass in kilograms

    //public static final double CL =0.22;  lift coefficient
    public static final double Cd =0.40 ; // Drag coefficient
    public static final double W=240; //Angular velocity of ball  (m/s)
    public static final double R=0.03683;  //radius of ball (m)
    public static final double P = 1.23; //density of air  (kg/m3 )
    public static final double A = 0.00426; //cross section area of ball (m2)

    // ball location
    //public static final double[] Mx = {1};	//Position of magnets in x (m).
    //public static final double[] My = {1};	//Position of magnets in y (m).






    public static void main(String[] args)
    {



double xInitial, yInitial, epsilon, VxInitial, VyInitial;

  xInitial = 0.0;//(m)
  yInitial = 1.5;//(m)
  VxInitial = 50;//(m/s)
  VyInitial = 10;//(m/s)
  epsilon = 0.0001;	//Small variation in position



	// Calculate length of arrays
	int imax = (int)(Tmax/DT);		// Maximal index

	// Declare main variables
	double[] t = new double[imax];		// time in sec

	double[] y1 = new double[imax];// y-position in m
	double[] vy1 = new double[imax]; // y-velocity in m/s
	double[] ay1 = new double[imax];// y-acceleration in m/s/s

  double[] x1 = new double[imax];// x-position in m
	double[] vx1 = new double[imax]; // x-velocity in m/s
	double[] ax1 = new double[imax];// x-acceleration in m/s/s


  t[0] = 0;

  y1[0] = yInitial;
  vy1[0] = VyInitial;
  ay1[0] = accelerationy(vx1[0],vy1[0],t[0]);

  x1[0] = xInitial;
  vx1[0] = VxInitial;
  ax1[0] = accelerationx(vx1[0],vy1[0],t[0]);


  for(int i=0; i<10000;i++)

    {

      t[i+1] = t[i]+DT;


      x1[i+1]=x1[i] + vx1[i] * DT;
      y1[i+1]=y1[i] + vy1[i] * DT;

      vx1[i+1]=vx1[i] + ax1[i] * DT;
      vy1[i+1]=vy1[i] + ay1[i] * DT;

      ax1[i+1] = accelerationx(vx1[i+1],vy1[i+1],t[i+1]);
      ay1[i+1] = accelerationy(vx1[i+1],vy1[i+1],t[i+1]);

    }

  String heading1 = "X";
  String heading2 = "Y";
  String heading3 = "Vy";
  String heading4 = "Vx";
  String heading5 = "Ay";
  String heading6 = "Ax";
  String heading7 = "T";


  System.out.printf("%8s %10s %10s %10s %10s %10s %10s %n",heading1,heading2,heading3,heading4,heading5,heading6,heading7);


  for(int i=0;i<10000;i+=100) //  we are only printing the position every 100 steps
  {
    System.out.printf("%10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n", x1[i],y1[i],vy1[i], vx1[i],ay1[i],ax1[i],t[i]);

  }



    }

public static double Forcey(double xvel, double yvel , double t)

  {

    /*If the ball has topspin, the sign in front of CL is negative in the y-dir and therefore positive in the x-dir.

      Consequently, if the ball has backspin, then the opposite is true; CL is positive in the y-dir and negative in the x-dir.

      **The code is set for a fastball.**
*/


    double CL= 1/(2 + (Math.sqrt((Math.pow(xvel,2)) + (Math.pow(yvel,2)))/(R*W)));

    double Weight= gravity * Mass;

    double Fy= (0.5 * A * P) *  Math.sqrt((Math.pow(xvel,2)) + (Math.pow(yvel,2))) * ((CL * xvel) - (Cd * yvel)) - (Weight);


    return Fy;

  }

    public static double accelerationy(double xvel, double yvel , double t)

      {

          double Ay=(Forcey(xvel,yvel,t)/Mass);

          return Ay;
      }



    public static double Forcex(double xvel, double yvel , double t)

      {
        double CL= 1/(2 + (Math.sqrt((Math.pow(xvel,2)) + (Math.pow(yvel,2)))/(R*W)));

        double Fx=  - ((0.5 * A * P) *  Math.sqrt((Math.pow(xvel,2)) + (Math.pow(yvel,2))) * ((Cd * xvel) + (CL * yvel)));

        return Fx;
      }



    public static double accelerationx(double xvel, double yvel , double t)

      {

          double Ax=(Forcex(xvel,yvel,t)/Mass);

          return Ax;
      }



}
