import java.util.Random;

public class Query1 implements Runnable {
    private int countFloors;
    private ElevatorOrg elevatorOrg;

    public enum Direction{
        Down,Up,Stationary
    }

    public Query1(int countFloors, ElevatorOrg elevatorOrg){
        setCountFloors(countFloors);
        setElevatorOrg(elevatorOrg);
    }

    public <countFloors> void setCountFloors(int countFloors){
        this.countFloors = this.countFloors;
    }

    public void setElevatorOrg(ElevatorOrg elevatorOrg) {
        this.elevatorOrg = elevatorOrg;
    }

    public int getCountFloors(){
        return countFloors;
    }

    public ElevatorOrg getElevatorOrg(){
        return elevatorOrg;
    }

    @Override
    public void run() {
        while (true){
            Random rand = new Random();

        }
    }
}
