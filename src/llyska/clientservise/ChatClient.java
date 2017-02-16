package llyska.clientservise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * �����-������ ���-�������. �������� � �������. �������� � ������� shutdown �������� ������ � �������
 */
public class ChatClient {
    final Socket s; // ��� ����� ����� ��� �������
    final BufferedReader socketReader; // ���������������� �������� � �������
    final BufferedWriter socketWriter; // ���������������� �������� �� ������
    final BufferedReader userInput; // ���������������� �������� ����������������� ����� � �������

    /**
     * ����������� ������� �������
     *
     * @param host - IP ����� ��� localhost ��� �������� ���
     * @param port - ����, �� ������� ����� ������
     * @throws java.io.IOException - ���� �� ������ ���������������, �������� ����������, ����� ������������� ��������
     *         �������
     */
    public ChatClient(String host, int port) throws IOException {
        s = new Socket(host, port); // ������� �����
        // ������� �������� � �������� � ����� � �������� ���������� UTF-8
        socketReader = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));
        socketWriter = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"));
        // ������� �������� � ������� (�� ������������)
        userInput = new BufferedReader(new InputStreamReader(System.in));
        new Thread(new Receiver()).start();// ������� � ��������� ���� ������������ ������ �� ������
    }

    /**
     * �����, ��� ���������� ������� ���� ������ ��������� � ������� � �������� �� ������
     */
    public void run() {
        System.out.println("Type phrase(s) (hit Enter to exit):");
        while (true) {
            String userString = null;
            try {
                userString = userInput.readLine(); // ������ ������ �� ������������
            } catch (IOException ignored) {
            } // � ������� ��������� �� ����� ���� � ��������, ����������
            // ���� ���-�� �� ��� ��� ������������ ������ ����� Enter...
            if (userString == null || userString.length() == 0 || s.isClosed()) {
                close(); // ...��������� �������.
                break; // �� ����� break �� �� ������, �� ����� ��, ����� ���������� �� �������
            } else { // ...�����...
                try {
                    socketWriter.write(userString); // ����� ������ ������������
                    socketWriter.write("\n"); // ��������� "����� ������", ���� readLine() ������� ��������
                    socketWriter.flush(); // ����������
                } catch (IOException e) {
                    close(); // � ����� ������ - ���������.
                }
            }
        }
    }

    /**
     * ����� ��������� ������� � ������� �� ��������� (��� ������������ ����� �������� ������ BufferedReader.readLine(),
     * �� �������� ������������)
     */
    public synchronized void close() {// ����� ���������������, ����� ��������� ������� ��������.
        if (!s.isClosed()) { // ���������, ��� ����� �� ������...
            try {
                s.close(); // ���������...
                System.exit(0); // �������!
            } catch (IOException ignored) {
                ignored.printStackTrace();
            }
        }
    }

    public static void main(String[] args) { // ������� ����� ���������
        try {
            new ChatClient("localhost", 45000).run(); // ������� ��������������...
        } catch (IOException e) { // ���� ������ �� ������...
            System.out.println("Unable to connect. Server not running?"); // ��������...
        }
    }

    /**
     * ��������� ��������� ����� ������������ ������
     */
    private class Receiver implements Runnable {
        /**
         * run() ��������� ����� ������� ���� �� ������������ ������� ����.
         */
        @Override
        public void run() {
            while (!s.isClosed()) { // ����� ��������� �������.
                String line = null;
                try {
                    line = socketReader.readLine(); // ������� ��������
                } catch (IOException e) { // ���� � ������ ������ ������, ��...
                    // ��������, ��� ��� �� ��������� ������� �������� ������ ��������
                    if ("Socket closed".equals(e.getMessage())) {
                        break;
                    }
                    System.out.println("Connection lost"); // � ���� �� ������� � ������ ������ ����.
                    close(); // �� � ��������� ����� (������, ��������� ����� ������ ChatClient, ���� ������)
                }
                if (line == null) { // ������ ����� null ���� ������ ������� ������� �� ����� ����������, ���� ��������
                    System.out.println("Server has closed connection");
                    close(); // ...�����������
                } else { // ����� �������� ��, ��� ������� ������.
                    System.out.println("Server:" + line);
                }
            }
        }
    }
}