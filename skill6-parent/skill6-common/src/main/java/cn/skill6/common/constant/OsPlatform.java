package cn.skill6.common.constant;

/**
 * 操作系统平台
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年9月2日 下午11:51:33
 */
public enum OsPlatform {
  WINDOWS("Windows"),
  LINUX("Linux"),
  MAC("Mac");

  private String osName;

  private OsPlatform(String osName) {
    this.osName = osName;
  }

  /** @return the osName */
  public String getOsName() {
    return osName;
  }

  /** @param osName the osName to set */
  public void setOsName(String osName) {
    this.osName = osName;
  }

  /** @return 当前操作系统 */
  public static OsPlatform getCurrentOs() {
    String currOsName = System.getProperty("os.name");
    if (currOsName.indexOf(OsPlatform.WINDOWS.getOsName()) != -1) {
      return OsPlatform.WINDOWS;
    }
    if (currOsName.indexOf(OsPlatform.MAC.getOsName()) != -1) {
      return OsPlatform.MAC;
    }
    return OsPlatform.LINUX;
  }
}
