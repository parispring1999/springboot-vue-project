package com.wms.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Csachieve {
    //public static void main(String [] args) {
    public static void main() {
        //Scanner scanner = new Scanner(System.in);
        //int a = scanner.nextInt();
        //int b = scanner.nextInt();
        //int c = scanner.nextInt();

        try {
            //String[] my_args =new String[] {"python","test.py",String.valueOf(a),String.valueOf(b),String.valueOf(c)};
            String[] my_args =new String[] {"python","/root/桌面/springboot-vue-project/pycmd/control_shell.py"};
            Process proc =  Runtime.getRuntime().exec(my_args);//执行脚本

            BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
            proc.waitFor();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
