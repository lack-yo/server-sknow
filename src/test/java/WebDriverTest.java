import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @author loufeng
 * @date 2017/5/23 下午8:19.
 */
public class WebDriverTest {
    @Test
    public void test1(){
        System.setProperty("webdriver.chrome.driver", "/Users/loufeng/config/chromedriver");
        //定义驱动为谷歌
        WebDriver driver = new ChromeDriver();

        //驱动地址
        driver.get("http://www.baidu.com");

        //输入框
        WebElement text = driver.findElement(By.name("wd"));

        //设置值
        text.sendKeys("大搜车");

        //模拟提交
        driver.findElement(By.id("su")).click();

        driver.close();
    }

    @Test
    public void test2(){
        //截取appid
        String appid = "wx1e43e7dacbbfc6db" +
                "开发者ID是公众号开发识别码，配合开发者密码可调用公众号的接口能力。";
        appid = appid.replaceAll(" ", "");
        String[] str  = appid.split("开");
        System.out.println(str[0]);
    }

    @Test
    public void test3(){
        System.setProperty("webdriver.chrome.driver", "/Users/loufeng/config/chromedriver");
        //定义驱动为谷歌
        WebDriver driver = new ChromeDriver();

        //驱动地址
        driver.get("https://mp.weixin.qq.com/");
        WebElement account = driver.findElement(By.id("account"));
        account.sendKeys("longjuncheng@souche.com");
        WebElement pwd = driver.findElement(By.id("pwd"));
        pwd.sendKeys("12213");
        WebElement submit = driver.findElement(By.id("loginBt"));
        submit.click();
        submit.click();

        File file = null;
        try {

            WebElement ele = driver.findElement(By.id("verifyImg"));


            if (ele != null) {
                Actions action = new Actions(driver);
                action.moveToElement(ele).perform();
                BufferedImage inputbig = createElementImage(driver, ele);

                ByteArrayOutputStream os = new ByteArrayOutputStream();
                ImageIO.write(inputbig, "png", os);

                file = new File( "test.png");
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(os.toByteArray());
            }else{
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        driver.close();

    }

    private static BufferedImage createElementImage(WebDriver driver,
                                                    WebElement webElement) throws IOException {
        // 获得webElement的位置和大小。
        Point location = webElement.getLocation();
        Dimension size = webElement.getSize();
        // 创建全屏截图。
        BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(
                takeScreenshot(driver)));
        // 截取webElement所在位置的子图。
        BufferedImage croppedImage =  null;
        int pointX = location.getX();
        int poinnY = location.getY();
        int wide = size.getWidth();
        int high = size.getHeight();

        try {

            croppedImage = originalImage.getSubimage(pointX - 10,
                    poinnY, wide + 10, high);
        } catch (Exception e) {
        }

        if(croppedImage == null)
            originalImage.getSubimage(pointX - 10,poinnY, wide + 10, high);

        return croppedImage;
    }

    private static byte[] takeScreenshot(WebDriver driver) throws IOException {
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        return ((TakesScreenshot) augmentedDriver)
                .getScreenshotAs(OutputType.BYTES);
    }


}
