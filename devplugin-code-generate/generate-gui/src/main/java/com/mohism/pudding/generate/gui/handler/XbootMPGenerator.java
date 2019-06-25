//package com.mohism.pudding.generate.gui.handler;
//
//import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
//import com.mohism.pudding.generate.gui.config.DatabaseConfig;
//import com.mohism.pudding.generate.gui.model.DbType;
//import com.mohism.pudding.generate.gui.model.Entity;
//import com.mohism.pudding.generate.gui.model.GeneratorConfig;
//import com.mohism.pudding.generate.gui.util.DbUtil;
//import com.sun.media.sound.ModelPatch;
//import lombok.extern.slf4j.Slf4j;
//import org.beetl.core.Configuration;
//import org.beetl.core.GroupTemplate;
//import org.beetl.core.Template;
//import org.beetl.core.resource.FileResourceLoader;
//import org.mybatis.generator.api.ProgressCallback;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.net.URL;
//
//import static com.mohism.pudding.generate.gui.handler.XbootGenerator.camel2Underline;
//import static com.mohism.pudding.generate.gui.handler.XbootGenerator.dotToLine;
//import static com.mohism.pudding.generate.gui.handler.XbootGenerator.first2LowerCase;
//
//
///**
// * 代码生成器 Mybatis-Plus
// * @author Exrickx
// */
//@Slf4j
//public class XbootMPGenerator {
//
//
//    private GeneratorConfig generatorConfig;
//
//    private DatabaseConfig selectedDatabaseConfig;
//
//    private ProgressCallback progressCallback;
//
//    public XbootMPGenerator() {
//
//    }
//
//    public void setGeneratorConfig(GeneratorConfig generatorConfig) {
//        this.generatorConfig = generatorConfig;
//    }
//
//    public void setDatabaseConfig(DatabaseConfig databaseConfig) {
//        this.selectedDatabaseConfig = databaseConfig;
//    }
//
//    public void setProgressCallback(ProgressCallback progressCallback) {
//        this.progressCallback = progressCallback;
//    }
//
//    /**
//     * 实体类名
//     * 建议仅需修改
//     */
//    private static final String className = "Depart";
//
//    /**
//     * 类说明描述
//     * 建议仅需修改
//     */
//    private static final String description = "测试";
//
//    /**
//     * 作者名
//     * 建议仅需修改
//     */
//    private static final String author = "real earth";
//
//    /**
//     * 数据库表名前缀
//     * 下方请根据需要修改
//     */
//    private static final String tablePre = "sys_";
//
//    /**
//     * 主键类型
//     */
//    private static final String primaryKeyType = "String";
//
//    /**
//     * 实体类对应包
//     * (文件自动生成至该包下)
//     */
//    private static final String entityPackage ="com.mohism.pudding.base.manager.api.entity";
//
//    /**
//     * dao对应包
//     * (文件自动生成至该包下)
//     */
//    private static final String daoPackage = "com.mohism.pudding.base.manager.modular.mapper";
//
//    /**
//     * service对应包
//     * (文件自动生成至该包下)
//     */
//    private static final String servicePackage = "com.mohism.pudding.base.manager.modular.service";
//
//    /**
//     * serviceImpl对应包
//     * (文件自动生成至该包下)
//     */
//    private static final String serviceImplPackage = "com.mohism.pudding.base.manager.modular.serviceimpl";
//
//    /**
//     * controller对应包
//     * (文件自动生成至该包下)
//     */
//    private static final String controllerPackage = "com.mohism.pudding.base.manager.modular.controller";
//
//    /**
//     * 运行该主函数即可生成代码
//     * @param args
//     * @throws IOException
//     */
////    public static void main(String[] args) throws IOException {
////
////        //模板路径
////        String root = generatorConfig.getProjectFolder()+"/src/main/java/cn/exrick/xboot/generator/template";
////        FileResourceLoader resourceLoader = new FileResourceLoader(root,"utf-8");
////        Configuration cfg = Configuration.defaultConfiguration();
////
////        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
////        //生成代码
////        generateCode(gt);
////
////        //根据类名删除生成的代码
////        //deleteCode(className);
////    }
//
//    /**
//     * 生成代码
//     * @param
//     * @throws IOException
//     */
//    public  void generate() throws IOException{
//        //模板路径
////        String root = "/mp/template";
////        URL root = Thread.currentThread().getContextClassLoader().getResource("mp/template");
//
//        Entity entity = new Entity();
//        entity.setEntityPackage(generatorConfig.getModelPackage());//entityPackage
//        entity.setDaoPackage(generatorConfig.getModelPackage());//daoPackage
//        entity.setServicePackage(servicePackage);//servicePackage
//        entity.setServiceImplPackage(serviceImplPackage);
//        entity.setControllerPackage(controllerPackage);
//        entity.setAuthor(author);
//        entity.setClassName(className);
//        entity.setTableName(tablePre+camel2Underline(className));
//        entity.setClassNameLowerCase(first2LowerCase(className));
//        entity.setDescription(description);
//        entity.setPrimaryKeyType(primaryKeyType);
//        entity.setActiviti(false);
//
//        OutputStream out = null;
//
//        //生成实体类代码
//        entityTemplate.binding("entity", entity);
//        String entityResult = entityTemplate.render();
//        log.info(entityResult);
//        //创建文件
//        String entityFileUrl = generatorConfig.getProjectFolder()+"/src/main/java/"+ dotToLine(generatorConfig.getModelPackage()) + "/" + first2LowerCase(className) + ".java";
//
//        File entityFile = new File(entityFileUrl);
//        File entityDir = entityFile.getParentFile();
//        if (!entityDir.exists()) {
//            entityDir.mkdirs();
//        }
//        if(!entityFile.exists()){
//            // 若文件存在则不重新生成
//            entityFile.createNewFile();
//            out = new FileOutputStream(entityFile);
//            entityTemplate.renderTo(out);
//        }
//
//        //生成dao代码
//        daoTemplate.binding("entity",entity);
//        String daoResult = daoTemplate.render();
//        log.info(daoResult);
//        //创建文件
//        String daoFileUrl = generatorConfig.getProjectFolder()+"/src/main/java/"+ dotToLine(generatorConfig.getDaoPackage()) + "/" +first2LowerCase(className) + "Mapper.java";
//        File daoFile = new File(daoFileUrl);
//        File daoDir = daoFile.getParentFile();
//        if (!daoDir.exists()) {
//            daoDir.mkdirs();
//        }
//        if(!daoFile.exists()) {
//            // 若文件存在则不重新生成
//            daoFile.createNewFile();
//            out = new FileOutputStream(daoFile);
//            daoTemplate.renderTo(out);
//        }
//
//        //生成service代码
//        serviceTemplate.binding("entity",entity);
//        String serviceResult = serviceTemplate.render();
//        log.info(serviceResult);
//        //创建文件
//        String serviceFileUrl = generatorConfig.getProjectFolder()+"/src/main/java/"+ dotToLine(servicePackage) + "/I" + first2LowerCase(className) + "Service.java";
//        File serviceFile = new File(serviceFileUrl);
//        File serviceDir = serviceFile.getParentFile();
//        if (!serviceDir.exists()) {
//            serviceDir.mkdirs();
//        }
//        if(!serviceFile.exists()) {
//            // 若文件存在则不重新生成
//            serviceFile.createNewFile();
//            out = new FileOutputStream(serviceFile);
//            serviceTemplate.renderTo(out);
//        }
//
//        //生成serviceImpl代码
//        serviceImplTemplate.binding("entity",entity);
//        String serviceImplResult = serviceImplTemplate.render();
//        log.info(serviceImplResult);
//        //创建文件
//        String serviceImplFileUrl = generatorConfig.getProjectFolder()+"/src/main/java/"+ dotToLine(serviceImplPackage) + "/I" + first2LowerCase(className) + "ServiceImpl.java";
//        File serviceImplFile = new File(serviceImplFileUrl);
//        File serviceImplDir = serviceImplFile.getParentFile();
//        if (!serviceImplDir.exists()) {
//            serviceImplDir.mkdirs();
//        }
//        if(!serviceImplFile.exists()) {
//            // 若文件存在则不重新生成
//            serviceImplFile.createNewFile();
//            out = new FileOutputStream(serviceImplFile);
//            serviceImplTemplate.renderTo(out);
//        }
//
//        //生成controller代码
//        controllerTemplate.binding("entity",entity);
//        String controllerResult = controllerTemplate.render();
//        log.info(controllerResult);
//        //创建文件
//        String controllerFileUrl = generatorConfig.getProjectFolder()+"/src/main/java/"+ dotToLine(controllerPackage) + "/" + first2LowerCase(className) + "Controller.java";
//        File controllerFile = new File(controllerFileUrl);
//        File controllerDir = controllerFile.getParentFile();
//        if (!controllerDir.exists()) {
//            controllerDir.mkdirs();
//        }
//        if(!controllerFile.exists()) {
//            // 若文件存在则不重新生成
//            controllerFile.createNewFile();
//            out = new FileOutputStream(controllerFile);
//            controllerTemplate.renderTo(out);
//        }
//
//        //生成mapperXml代码
//        mapperXmlTemplate.binding("entity",entity);
//        String mapperXmlResult = mapperXmlTemplate.render();
//        log.info(mapperXmlResult);
//        //创建文件
//        String mapperXmlFileUrl = generatorConfig.getProjectFolder()+"/src/main/resources/mapper/" + first2LowerCase(className) + "Mapper.xml";
//        File mapperXmlFile = new File(mapperXmlFileUrl);
//        File mapperXmlDir = mapperXmlFile.getParentFile();
//        if (!mapperXmlDir.exists()) {
//            mapperXmlDir.mkdirs();
//        }
//        if(!mapperXmlFile.exists()) {
//            // 若文件存在则不重新生成
//            mapperXmlFile.createNewFile();
//            out = new FileOutputStream(mapperXmlFile);
//            mapperXmlTemplate.renderTo(out);
//        }
//
//        if(out!=null){
//            out.close();
//        }
//        log.info("生成代码成功！");
//    }
//
//    /**
//     * 删除指定类代码
//     * @param className
//     * @throws IOException
//     */
////    private static void deleteCode(String className) throws IOException{
////
////        String entityFileUrl = generatorConfig.getProjectFolder();+"/src/main/java/"+ dotToLine(entityPackage) + "/" +className+".java";
////        File entityFile = new File(entityFileUrl);
////        if(entityFile.exists()){
////            entityFile.delete();
////        }
////        String daoFileUrl = generatorConfig.getProjectFolder();+"/src/main/java/"+ dotToLine(daoPackage) + "/" +className+"Mapper.java";
////        File daoFile = new File(daoFileUrl);
////        if(daoFile.exists()){
////            daoFile.delete();
////        }
////
////        String serviceFileUrl = generatorConfig.getProjectFolder();+"/src/main/java/"+ dotToLine(servicePackage) + "/I" +className+"Service.java";
////        File serviceFile = new File(serviceFileUrl);
////        if(serviceFile.exists()){
////            serviceFile.delete();
////        }
////
////        String serviceImplFileUrl = generatorConfig.getProjectFolder();+"/src/main/java/"+ dotToLine(serviceImplPackage) + "/I" +className+"ServiceImpl.java";
////        File serviceImplFile = new File(serviceImplFileUrl);
////        if(serviceImplFile.exists()){
////            serviceImplFile.delete();
////        }
////
////        String controllerFileUrl = generatorConfig.getProjectFolder();+"/src/main/java/"+ dotToLine(controllerPackage) + "/" +className+"Controller.java";
////        File controllerFile = new File(controllerFileUrl);
////        if(controllerFile.exists()){
////            controllerFile.delete();
////        }
////
////        String mapperXmlFileUrl = generatorConfig.getProjectFolder();+"/src/main/resources/mapper/" + className + "Mapper.xml";
////        File mapperXmlFile = new File(mapperXmlFileUrl);
////        if(mapperXmlFile.exists()){
////            mapperXmlFile.delete();
////        }
////
////        log.info("删除代码完毕！");
////    }
//}
