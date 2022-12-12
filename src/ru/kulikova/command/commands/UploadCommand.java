package ru.kulikova.command.commands;

import ru.kulikova.command.Command;
import ru.kulikova.command.Receiver;

public class UploadCommand implements Command {
    private Receiver menu;

    public UploadCommand(Receiver menu) {
        this.menu = menu;
    }
    @Override
    public void execute() {
        menu.upload();
    }
}
