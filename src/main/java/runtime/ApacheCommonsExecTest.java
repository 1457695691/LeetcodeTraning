package runtime;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author Ayuan
 * @Description: Apache Commons Exec 是一个用于执行外部进程的 Java 库，可以方便地启动和控制进程，并且提供了对输入、输出流的管理和处理
 * @date 2023/5/6 12:20
 */
public class ApacheCommonsExecTest {

    public static void main(String[] args) throws IOException {
        //1.构造命令行对象：通过 CommandLine 对象构造需要执行的外部程序和参数。
        CommandLine cmdLine = CommandLine.parse("java -version");

        //2.创建执行器对象：通过 DefaultExecutor 对象创建一个执行器，并设置工作目录（可选）。
        DefaultExecutor executor = new DefaultExecutor();
        //executor.setWorkingDirectory(new File("/your/workdir"));

        //3.创建处理器对象：PumpStreamHandler 对象可以处理输入输出流并存储进程的标准输出和标准错误信息。
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
        executor.setStreamHandler(streamHandler);

        //4.执行命令并等待进程结束：调用 executor.execute方法执行命令。
        // 如果要等待进程执行完成对应的操作，请在此后调用 process.waitFor() 等待进程结束。
        // 执行完成后处理 outputStream 中的输出结果。
        executor.execute(cmdLine);
        String output = outputStream.toString("UTF-8");
        System.out.println(output);
    }
}
