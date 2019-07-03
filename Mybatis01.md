 # Mybatis 坑
    1.idea maven项目找不到 Mapper.xml文件，解决方案
        1.  idea maven项目中java目录下的XML文件不会编译，即Mapper映射文件应放在resources目录下
        2.  在pom.xml引入XML文件
              <build>
                    <!-- 导入 java目录下面的xml文件 -->
                    <resources>
                        <resource>
                            <directory>src/main/java</directory>
                            <includes>
                                <include>org/yong/dao/impl/BankUserMapper.xml</include>
                            </includes>
                        </resource>
                    </resources>
                </build>