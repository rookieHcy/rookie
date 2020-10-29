import com.google.common.io.Files;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.concurrent.ExecutorService;

/**
 * @ClassName FindLongestClass
 * @Description 查找最长的类名
 * @Author hou
 * @Date 2020/7/6 3:17 下午
 * @Version 1.0
 **/
@Slf4j
public class FindLongestClass {
    private static void doFind(String basePath) {
        File baseFile = new File(basePath);
        if (!baseFile.exists()) {
            log.error("baseFile not exists");
            return;
        }

        //获取path下所有目录
        Iterable<File> files = Files.fileTraverser().depthFirstPostOrder(baseFile);
        int count = 0;
        int max = -1;
        int j = 0;
        for (File file : files) {
            count++;
            if(count / 100 == j){
                j ++;
                System.out.println("已经扫描了" + count + "个文件");
            }
            if (!file.getName().endsWith(".java")) continue;

            if (file.getName().length() > max) {
                max = file.getName().length();
                System.out.println(file.getName());
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
//        String path = "/Users/hou/work/projects/rc-dataprod-management";
        String path = "/Users/hou/work/projects";
        doFind(path);
    }

}