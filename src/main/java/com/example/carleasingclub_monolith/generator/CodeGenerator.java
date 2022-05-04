package com.example.carleasingclub_monolith.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.IFill;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;


/**


/**
 * @author chennanjiang
 * @date Created in 2022/4/25 14:06
 * @description mybatisPlus代码生成器
 */
public class CodeGenerator {
    public static void main(String[] args) {
        // 数据源配置
        DataSourceConfig.Builder dataSourceConfigBuilder = new DataSourceConfig
                .Builder(
                "jdbc:mysql://localhost:3306/carleasingclub" +
                        "?serverTimezone=Asia/Shanghai",
                "root",
                "root");

        // 全局配置
        GlobalConfig.Builder globalConfigBuilder = new GlobalConfig.Builder();

        // 代码生成目录
        String projectPath = System.getProperty("user.dir");
        //输出目录
        globalConfigBuilder.outputDir(projectPath + "/src/main/java");
        // 作者
        globalConfigBuilder.author("zkboort");
        // 结束时是否打开文件夹
        globalConfigBuilder.openDir(false);

        // 是否覆盖旧的文件
        //globalConfigBuilder.fileOverride();
        // 实体属性Swagger2注解
        globalConfigBuilder.enableSwagger();

        // 包配置，如模块名、实体、mapper、service、controller等
        PackageConfig.Builder packageConfigBuilder = new PackageConfig.Builder();
        packageConfigBuilder.moduleName("carleasingclub_monolith");
        packageConfigBuilder.entity("entity");
        packageConfigBuilder.mapper("mapper");
        packageConfigBuilder.service("service");
        //packageConfigBuilder.serviceImpl("");
        packageConfigBuilder.controller("controller");

        // 策略配置
        StrategyConfig.Builder strategyConfigBuilder = new StrategyConfig.Builder();
        // 设置需要映射的表名
        strategyConfigBuilder.addInclude(
                "attribute_attrigroup_relation",
                "car_product_arribute",
                "car_product_attribute_group",
                "car_product_attribute_value",
                "car_product_brand",
                "car_product_category",
                "car_product_sku",
                "car_product_sku_imges",
                "car_product_sku_sale_attribute_value",
                "car_product_spu",
                "custom_user",
                "system_user",
                "sys_menu",
                "role",
                "picture"
        );
        // 下划线转驼峰
        strategyConfigBuilder.entityBuilder().naming(NamingStrategy.underline_to_camel);
        strategyConfigBuilder.entityBuilder().columnNaming(NamingStrategy.underline_to_camel);
        // 去除前缀"t_"
        //strategyConfigBuilder.addTablePrefix("t_");

        // entity的Lombok
        strategyConfigBuilder.entityBuilder().enableLombok();
        // 逻辑删除
        strategyConfigBuilder.entityBuilder().logicDeleteColumnName("deleted");
        strategyConfigBuilder.entityBuilder().logicDeletePropertyName("deleted");
        // 自动填充
        // 创建时间
        IFill gmtCreate = new Column("gmt_create", FieldFill.INSERT);
        // 更新时间
        IFill gmtModified = new Column("gmt_modified", FieldFill.INSERT_UPDATE);
        strategyConfigBuilder.entityBuilder().addTableFills(gmtCreate, gmtModified);
        // 乐观锁
        strategyConfigBuilder.entityBuilder().enableSerialVersionUID();
        strategyConfigBuilder.entityBuilder().versionColumnName("version");
        strategyConfigBuilder.entityBuilder().versionPropertyName("version");
        // 使用Restful风格的Controller
        strategyConfigBuilder.controllerBuilder().enableRestStyle();
        // 将请求地址转换为驼峰命名，如 http://localhost:8080/hello_id_2
        //strategyConfigBuilder.controllerBuilder().enableHyphenStyle();
        // 自定义配置
        //InjectionConfig.Builder injectionConfigBuilder = new InjectionConfig.Builder();
        // 模板引擎配置
        //TemplateConfig.Builder templateConfigBuilder = new TemplateConfig.Builder();
        // 如果模板引擎是 freemarker
        //String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        //String templatePath = "/templates/mapper.xml.vm";
        //templateConfigBuilder.entity()
        // 创建代码生成器对象，加载配置
        AutoGenerator autoGenerator = new AutoGenerator(dataSourceConfigBuilder.build());
        autoGenerator.global(globalConfigBuilder.build());
        autoGenerator.packageInfo(packageConfigBuilder.build());
        autoGenerator.strategy(strategyConfigBuilder.build());
        //autoGenerator.injection(injectionConfigBuilder.build());
        //autoGenerator.template();
        // 执行
        autoGenerator.execute();
    }

}
