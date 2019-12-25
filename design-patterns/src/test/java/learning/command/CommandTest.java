package learning.command;

import learning.command.app.CameraApp;
import learning.command.app.TVApp;
import learning.command.command.CloseCommand;
import learning.command.command.OpenCommand;
import org.junit.Test;

public class CommandTest {
    @Test
    public void testCommand() {
        Command tvOpenCommand = new OpenCommand(new TVApp());
        tvOpenCommand.execute();
        tvOpenCommand.revoke();

        Command cameraCloseCommand = new CloseCommand(new CameraApp());
        cameraCloseCommand.execute();
    }
}
