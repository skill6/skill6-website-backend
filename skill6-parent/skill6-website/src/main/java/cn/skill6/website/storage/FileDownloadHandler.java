package cn.skill6.website.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.skill6.common.exception.tools.StackTrace2Str;
import cn.skill6.website.config.FileStorePathConfig;

/**
 * 文件存储处理
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年9月3日 上午1:34:37
 */
public class FileDownloadHandler {
	private final Logger logger = LoggerFactory.getLogger(FileDownloadHandler.class);
	
	public String fileUploadHandler(HttpServletRequest request, String storePath) {
        //得到上传文件的保存目录，将上传的文件存放于工程文件的兄弟级文件download目录下
        String saveFile = storePath;
        File file = new File(saveFile);
        
        //判断上传文件的保存目录是否存在
        if (!file.exists() && !file.isDirectory()) {
            logger.info(saveFile+"目录不存在，已经创建");
            //创建目录
            file.mkdirs();
        }
        try{
            //使用Apache文件上传组件处理文件上传步骤：
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
             //解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8"); 
            //3、判断提交上来的数据是否是上传表单的数据
            if(!ServletFileUpload.isMultipartContent(request)){
                //按照传统方式获取数据
                return null;
            }
            //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = upload.parseRequest(request);
            for(FileItem item : list){
                //如果fileitem中封装的是普通输入项的数据
                if(item.isFormField()){
                    String name = item.getFieldName();
                    //解决普通输入项的数据的中文乱码问题
                    String value = item.getString("UTF-8");
                    logger.info("普通表单（暂不处理）：" + name + "=" + value);
                }else{//如果fileitem中封装的是上传文件
                    //得到上传的文件名称，
                    String filename = item.getName();
                    if(filename==null || filename.trim().equals("")){
                        continue;
                    }
                    //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                    //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                    filename = filename.substring(filename.lastIndexOf("\\")+1);
                    //判断文件是否已经存在
                    while(true) {
                    	File tempFile = new File(saveFile + "/" + filename);
                    	if(tempFile.exists()) {
                    		//获取扩展名
                    		int index = filename.lastIndexOf(".");
                    			String fileHeadName = filename.substring(0, index);
                        		String fileBackName = filename.substring(index+1);
                        		//重命名文件名
                        		filename = fileHeadName + "1." + fileBackName; 
                    	}else {
                    		break;
                    	}
                    }
                    
                    //获取item中的上传文件的输入流
                    InputStream in = item.getInputStream();
                    //创建一个文件输出流
                    FileOutputStream out = new FileOutputStream(saveFile + "/" + filename);
                    //创建一个缓冲区
                    byte buffer[] = new byte[1024];
                    //判断输入流中的数据是否已经读完的标识
                    int len = 0;
                    //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                    while((len=in.read(buffer))>0){
                        //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                        out.write(buffer, 0, len);
                    }
                    //关闭输入流
                    in.close();
                    //关闭输出流
                    out.close();
                    //删除处理文件上传时生成的临时文件
                    item.delete();
                    logger.info("上传文件名称："+filename);
                    return filename;
                }
            }
        }catch (Exception e) {
            logger.error(StackTrace2Str.exceptionStackTrace2Str(e));
        }
        
        return null;
	}
	
	public void fileDownloadHandler(HttpServletRequest request, HttpServletResponse response, String storePath) throws IOException {
		response.setContentType("text/html;charset=UTF-8"); 
	    //得到要下载的文件名
        String fileName = request.getParameter("filename");
        //上传的文件都是保存在工程文件的兄弟级文件download目录
        String saveFile = FileStorePathConfig.getFilePath();
        File fileSaveRootPath = new File(saveFile);
        //得到要下载的文件
        logger.info("下载文件：" + fileSaveRootPath + "/" + fileName);
        File file = new File(fileSaveRootPath + "/" + fileName);
        //如果文件不存在
        if(!file.exists()){
            return;
        }
        
		//解决空格问题变加号问题
		String fileNameShow = URLEncoder.encode(fileName, "UTF-8");
		fileNameShow = StringUtils.replace(fileNameShow, "+", "%20");  
        //设置响应头，控制浏览器下载该文件
        response.setHeader("content-disposition", "attachment;filename=" + fileNameShow);
        //读取要下载的文件，保存到文件输入流
        FileInputStream in = new FileInputStream(fileSaveRootPath + "/" + fileName);
        //创建输出流
        OutputStream out = response.getOutputStream();
        //创建缓冲区
        byte buffer[] = new byte[1024];
        int len = 0;
        //循环将输入流中的内容读取到缓冲区当中
        while((len=in.read(buffer))>0){
            //输出缓冲区的内容到浏览器，实现文件下载
            out.write(buffer, 0, len);
        }
        
        //关闭文件输入流
        in.close();
        //关闭输出流
        out.close();
	}
}