package ylzl.web.servlet.manager;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import ylzl.domain.Product;
import ylzl.service.ProductService;
import ylzl.service.impl.ProductServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

/**
 * @program: itcaststore
 * @description:
 * @author: Leo
 * @create: 2019-07-09 15:06
 **/
@WebServlet(name = "saveProduct", urlPatterns = {"/saveProduct"})
public class SaveProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        HashMap<String,String> params = new HashMap<>();
        Product product = new Product();
        boolean add = false;
        //获得一个文件上传的工厂类
        DiskFileItemFactory dfif = new DiskFileItemFactory();
        //设置文件上传临时存储的大小8M
        dfif.setSizeThreshold(1024*1024*8);
        //指定临时文件目录，默认值为当前用户的系统临时文件目录
        dfif.setRepository(new File("java.io.tmpdir"));
        //使用servlet来处理文件上传
        ServletFileUpload upload = new ServletFileUpload(dfif);
        //设置文件上传的大小
        upload.setSizeMax(1024*1024*50);
        upload.setHeaderEncoding("utf-8");
        //获得当前服务器的路径
        String uploadPath = this.getServletContext().getRealPath("");
        //System.out.println("当前服务器路径---->"+uploadPath);
        uploadPath = uploadPath+"productImg";
        File uploadDir = new File(uploadPath);
        if(!uploadDir.exists()){
            uploadDir.mkdir();
        }
        try {
            List<FileItem> formItem = upload.parseRequest(req);
            if(formItem != null && formItem.size() >0){
                //循环遍历表单项
                for(FileItem item : formItem){
                    //不同字段
                    if(item.isFormField()){

                        String fieldName = item.getFieldName();
                        String value = item.getString("utf-8");
                        params.put(fieldName, value);
                    }
                    //文件
                    else {
                        String rowFileName = item.getName();
                        String extension = getExtension(rowFileName);
                        //随机生成文件名
                        String fileName = UUID.randomUUID().toString() + "." + extension;
                        String filePath = uploadPath+"\\"+fileName;
                        File storeFile = new File(filePath);
                        item.write(storeFile);
                        params.put("imgurl","/productImg/"+fileName);
                        item.delete();
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
            req.setAttribute("message", "文件上传失败:"+e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //获取ID
        String id = params.get("id");
        List<String> ids = productService.listAllIds();
        //ID为空 添加
        if (id == null || id.trim().length() <= 0){
            String generatedId = generateNoRepeatedId(ids);
            product.setId(generatedId);
            add = true;
        }
        //修改
        else {
            product.setId(id);
        }
        product.setName(params.get("name"));
        String price = params.get("price");
        if (price != null && price.trim().length() > 0){
            product.setPrice( Double.parseDouble(price));
        }
        product.setDescription(params.get("description"));
        product.setPnum(Integer.parseInt(params.get("pnum")));
        product.setCategory(params.get("category"));
        product.setImgurl(params.get("imgurl"));
       //添加
        if (add){
            int insert = productService.insert(product);
            if (insert <= 0){
                //放入错误提示信息
                req.setAttribute("message","添加商品信息失败");
                req.getRequestDispatcher("/editProduct").forward(req,resp);
                req.getRequestDispatcher("/admin/editProduct.jsp").forward(req,resp);
            }
        }
        else {
            int update = productService.update(product);
            if (update <= 0){
                //放入错误提示信息
                req.setAttribute("message","修改商品信息失败");
                req.getRequestDispatcher("/editProduct").forward(req,resp);
                req.getRequestDispatcher("/admin/productManage.jsp").forward(req,resp);
            }
        }
        //重定向至商品列表页
        resp.sendRedirect(req.getContextPath() + "/listProduct");
    }
    /**
     * 生成不重复ID
     * @param ids
     * @return
     */
    private String generateNoRepeatedId(List<String> ids){
        String id = null;
        HashSet<String> set = new HashSet<>(ids);
        do {
            id = UUID.randomUUID().toString();
        }while (!set.add(id));
        return id;
    }

    /**
     * 获取文件后缀名
     * @param fileName
     * @return
     */
    private String getExtension(String fileName){
        if ((fileName != null) && (fileName.length() > 0)) {
            int dot = fileName.lastIndexOf('.');
            if ((dot >-1) && (dot < (fileName.length() - 1))) {
                return fileName.substring(dot + 1);
            }
        }
        return fileName;
    }
}