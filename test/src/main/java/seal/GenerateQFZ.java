package seal;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.graphics.PdfGraphicsUnit;
import com.spire.pdf.graphics.PdfImage;
import com.spire.pdf.graphics.PdfUnitConvertor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @ClassName GenerateQFZ
 * @Description pdf生成骑缝章测试
 * @Author hou
 * @Date 2020/10/29 2:42 下午
 * @Version 1.0
 **/
public class GenerateQFZ {

    private static final String PDF_PATH = "/Users/hou/Desktop/个性化配置计费标准_odin_5.7.10.pdf";
    private static final String IMAGE_PATH = "/Users/hou/Desktop/WechatIMG2324.png";

    public static void main(String[] args) throws IOException {
        //加载测试文档
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(PDF_PATH);

        PdfUnitConvertor convert = new PdfUnitConvertor();
        PdfPageBase pageBase;

        //获取分割后的印章图片
        BufferedImage[] images = getImage(doc.getPages().getCount());
        float x;
        float y;

        //将图片绘制到PDF页面上的指定位置
        for (int i = 0; i < doc.getPages().getCount(); i++) {
            BufferedImage image = images[i];
            pageBase = doc.getPages().get(i);
            x = (float) (pageBase.getSize().getWidth()) - convert.convertUnits(image.getWidth(), PdfGraphicsUnit.Pixel, PdfGraphicsUnit.Point);
            y = (float) pageBase.getSize().getHeight() / 2;
            pageBase.getCanvas().drawImage(PdfImage.fromImage(image), new Point2D.Float(x, y));
        }
        //保存结果文档
        doc.saveToFile("output/AddSeal.pdf");
    }

    //定义GetImage方法，根据PDF页数分割印章图片
    private static BufferedImage[] getImage(int num) throws IOException {
        BufferedImage image = ImageIO.read(new File(IMAGE_PATH));
        int rows = 1;
        int chunks = rows * num;
        int chunkWidth = image.getWidth() / num;
        int chunkHeight = image.getHeight() / rows;
        int count = 0;
        BufferedImage[] imgs = new BufferedImage[chunks];
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < num; y++) {
                imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());
                Graphics2D gr = imgs[count++].createGraphics();
                gr.drawImage(image, 0, 0, chunkWidth, chunkHeight,
                        chunkWidth * y, chunkHeight * x,
                        chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, Color.WHITE, null);
                gr.dispose();
            }
        }
        return imgs;
    }

}