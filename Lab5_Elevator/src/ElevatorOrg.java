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

            Iterator<Query1> iterator = queue.iterator();
            while (iterator.hasNext()) {
                Query1 request = iterator.next();
                for (Elevator elevator :
                        elevators) {

                    //empty elevator
                    if (!elevator.isBusy()) {
                        elevator.addRequest(request);
                        iterator.remove();
                        break;
                    }

                    // same direction
                    if (elevator.isBusy() &&
                            elevator.getDirection() == Direction.UP &&
                            Query.getStartFloor() > elevator.getCurrentFloor() &&
                            Query.getCountPas() <= elevator.getCurrentCapacity()) {
                        elevator.addRequest(request);
                        iterator.remove();
                        break;
                    }
                }

                ExecutorService executor = Executors.newFixedThreadPool(elevators.size());
                elevators.forEach(elevator -> executor.submit(elevator.getMove()));
                stop(executor);

        /*for (Elevator elevator :
            elevators) {
          elevator.move();
        }*/

                for (int i = 0; i < elevators.size(); i++) {
                    System.out.println("Elevator " + i + " - " + elevators.get(i));
                }

            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ElevatorService that = (ElevatorService) o;
        return Objects.equals(elevators, that.elevators) && Objects
                .equals(queue, that.queue) && Objects.equals(lock, that.lock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elevators, queue, lock);
    }

    @Override
    public String toString() {
        return "ElevatorService{" +
                "elevators=" + elevators +
                ", queue=" + queue +
                ", lock=" + lock +
                '}';
    }
}

        }
    }






}
