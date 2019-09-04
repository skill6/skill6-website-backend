package cn.skill6.website.util.storage.abst;

import cn.skill6.common.exception.file.FileNotFoundException;
import cn.skill6.common.exception.general.NullPointerException;
import cn.skill6.common.exception.general.ParamsException;
import cn.skill6.website.util.sequence.SequenceManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * 文件存储基类
 *
 * @author 何明胜
 * @since 2018年9月3日 下午11:34:35
 */
public abstract class BaseStoreHandler {
    protected void storeFile(InputStream inputStream, String storePath) throws IOException {
        FileOutputStream out = new FileOutputStream(storePath);
        byte[] buffer = new byte[1024];
        int length = 0;

        while ((length = inputStream.read(buffer)) > 0) {
            out.write(buffer, 0, length);
        }

        inputStream.close();
        out.close();
    }

    protected void readFile(HttpServletResponse response, String fileUrl, String fileName) throws IOException {
        File file = new File(fileUrl);
        if (!file.exists()) {
            throw new FileNotFoundException("文件未找到");
        }

        // 解决文件空格变加号问题
        String fileNameShow = URLEncoder.encode(fileName, "UTF-8");
        fileNameShow = StringUtils.replace(fileNameShow, "+", "%20");

        response.setContentType("application/x-msdownload");
        response.setCharacterEncoding("UTF-8");
        // 设置响应头，控制浏览器下载该文件
        response.setHeader("content-disposition", "attachment;filename=" + fileNameShow);

        // 读取要下载的文件，保存到文件输入流
        FileInputStream in = new FileInputStream(fileUrl);
        // 创建缓冲区
        byte[] buffer = new byte[1024];
        int len = 0;
        OutputStream outputStream = response.getOutputStream();
        // 循环将输入流中的内容读取到缓冲区当中
        while ((len = in.read(buffer)) > 0) {
            // 输出缓冲区的内容到浏览器，实现文件下载
            outputStream.write(buffer, 0, len);
        }

        in.close();
        outputStream.close();
    }

    protected MultipartHttpServletRequest parseRequest(HttpServletRequest request) {
        // 将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        ServletContext servletContext = request.getSession().getServletContext();
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(servletContext);

        // 检查form中是否有enctype="multipart/form-data"
        if (!multipartResolver.isMultipart(request)) {
            throw new ParamsException("上传中不含有文件！");
        }

        return (MultipartHttpServletRequest) request;
    }

    protected String isFileExist(String parentFilePath, String suffix) {
        String fileId;

        // 判断文件是否已经存在
        while (true) {
            fileId = SequenceManager.getNextIdStr();
            String fileName = parentFilePath + "/" + fileId + "." + suffix;
            File tempFile = new File(fileName);

            if (!tempFile.exists()) {
                return fileId;
            }
        }
    }

    /**
     * @return 文件后缀
     */
    protected String getFileSuffix(String fileName) {
        if (StringUtils.isEmpty(fileName)) {
            throw new NullPointerException("文件名称为null");
        }

        // 增加对.tar.gz等的判断
        ArrayList<String> specialSuffix = new ArrayList<>(1);
        specialSuffix.add("tar.gz");
        specialSuffix.add("tar.bz2");

        for (String sSuffix : specialSuffix) {
            if (fileName.contains(sSuffix)) {
                return sSuffix;
            }
        }

        int index = fileName.lastIndexOf(".");

        return fileName.substring(index + 1);
    }
}
