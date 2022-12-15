package ru.kulikova.command;


import ru.kulikova.Game;
import ru.kulikova.Paragraph;

import java.io.*;
import java.util.Scanner;

public class Receiver {
    private Game game; // не уверена, что это праивильно
    // Просто не понимаю как еще выйти в меню
    private Paragraph currentParagraph;


    public Receiver(Paragraph paragraph) {
        this.currentParagraph = paragraph;
    }

    public Paragraph getCurrentParagraph() {
        return currentParagraph;
    }

    public void setCurrentParagraph(Paragraph currentParagraph) {
        this.currentParagraph = currentParagraph;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    // TODO внутри устанавливаем текущим параграфом - 1-ый и запускаем метод отрисовки
    public void start(){
        boolean result = true;
        while (result){
            if (getCurrentParagraph().getGameResult()) break;
            choiceParagraph();
            Scanner scanner = new Scanner(System.in);
            int userAns = scanner.nextInt();
            switch (userAns) {
                case 1 -> {
                    setCurrentParagraph(getCurrentParagraph().getVariant1());
                }
                case 2 -> {
                    setCurrentParagraph(getCurrentParagraph().getVariant2());
                }
                case 3 -> {
                    result = false;
                    getGame().openMenu();
                }
            }
        }
    }

    public void save(){
        BinHandler<Paragraph> receiverBinHandler = new BinHandler<>();
        receiverBinHandler.writeToFile(getCurrentParagraph());
        System.out.println("Игра сохранена");
    }

    public void upload(){
        System.out.println("Загрузка игры...");
        BinHandler<Paragraph> receiverBinHandler = new BinHandler<>();
        try {
            setCurrentParagraph(receiverBinHandler.readFromFile());
            start();
        } catch (RuntimeException e){ // Не понимаю в чем ошибка...
            System.out.println("Ранее сохраненных игр не обнаружено");
            getGame().openMenu();
        }
    }

    public void exit(){
        System.out.println("Закрытие игры"); // я не понимаю как правильно закрыть игру
    }

    private void choiceParagraph(){
        System.out.println(currentParagraph.getText());
        System.out.println(currentParagraph.getDescription1() + currentParagraph.getVariant1().getName() + ". " +
                "Для выбора этого варианта нажмите 1");
        System.out.println(currentParagraph.getDescription2() + currentParagraph.getVariant2().getName() + ". " +
                "Для выбора этого варианта нажмите 2");
        System.out.println("Для того, чтобы выйти в основное меню, нажмите 3");
    }



    public class BinHandler<T> {
        private File file;

        public BinHandler() {
            file = new File("receiver.bin");
        }

        public void writeToFile(T object) {
            try (FileOutputStream fileOutput = new FileOutputStream(file);
                 ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)) {
                objectOutput.writeObject(object);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public T readFromFile() {
            Object result = null;
            try (FileInputStream fileInput = new FileInputStream(file);
                 ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {
                result = objectInput.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            return (T) result;
        }

    }


}
