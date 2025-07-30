package Test;

import java.util.Random;

public class T1 {
    public static void main(String[] args) {


        int [] temp={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};


        Random random=new Random();
        for (int i = 0; i < temp.length; i++) {
            int index =random.nextInt(temp.length);
            int Temp=temp[i];
            temp[i]=temp[index];
            temp[index]=Temp;
        }

        int [][] data= new int[3][5];

        for (int i = 0; i < temp.length; i++) {
           data[i/5][i%5]=temp[i];
        }

        for (int i = 0; i < data.length; i++) {
            System.out.println();
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j]+"\t");
            }
                   
        }




    }
}
