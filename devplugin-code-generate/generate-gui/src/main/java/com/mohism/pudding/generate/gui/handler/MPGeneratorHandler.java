package com.mohism.pudding.generate.gui.handler;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.mohism.pudding.generate.gui.config.DatabaseConfig;
import com.mohism.pudding.generate.gui.engine.BeetlTemplateEngine;
import com.mohism.pudding.generate.gui.model.DbType;
import com.mohism.pudding.generate.gui.model.GeneratorConfig;
import com.mohism.pudding.generate.gui.util.DbUtil;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.FileResourceLoader;
import org.mybatis.generator.api.ProgressCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @ 创建人 zt
 * @ 创建时间 2019/5/29
 * @ 描述 Mybatis-plus  代码自动生成
 */
public class MPGeneratorHandler {

    private static final Logger _LOG = LoggerFactory.getLogger(MPGeneratorHandler.class);

    private GeneratorConfig generatorConfig;

    private  DatabaseConfig selectedDatabaseConfig;

    private ProgressCallback progressCallback;

    public MPGeneratorHandler() {

    }

    public void setGeneratorConfig(GeneratorConfig generatorConfig) {
        this.generatorConfig = generatorConfig;
    }

    public void setDatabaseConfig(DatabaseConfig databaseConfig) {
        this.selectedDatabaseConfig = databaseConfig;
    }

    public void setProgressCallback(ProgressCallback progressCallback) {
        this.progressCallback = progressCallback;
    }

    public void generate() throws Exception {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 项目路径
        String projectPath = generatorConfig.getProjectFolder();//rojectFolder//System.getProperty("D://code/");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("real earth");
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        String dbType = selectedDatabaseConfig.getDbType();
        dsc.setUrl(DbUtil.getConnectionUrlWithSchema(selectedDatabaseConfig));
        // dsc.setSchemaName("public");
        dsc.setDriverName(DbType.valueOf(dbType).getDriverClass());
        dsc.setUsername(selectedDatabaseConfig.getUsername());
        dsc.setPassword(selectedDatabaseConfig.getPassword());
        // 获取数据类型
        mpg.setDataSource(dsc);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("mp");
        pc.setParent("com.mohism.pudding");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        mpg.setCfg(cfg);
        // 如果模板引擎是 freemarker
//        String templatePath = "/mp/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
//        List<FileOutConfig> focList = new ArrayList<>();
//        // 自定义配置会被优先输出
//        focList.add(new FileOutConfig(templatePath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        TemplateConfig   tc = new TemplateConfig ();
        tc.setController("/controller.java");
        tc.setService("/mpService");
        tc.setServiceImpl("/mpServiceImpl");
        tc.setEntityKt("/entity.kt");
        tc.setEntity("/entity.java");
        tc.setMapper("/mapper.java");
        tc.setXml("/mapper.xml");
        mpg.setTemplate(tc);
        mpg.setTemplateEngine(new BeetlTemplateEngine());

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("java.io.Serializable");
//        strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setEntityTableFieldAnnotationEnable(true);
//        strategy.setSuperControllerClass("com.mohism.pudding.core.base.controller");
        strategy.setInclude(generatorConfig.getTableName());//scanner("表名，多个英文逗号分割").split(",")
        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);

        mpg.execute();
    }
}