package learning.command.command;

import learning.command.App;
import learning.command.Command;

public class OpenCommand implements Command {
    private App app;

    public OpenCommand(App app) {
        this.app = app;
    }

    @Override
    public void execute() {
        this.app.open();
    }

    @Override
    public void revoke() {
        this.app.close();
    }
}
