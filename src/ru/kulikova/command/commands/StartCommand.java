package ru.kulikova.command.commands;

import ru.kulikova.command.Command;
import ru.kulikova.command.Receiver;

public class StartCommand implements Command {
    private Receiver menu;

    public StartCommand(Receiver menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.start();
    }

    @Override
    public String toString() {
        return "start";
    }
}
