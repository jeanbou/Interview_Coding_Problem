public class AreaOfTwoOverlappingTriangles {

	
	// https://math.stackexchange.com/questions/154628/find-the-area-of-overlap-of-two-triangles
	
	/* returns true if the specified triangle overlaps with this triangle. **/
    // https://github.com/LuizGsa21/intro-to-java-10th-edition/blob/master/src/ToolKit/Triangle2D.java
	/*
	public boolean overlaps(Triangle2D t) {

        MyPoint[] pt1 = getTrianglePoints();
        MyPoint[] pt2 = t.getTrianglePoints();

        // check is triangle side intersect
        for (int i = 0; i < 3; i++) {
            int maxI = (i+1) % 3; // max indexes

            for (int j = 0; j < 3; j++) {
                int maxJ = (j+1) % 3;
                Line2D line1 = new Line2D.Double(pt2[i].x, pt2[i].y, pt2[maxI].x, pt2[maxI].y);
                Line2D line2 = new Line2D.Double(pt1[i].x, pt1[i].y, pt1[maxJ].x, pt1[maxJ].y);
                if (line1.intersectsLine(line2)) {
                    return true;
                }
            }
        }
        return false;
    }

	
	int NoDivTriTriIsect(float V0[3],float V1[3],float V2[3],
            float U0[3],float U1[3],float U2[3])
{
float E1[3],E2[3];
float N1[3],N2[3],d1,d2;
float du0,du1,du2,dv0,dv1,dv2;
float D[3];
float isect1[2], isect2[2];
float du0du1,du0du2,dv0dv1,dv0dv2;
short index;
float vp0,vp1,vp2;
float up0,up1,up2;
float bb,cc,max;

// compute plane equation of triangle(V0,V1,V2)
SUB(E1,V1,V0);
SUB(E2,V2,V0);
CROSS(N1,E1,E2);
d1=-DOT(N1,V0);
/// plane equation 1: N1.X+d1=0

/// put U0,U1,U2 into plane equation 1 to compute signed distances to the plane
du0=DOT(N1,U0)+d1;
du1=DOT(N1,U1)+d1;
du2=DOT(N1,U2)+d1;

/// coplanarity robustness check
#if USE_EPSILON_TEST==TRUE
if(FABS(du0)<EPSILON) du0=0.0;
if(FABS(du1)<EPSILON) du1=0.0;
if(FABS(du2)<EPSILON) du2=0.0;
#endif
du0du1=du0*du1;
du0du2=du0*du2;

if(du0du1>0.0f && du0du2>0.0f) // same sign on all of them + not equal 0 ?
return 0;                    // no intersection occurs

// compute plane of triangle (U0,U1,U2)
SUB(E1,U1,U0);
SUB(E2,U2,U0);
CROSS(N2,E1,E2);
d2=-DOT(N2,U0);
// plane equation 2: N2.X+d2=0

// put V0,V1,V2 into plane equation 2
dv0=DOT(N2,V0)+d2;
dv1=DOT(N2,V1)+d2;
dv2=DOT(N2,V2)+d2;

#if USE_EPSILON_TEST==TRUE
if(FABS(dv0)<EPSILON) dv0=0.0;
if(FABS(dv1)<EPSILON) dv1=0.0;
if(FABS(dv2)<EPSILON) dv2=0.0;
#endif

dv0dv1=dv0*dv1;https://secure.ingdirect.fr/
dv0dv2=dv0*dv2;

if(dv0dv1>0.0f && dv0dv2>0.0f) // same sign on all of them + not equal 0 ?
return 0;                    // no intersection occurs

// compute direction of intersection line
CROSS(D,N1,N2);

// compute and index to the largest component of D
max=(float)FABS(D[0]);
index=0;
bb=(float)FABS(D[1]);
cc=(float)FABS(D[2]);
if(bb>max) max=bb,index=1;
if(cc>max) max=cc,index=2;

// this is the simplified projection onto L
vp0=V0[index];
vp1=V1[index];
vp2=V2[index];

up0=U0[index];
up1=U1[index];
up2=U2[index];

// compute interval for triangle 1
float a,b,c,x0,x1;
NEWCOMPUTE_INTERVALS(vp0,vp1,vp2,dv0,dv1,dv2,dv0dv1,dv0dv2,a,b,c,x0,x1);

// compute interval for triangle 2
float d,e,f,y0,y1;
NEWCOMPUTE_INTERVALS(up0,up1,up2,du0,du1,du2,du0du1,du0du2,d,e,f,y0,y1);

float xx,yy,xxyy,tmp;
xx=x0*x1;
yy=y0*y1;
xxyy=xx*yy;

tmp=a*xxyy;
isect1[0]=tmp+b*x1*yy;
isect1[1]=tmp+c*x0*yy;

tmp=d*xxyy;
isect2[0]=tmp+e*xx*y1;
isect2[1]=tmp+f*xx*y0;

SORT(isect1[0],isect1[1]);
SORT(isect2[0],isect2[1]);

if(isect1[1]<isect2[0] || isect2[1]<isect1[0]) return 0;
return 1;
}
	
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
*/
}
