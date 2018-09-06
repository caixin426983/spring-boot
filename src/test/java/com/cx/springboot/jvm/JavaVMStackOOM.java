package com.cx.springboot.demo;

public class JavaVMStackOOM {


    private void donStop(){
        while (true){

        }
    }

    public void stackLeakByThread(){
        while (true){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    donStop();
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }


}
