import java.util.Calendar;

public class CollisionDrawingMain {

	public static void main(String[] args) {
		
		GraphicHelper graphicHelper = new GraphicHelper();
		
		//initiate particles
		Particle particle[] = new Particle[2];
		
		//Particle( int xPos, int yPos, double speed, double angle, int radius )
		particle[0] = new Particle( 400, 400, 100, 0.0, 20 );
		particle[1] = new Particle( 800, 400, 0, 0.0, 20 );
		
		//initiate timing variables
		final long TOTAL_TIME = 7000;
		long startTime = Calendar.getInstance().getTimeInMillis();
		long currentTime = startTime;
		long prevTime = startTime;
		long endTime = startTime + TOTAL_TIME;
		long timeDifference = 0;
		
		//loop until total time is reached
		boolean timesUp = false;
		while( timesUp == false ) {
			
			prevTime = currentTime;
			try { Thread.sleep(20) ; }catch(Exception e) {}
			currentTime = Calendar.getInstance().getTimeInMillis();
			timeDifference = currentTime - prevTime;
			
			
			Particle.detectCollisions( particle );
			
			graphicHelper.clearScreen();
			for( int i=0; i<particle.length; i++ ) {
				
				particle[i].updateParticle(timeDifference);
				graphicHelper.drawCircle( particle[i] );
				
			}
			
			
			
			if( currentTime > endTime ) {
				timesUp = true;
			}
		}
		
		System.exit(0);
	}
}
