
package ru.geekbrains.skopin.lesson8;

import javax.swing.*;
import java.awt.*;

public class HelpWindow extends JFrame {

    private static HelpWindow helpWindow;
/*
    окно помощи с текстом (он редактируется. но не сохраняется)
 */
    private HelpWindow() {
        setTitle("Помощь. GUI version 0.1");
        setBounds(10, 10, 400, 400);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JTextPane textPane = new JTextPane();
        textPane.setText(text());
        add(textPane);
        setVisible(true);
    }

    public static void createHelp () {
        if (helpWindow == null) {
            helpWindow = new HelpWindow();
        }
        helpWindow.setVisible(true);
    }

    private static String text () {
        String text = "Хотел объединить графический интерфейс с Крестиками - ноликами из 4 урока, " +
                " но пока ничего не получается, читаю литературу про GUI в Java.. " +
                "Складывается ощущение, что чего-то не хватает - знаний. Нет согласованности действий, " +
                "либо человек играет, а копьютер ждет, либо компьютер играет... " +
                "Над этим пока думаю, а готовое сдаю ... ";
        return text;
    }
}
