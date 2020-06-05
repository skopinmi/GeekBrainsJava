
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
    private static int x;
    private static int y;

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
                Main.setDotHuman("X");
                Main.setDotComp("O");
                DOT = "X";
                Main.makeGameField(SIZE);
            }
        });
        dotO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.setDotHuman("O");
                Main.setDotComp("X");
                DOT = "O";
                Main.makeGameField(SIZE);
            }
        });
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (int i = 0; i < SIZE * SIZE; i++) {
                    jButtons[i].setText("");
                    Main.makeGameField(SIZE);
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
                    calculateXY(a);
                    String w = Main.getGameField(x, y);
                    if (w.equals("")) {
                        jButtons[a].setText(DOT);
                        textArea.append("Вы нажали кнопку № " + a + "!");
                        Main.putInGameField(x, y);
                        Main.setMyMove(false);
                    }
                    x = -1;
                    y = -1;
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

    private static void calculateXY (int a) {
        if (a < SIZE ) {
            y = 0;
            x = a;
        } else if (a < SIZE * 2) {
            y = SIZE - 2;
            x = a - SIZE;
        } else {
            y = SIZE - 1;
            x = a - (SIZE * 2);
        }
    }

    public static void setJButton (int x, int y) {
        int a = -1;
        if (y == 0) {
            a = x;
        } else if (y == 1 ) {
            a = SIZE + x;
        } else {
            a = SIZE * 2 + x;
        }
        jButtons[a].setText(Main.getDotComp());
    }

}
