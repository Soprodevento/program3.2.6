public class RobotConnectionImpl implements RobotConnection{

    private Robot robot;
    @Override
    public void moveRobotTo(int x, int y) throws RobotConnectionException{
        if (this.robot == null){
            throw new RobotConnectionException("Connection to the robot hasn't been established");
        }
        Robot.moveRobot(this.robot, x, y);
    }

    @Override
    public void close() throws RobotConnectionException {
        this.robot = null;
    }

    @Override
    public void open(Robot robot) throws RobotConnectionException {
        if (this.robot != null){
            throw new RobotConnectionException("Connection already established");
        }
        this.robot = robot;
    }

}