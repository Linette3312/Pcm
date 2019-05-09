package pacman.entries.pacman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import pacman.controllers.Controller;
import pacman.game.Game;

import static pacman.game.Constants.*;

public class MyPacMan extends Controller<MOVE>
{	
	private static final int MIN_DISTANCE=10;	
	 private Random random = new Random();
	
	
	
	
	public MOVE getMove(Game game,long timeDue)
	{			
		int current=game.getPacmanCurrentNodeIndex();
		int[] puntos=game.getPillIndices();
		int[] puntosPoder=game.getActivePowerPillsIndices();	
		ArrayList<Integer> targets=new ArrayList<Integer>();
		
		
		
		
		//Capa 1 : Huye de los fantasmas
				for(GHOST ghost : GHOST.values())
					if(game.getGhostEdibleTime(ghost)==0 && game.getGhostLairTime(ghost)==0)
						if(game.getShortestPathDistance(current,game.getGhostCurrentNodeIndex(ghost))<MIN_DISTANCE) {
							System.out.println("huyendo");
							return game.getNextMoveAwayFromTarget(game.getPacmanCurrentNodeIndex(),game.getGhostCurrentNodeIndex(ghost),DM.PATH);
							}
				
				
				//Puntos Poder
				for(int i = 0; i<puntosPoder.length;i++) {
					if(game.isPowerPillStillAvailable(i)) {
						System.out.println("aún haaaayyyy!!!");
						targets.add(puntosPoder[i]);
						System.out.println("Indices: "+targets.size());
						
						for(GHOST ghost : GHOST.values()) {
						
						if(game.getShortestPathDistance(current, puntosPoder[i])<70 && game.getGhostLairTime(ghost)==0) {
							System.out.println("hola \t"+puntosPoder.length+" "+game.getGhostLairTime(ghost));
							System.out.println("\n"+game.getShortestPathDistance(current, puntosPoder[i]));
							System.out.println("punto poder");
							System.out.println(puntosPoder.length);
							return game.getNextMoveTowardsTarget(current, puntosPoder[i], DM.PATH);
						}
						}
					}
				}
				
				
		//Capa 2
		int[] targetsArray = null;
		
		
		for(int i=0;i<puntos.length;i++) {
			int points = puntos.length;
			if(game.isPillStillAvailable(i)) {
				targets.add(puntos[i]);
				if(game.getShortestPathDistance(current, puntos[i])<20 ) {
					System.out.println("pill");
					
					//System.out.println("\n"+game.getShortestPathDistance(current, puntosPoder[i]));
					
					points=points-i;
					System.out.println(":v   "+points);
					return game.getNextMoveTowardsTarget(current, puntos[i], DM.PATH);
				}
			}
		}
		
		targetsArray=new int[targets.size()];		
		
		for(int i=0;i<targetsArray.length;i++) {
			targetsArray[i]=targets.get(i);
			
		}
		
		
		
		
		
//		MOVE[] moves = game.getPossibleMoves(current, game.getPacmanLastMoveMade());
//        if (moves.length > 0) {
//            return moves[random.nextInt(moves.length)];
//        }
        // Must be possible to turn around
        //return game.getPacmanLastMoveMade().opposite();
		
		
		
		return game.getNextMoveTowardsTarget(current,game.getClosestNodeIndexFromNodeIndex(current,targetsArray,DM.PATH),DM.PATH);

		
		
		
		
		
		
		
		//Capa 3: Colectar puntos poder
		
		
		
		
		
		//Capa 4: Comerse a los fantasmas azules.
		
		
		
		
		
		
		//Capa 3: Colectar bolitas sin poder
		
				
		//Verifica que aún haya puntos poder en el ambiente.
						
		
		
		
		
		
				
				
		
	}
	
	
}


						




















