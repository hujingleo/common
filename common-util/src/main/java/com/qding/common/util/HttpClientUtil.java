package com.qding.common.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;



/**
 * 封装了一些采用HttpClient发送HTTP请求的方法
 * 
 * @author magenm
 * 
 */
public class HttpClientUtil {

	private static Log log = LogFactory.getLog(HttpClientUtil.class);

	private HttpClientUtil() {
	}
	public static InputStream sendGetRequest(String reqURL, String decodeCharset, String param, HashMap<String, String> headers) {
		long responseLength = 0; // 响应长度
		String responseContent = null; // 响应内容
		HttpClient httpClient = new DefaultHttpClient(); // 创建默认的httpClient实例

		HttpGet httpGet = new HttpGet(reqURL+URLEncoder.encode(param));
		for(String key:headers.keySet()){
			httpGet.setHeader(key, headers.get(key));
		}


		try {
			HttpResponse response = httpClient.execute(httpGet); // 执行GET请求
			log.info(" status = "+response.getStatusLine());
			System.out.println(response);
			HttpEntity entity = response.getEntity(); // 获取响应实体
			if (null != entity) {
				responseLength = entity.getContentLength();
				log.info(" responseLength = "+responseLength);

//				responseContent = EntityUtils.toString(entity,
//						decodeCharset == null ? "UTF-8" : decodeCharset);
			//	EntityUtils.consume(entity); // Consume response content

				InputStream instream = entity.getContent();
				log.info(" instream = " + instream);
				FileOutputStream fos = new FileOutputStream("d:/logo1.jpg");
				byte[] buffer = new byte[1024];
				int len1 = 0;
				while ((len1 = instream.read(buffer)) != -1) {
					fos.write(buffer, 0, len1);
				}
				fos.close();
				return instream;


			}
			// System.out.println("请求地址: " + httpGet.getURI());
			// System.out.println("响应状态: " + response.getStatusLine());
			// System.out.println("响应长度: " + responseLength);
			// System.out.println("响应内容: " + responseContent);
		} catch (Exception e) {
			log.error("该异常通常是网络原因引起的,如HTTP服务器未启动等,堆栈信息如下", e);
		} finally {
			httpClient.getConnectionManager().shutdown(); // 关闭连接,释放资源
		}
		return null;
	}
	public static Object sendGetRequest
			(String reqURL, String decodeCharset, String param, HashMap<String, String> headers,boolean isFile,String filePath) {
		long responseLength = 0; // 响应长度
		String responseContent = null; // 响应内容
		HttpClient httpClient = new DefaultHttpClient(); // 创建默认的httpClient实例

		HttpGet httpGet = new HttpGet(reqURL+URLEncoder.encode(param));
		for(String key:headers.keySet()){
			httpGet.setHeader(key, headers.get(key));
		}


		try {
			HttpResponse response = httpClient.execute(httpGet); // 执行GET请求
			log.info(" status = "+response.getStatusLine());
			System.out.println(response);
			HttpEntity entity = response.getEntity(); // 获取响应实体
			if (null != entity) {
				responseLength = entity.getContentLength();
				log.info(" responseLength = " + responseLength);
				if(isFile){
					InputStream instream = entity.getContent();
					log.info(" instream = " + instream);
					FileOutputStream fos = new FileOutputStream(filePath);
					byte[] buffer = new byte[1024];
					int len1 = 0;
					while ((len1 = instream.read(buffer)) != -1) {
						fos.write(buffer, 0, len1);
					}
					fos.close();
					return instream;
				}else{
					responseContent = EntityUtils.toString(entity,
						decodeCharset == null ? "UTF-8" : decodeCharset);
					return responseContent;
				}





			}
			// System.out.println("请求地址: " + httpGet.getURI());
			// System.out.println("响应状态: " + response.getStatusLine());
			// System.out.println("响应长度: " + responseLength);
			// System.out.println("响应内容: " + responseContent);
		} catch (Exception e) {
			log.error("该异常通常是网络原因引起的,如HTTP服务器未启动等,堆栈信息如下", e);
		} finally {
			httpClient.getConnectionManager().shutdown(); // 关闭连接,释放资源
		}
		return null;
	}
//	/**
//	 * 发送HTTP_GET请求
//	 *
//	 * @see 该方法会自动关闭连接,释放资源
//	 * @param requestURL
//	 *            请求地址(含参数)
//	 * @param decodeCharset
//	 *            解码字符集,解析响应数据时用之,其为null时默认采用UTF-8解码
//	 * @return 远程主机响应正文
//	 */
	public static String sendGetRequest(String reqURL, String decodeCharset) {
		long responseLength = 0; // 响应长度
		String responseContent = null; // 响应内容
		HttpClient httpClient = new DefaultHttpClient(); // 创建默认的httpClient实例
		HttpGet httpGet = new HttpGet(reqURL); // 创建org.apache.http.client.methods.HttpGet
		try {
			HttpResponse response = httpClient.execute(httpGet); // 执行GET请求
			System.out.println(response);
			HttpEntity entity = response.getEntity(); // 获取响应实体
			if (null != entity) {
				responseLength = entity.getContentLength();
				responseContent = EntityUtils.toString(entity,
						decodeCharset == null ? "UTF-8" : decodeCharset);
				EntityUtils.consume(entity); // Consume response content
			}
			// System.out.println("请求地址: " + httpGet.getURI());
			// System.out.println("响应状态: " + response.getStatusLine());
			// System.out.println("响应长度: " + responseLength);
			// System.out.println("响应内容: " + responseContent);
		} catch (Exception e) {
			log.error("该异常通常是网络原因引起的,如HTTP服务器未启动等,堆栈信息如下", e);
		} finally {
			httpClient.getConnectionManager().shutdown(); // 关闭连接,释放资源
		}
		return responseContent;
	}
	
	public static String httpPost(String url, Map<String, String> params,
			String encoding) throws Exception {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		System.out.println("url:"+url);
		HttpPost post = new HttpPost(url);
		List<BasicNameValuePair> postData = new ArrayList<BasicNameValuePair>();
		for (Map.Entry<String, String> entry : params.entrySet()) {
			postData.add(new BasicNameValuePair(entry.getKey(), entry
					.getValue()));
			System.out.println(entry.getValue());
		}
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(postData,encoding);
		post.setEntity(entity);
		HttpResponse response = httpClient.execute(post);

		return getContent(response, encoding);
	}
	
	public static String getContent(HttpResponse res, String encoding)
			throws Exception {
		HttpEntity ent = res.getEntity();
		String result = IOUtils.toString(ent.getContent(), encoding);
		ent.consumeContent();
		return result;
	}

//
//	/**
//	 * 发送HTTP_POST请求
//	 *
//	 * @see 该方法为<code>sendPostRequest(String,String,boolean,String,String)</code>
//	 *      的简化方法
//	 * @see 该方法在对请求数据的编码和响应数据的解码时,所采用的字符集均为UTF-8
//	 * @see 当<code>isEncoder=true</code>时,其会自动对<code>sendData</code>中的[中文][|][
//	 *      ]等特殊字符进行<code>URLEncoder.encode(string,"UTF-8")</code>
//	 * @param isEncoder
//	 *            用于指明请求数据是否需要UTF-8编码,true为需要
//	 */
	public static String sendPostRequest(String reqURL, String sendData,
			boolean isEncoder) {
		return sendPostRequest(reqURL, sendData, isEncoder, null, null);
	}

	/**
	 * 发送HTTP_POST请求
	 * 
	 * @see 该方法会自动关闭连接,释放资源
	 * @see 当<code>isEncoder=true</code>时,其会自动对<code>sendData</code>中的[中文][|][
	 *      ]等特殊字符进行<code>URLEncoder.encode(string,encodeCharset)</code>
	 * @param reqURL
	 *            请求地址
	 * @param sendData
	 *            请求参数,若有多个参数则应拼接成param11=value11¶m22=value22¶m33=value33的形式后,
	 *            传入该参数中
	 * @param isEncoder
	 *            请求数据是否需要encodeCharset编码,true为需要
	 * @param encodeCharset
	 *            编码字符集,编码请求数据时用之,其为null时默认采用UTF-8解码
	 * @param decodeCharset
	 *            解码字符集,解析响应数据时用之,其为null时默认采用UTF-8解码
	 * @return 远程主机响应正文
	 */
	public static String sendPostRequest(String reqURL, String sendData,
			boolean isEncoder, String encodeCharset, String decodeCharset) {
		String responseContent = null;
		HttpClient httpClient = new DefaultHttpClient();

		HttpPost httpPost = new HttpPost(reqURL);
		// httpPost.setHeader(HTTP.CONTENT_TYPE,
		// "application/x-www-form-urlencoded; charset=UTF-8");
		httpPost.setHeader(HTTP.CONTENT_TYPE,
				"application/x-www-form-urlencoded");
		try {
			if (isEncoder) {
				List<NameValuePair> formParams = new ArrayList<NameValuePair>();
				for (String str : sendData.split("&")) {
					formParams.add(new BasicNameValuePair(str.substring(0,
							str.indexOf("=")),
							str.substring(str.indexOf("=") + 1)));
				}
				httpPost.setEntity(new StringEntity(URLEncodedUtils.format(
						formParams, encodeCharset == null ? "UTF-8"
								: encodeCharset)));
			} else {
				httpPost.setEntity(new StringEntity(sendData));
			}

			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (null != entity) {
				responseContent = EntityUtils.toString(entity,
						decodeCharset == null ? "UTF-8" : decodeCharset);
				EntityUtils.consume(entity);
			}
		} catch (Exception e) {
			log.error("与[" + reqURL + "]通信过程中发生异常,堆栈信息如下", e);
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return responseContent;
	}

//	/**
//	 * 发送HTTP_POST请求
//	 *
//	 * @see 该方法会自动关闭连接,释放资源
//	 * @see 该方法会自动对<code>params</code>中的[中文][|][ ]等特殊字符进行
//	 *      <code>URLEncoder.encode(string,encodeCharset)</code>
//	 * @param reqURL
//	 *            请求地址
//	 * @param params
//	 *            请求参数
//	 * @param encodeCharset
//	 *            编码字符集,编码请求数据时用之,其为null时默认采用UTF-8解码
//	 * @param decodeCharset
//	 *            解码字符集,解析响应数据时用之,其为null时默认采用UTF-8解码
//	 * @return 远程主机响应正文
//	 */
	public static String sendPostRequest(String reqURL,
			Map<String, String> params, String encodeCharset,
			String decodeCharset) {
		String responseContent = null;
		HttpClient httpClient = new DefaultHttpClient();

		HttpPost httpPost = new HttpPost(reqURL);
		List<NameValuePair> formParams = new ArrayList<NameValuePair>(); // 创建参数队列
		for (Map.Entry<String, String> entry : params.entrySet()) {
			formParams.add(new BasicNameValuePair(entry.getKey(), entry
					.getValue()));
		}
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(formParams,
					encodeCharset == null ? "UTF-8" : encodeCharset));

			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (null != entity) {
				responseContent = EntityUtils.toString(entity,
						decodeCharset == null ? "UTF-8" : decodeCharset);
				EntityUtils.consume(entity);
			}
		} catch (Exception e) {
			log.error("与[" + reqURL + "]通信过程中发生异常,堆栈信息如下", e);
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return responseContent;
	}

//	/**
//	 * 发送HTTPS_POST请求
//	 *
//	 * @see 该方法为<code>sendPostSSLRequest(String,Map<String,String>,String,String)</code>
//	 *      方法的简化方法
//	 * @see 该方法在对请求数据的编码和响应数据的解码时,所采用的字符集均为UTF-8
//	 * @see 该方法会自动对<code>params</code>中的[中文][|][ ]等特殊字符进行
//	 *      <code>URLEncoder.encode(string,"UTF-8")</code>
//	 */
	public static String sendPostSSLRequest(String reqURL,
			Map<String, String> params) {
		return sendPostSSLRequest(reqURL, params, null, null);
	}

	/**
	 * 发送HTTPS_POST请求
	 * 
	 * @see 该方法会自动关闭连接,释放资源
	 * @see 该方法会自动对<code>params</code>中的[中文][|][ ]等特殊字符进行
	 *      <code>URLEncoder.encode(string,encodeCharset)</code>
	 * @param reqURL
	 *            请求地址
	 * @param params
	 *            请求参数
	 * @param encodeCharset
	 *            编码字符集,编码请求数据时用之,其为null时默认采用UTF-8解码
	 * @param decodeCharset
	 *            解码字符集,解析响应数据时用之,其为null时默认采用UTF-8解码
	 * @return 远程主机响应正文
	 */
	public static String sendPostSSLRequest(String reqURL,
			Map<String, String> params, String encodeCharset,
			String decodeCharset) {
		String responseContent = "";
		HttpClient httpClient = new DefaultHttpClient();
		X509TrustManager xtm = new X509TrustManager() {
			public void checkClientTrusted(X509Certificate[] chain,
					String authType) throws CertificateException {
			}

			public void checkServerTrusted(X509Certificate[] chain,
					String authType) throws CertificateException {
			}

			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};
		try {
			SSLContext ctx = SSLContext.getInstance("TLS");
			ctx.init(null, new TrustManager[] { xtm }, null);
			SSLSocketFactory socketFactory = new SSLSocketFactory(ctx);
			httpClient.getConnectionManager().getSchemeRegistry()
					.register(new Scheme("https", 443, socketFactory));

			HttpPost httpPost = new HttpPost(reqURL);
			if (null != params) {
				List<NameValuePair> formParams = new ArrayList<NameValuePair>();
				for (Map.Entry<String, String> entry : params.entrySet()) {
					formParams.add(new BasicNameValuePair(entry.getKey(), entry
							.getValue()));
				}
				httpPost.setEntity(new UrlEncodedFormEntity(formParams,
						encodeCharset == null ? "UTF-8" : encodeCharset));
			}
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (null != entity) {
				responseContent = EntityUtils.toString(entity,
						decodeCharset == null ? "UTF-8" : decodeCharset);
				EntityUtils.consume(entity);
			}
		} catch (Exception e) {
			log.error("与[" + reqURL + "]通信过程中发生异常,堆栈信息为", e);
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return responseContent;
	}

	/**
	 * 发送HTTP_POST请求
	 * 
	 * @see 若发送的<code>params</code>中含有中文,记得按照双方约定的字符集将中文
	 *      <code>URLEncoder.encode(string,encodeCharset)</code>
	 * @see 本方法默认的连接超时时间为30秒,默认的读取超时时间为30秒
	 * @param reqURL
	 *            请求地址
	 * @param params
	 *            发送到远程主机的正文数据,其数据类型为<code>java.util.Map<String, String></code>
	 * @return 远程主机响应正文`HTTP状态码,如<code>"SUCCESS`200"</code><br>
	 *         若通信过程中发生异常则返回"Failed`HTTP状态码",如<code>"Failed`500"</code>
	 */
	public static String sendPostRequestByJava(String reqURL,
			Map<String, String> params) {
		StringBuilder sendData = new StringBuilder();
		for (Map.Entry<String, String> entry : params.entrySet()) {
			sendData.append(entry.getKey()).append("=")
					.append(entry.getValue()).append("&");
		}
		if (sendData.length() > 0 && sendData.toString().endsWith("&")) {
			sendData.setLength(sendData.length() - 1); // 删除最后一个&符号
		}
		return sendPostRequestByJava(reqURL, sendData.toString());
	}

	/**
	 * 发送HTTP_POST请求
	 * 
	 * @see 若发送的<code>sendData</code>中含有中文,记得按照双方约定的字符集将中文
	 *      <code>URLEncoder.encode(string,encodeCharset)</code>
	 * @see 本方法默认的连接超时时间为30秒,默认的读取超时时间为30秒
	 * @param reqURL
	 *            请求地址
	 * @param sendData
	 *            发送到远程主机的正文数据
	 * @return 远程主机响应正文`HTTP状态码,如<code>"SUCCESS`200"</code><br>
	 *         若通信过程中发生异常则返回"Failed`HTTP状态码",如<code>"Failed`500"</code>
	 */
	public static String sendPostRequestByJava(String reqURL, String sendData) {
		HttpURLConnection httpURLConnection = null;
		OutputStream out = null; // 写
		InputStream in = null; // 读
		int httpStatusCode = 0; // 远程主机响应的HTTP状态码
		try {
			URL sendUrl = new URL(reqURL);
			httpURLConnection = (HttpURLConnection) sendUrl.openConnection();
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setDoOutput(true); // 指示应用程序要将数据写入URL连接,其值默认为false
			httpURLConnection.setUseCaches(false);
			httpURLConnection.setConnectTimeout(30000); // 30秒连接超时
			httpURLConnection.setReadTimeout(30000); // 30秒读取超时

			out = httpURLConnection.getOutputStream();
			out.write(sendData.toString().getBytes("UTF-8"));

			// 清空缓冲区,发送数据
			out.flush();

			// 获取HTTP状态码
			httpStatusCode = httpURLConnection.getResponseCode();

			in = httpURLConnection.getInputStream();
			byte[] byteDatas = new byte[in.available()];
			in.read(byteDatas);
			return new String(byteDatas);
		} catch (Exception e) {
			log.error(e.getMessage());
			return "Failed`" + httpStatusCode;
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
					log.error("关闭输出流时发生异常,堆栈信息如下", e);
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					log.error("关闭输入流时发生异常,堆栈信息如下", e);
				}
			}
			if (httpURLConnection != null) {
				httpURLConnection.disconnect();
				httpURLConnection = null;
			}
		}
	}

	/**
	 * 发送HTTP_PUT请求
	 *
	 * @see 若发送的<code>sendData</code>中含有中文,记得按照双方约定的字符集将中文
	 *      <code>URLEncoder.encode(string,encodeCharset)</code>
	 * @see 本方法默认的连接超时时间为30秒,默认的读取超时时间为30秒
	 * @param reqURL
	 *            请求地址
	 * @param sendData
	 *            发送到远程主机的正文数据
	 * @return 远程主机响应正文`HTTP状态码,如<code>"SUCCESS`200"</code><br>
	 *         若通信过程中发生异常则返回"Failed`HTTP状态码",如<code>"Failed`500"</code>
	 */
	public static String sendPutRequestByJava(String reqURL, String sendData) {
		HttpURLConnection httpURLConnection = null;
		OutputStream out = null; // 写
		InputStream in = null; // 读
		int httpStatusCode = 0; // 远程主机响应的HTTP状态码
		try {
			URL sendUrl = new URL(reqURL);
			httpURLConnection = (HttpURLConnection) sendUrl.openConnection();
			httpURLConnection.setRequestMethod("PUT");
			httpURLConnection.setDoOutput(true); // 指示应用程序要将数据写入URL连接,其值默认为false
			httpURLConnection.setUseCaches(false);
			httpURLConnection.setConnectTimeout(30000); // 30秒连接超时
			httpURLConnection.setReadTimeout(30000); // 30秒读取超时

			out = httpURLConnection.getOutputStream();
			out.write(sendData.toString().getBytes("UTF-8"));

			// 清空缓冲区,发送数据
			out.flush();

			// 获取HTTP状态码
			httpStatusCode = httpURLConnection.getResponseCode();

			in = httpURLConnection.getInputStream();
			byte[] byteDatas = new byte[in.available()];
			in.read(byteDatas);
			return new String(byteDatas);
		} catch (Exception e) {
			log.error(e.getMessage());
			return "Failed`" + httpStatusCode;
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
					log.error("关闭输出流时发生异常,堆栈信息如下", e);
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					log.error("关闭输入流时发生异常,堆栈信息如下", e);
				}
			}
			if (httpURLConnection != null) {
				httpURLConnection.disconnect();
				httpURLConnection = null;
			}
		}
	}
//
//	/**
//	 * 发送HTTP_DELETE请求
//	 *
//	 * @see 若发送的<code>sendData</code>中含有中文,记得按照双方约定的字符集将中文
//	 *      <code>URLEncoder.encode(string,encodeCharset)</code>
//	 * @see 本方法默认的连接超时时间为30秒,默认的读取超时时间为30秒
//	 * @param reqURL
//	 *            请求地址
//	 * @param sendData
//	 *            发送到远程主机的正文数据
//	 * @return 远程主机响应正文`HTTP状态码,如<code>"SUCCESS`200"</code><br>
//	 *         若通信过程中发生异常则返回"Failed`HTTP状态码",如<code>"Failed`500"</code>
//	 */
	public static String sendDeleteRequestByJava(String reqURL) {
		HttpURLConnection httpURLConnection = null;
		OutputStream out = null; // 写
		InputStream in = null; // 读
		int httpStatusCode = 0; // 远程主机响应的HTTP状态码
		try {
			URL sendUrl = new URL(reqURL);
			httpURLConnection = (HttpURLConnection) sendUrl.openConnection();
			httpURLConnection.setRequestMethod("DELETE");
			httpURLConnection.setDoOutput(true); // 指示应用程序要将数据写入URL连接,其值默认为false
			httpURLConnection.setUseCaches(false);
			httpURLConnection.setConnectTimeout(30000); // 30秒连接超时
			httpURLConnection.setReadTimeout(30000); // 30秒读取超时

//			out = httpURLConnection.getOutputStream();
//
//			// 清空缓冲区,发送数据
//			out.flush();

			// 获取HTTP状态码
			httpStatusCode = httpURLConnection.getResponseCode();

			in = httpURLConnection.getInputStream();
			byte[] byteDatas = new byte[in.available()];
			in.read(byteDatas);
			return new String(byteDatas);
		} catch (Exception e) {
			log.error(e.getMessage());
			return "Failed`" + httpStatusCode;
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
					log.error("关闭输出流时发生异常,堆栈信息如下", e);
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					log.error("关闭输入流时发生异常,堆栈信息如下", e);
				}
			}
			if (httpURLConnection != null) {
				httpURLConnection.disconnect();
				httpURLConnection = null;
			}
		}
	}


	/**
	 * 发送HTTPS_GET请求
	 *
	 //	 * @see 该方法会自动关闭连接,释放资源
	 //	 * @see 该方法会自动对<code>params</code>中的[中文][|][ ]等特殊字符进行
	 *      <code>URLEncoder.encode(string,encodeCharset)</code>
	 * @param reqURL
	 *            请求地址
	//	 * @param params
	 *            请求参数
	 * @param encodeCharset
	 *            编码字符集,编码请求数据时用之,其为null时默认采用UTF-8解码
	 * @param decodeCharset
	 *            解码字符集,解析响应数据时用之,其为null时默认采用UTF-8解码
	 * @return 远程主机响应正文
	 */
	public static String sendGetSqSLRequest(String reqURL, String encodeCharset,
											String decodeCharset) {
		String responseContent = "";
		HttpClient httpClient = new DefaultHttpClient();
		X509TrustManager xtm = new X509TrustManager() {
			public void checkClientTrusted(X509Certificate[] chain,
										   String authType) throws CertificateException {
			}

			public void checkServerTrusted(X509Certificate[] chain,
										   String authType) throws CertificateException {
			}

			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};
		try {
			SSLContext ctx = SSLContext.getInstance("TLS");
			ctx.init(null, new TrustManager[] { xtm }, null);
			SSLSocketFactory socketFactory = new SSLSocketFactory(ctx);
			httpClient.getConnectionManager().getSchemeRegistry()
					.register(new Scheme("https", 443, socketFactory));

			HttpGet httpGet = new HttpGet(reqURL);

			HttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if (null != entity) {
				responseContent = EntityUtils.toString(entity,
						decodeCharset == null ? "UTF-8" : decodeCharset);
				EntityUtils.consume(entity);
			}
		} catch (Exception e) {
			log.error("与[" + reqURL + "]通信过程中发生异常,堆栈信息为", e);
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return responseContent;
	}


	public static String sendPostRequestByJavaSetHeader(String reqURL, String sendData, String contentType, String authorization) {
		HttpURLConnection httpURLConnection = null;
		OutputStream out = null; // 写
		InputStream in = null; // 读
		int httpStatusCode = 0; // 远程主机响应的HTTP状态码
		try {
			URL sendUrl = new URL(reqURL);
			httpURLConnection = (HttpURLConnection) sendUrl.openConnection();
			httpURLConnection.setRequestProperty("Authorization",authorization);
			httpURLConnection.setRequestProperty("Content-Type",contentType);
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setDoOutput(true); // 指示应用程序要将数据写入URL连接,其值默认为false
			httpURLConnection.setUseCaches(false);
			httpURLConnection.setConnectTimeout(30000); // 30秒连接超时
			httpURLConnection.setReadTimeout(30000); // 30秒读取超时

			out = httpURLConnection.getOutputStream();
			out.write(sendData.toString().getBytes("UTF-8"));

			// 清空缓冲区,发送数据
			out.flush();

			// 获取HTTP状态码
			httpStatusCode = httpURLConnection.getResponseCode();

			in = httpURLConnection.getInputStream();
			
			byte[] byteDatas = new byte[in.available()];
			in.read(byteDatas);
			return new String(byteDatas);
		} catch (Exception e) {
			log.error(e.getMessage());
			return "Failed`" + httpStatusCode;
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
					log.error("关闭输出流时发生异常,堆栈信息如下", e);
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					log.error("关闭输入流时发生异常,堆栈信息如下", e);
				}
			}
			if (httpURLConnection != null) {
				httpURLConnection.disconnect();
				httpURLConnection = null;
			}
		}
	}
	public static String sendPostRequestByJavaByteSetHeader(String reqURL, String sendData, String contentType, String authorization) {
		HttpURLConnection httpURLConnection = null;
		OutputStream out = null; // 写
		InputStream in = null; // 读
		InputStreamReader inr=null;
	
		int httpStatusCode = 0; // 远程主机响应的HTTP状态码
		try {
			URL sendUrl = new URL(reqURL);
			httpURLConnection = (HttpURLConnection) sendUrl.openConnection();
			httpURLConnection.setRequestProperty("Authorization",authorization);
			httpURLConnection.setRequestProperty("Content-Type",contentType);
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setDoOutput(true); // 指示应用程序要将数据写入URL连接,其值默认为false
			httpURLConnection.setUseCaches(false);
			httpURLConnection.setConnectTimeout(30000); // 30秒连接超时
			httpURLConnection.setReadTimeout(30000); // 30秒读取超时

			out = httpURLConnection.getOutputStream();
			out.write(sendData.toString().getBytes("UTF-8"));

			// 清空缓冲区,发送数据
			out.flush();

			// 获取HTTP状态码
			httpStatusCode = httpURLConnection.getResponseCode();

			in = httpURLConnection.getInputStream();
		       byte b[] = new byte[1024000];   
		        int len = 0;   
		        int temp=0;          //所有读取的内容都使用temp接收   
		        while((temp=in.read())!=-1){    //当没有读取完时，继续读取   
		            b[len]=(byte)temp;   
		            len++;   
		        }   
		        //in.close();   
		        //System.out.println(new String(b,0,len));
			   
			//in.read(byteDatas);
		      
			return new String(b,0,len,"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return "Failed`" + httpStatusCode;
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
					log.error("关闭输出流时发生异常,堆栈信息如下", e);
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					log.error("关闭输入流时发生异常,堆栈信息如下", e);
				}
			}
			if (httpURLConnection != null) {
				httpURLConnection.disconnect();
				httpURLConnection = null;
			}
		}
	}
	/**
	 * 
	 * @param uri
	 * @param host
	 * @param authorization
	 * @return
	 */
	public static String httpPostData(String host, String uri,
			String authorization,String data) {
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://"+host + uri);
			// 添加http头信息
			httppost.addHeader("Host", host);
			httppost.addHeader("Authorization", authorization);
			/*httppost.addHeader("Date", DateUtils.fromatRFC1123(new Date()));*/
			
			 List<NameValuePair> params=new ArrayList<NameValuePair>(); 
			 params.add(new BasicNameValuePair("data", data));
			 httppost.setEntity(new UrlEncodedFormEntity(params,"UTF-8")); 

//			StringEntity entity=new StringEntity(data,"UTF-8");
//			entity.setContentEncoding("UTF-8");  
//			entity.setContentType("application/json"); 
//			httppost.setEntity(entity);
			
			HttpResponse response = httpclient.execute(httppost);
			// 检验状态码，如果成功接收数据
			int code = response.getStatusLine().getStatusCode();
			if (code == 200) {
				String rev = EntityUtils.toString(response.getEntity());
				return rev;
			}
			return EntityUtils.toString(response.getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}

	/**
	 *
	 * @param uri
	 * @param headers
	 * @param body
	 * @return
	 */
	public static String httpPostBody( String uri,
									  Map<String,String> headers, Map<String,String> body) {
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(uri);
			// 添加http头信息
			Set<String> headerKeySet = headers.keySet();
			if(headerKeySet.size()>0){
				for(String key : headerKeySet){
					log.info(" key = "+key+" value = "+headers.get(key));
					httppost.addHeader(key, headers.get(key));
				}
			}
			List<NameValuePair> params=new ArrayList<NameValuePair>();
			Set<String> bodyKeySet = body.keySet();
			if(bodyKeySet.size()>0){
				for(String key : bodyKeySet){
					log.info(" key = "+key+" value = "+body.get(key));
					params.add(new BasicNameValuePair(key, body.get(key)));
				}
			}
			String ss = "{\"grant_type\": \"client_credentials\",\"client_id\": \"YXA6-Fq6QGgbEeaQT1FYxElvEw\",\"client_secret\": \"YXA6cas8UUM46_eX9-wuJ3TdJdGgVVY\"}";

			httppost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));

//			StringEntity entity=new StringEntity(data,"UTF-8");
//			entity.setContentEncoding("UTF-8");
//			entity.setContentType("application/json");
//			httppost.setEntity(entity);

			HttpResponse response = httpclient.execute(httppost);
			// 检验状态码，如果成功接收数据
			int code = response.getStatusLine().getStatusCode();
			if (code == 200) {
				String rev = EntityUtils.toString(response.getEntity());
				return rev;
			}
			return EntityUtils.toString(response.getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exception";
	}
	public static String postFile(File file,String url,String partName) {
		
       
       try {
    	   HttpClient httpclient = new DefaultHttpClient();
    	   HttpPost filePost = new HttpPost(url);
      
            MultipartEntity reqEntity = new MultipartEntity();  
            FileBody fileBody = new FileBody(file);  
            reqEntity.addPart(partName, fileBody);  
          
            //设置请求  
            filePost.setEntity(reqEntity);  
            
          
            HttpResponse response = httpclient.execute(filePost);
            int code = response.getStatusLine().getStatusCode();
        	String rev = EntityUtils.toString(response.getEntity());
			log.info(code+ " resulit is  "+rev);
			return rev;
			
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        return null;
    }

	public static void main(String[] args) throws Exception {
	/*	File file=new File("d:/data/test.jpg");
		HttpClientUtil.postFile(file,"http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE", "media");

		 */

		//String url="https://a1.easemob.com/jnshu4/carjn/chatmessages?ql=select+*+where+timestamp>1471621974799&limit=2";
		HashMap<String, String> headers = new HashMap<String, String>();
		Map<String,String> bodies = new HashMap<String, String>();
		//String url= "https://a1.easemob.com/carjn/carjn/token";
		String ss = "{\"grant_type\": \"client_credentials\",\"client_id\": \"YXA6-Fq6QGgbEeaQT1FYxElvEw\",\"client_secret\": \"YXA6cas8UUM46_eX9-wuJ3TdJdGgVVY\"}";
		String requestParam = "<xml><bill_date><![CDATA[20170314]]></bill_date><bill_type><![CDATA[ALL]]></bill_type><mch_id><![CDATA[105500000209]]></mch_id><nonce_str><![CDATA[GcWMfOfqxztoDknRhWKSfCtLclgHdPCi]]></nonce_str><service><![CDATA[pay.bill.agent]]></service><sign><![CDATA[81666B1E5C125A6CEBF70B2884E59CF0]]></sign></xml>";
		String url = "https://download.swiftpass.cn/gateway";
		String  result= HttpClientUtil.sendPostRequestByJavaByteSetHeader(url,requestParam,"application/xml","");
		//log.info(result);


	}
}

