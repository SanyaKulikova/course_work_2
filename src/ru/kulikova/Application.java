package ru.kulikova;
// Взаимодействие с пользователем должно быть реализовано через консоль.
//Меню должно быть реализовано с помощью паттерна Команда,
//где каждый пункт меню - отдельная команда.
//
//Меню:
//1. Начать игру (начало отрисовки параграфов)
//2. Загрузить игру
//3. Выйти
//
//После начала игры должна быть возможность выйти в меню при этом
//в меню появляется новый пункт 'Сохранить игру'.
//
//Когда пользователь выбирает пункт 'Сохранить игру'
//состояние игры необходимо сохранять в файл и
//восстанавливать при выборе пункта 'Загрузить игру'.
//
//Параграфы-узлы в файле 'узлы-и-переходы.png'

import ru.kulikova.command.Menu;
import ru.kulikova.command.Receiver;
import ru.kulikova.command.commands.ExitCommand;
import ru.kulikova.command.commands.SaveCommand;
import ru.kulikova.command.commands.StartCommand;
import ru.kulikova.command.commands.UploadCommand;

import java.util.Map;

public class Application {
    public static void main(String[] args) {

        Paragraph paragraph01 = new Paragraph("Лисенок",
                "Каждое утро Лисёнок просыпался, завтракал и шёл " +
                "увидеться с Бельчонком. Это утро не было исключением. Лисёнок пришёл на их обычное место встречи,\n " +
                "но Бельчонка там не было. Лисёнок ждал, ждал, но так и не смог дождаться своего друга. " +
                "Бельчонок не пропустил еще ни одной встречи, вдруг он попал в беду.\n - подумал Лисёнок. " +
                "Как поступить Лисенку?");
        Paragraph paragraph02 = new Paragraph("Вернуться домой",
                " Вернувшись домой, Лисёнок нашёл там Бельчонка. Оказалось, что Бельчонок пришёл на место " +
                        "встречи раньше и увидел там рой злобных пчел.\n Он поспешил предупредить об этом Лисёнка, " +
                        "но они разминулись. Наконец-то друзья нашли друг друга! Игра завершилась успехом");
        Paragraph paragraph03 = new Paragraph("Отправиться на поиски",
               "Все лесные жители были заняты своими делами и не обращали внимания на Лисёнка и его проблему. " +
                       "Но вдруг кто нибудь видел Бельчонка... Лисёнок не знал, что ему делать. Помогите ему." );
        Paragraph paragraph04 = new Paragraph("Попытаться разузнать о Бельчонке у лесных жителей",
                "Пока Лисёнок принимал решение, лесные жители разошлись кто куда. Остались только Сова и Волк. " +
                        "Но у Совы бывают проблемы с памятью, а Волк может сильно разозлиться из-за расспросов. " +
                        "Кого выбрать?");
        Paragraph paragraph05 = new Paragraph("Искать Бельчонка в одиночку",
                "Лисёнок слишком долго плутал по лесу в поисках друга и сам не заметил, как заблудился. " +
                        "Теперь его самого нужно искать. Игра завершилась неудачей");
        Paragraph paragraph06 = new Paragraph("Расспросить Сову",
                "Сова долго не хотела говорить, но в итоге сказала, что видела испуганного Бельчонка, бежавшего " +
                        "вглубь леса. Все лесные жители знают, что в глубине леса опасно, если Бельчонок там, ему " +
                        "срочно нужна помощь.");
        Paragraph paragraph07 = new Paragraph("Расспросить Волка",
                "Волк оказался вполне дружелюбным, но помочь не смог. Лишь сказал, что маленькому лисенку не " +
                        "стоит бродить по лесу одному. И как теперь поступить?");
        Paragraph paragraph08 = new Paragraph("Поверить Сове и отправиться вглубь леса",
                "В глубине леса Лисёнок встретил Медвежонка. Ленивый Медвежонок был готов рассказать все, " +
                        "что знает, если Лисёнок принесёт ему мёда.");
        Paragraph paragraph09 = new Paragraph("Нужно воспользоваться шансом и раздобыть мёд",
                "Лисёнок быстро нашёл мёд, но вокруг летал рой злобных пчел. Лисёнок всегда боялся пчёл, но и " +
                        "не найти друга он тоже боялся.");
        Paragraph paragraph10 = new Paragraph("Подождать, вдруг пчёлы улетят",
                "Лисёнок подождал немного, и пчёлы разлетелись. Лисёнок без проблем набрал мёда. Вдруг он " +
                        "понял, что очень голоден. Что же делать?");
        Paragraph paragraph11 = new Paragraph("Нужно попытаться выкрасть мёд немедленно",
                "Это была не лучшая идея. Пчёлы покусали Лисёнка, теперь ему самому нужна помощь. " +
                        "Игра завершилась неудачей");
        Paragraph paragraph12 = new Paragraph("Поесть немного и передохнуть",
                "Пока Лисёнок ел, злобные пчёлы вернулись и покусали его. Лисёнку нужна помощь, он не сможет " +
                        "продолжить поиски. Игра завершилась неудачей");
        Paragraph paragraph13 = new Paragraph("Скорее отнести мёд Медвежонку",
                "Довольный Медвежонок рассказал Лисёнку, что очень хорошо знает семью Белок и уверен, что " +
                        "Бельчонок никогда не пошёл бы в глубь леса. Он заверял Лисёнка, что Белки не попадают в " +
                        "неприятности, и что Совам нельзя верить, он также уговаривал Лисёнка вернуться домой.");
        paragraph01.setVariant1(paragraph02);
        paragraph01.setVariant2(paragraph03);
        paragraph03.setVariant1(paragraph04);
        paragraph03.setVariant2(paragraph05);
        paragraph04.setVariant1(paragraph06);
        paragraph04.setVariant2(paragraph07);
        paragraph06.setVariant1(paragraph08);
        paragraph06.setVariant2(paragraph05);
        paragraph07.setVariant1(paragraph02);
        paragraph07.setVariant2(paragraph05);
        paragraph08.setVariant1(paragraph05);
        paragraph08.setVariant2(paragraph09);
        paragraph09.setVariant1(paragraph10);
        paragraph09.setVariant2(paragraph11);
        paragraph10.setVariant1(paragraph12);
        paragraph10.setVariant2(paragraph13);
        paragraph13.setVariant1(paragraph05);
        paragraph13.setVariant2(paragraph02);

        paragraph06.setDescription2("Сове не стоит верить ->");
        paragraph07.setDescription1("Волк прав ->");
        paragraph08.setDescription1("Нет, потрачено слишком много времени, нужно идти дальше ->");
        paragraph13.setDescription1("Медвежонок ничего не знает, нужно продолжить поиски ->");
        paragraph13.setDescription2("Может быть он прав и Лисёнок просто паникует ->");

        Receiver receiver = new Receiver(paragraph01);

        Menu menu = new Menu(new StartCommand(receiver),
                new UploadCommand(receiver),
                new SaveCommand(receiver),
                new ExitCommand(receiver));

        Game game01 = new Game(menu);
        receiver.setGame(game01);

        game01.openMenu();


    }
}
