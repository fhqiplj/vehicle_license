package com.fhqiplj.powernet.photo.collage;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        System.out.println("Is working at current folder?");
        String result = scan.nextLine();
        if (result.equals("Y") || result.equals("y"))
        {
            File current  = new File("");
            String floder = current.getAbsolutePath();
            System.out.println("Will check out all photo under " + floder + ", and collect at \"Power_Network\" folder");
            File current_folder = new File(floder);
            isDirectory(current_folder, current_folder.getAbsolutePath());


        }else
        {
            System.out.println("You input was not right answer. Quit!");
        }

    }

    public static void isDirectory(File file, String rootFloder) {
        String  destFileName = rootFloder + "/Power_Network";

        if(file.exists()){
            if (file.isFile()) {
                System.out.println("Find one file:" + file.getAbsolutePath());
                if (file.getName().contains("jpg") || file.getName().contains("JPG") ) {
                    System.out.println("Find one picture:" + file.getAbsolutePath());
                    String newFileName = destFileName + "/" + file.getName();
                    if (file.renameTo(new File(newFileName)))
                        System.out.println("Move file to new folder: " + newFileName);
                    else
                        System.out.println("Can not move file to new folder: " + newFileName);
                }
            }else{
                File[] list = file.listFiles();//list获取的结果：[D:\qrcodeFile\20190116, D:\qrcodeFile\20190117]
                if (list.length == 0) {
                    System.out.println(file.getAbsolutePath() + " is null folder");
                } else {
                    for (int i = 0; i < list.length; i++) {
                        isDirectory(list[i], rootFloder);
                    }
                }
            }
        }else{
            System.out.println("文件不存在！");
        }
    }
}
