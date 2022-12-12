package ru.kulikova.command.commands;

import ru.kulikova.command.Command;
import ru.kulikova.command.Receiver;

public class SaveCommand implements Command {
    private Receiver menu;

    public SaveCommand(Receiver menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.save();
    }
}
