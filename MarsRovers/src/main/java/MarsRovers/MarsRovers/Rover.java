package MarsRovers.MarsRovers;



public class Rover {
	//assigning numbers to directions,
	//this is also gonna help me to determination of turnings(left and right)
	public static final Integer N = 1;
    public static final Integer E = 2;
    public static final Integer S = 3;
    public static final Integer W = 4;
    Integer x = 0;
    Integer y = 0;
    Integer facing = N;
    
    public void setPosition(Integer x, Integer y, Integer facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }
    //determining direction according to facing
    public void printPosition() {
        char direction = 'N';
        if (facing == 1) {
            direction = 'N';
        } else if (facing == 2) {
            direction = 'E';
        } else if (facing == 3) {
            direction = 'S';
        } else if (facing == 4) {
            direction = 'W';
        }
        System.out.println(x + " " + y + " " + direction);
    }
    
    //one by one, each of command(instructions) char being processed
    public void process(String commands) 
	{
		for (int idx = 0; idx < commands.length(); idx++) {
			process(commands.charAt(idx));
		}
	}
	
    //applying commands
	public void process(Character command) {

		if (command.equals('L')) {
			turnLeft();
		} else if (command.equals('R')) {
			turnRight();
		} else if (command.equals('M')) {
			move();
		} else {
			throw new IllegalArgumentException(
                "wrong language!");
		}
	}
	
	//according to directions, increasing x or y coordinates
    public void move() {
        if (facing == N) {
            this.y++  ;
        } else if (facing == E) {
            this.x++  ;
        } else if (facing == S) {
            this.y--;
        } else if (facing == W) {
            this.x--;
        }
    }
    /*
     * executing turnLeft(): facing decreased by 1 and if it is less than N(1),
     * then facing will be W(4). Otherwise it will be decreased by 1 again 
     * executing turnRight(): same logic with turnLeft()
     */
    public void turnLeft() {
        facing = (facing - 1) < N ? W : facing - 1;
    }
    public void turnRight() {
        facing = (facing + 1) > W ? N : facing + 1;
    }

	  
    public static void main(String args[]) {
    	
    	
   
        Rover rover = new Rover();
        System.out.println("Upper-right coordinates: 5 5"+"\n"  
                              +"The rover's position: "+ "1 2 N");
        rover.setPosition(1, 2, N);
        System.out.println("The instruction's of the rover : " + "LMLMLMLMM");
        rover.process("LMLMLMLMM");
        System.out.println("Output is : ");
        rover.printPosition();
        
        System.out.println("-----------------------------------------");
        
        System.out.println("The rover's position: "+ "3 3 E");
        rover.setPosition(3, 3, E);
        System.out.println("The instruction's of the rover : " + "MMRMMRMRRM");
        rover.process("MMRMMRMRRM");
        System.out.println("Output is : ");
        rover.printPosition();
        
        
    }
}