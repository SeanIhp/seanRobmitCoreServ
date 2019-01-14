package cn.com.iherpai.common.utils.fetch;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUrlConnectionProcessor {
	public static final ThreadLocal<HttpURLConnection> session = new ThreadLocal<HttpURLConnection>();

	public static HttpURLConnection getConnection(URL xUrl) throws IOException {
		HttpURLConnection conn = (HttpURLConnection) session.get();
		if (conn == null) {
			conn = (HttpURLConnection) xUrl.openConnection();
			conn.setConnectTimeout(1000*30);
			conn.setReadTimeout(1000*30);
			session.set(conn);
		}
		return conn;
	}

	public static void closeConnection() {
		HttpURLConnection conn = (HttpURLConnection) session.get();
		session.set(null);
		if (conn != null)
			conn.disconnect();
	}
}
