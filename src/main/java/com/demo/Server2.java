package com.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * создаем сервер которий будет слушать порт 8189
 */
public class Server2 {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8189);// создаем сокет которий слушает порт 8189 на нашем компе
        try {
            System.out.println("Server starts...");

            while (true) {

                /**
                 * если на мой IP и на порт (8189) постучится ктото извне (из интернета) то тут я создам и с ним
                 * соебинение ( метод serverSocket.accept() )
                 */
                Socket socket = serverSocket.accept();


                /**
                 * тут я считиваю информацию которая передается мне по сокету (например слова что ты мне присилаешь)
                 */
                InputStreamReader input = new InputStreamReader(socket.getInputStream());

                /**
                 * просто обрабативаю инфу что прищла и чтото с ней делаю
                 */
                StringBuilder s = new StringBuilder();
                Thread.sleep(100);
                while (input.ready()) s.append((char) input.read());
                System.out.println("read request: " + s);

                /**
                 * Тут я посилаю какойто ответ клиенту что приконектился ко мне...
                 */
                OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
                String answer = "Hello client";
                out.write(answer);
                out.flush();
                System.out.println("Send message: " + answer);


                out.close();
                socket.close();

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        serverSocket.close();
    }
}
