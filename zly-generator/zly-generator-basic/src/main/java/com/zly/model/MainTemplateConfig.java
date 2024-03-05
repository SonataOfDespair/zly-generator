package com.zly.model;

import lombok.Data;

/**
 * 动态模板配置
 */
@Data
public class MainTemplateConfig {

    /**
     * 作者（字符串，填充值）
     */
    private String author = "zly";

    /**
     * 输出信息
     */
    private String outputText = "输出结果";

    /**
     * 判断是否循环（开关）
     */
    private boolean loop;

}
