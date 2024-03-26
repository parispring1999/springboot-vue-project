package com.wms;

import org.springframework.boot.SpringApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartAll {
        public static void main(String[] args) {
            SpringApplication.run(com.wms.WmsApplication.class, args);
            try {
                //String[] my_args =new String[] {"python","test.py",String.valueOf(a),String.valueOf(b),String.valueOf(c)};
                String[] my_args =new String[] {"/bin/bash","-c","cd /root/桌面/springboot-vue-project/VueWorkspace/wms-web;npm run serve"};
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
