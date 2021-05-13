public class Query {
    private int startFloor;
    private int targetFloor;
    private int countPas;
    private Query1.Direction direction;

    public Query(int startFloor, int targetFloor, int countPas){
        this.startFloor = startFloor;
        this.targetFloor = targetFloor;
        this.countPas = countPas;
        this.direction = direction.Down;
    }

    public void setStartFloor(int startFloor){
        this.startFloor = startFloor;
    }
    public void setTargetFloor(int targetFloor){
        this.targetFloor = targetFloor;
    }
    public void setCountPas(int countPas){
        this.countPas = countPas;
    }
    public int getStartFloor(){
        return startFloor;
    }
    public int getTargetFloor(){
        return targetFloor;
    }
    public int getCountPas(){
        return countPas;
    }
    @Override
    public String toString() {
        return "PersonQuery{" +
                "startFloor=" + startFloor +
                ", targetFloor=" + targetFloor +
                ", countPas=" + countPas +
                ", direction=" + direction +
                '}';
    }


}
