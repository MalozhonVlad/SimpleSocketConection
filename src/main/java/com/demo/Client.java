package com.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {


            while (true) {

                /**
                 * Пишу IP и порт сервера с которим хочу установить соебинение !!!
                 */
                Socket clientSocket = new Socket("localhost", 8189);

                /**
                 * посилаю какуету информацию по сети если у меня уже установлено соединение
                 */
                // Request
                OutputStream out = clientSocket.getOutputStream();
                out.write("welcome to the jungle".getBytes());
                out.flush();


                /**
                 * Принимаю информацию от сервера
                 */
                BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                br.lines().forEach(System.out::println);


                br.close();
                out.close();
                clientSocket.close();
                Thread.sleep(2000);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
