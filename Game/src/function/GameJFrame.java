package function;


import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {


    int[][] data = new int[3][5];
    int x = 0;
    int y = 0;
    //正确数组
    int [][] win = {
            {1,2,3,4,5},
            {6,7,8,9,10},
            {11,12,13,14,0}

    };

    //步数
    int step=0;

    //二级菜单
    JMenuItem ReplayItem = new JMenuItem("重新游戏");
    JMenuItem ReloginItem = new JMenuItem("重新登陆");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenuItem accountItem = new JMenuItem("关注我");


    public GameJFrame() {
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
        int[] temp = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};


        Random random = new Random();
        for (int i = 0; i < temp.length; i++) {
            int index = random.nextInt(temp.length);
            int Temp = temp[i];
            temp[i] = temp[index];
            temp[index] = Temp;
        }

        for (int i = 0; i < temp.length; i++) {

            if (temp[i] == 0) {
                x = i / 5;
                y = i % 5;
            }
                data[i / 5][i % 5] = temp[i];
        }


    }

    private void InitImage() {

        this.getContentPane().removeAll();

        if(victory()){
            JLabel winjlabel =new JLabel(new ImageIcon("Game/src/image/win.png"));
            winjlabel.setBounds(400,400,197,73);
            this.getContentPane().add(winjlabel);

        }

        JLabel stepCount =new JLabel("步数"+step);
        stepCount.setBounds(50,30,200,50);
        this.getContentPane().add(stepCount);




        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                int num = data[i][j];


                // 只有当num不为0时才显示图片
                if (num != 0) {
                    JLabel jLabel = new JLabel(new ImageIcon("Game/src/image/images/" + num + ".gif"));
                    jLabel.setBounds(j*136+150, i*214+150, 136, 214);
                    jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                    this.getContentPane().add(jLabel);
                } else {
                    // 对于空格位置，显示一个空标签或背景
                    JLabel emptyLabel = new JLabel();
                    emptyLabel.setBounds(j*136+150, i*214+150, 136, 214);
                    emptyLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                    this.getContentPane().add(emptyLabel);
                }

            }
        }
        //添加背景图片
        JLabel background = new JLabel(new ImageIcon("Game/src/image/background.png"));
        background.setBounds(90, 45, 799, 800);
        this.getContentPane().add(background);
        this.getContentPane().repaint();
    }


    private void InitFunction() {
        //初始化菜单界面
        JMenuBar jMenuBar = new JMenuBar();
        //功能
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我");

        functionJMenu.add(ReplayItem);
        functionJMenu.add(ReloginItem);
        functionJMenu.add(closeItem);
        aboutJMenu.add(accountItem);
        //绑定事件
        ReplayItem.addActionListener(this);
        ReloginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);



        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        this.setJMenuBar(jMenuBar);
    }

    private void InitJmframe() {
        this.setSize(1000, 1000);
        this.setTitle("奶龙拼图");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.addKeyListener(this);


    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code==65){
            //展示完整图片
            this.getContentPane().removeAll();
            JLabel all=new JLabel(new ImageIcon("Game/src/image/all.jpg"));
            all.setBounds(150,150,680,642);
            this.getContentPane().add(all);

            //添加背景图片
            JLabel background = new JLabel(new ImageIcon("Game/src/image/background.png"));
            background.setBounds(90, 45, 799, 800);
            this.getContentPane().add(background);
            this.getContentPane().repaint();

        }


    }


    @Override
    public void keyReleased(KeyEvent e) {

        if(victory()){
            return;
        }


        int code = e.getKeyCode();
        if (code == 37) { // 左方向键 - 空格向左移动（数字向右移动）
            if (y > 0) { // 确保 y-1 不小于0
                // 交换空格和左侧的数字
                data[x][y] = data[x][y - 1];
                data[x][y - 1] = 0;
                y--; // 空格位置向左移动
                step++;
                InitImage();
            }
        } else if (code == 38) { // 上方向键 - 空格向上移动（数字向下移动）
            if (x > 0) { // 确保 x-1 不小于0
                // 交换空格和上方的数字
                data[x][y] = data[x - 1][y];
                data[x - 1][y] = 0;
                x--; // 空格位置向上移动
                step++;
                InitImage();
            }
        } else if (code == 39) { // 右方向键 - 空格向右移动（数字向左移动）
            if (y < data[0].length - 1) { // 确保 y+1 不超出右边界
                // 交换空格和右侧的数字
                data[x][y] = data[x][y + 1];
                data[x][y + 1] = 0;
                y++; // 空格位置向右移动
                step++;
                InitImage();
            }
        } else if (code == 40) { // 下方向键 - 空格向下移动（数字向上移动）
            if (x < data.length - 1) { // 确保 x+1 不超出下边界
                // 交换空格和下方的数字
                data[x][y] = data[x + 1][y];
                data[x + 1][y] = 0;
                x++; // 空格位置向下移动
                step++;
                InitImage();
            }
        } else if (code == 65) {
            InitImage();
        } else if (code == 87) {
            data=new int[][]{
                    {1,2,3,4,5},
                    {6,7,8,9,10},
                    {11,12,13,14,0}
            };
            InitImage();
        }
    }


    public boolean victory(){
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if(data[i][j]!=win[i][j]){
                    return false;
                }
            } 
        }
        return true;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj=e.getSource();

        if(obj==ReplayItem){

            step=0;
            //打乱数据
            InitData();
            //加载图片
            InitImage();
        } else if (obj==ReloginItem) {
            this.setVisible(false);
            new loginJFrame();
            
        } else if (obj == closeItem) {
            System.exit(0);

        } else if (obj == accountItem) {

            JDialog jDialog =new JDialog();
            JLabel mejlabel=new JLabel(new ImageIcon("Game/src/image/me.png"));
            mejlabel.setBounds(0,0,634,866);
            jDialog.getContentPane().add(mejlabel);
            jDialog.setSize(800,800);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setVisible(true);

        }

    }
}


