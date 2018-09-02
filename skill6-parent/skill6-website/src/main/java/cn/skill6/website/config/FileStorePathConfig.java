package cn.skill6.website.config;

import java.io.IOException;
import java.util.Properties;

import cn.skill6.common.constant.OsPlatform;
import cn.skill6.common.utility.ReadConfigFile;

/**
 * 工程相关文件存储路径配置
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年9月3日 上午12:27:19
 */
public class FileStorePathConfig {
  /** 文件上传和下载路径 * */
  public static String FILE_PATH;

  /** 图片上传和下载路径 * */
  public static String IMAGE_PATH;

  private static Properties PATH_CONFIG_FILE;

  public static String getFilePath() {
    if (FILE_PATH != null) {
      return FILE_PATH;
    }

    initPathConfigFile();
    if (getCurrentOs() == OsPlatform.WINDOWS) {
      FILE_PATH = PATH_CONFIG_FILE.getProperty("windows_file_path", "D:/skill6/files");
    } else {
      FILE_PATH = PATH_CONFIG_FILE.getProperty("linux_file_path", "/opt/cn/skill6/files");
    }

    return FILE_PATH;
  }

  public static String getImagePath() {
    if (IMAGE_PATH != null) {
      return IMAGE_PATH;
    }

    initPathConfigFile();
    if (getCurrentOs() == OsPlatform.WINDOWS) {
      IMAGE_PATH = PATH_CONFIG_FILE.getProperty("windows_file_path", "D:/skill6/images");
    } else {
      IMAGE_PATH = PATH_CONFIG_FILE.getProperty("linux_file_path", "/opt/cn/skill6/images");
    }

    return IMAGE_PATH;
  }

  /** 单例模式保存配置文件 */
  public static void initPathConfigFile() {
    if (IMAGE_PATH == null) {
      try {
        PATH_CONFIG_FILE = ReadConfigFile.readByRelativePath("config/deploy-path.properties");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * 获取当前操作系统
   *
   * @return
   */
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
