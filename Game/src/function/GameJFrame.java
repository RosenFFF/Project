package function;


import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameJFrame extends JFrame {


    int [][] data= new int[3][5];


    public GameJFrame(){
        //初始化界面
        InitJmframe();
        //初始化菜单
        InitFunction();
        //初始化数据
        InitData();



        //初始化图片
        InitImage();


        this.setVisible(true);
    }

    private void InitData() {
        int [] temp={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};


        Random random=new Random();
        for (int i = 0; i < temp.length; i++) {
            int index =random.nextInt(temp.length);
            int Temp=temp[i];
            temp[i]=temp[index];
            temp[index]=Temp;
        }

        for (int i = 0; i < temp.length; i++) {
            data[i/5][i%5]=temp[i];
        }



    }

    private void InitImage() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <5; j++) {
                int num=data[i][j];
                JLabel jLabel=new JLabel(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\PictureGame\\Game\\src\\image\\images\\"+num+".gif"));
                jLabel.setBounds(j*136,i*214,136,214);
                this.getContentPane().add(jLabel);
            }

        }
    }


    private void InitFunction() {
        //初始化菜单界面
        JMenuBar jMenuBar=new JMenuBar();
        //功能
        JMenu functionJMenu=new JMenu("功能");
        JMenu aboutJMenu=new JMenu("关于我们");
        //二级菜单
        JMenuItem ReplayItem =new JMenuItem("重新游戏");
        JMenuItem ReloginItem =new JMenuItem("重新登陆");
        JMenuItem closeItem = new JMenuItem("关闭游戏");
        JMenuItem accountItem = new JMenuItem("公众号");

        functionJMenu.add(ReplayItem);
        functionJMenu.add(ReloginItem);
        functionJMenu.add(closeItem);
        aboutJMenu.add(accountItem);

        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        this.setJMenuBar(jMenuBar);
    }

    private void InitJmframe() {
        this.setSize(700,710);
        this.setTitle("奶龙拼图");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);


    }


}
