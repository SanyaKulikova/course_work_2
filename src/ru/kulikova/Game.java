package ru.kulikova;

import ru.kulikova.command.Menu;
import ru.kulikova.command.Receiver;

import java.util.Scanner;

public class Game {
    private Menu menu;

    private int numberOfOpens = 1;

    public Game(Menu menu) {
        this.menu = menu;
    }

    public int getNumberOfOpens() {
        return numberOfOpens;
    }

    public void setNumberOfOpens(int numberOfOpens) {
        this.numberOfOpens = numberOfOpens;
    }

    // Игра может знать свое меню в виде списка? Или его нужно передать через Menu?
    public void openMenu (){
        if (isJustOpen()) {
            System.out.println("Добро пожаловать в игру!");
            showMenu();
        } else showFullMenu();

        setNumberOfOpens(getNumberOfOpens() + 1);

        Scanner sc = new Scanner(System.in);
        int userAns = sc.nextInt();

        switch (userAns) {
            case 1 -> {
                menu.startGame();
            }
            case 2 -> {
                menu.uploadGame();
            }
            case 3 -> {
                menu.exitGame();
            }
            case 4 -> {
                menu.saveGame();
            }
        }

    }

    private void showMenu(){
        System.out.println("Чтобы начать игру, нажмите 1.");
        System.out.println("Чтобы загрузить ранее сохраненную игру, нажмите 2.");
        System.out.println("Чтобы выйти, нажмите 3.");

    }

    private void showFullMenu(){
        System.out.println("Чтобы продолжить игру, нажмите 1.");
        System.out.println("Чтобы загрузить ранее сохраненную игру, нажмите 2.");
        System.out.println("Чтобы выйти, нажмите 3.");
        System.out.println("Чтобы сохранить текущую игру нажмите 4");
    }

    private boolean isJustOpen(){
        return getNumberOfOpens() == 1;
    }



}
