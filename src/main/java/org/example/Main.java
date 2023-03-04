package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main {

    public static Robot robot = null;
    public static void main(String[] args) {
        try{
            robot = new Robot();
        }catch(Exception e){
            e.printStackTrace();
        }

        //Создание окна
        JFrame window = new JFrame();
        window.setUndecorated(true);
        window.setAlwaysOnTop(true);
        window.setLocation(0,0);
        window.setLayout(new FlowLayout());

        JButton[] btn = new JButton[5];
        for (int i = 0; i < 5; i++){
            btn[i] = new JButton();
            btn[i].setName("b"+i);
            btn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Определяем кнопку
                    JButton button = (JButton)e.getSource();
                    String name = button.getName();
                    switch(name){
                        case "b0": // браузер
                            try {
                                ProcessBuilder proc = new ProcessBuilder("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
                                proc.start();
                            }catch(Exception ex){
                                ex.printStackTrace();
                            }
                            break;
                        case "b1": // мышь
                            for (int i = 500; i >= 0; i--){
                                robot.mouseMove(i,i);
                                robot.delay(5);
                            }
                            robot.mouseMove(50,30);
                            robot.mousePress(InputEvent.getMaskForButton(MouseEvent.BUTTON1));
                            robot.delay(200);
                            robot.mouseRelease(InputEvent.getMaskForButton(MouseEvent.BUTTON1));
                            break;
                        case "b2": // калькулятор
                            try {
                                ProcessBuilder proc = new ProcessBuilder("calc");
                                proc.start();
                            }catch (Exception ex){
                                ex.printStackTrace();
                            }
                            robot.delay(1000);
                            robot.keyPress(KeyEvent.VK_ALT);
                            robot.keyPress(KeyEvent.VK_F4);
                            robot.keyRelease(KeyEvent.VK_ALT);
                            robot.keyRelease(KeyEvent.VK_F4);
                            break;
                        case "b3": // мигание

                            break;
                        case "b4": // выход
                            System.exit(0);
                            break;
                    }
                }
            });
            window.add(btn[i]);
        }
        btn[0].setText("Браузер");
        btn[1].setText("Мышь");
        btn[2].setText("Калькулятор");
        btn[3].setText("Мигание");
        btn[4].setText("Выход");

        window.pack();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}