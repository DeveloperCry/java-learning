package learning.command.command;

import learning.command.App;
import learning.command.Command;

public class CloseCommand implements Command {
    private App app;

    public CloseCommand(App app) {
        this.app = app;
    }

    @Override
    public void execute() {
        this.app.close();
    }

    @Override
    public void revoke() {
        this.app.open();
    }
}
