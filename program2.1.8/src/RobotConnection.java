public interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y) throws RobotConnectionException;

    @Override
    void close() throws RobotConnectionException;
    void open(Robot robot) throws RobotConnectionException;
}