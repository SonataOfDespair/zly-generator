package com.zly.generator;

import com.zly.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        //1.静态文件生成
        //此处获取到的路径为：zly-generator/zly-generator-basic
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        //输入路径：ACM示例代码模板目录
        String inputPath = new File(parentFile, "zly-generator-demo-projects/acm-template").getAbsolutePath();
        //输出路径
        String outputPath = projectPath;
        //递归遍历
        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);

        //2.动态文件生成
        String dynamicInputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath + File.separator + "acm-template/src/com/zly/acm/MainTemplate.java";
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("zly");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果为：");
        DynamicGenerator.doGenerate(dynamicInputPath, dynamicOutputPath, mainTemplateConfig);
    }
}
