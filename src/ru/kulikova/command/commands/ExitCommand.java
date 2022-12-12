package ru.kulikova.command.commands;

import ru.kulikova.command.Command;
import ru.kulikova.command.Receiver;

public class ExitCommand implements Command {
    private Receiver menu;

    public ExitCommand(Receiver menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.exit();
    }
}
