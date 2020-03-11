package com.zyj;

import javafx.fxml.LoadException;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import javax.annotation.processing.FilerException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.rmi.ConnectIOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:77
 * @date: 2020/3/11 0011
 * @time: 9:04
 */
@Slf4j
public class Generator {
    public void generator() {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;

//        指向配置文件位置
        try {
            InputStream resourceAsStream = this.getClass().getResourceAsStream("/generatorConfig.xml");
//            File configFile = new File("generatorConfig.xml");
            ConfigurationParser parser = new ConfigurationParser(warnings);
            Configuration config = parser.parseConfiguration(resourceAsStream);
//            对比目录，无则创建
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }finally {
            for (String warning : warnings) {
                log.warn(warning);
            }
        }
    }


    public static void main(String[] args) {
        Generator generator = new Generator();
        generator.generator();
    }
}
