
package ru.geekbrains.skopin.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static int SIZE = 3;
    private static String DOT = "X";
    private static JButton [] jButtons;
    private static GameWindow gameWindow = new GameWindow();

    private GameWindow () {

        setTitle("X/O и swing! GUI v0.1");
        setBounds(100, 100, 350, 400);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

/*
        текстовая панелька внизу окна
 */
        JTextArea textArea = new JTextArea();
        JPanel down = new JPanel(new FlowLayout());
        down.add(textArea);
/*
        панелька с кнопочками - игровое поле
 */
        JPanel center = new JPanel(new GridLayout(SIZE, SIZE));
        jButtons = new JButton[SIZE * SIZE];
/*
        Заморочился с созданием менюшки
        кода много, а сложного нет совсем
 */

        JPanel top = new JPanel(new FlowLayout());
        JMenuBar menu = new JMenuBar();
        JMenu game = new JMenu("Игра");
        JMenuItem newGame = new JMenuItem("Новая игра");
        JMenuItem exit = new JMenuItem("Выход");
        game.add(newGame);
        game.add(exit);
        menu.add(game);
        JMenu options = new JMenu("Настройки");
        JMenu difficulty = new JMenu("Сложность");
        JMenuItem light = new JMenuItem("Легкая");
        JMenuItem medium = new JMenuItem("Средняя");
        JMenuItem hard = new JMenuItem("Тяжелая");
        difficulty.add(light);
        difficulty.add(medium);
        difficulty.add(hard);
        JMenu dots = new JMenu("Выбор фишки");
        JMenuItem dotX = new JMenuItem("Крестики");
        JMenuItem dotO = new JMenuItem("Нолики");
        dots.add(dotX);
        dots.add(dotO);
        options.add(difficulty);
        options.add(dots);
        menu.add(options);
        JMenuItem help = new JMenuItem("Помощь");
        menu.add(help);
        top.add(menu);
/*
        парочка функций
        newGame / новая игра - очистка игрового поля
        exit / выход - выход из программы
        difficulty / сложность - выбор из 3-х вариантов (действия нет)
        dots / выбол фишки - крестик/нолик изменяется надпись при нажатии
        help / помощь - выбрасывается дополнительное окно с текстом
 */

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        dotX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DOT = "X";
            }
        });
        dotO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DOT = "O";
            }
        });
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (int i = 0; i < SIZE * SIZE; i++) {
                    jButtons[i].setText("");
                }
            }
        });
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                HelpWindow.createHelp();
            }
        });
/*
        Кнопочки игрового поля с действием
        изменяется надпись на кнопочке после нажатия
        в соответствии с выбором фишки
        в текстовой строке номер кнопки отображается
 */

        for (int i = 0; i < SIZE * SIZE; i++) {
            jButtons[i] = new JButton();
            center.add(jButtons[i]);
            int a = i;
            jButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    jButtons[a].setText(DOT);
                    textArea.append("Вы нажали кнопку № " + a + "!" );
                }
            });
        }
/*
        все созданное разместил в окне
 */
        add(center, BorderLayout.CENTER);
        add(down, BorderLayout.SOUTH);
        add(top, BorderLayout.NORTH);         // центральное расположение меню менюбар добавлено в панель
//        add(menu, BorderLayout.NORTH);     // обычное расположение меню без панели
    }
    public static GameWindow createGameWindow () {
        return gameWindow;
    }

}
