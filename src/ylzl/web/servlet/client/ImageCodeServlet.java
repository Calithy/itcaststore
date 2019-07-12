package ylzl.web.servlet.client;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(name = "ImageCodeServlet",
            urlPatterns = "/ImageCodeServlet")
public class ImageCodeServlet extends HttpServlet {

    //集合中保存所有成语
    private List<String> words = new ArrayList<String>();
    @Override
    public void init(){
        try {
            /*加载servlet时将资源加载，并存入list*/
            String path = this.getClass().getClassLoader().getResource("new_words.txt").getPath();
            //设置编码UTF-8，否则会出现乱码
            BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(path),"utf-8"));

            String line = null;
            while((line = bf.readLine()) != null){
                words.add(line);

            }
            bf.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //禁止缓存
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("charset","utf-8");
        //设置图片大小
        int width = 120;
        int height = 30;

        //在内存中绘制一张图片
        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //绘制图片背景颜色
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(getRandomColor(200,250));
        //绘制的位置
        graphics.fillRect(0,0,width,height);

        //绘制的边框
        graphics.setColor(Color.white);
        graphics.fillRect(0,0,width-1,height-1);

        //四个随机数字
        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setFont(new Font("宋体",Font.BOLD,18));

        Random random = new Random();
        int index = random.nextInt(words.size());
        String word = words.get(index);
      //  String word = new String(old_word.getBytes("utf-8"));//解决乱码问题


        //定义x坐标
        int x = 10;
        for (int i = 0; i < word.length();i++){
            graphics2D.setColor(new Color(20 + random.nextInt(110),
                    20 + random.nextInt(110),20 + random.nextInt(110)));
            int angle = random.nextInt(60) - 30;
            double theta = angle * Math.PI / 180;

            //获得字母数字
            char c = word.charAt(i);

            graphics2D.rotate(theta,x,20);
            graphics2D.drawString(String.valueOf(c),x,20);
            graphics2D.rotate(-theta,x,20);
            x += 30;
        }

        //保存到session中
        request.getSession().setAttribute("check_code",word);

        //绘制干扰线
        graphics.setColor(getRandomColor(160,200));
        int x1,x2;
        int y1,y2;
        for(int i = 0; i < 30; i++){
            x1 = random.nextInt(width);
            x2 = random.nextInt(12);
            y1 = random.nextInt(height);
            y2 = random.nextInt(12);
            graphics.drawLine(x1,y1,x1 + x2,x2 +y2);
        }
        //将图片输出到浏览器
        graphics.dispose();

        //将图片写到respons中
        ImageIO.write(bufferedImage,"jpg",response.getOutputStream());
    }

    /**
     * 取随机颜色
     * @param fc
     * @param bc
     * @return Color
     */
    private Color getRandomColor(int fc, int bc){
        Random random = new Random();
        if(fc > 255){
            fc = 255;
        }
        if(bc > 255){
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r,g,b);
    }
}
