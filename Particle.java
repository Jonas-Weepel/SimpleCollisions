import java.awt.Point;

public class Particle {
	public double xPos = 0.0;
	public double yPos = 0.0;
	public double speed = 0.0;
	public double angle = 0.0;
	public int radius = 0;
	public double mass =0;

	public Particle( int xPos, int yPos, double speed, double angle, int radius ) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.speed = speed;
		this.angle = angle;
		this.radius = radius;
		this.mass = Math.PI*( Math.pow(radius, 2) );
	}

	public void updateParticle( long time ) {
		double xVel = speed*( Math.cos(Math.toRadians(angle)) );
		double yVel = speed*( -Math.sin(Math.toRadians(angle)) );
		xPos += xVel/time;
		yPos += yVel/time;
	}

	public static void detectCollisions( Particle[] particle ) {

		double collisionDistance = 0.0;
		double particleDistance = 0.0;
		double xDisplacement = 0.0;
		double yDisplacement = 0.0;
		Particle[] collisionPair = new Particle[2];
		
		for( int i=0; i<particle.length; i++ ) {
			for( int j=1; j<particle.length; j++ ) {
				
				collisionDistance = particle[i].radius + particle[j].radius;
				xDisplacement = particle[j].xPos - particle[i].xPos;
				yDisplacement = particle[j].yPos - particle[i].yPos;
				particleDistance = Math.sqrt( Math.pow(xDisplacement,2) + Math.pow(yDisplacement,2) );
				
				
				if( particleDistance < collisionDistance ) {
					collisionPair[0] = particle[i];
					collisionPair[1] = particle[j];
					collisionPair = handleCollision( collisionPair );
					particle[i] = collisionPair[0];
					particle[j] = collisionPair[1];
					return;
				}
			}
		}
	}

	private static Particle[] handleCollision(Particle[] particle ) {
		
		

		particle[0].speed = (particle[0].speed+particle[1].speed)/2;
		particle[0].angle = particle[0].angle+180;
		
		particle[1].speed = (particle[0].speed+particle[1].speed)/2;
		particle[1].angle = particle[1].angle;
		
		return particle;
	}

	public Point getLocation() {
		return new Point( (int)(xPos), (int)(yPos) );
	}
}