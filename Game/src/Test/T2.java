package Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class T2 extends JFrame implements ActionListener {
    JButton j1=new JButton("我是奶龙来点我");
    JButton j2 =new JButton("我是贝利亚来点我");


    public T2(){
        this.setSize(680,700);
        this.setTitle("拼图游戏");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);


        j1.setBounds(0,0,100,50);
        j1.addActionListener(this);

        j2.setBounds(100,0,100,50);
        j2.addActionListener(this);

    this.getContentPane().add(j1);
    this.getContentPane().add(j2);


    this.setVisible(true);



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();
        if(source==j1){
            j1.setSize(200,200);
        }else if(source==j2){
            Random random=new Random();
            j2.setLocation(random.nextInt(500),random.nextInt(500));

        }
    }
}
