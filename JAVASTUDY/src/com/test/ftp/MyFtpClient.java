package com.test.ftp;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class MyFtpClient {
    public static void main(String[] args) throws SocketException, IOException {
        String server = "192.168.20.2";
        int port = 21;
        String id = "lsb0709";
        String pw = "1234";
        String path = "c:\\Repository\\file\\";
        String file = "text.txt";

        FTPClient ftpClient = new FTPClient();
        ftpClient.setControlEncoding("UTF-8");
        ftpClient.connect(server, port);
        int replyCode = ftpClient.getReplyCode();

        // 서버 접속 단계
        if (FTPReply.isPositiveCompletion(replyCode)) {

            // 아래부터는 서버 접속 성공했을 때 실행하는 명령
            System.out.println("FTP 서버에 연결되었습니다.");
            System.out.println(ftpClient.getReplyCode() + "FTP 서버 접속에 성공하였습니다.");

            // 인증 단계
            boolean sucess = ftpClient.login(id, pw);

            if (!sucess) { // 로그인 실패
                System.out.println(ftpClient.getReplyCode() + "로그인이 실패 했습니다.");
                System.exit(1);

            } else { // 로그인 성공
                System.out.println(ftpClient.getReplyCode() + "로그인이 성공 했습니다.");

                ftpClient.setFileType(FTP.BINARY_FILE_TYPE); // 전송 파일 타입 : Binary 파일
                ftpClient.enterLocalPassiveMode(); // Active Mode --> 공인 IP연결, Passive Mode --> 사설 IP 연결

                FileInputStream fileInputStream = new FileInputStream(path + file);
                if (ftpClient.storeFile(file, fileInputStream)) {
                    // 파일 전송 성공
                    System.out.println("업로드 된 파일명 : " + file);
                }
            }
        } else {
            // 시스템 접속 실패했을 때 실행하는 명령
            System.out.println("서버 연결 실패");
        }
    }
}
