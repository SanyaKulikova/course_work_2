package ru.kulikova.command;

import java.sql.Array;

public class Menu {
    private Command start;
    private Command upload;
    private Command save;
    private Command exit;


    public Menu(Command start, Command upload, Command save, Command exit) {
        this.start = start;
        this.upload = upload;
        this.save = save;
        this.exit = exit;
    }

    public void startGame(){
        start.execute();
    }

    public void saveGame(){
        save.execute();
    }

    public void uploadGame(){
        upload.execute();
    }

    public void exitGame(){
        exit.execute();
    }

}
