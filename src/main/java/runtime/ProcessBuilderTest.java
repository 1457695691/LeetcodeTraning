package runtime;

import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ayuan
 * @Description: Java实现调用外部程序
 * @date 2023/5/6 11:56
 */
public class ProcessBuilderTest {

    @Test
    public void processBuilderTest1() {
        ProcessBuilder processBuilder = new ProcessBuilder();
//        processBuilder.command("java");
//        processBuilder.command("java","-version");
        List<String> command = new ArrayList<>();
        command.add("java");
        command.add("-version");
        processBuilder.command(command);
        //将标准输入流和错误输入流合并，通过标准输入流读取信息
        processBuilder.redirectErrorStream(true);
        try {
            //启动进程
            Process start = processBuilder.start();
            //获取输入流
            InputStream inputStream = start.getInputStream();
            //转成字符输入流
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            int len = -1;
            //字符缓冲区
            char[] c = new char[1024];
            //读取进程输入流中的内容
            while ((len = inputStreamReader.read(c)) != -1) {
                String s = new String(c, 0, len);
                System.out.print(s);
            }
            inputStreamReader.close();
            inputStream.close();
            //阻塞当前线程，直到进程退出为止
            start.waitFor();
            int exitValue = start.exitValue();
            if (exitValue == 0) {
                System.out.println("进程正常结束");
            } else {
                System.out.println("进程异常结束");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
