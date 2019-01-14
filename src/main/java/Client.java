

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

	public static Socket socket =null;
	public static void openSocket(){
		try {
			socket=new Socket("127.0.0.1", 10086);
		} catch (Exception e) {
			System.out.println("客户端未连接...");
		} 
	}
	public static void close(){
		try {
			socket.close();
		} catch (IOException e) {
		System.out.println("客户端关闭异常...");
		}
	}
public static void main(String []args) throws Exception{
//	OcptopusSocketServer.getInstance().start();
//	System.out.println("客户端等待10秒");
//    #为了使服务进程先启动....
//    Thread.sleep(1000*10);
    openSocket();
    String s1="";
//	s1="type=00";//开机
//	s1="type=01";//查询
//	s1="type=02;receiptNum=000102081534819878533;money=700";//消费
	s1="type=03;receiptNum=000102081534819878533;money=700";//充值
//	s1="type=05";//不能服务
//	s1="type=06";//待机
//	s1="type=07;receiptNum=5643434453355;money=2228;cardNo=56271246";//重新刷卡支付
//	s1="type=08;receiptNum=5643434453355;money=2228;cardNo=56271246";//重新刷卡充值
//	s1="type=04";//关机
    Send(s1,socket);
    System.out.println("------------waitting for response------------------");
    String respstr=Accept(socket);
    System.out.println(respstr);

}

// 发送数据
public static void Send(String obj, Socket socket) throws Exception {
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
			socket.getOutputStream(), "UTF-8"));
	writer.append(obj);
	writer.newLine();
	writer.flush();
}

// 接受数据
public static String Accept(Socket socket) throws IOException {
    //读取客户端数据
	BufferedReader reader = new BufferedReader(new InputStreamReader(socket
			.getInputStream(), "UTF-8"));
	String line = reader.readLine();
	return line;
}
}