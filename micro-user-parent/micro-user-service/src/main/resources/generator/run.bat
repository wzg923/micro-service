@echo -----------------------------------------------------------------------------
@echo Mybatis 代码生成器
@echo -----------------------------------------------------------------------------

@rem 方法一：eclipse  ->Maven Build -> Globals: mybatis-generator:generate
@rem Maven命令：mvn mybatis-generator:generate

@rem 方法二：执行run.bat
set dir=%cd%
@echo 开始生成代码

java -jar mybatis-generator-core-1.3.2.jar -configfile generatorConfig.xml -overwrite
@pause