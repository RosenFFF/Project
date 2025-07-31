import function.GameJFrame;
public class App {

    public static void main(String[] args) {
        new GameJFrame();
        String cwd = System.getProperty("user.dir");
        System.out.println("当前工作目录: " + cwd);


    }
}
