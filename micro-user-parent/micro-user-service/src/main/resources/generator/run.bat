@echo -----------------------------------------------------------------------------
@echo Mybatis ����������
@echo -----------------------------------------------------------------------------

@rem ����һ��eclipse  ->Maven Build -> Globals: mybatis-generator:generate
@rem Maven���mvn mybatis-generator:generate

@rem ��������ִ��run.bat
set dir=%cd%
@echo ��ʼ���ɴ���

java -jar mybatis-generator-core-1.3.2.jar -configfile generatorConfig.xml -overwrite
@pause