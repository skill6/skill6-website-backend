package cn.skill6.common.utility;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import cn.skill6.common.constant.Encode;
import cn.skill6.common.exception.tools.StackTrace2Str;
import lombok.extern.slf4j.Slf4j;

/**
 * 基于apache http工具包自定义http请求工具类，请求失败返回null
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年10月29日 上午12:14:14
 */
@Slf4j
public final class HttpsClient {
  /**
   * 封装get请求
   *
   * @param url 请求URL
   * @return get请求结果
   */
  public static String doGet(String url) {
    return doGet(url, null);
  }

  /**
   * 封装get请求
   *
   * @param url 请求URL
   * @param params 请求参数
   * @return get请求结果
   */
  public static String doGet(String url, Map<String, String> params) {
    CloseableHttpClient httpClient = null;
    CloseableHttpResponse httpResponse = null;
    String response = null;

    if (MapUtils.isNotEmpty(params)) {
      UrlEncodedFormEntity urlEncodedFormEntity = paramsConfig(params);
      String paramStr = null;

      try {
        paramStr = EntityUtils.toString(urlEncodedFormEntity);
      } catch (ParseException | IOException e) {
        log.error(StackTrace2Str.exceptionStackTrace2Str("参数转换失败", e));
      }

      if (StringUtils.isEmpty(paramStr)) {
        return response;
      }

      url = StringUtils.join(url, "?", paramStr);
    }

    HttpGet httpGet = new HttpGet(url);
    httpGet.setConfig(requestConfig());

    httpClient = HttpClients.createDefault();
    try {
      httpResponse = httpClient.execute(httpGet);
      HttpEntity entity = httpResponse.getEntity();
      response = EntityUtils.toString(entity);
    } catch (IOException e) {
      log.error(StackTrace2Str.exceptionStackTrace2Str("http请求失败", e));
    }

    closeResource(httpResponse, httpClient);

    return response;
  }

  /**
   * 封装post请求
   *
   * @param url 请求URL
   * @return post请求结果
   */
  public static String doPost(String url) {
    return doPost(url, null);
  }
  /**
   * 封装post请求
   *
   * @param url 请求URL
   * @param params 请求参数
   * @return post请求结果
   */
  public static String doPost(String url, Map<String, String> params) {
    CloseableHttpClient httpClient = null;
    CloseableHttpResponse httpResponse = null;
    String response = null;

    HttpPost httpPost = new HttpPost(url);
    httpPost.setConfig(requestConfig());
    httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");

    if (MapUtils.isNotEmpty(params)) {
      UrlEncodedFormEntity urlEncodedFormEntity = paramsConfig(params);
      httpPost.setEntity(urlEncodedFormEntity);
    }

    httpClient = HttpClients.createDefault();
    try {
      httpResponse = httpClient.execute(httpPost);
      HttpEntity entity = httpResponse.getEntity();
      response = EntityUtils.toString(entity);
    } catch (ParseException | IOException e) {
      log.error(StackTrace2Str.exceptionStackTrace2Str("http请求失败", e));
    }

    closeResource(httpResponse, httpClient);

    return response;
  }

  /**
   * 请求参数配置
   *
   * @return 请求参数实体
   */
  private static UrlEncodedFormEntity paramsConfig(Map<String, String> params) {
    UrlEncodedFormEntity urlEncodedFormEntity = null;
    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

    for (Map.Entry<String, String> entry : params.entrySet()) {
      BasicNameValuePair nameValuePair = new BasicNameValuePair(entry.getKey(), entry.getValue());
      nameValuePairs.add(nameValuePair);
    }

    try {
      urlEncodedFormEntity = new UrlEncodedFormEntity(nameValuePairs, Encode.DEFAULT_ENCODE);
    } catch (UnsupportedEncodingException e) {
      log.error(StackTrace2Str.exceptionStackTrace2Str("构建http参数失败", e));
    }

    return urlEncodedFormEntity;
  }

  /**
   * 获取请求配置
   *
   * @return 请求配置
   */
  private static RequestConfig requestConfig() {
    RequestConfig requestConfig =
        RequestConfig.custom()
            .setConnectTimeout(35000) // 连接主机服务超时时间
            .setConnectionRequestTimeout(35000) // 请求超时时间
            .setSocketTimeout(60000) // 数据读取超时时间
            .build();

    return requestConfig;
  }

  /**
   * 关闭资源
   *
   * @param httpResponse http返回体
   * @param httpClient http客户端
   */
  private static void closeResource(
      CloseableHttpResponse httpResponse, CloseableHttpClient httpClient) {

    if (httpResponse != null) {
      try {
        httpResponse.close();
      } catch (IOException e) {
        log.warn(StackTrace2Str.exceptionStackTrace2Str("httpResponse 关闭异常", e));
      }
    }

    if (httpClient != null) {
      try {
        httpClient.close();
      } catch (IOException e) {
        log.warn(StackTrace2Str.exceptionStackTrace2Str("httpClient 关闭异常", e));
      }
    }
  }
}
