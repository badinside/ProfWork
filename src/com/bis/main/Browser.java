package com.bis.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Browser {

	private String UserAgent;
	private Boolean UseProxy;

	public Browser() {
		setUserAgent("Mozilla/5.0 (X11; U; Linux i686; pl-PL; rv:1.9.0.2) Gecko/20121223 Ubuntu/9.25 (jaunty) Firefox/3.8");
		setUseProxy(false);

	}

	public Page OpenUrl(String InUrl) {
		Page page = new Page();

		try {
			URL url = new URL(InUrl);
			URLConnection conn = url.openConnection();
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(10000);
			conn.setRequestProperty("User-agent", UserAgent);
			conn.connect();

			BufferedReader htmlPage = new BufferedReader(new InputStreamReader(url.openStream()));

			String line = "";
			while ((line = htmlPage.readLine()) != null) {
				System.out.println(line);
			}
			htmlPage.close();
			return page;

		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;

		}

	}

	public String getUserAgent() {
		return UserAgent;
	}

	public void setUserAgent(String userAgent) {
		UserAgent = userAgent;
	}

	public void setUseProxy(Boolean useProxy) {
		UseProxy = useProxy;
	}

	public Boolean getUseProxy() {
		return UseProxy;
	};

}
