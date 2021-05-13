import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ElevatorOrg {
    private int CountElevators;
    private int floors;

    List<Elevator> elevators;
    List<Query1> queue;

    public ElevatorOrg(){
        elevators = new ArrayList<>();
        queue = new LinkedList<>();
    }

    public ElevatorOrg(List<Elevator> elevators){
        this.elevators = elevators;
    }

    public ElevatorOrg(int CountElevators){
        for (int i = 0; i < CountElevators; i++) {
            elevators.add(new Elevator());
        }
        queue = new LinkedList<>();
    }

    public void findQuery(Query1 query){
        System.out.println(Thread.currentThread().getName() + " - find");
        synchronized (this) {
            queue.add(query);
        }
    }
    public void progressQuery() {
        System.out.println(Thread.currentThread().getName() + " - in progress");
        synchronized (this){
            if(queue.isEmpty()){
                return;
            }

        }
