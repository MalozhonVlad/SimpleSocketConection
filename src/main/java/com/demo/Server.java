//package com.demo;
//
//
//
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//
//public class Server {
//    public static void main(String[] args) {
//        try {
//            System.out.println("Server starts...");
//            ServerSocket serverSocket = new ServerSocket(8189);
//
//            ExecutorService es = Executors.newFixedThreadPool(10);
//
//            for (int i = 0; i < 5; i++) {
////                System.out.println("Thread #" + i + "starts");
//                es.submit(new Thread(() ->{
//                    try{
//
//                        while (true) {
//                            Socket clientSocket = serverSocket.accept(); // устанавливаем соединения
//
//                            // Request
//                            InputStreamReader input = new InputStreamReader(clientSocket.getInputStream());
//                            StringBuilder s = new StringBuilder();
//                            Thread.sleep(100);
//                            while (input.ready()) s.append((char) input.read());
//                            System.out.println("read request: " + s);
//
//                            // Response
//                            OutputStreamWriter out = new OutputStreamWriter(clientSocket.getOutputStream());
////                            String answer = "HTTP/1.1 200 OK\n" +
////                                    "Cache-Control: no-cache\n" +
////                                    "Connection: close:\n" +
////                                    "Content-Type: application/json\n\n" +
////                                    "{\"ok\": \"" + (s.toString().length() > 30 ? "too long" : s.toString()) + "\"}";
//
//                            String answer = "Hello";
//
//                            out.write(answer);
//                            out.flush();
//                            System.out.println("Send message: " + answer);
//                            input.close();
//                            out.close();
//                            clientSocket.close();
//
//                        }
//
//
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
//                }));
//            }
//
//            Thread.sleep(100000);
//            serverSocket.close();
//            System.out.println("Server is closed...");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
