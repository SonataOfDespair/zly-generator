package com.zly.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.zly.generator.MainGenerator;
import com.zly.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(name = "generator", description = "生成代码", mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable<Integer> {

    /**
     * 判断是否循环（开关）
     */
    @Option(names = {"-l", "--loop"}, arity = "0..1", description = "是否循环", interactive = true, echo = true)
    private boolean loop;

    /**
     * 作者（字符串，填充值）
     */
    @Option(names = {"-a", "--author"}, arity = "0..1", description = "作者名称", interactive = true, echo = true)
    private String author = "zly";

    /**
     * 输出信息
     */
    @Option(names = {"-o", "--outputText"}, arity = "0..1", description = "输出结果", interactive = true, echo = true)
    private String outputText = "求和结果为：";

    public Integer call() throws Exception {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        BeanUtil.copyProperties(this, mainTemplateConfig);
        System.out.println("配置信息：" + mainTemplateConfig);
        MainGenerator.doGenerate(mainTemplateConfig);
        return 0;
    }
}