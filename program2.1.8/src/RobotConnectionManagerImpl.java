public class RobotConnectionManagerImpl implements RobotConnectionManager {

    private final Robot robot;

    public RobotConnectionManagerImpl(Robot robot) {
        this.robot = robot;
    }

    @Override
    public RobotConnection getConnection() throws RobotConnectionException {
        RobotConnectionImpl rc = new RobotConnectionImpl();
        rc.open(this.robot);
        return rc;
    }
}