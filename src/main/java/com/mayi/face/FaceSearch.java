package com.mayi.face;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class FaceSearch {
public static void main(String[] args) throws IOException {
	String url="https://aip.baidubce.com/rest/2.0/face/v3/search";
	
	String access_token="24.1c9bd773e8d769b8094e9298ddfe1f1f.2592000.1530691612.282335-11347282";
	String image="";
	
	//把图片文件读取
	byte[] bytes = FileUtils.readFileToByteArray(new File("d:\\1.jpg"));
	image=Base64.encodeBase64String(bytes);
	CloseableHttpClient client = HttpClients.createDefault();
	
	HttpPost post = new HttpPost(url+"?access_token="+access_token);
	
	post.addHeader("Content-Type", "application/json");
	
	List<NameValuePair> list=new ArrayList<NameValuePair>();
	list.add(new BasicNameValuePair("image", image));
	list.add(new BasicNameValuePair("image_type", "BASE64"));
	list.add(new BasicNameValuePair("group_id_list", "java0115"));
	
	
	post.setEntity(new UrlEncodedFormEntity(list));
	
	try {
		CloseableHttpResponse res = client.execute(post);
		if(res.getStatusLine().getStatusCode()==200){
			HttpEntity entity = res.getEntity();
			System.out.println(EntityUtils.toString(entity, "utf-8"));
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	client.close();
	
}
}
