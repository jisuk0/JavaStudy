package ch16_network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiChatServer {
	
	private ArrayList<Client> clientList = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void serverStart() {
		ServerSocket server = null;
		try {
			server = new ServerSocket(5000);
			System.out.println("5000포트 서버 오픈!");
			while(true) {
				Socket soc = server.accept();
				System.out.println("요청 수락!");
				System.out.println(soc.getRemoteSocketAddress());
				Client client = new Client(soc);
				client.start();
				clientList.add(client);
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//여러 접속 클라이언트에게 메세지를 전해주기위한 클래스
	public class Client extends Thread{
		Socket soc;
		PrintWriter writer;
		String name;
		
		public Client(Socket soc) {
			this.soc = soc;
			try {
				writer = new PrintWriter(soc.getOutputStream());
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		//접속 클라이언트 모두에게 메세지 전송
		public void sendAll(String msg) {
			for(int i = 0; i < clientList.size(); i++) {
				clientList.get(i).writer.println(msg);
				clientList.get(i).writer.flush();
			}
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));
				name = reader.readLine();
				sendAll(name + " 님이 입장하였습니다");
				while(true) {
					String msg = reader.readLine();
					if(msg == null || msg.isEmpty()) {
						break;
					}
					sendAll(msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				sendAll(name + "님이 퇴장하셨습니다.");
				clientList.remove(this);
				try {
					if(soc != null) soc.close();
				} catch (IOException e) {
					// TODO: handle exception
					
				}
			}
		}
		
		
	}

}
