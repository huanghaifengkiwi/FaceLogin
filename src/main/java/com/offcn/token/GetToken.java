package com.offcn.token;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GetToken {

	public static void main(String[] args) {
		String grant_type="client_credentials";
		String client_id="i4N7fwZCBRuifBND9PFlS46t";
		String client_secret="hdCHRYhKv8elElMh9ZKE5x8DqDWs1Ijf";
		String url="https://aip.baidubce.com/oauth/2.0/token?grant_type="+grant_type+"&client_id="+client_id+"&client_secret="+client_secret;
		CloseableHttpClient client = HttpClients.createDefault();
		
		HttpPost post = new HttpPost(url);
		
		try {
			CloseableHttpResponse res = client.execute(post);
			if(res.getStatusLine().getStatusCode()==200){
				HttpEntity entity = res.getEntity();
				System.out.println(EntityUtils.toString(entity, "utf-8"));
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
