package com.learn._04_advanced._09_advance_componentScan.filterComponentScan.filter;

import com.learn._04_advanced._09_advance_componentScan.filterComponentScan.bean.color.NotColorGreen;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

/**
 * 编程式自定义过滤规则：
 * 1 实现 TypeFilter 接口的 match 方法。
 * 2 MetadataReader: 通过这个 Reader，
 *   可以读取到正在扫描的类的信息（包括类的信息、类上标注的注解等）。
 * 3 MetadataReaderFactory: 借助这个 Factory，
 *   可以获取到其他类（存在容器中的其他 bean）的 Reader，进而获取到其他类的信息，
 *   相当于借助 ReaderFactory 可以获取到 Reader，借助 Reader 可以获取到指定类的信息。
 */
public class GreenFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader,
                         MetadataReaderFactory metadataReaderFactory) {
        // 获取 @ComponentScan 当前扫描到的类的信息（类的全限定名）
        String className = metadataReader.getClassMetadata().getClassName();
        // 如果该类是 Green 类型，直接返回 false 表示拒绝扫描导入容器。
        return className.equals(NotColorGreen.class.getName());
    }
}
