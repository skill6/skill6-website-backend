package cn.skill6.microservice.complex;

/** 对markdown进行解析处理 */
public interface MarkdownSvc {

  String toHtml(String md);
}
