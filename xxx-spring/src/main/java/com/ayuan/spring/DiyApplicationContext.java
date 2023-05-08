package com.ayuan.spring;

import java.io.File;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Ayuan
 * @Description: diy容器
 * @date 2023/5/8 15:02
 */
public class DiyApplicationContext {

    private Class configClass;

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public DiyApplicationContext(Class configClass) {
        this.configClass = configClass;
        //判断类上有没有要扫描的路径
        if (configClass.isAnnotationPresent(ComponentScan.class)) {
            ComponentScan componentScanAnnotation = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
            //1.获取扫描包名（com.ayuan.service）
            String path = componentScanAnnotation.value();
            //2.转换为相对路径名（com/ayuan/service）
            path = path.replace(".", "/");
            ClassLoader classLoader = DiyApplicationContext.class.getClassLoader();
            //3.通过classLoader转换为绝对路径
            URL resource = classLoader.getResource(path);
            File file = new File(resource.getFile());
            //4.过滤所有后缀为.class的文件
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    String fileName = f.getAbsolutePath();
                    //5.判断类是不是一个bean（是否包含component注解）
                    if (fileName.endsWith(".class")) {
                        // 路径转换为包路径（com.ayuan.service）
                        String className = fileName.substring(fileName.indexOf("com"), fileName.lastIndexOf(".class"));
                        className = className.replace("\\", ".");
                        try {
                            Class<?> clazz = classLoader.loadClass(className);
                            if (clazz.isAnnotationPresent(Component.class)) {
                                //6.获取beanName
                                Component componentAnnotation = clazz.getAnnotation(Component.class);
                                String beanName = componentAnnotation.value();
                                //7.实例化beanDefinition
                                BeanDefinition beanDefinition = new BeanDefinition();
                                beanDefinition.setType(clazz);
                                //8.判断作用域单例还是多例
                                if (clazz.isAnnotationPresent(Scope.class)) {
                                    Scope scopeAnnotation = clazz.getAnnotation(Scope.class);
                                    beanDefinition.setScope(scopeAnnotation.value());
                                } else {
                                    beanDefinition.setScope("singleton");
                                }
                                //9.放入beanDefinitionMap里面
                                beanDefinitionMap.put(beanName, beanDefinition);
                            }
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }

    public Object getBean(String beanName) {
        return null;
    }

}
