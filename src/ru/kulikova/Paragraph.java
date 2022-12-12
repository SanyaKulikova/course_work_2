package ru.kulikova;

import java.io.Serializable;
import java.util.Objects;

public class Paragraph implements Serializable {
    private String name;
    private String text;
    transient private Paragraph variant1;
    transient private Paragraph variant2;


    public Paragraph(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public Paragraph getVariant1() {
        return variant1;
    }

    public void setVariant1(Paragraph variant1) {
        this.variant1 = variant1;
    }

    public Paragraph getVariant2() {
        return variant2;
    }

    public void setVariant2(Paragraph variant2) {
        this.variant2 = variant2;
    }

    public boolean getGameResult() {
        if (this.getName().equals("Вернуться домой")) {
            System.out.println(this);
            System.out.println("Ура! Вы победили!"); // TODO подумать как правильно заканчивать игру
            // допустим, что чтобы играть заново нужно снова открывать приложение
            return true;
        } else if (this.getName().equals("Поесть немного и передохнуть")
                || this.getName().equals("Нужно попытаться выкрасть мёд немедленно" )
                || this.getName().equals("Искать Бельчонка в одиночку")) {
            System.out.println(this);
            System.out.println("К сожалению, вы проиграли");
            return true;
        } else return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paragraph paragraph = (Paragraph) o;

        if (!Objects.equals(name, paragraph.name)) return false;
        return Objects.equals(text, paragraph.text);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return  name + '\'' +
                 text + '\'';
    }
}
