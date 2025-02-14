package ch16_network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveThread extends Thread {
	private Socket soc;
	
	public ReceiveThread(Socket soc) {
		this.soc = soc;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(soc.getInputStream(), "UTF-8"));
			while(true) {
				String msg = reader.readLine();
				if(msg == null || msg.equals("")) {
					break;
				}
				System.out.println(msg);
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (soc != null) {
					soc.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	
}
