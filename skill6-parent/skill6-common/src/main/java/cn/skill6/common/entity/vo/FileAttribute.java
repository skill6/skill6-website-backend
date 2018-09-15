package cn.skill6.common.entity.vo;

/**
 * 文件属性
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年9月13日 上午2:25:58
 */
public class FileAttribute {
  String id;
  String name;
  String suffix;
  String url;
  String hashCode;

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */ @Override
  public String toString() {
    return "FileAttribute [id="
        + id
        + ", name="
        + name
        + ", suffix="
        + suffix
        + ", url="
        + url
        + ", hashCode="
        + hashCode
        + "]";
  }
  /** @return the id */
  public String getId() {
    return id;
  }
  /** @param id the id to set */
  public void setId(String id) {
    this.id = id;
  }
  /** @return the name */
  public String getName() {
    return name;
  }
  /** @param name the name to set */
  public void setName(String name) {
    this.name = name;
  }
  /** @return the suffix */
  public String getSuffix() {
    return suffix;
  }
  /** @param suffix the suffix to set */
  public void setSuffix(String suffix) {
    this.suffix = suffix;
  }
  /** @return the url */
  public String getUrl() {
    return url;
  }
  /** @param url the url to set */
  public void setUrl(String url) {
    this.url = url;
  }
  /** @return the hashCode */
  public String getHashCode() {
    return hashCode;
  }
  /** @param hashCode the hashCode to set */
  public void setHashCode(String hashCode) {
    this.hashCode = hashCode;
  }
}
