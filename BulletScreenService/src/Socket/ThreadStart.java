package Socket;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * ThreadStart程序主入口
 * DO：用于开启监听端口，并分配线程池
 * @author muyoo
 */
public class ThreadStart {
	public static void main(String[] args) throws Exception {
		int port = 55533;
	    ServerSocket server = new ServerSocket(port);
	    ExecutorService threadPool = Executors.newFixedThreadPool(100);
	    while (true) {
	        Socket socket = server.accept();
	        threadPool.submit(new SocketThread(socket));
	      }
	}
}
