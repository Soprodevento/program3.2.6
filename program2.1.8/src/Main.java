public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot(0, 0, Direction.UP);
        RobotConnectionManager robotConnectionManager = new RobotConnectionManagerImpl(robot);
        moveRobot(robotConnectionManager, -3,0);
        System.out.println("Конечная позиция " + robot.getX() + " " + robot.getY() + ". Направление взгляда: " + robot.getDirection());
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int x, int y){

        int numAttempts = 3;

        for (int i = 0; i < numAttempts; i++) {
            try (RobotConnection rc = robotConnectionManager.getConnection()){
                rc.moveRobotTo(x, y);
                rc.close();
                break;
            } catch (RobotConnectionException e){
                if (i + 1 >= numAttempts){
                    throw new RobotConnectionException(e.getMessage());
                }
            }
        }
    }

}