package com.godlikehzj.bio;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException{
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new BioServer().start(9999);
                }catch (IOException e){
                    e.printStackTrace();
                }

            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                int i  = 0;
                while (true){
                    try{
                        String test = "test bio " + i;
                        new BioClient().send(test);
                        i++;
                        if (i == 1000)
                            break;
                    }catch (IOException e){
                        e.printStackTrace();
                    }

                }
            }
        }).start();

    }
}
