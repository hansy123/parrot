# springcloud-study
springcloud-study
springboot�汾2.1.8
springcloud�汾Greenwich.SR3
����Ŀû�в���vo po dto�ȸ��ͳһʹ��bean����
���ݿ�ΪMySQL��redis
û�м����۶������

�ṹĿ¼
springcloud-study -- ��һ��pom���� ���������Ϊspringcloud-parent
    eureka-server -- ����ע������ port:9001 actuator�˿�8001
    parrot-api -- server���е�bean��api�ӿ� 
    parrot-server -- ѧ��������Ŀ �˿�:9002 actuator�˿�8002
    parrot-clazz-server -- �༶������Ŀ����feign �˿�:9003 actuator�˿�8003
    zuul-server -- ���ط��� �˿�:9004 actuator�˿�8004
    config-server -- �������� port:9005 actuator�˿�8005
    zikpin-server -- ��·׷�� port:9006 actuator�˿�8006
    sql -- sql�ű�

eureka-server��parrot-server��parrot-clazz-server��zuul-server���������������ģ�bus����ˢ�¹���
parrot-server��parrot-clazz-server ������feign���

��1���������ģ�spring.application.nameֵ��git�����ļ���application���ƣ����ܴ��м�-
��2��bus����ˢ�£����ɵ���rabbitmq�����ڱ��ػ�����activemq�����ڿ���״̬����mismatch��
��3��zipkin web���棬������ʼ���޷�ƥ�䣬�������spring.sleuth.sampler.probability=1.0 ȫ����������ֵĬ��0.1��10%��


����ˢ�£�url:http://localhost:8003/actuator/bus-refresh post����
��·׷�ٵ�ַ��http://localhost:9006/zipkin/
tx-lcn����ͻ��ˣ�http://localhost:5001


���룺eureka-server��config-server��zipkin-server���Ժϲ�Ϊһ����Ŀ

sql�ű����ڻ�ʹ�ò�����й���

MyCat id�ֶα�����bigint
��д�������ò���˵����
balance:
    1. balance=��0��, ���ж����������͵���ǰ���õ�writeHost�ϡ�
    2. balance=��1�������ж�����������ķ��͵�readHost��
����3. balance=��2�������ж��������������writeHost��readhost�Ϸַ�
    4. balance=��3�����ж���������ķַ��� wiriterHost ��Ӧ�� readhost ִ��,writerHost ��������ѹ��
WriteType:
    1. writeType=��0��, ����д���������͵����õ�writeHost�ϡ�
����2. writeType=��1��������д����������ķ��͵�readHost��
  ��3. writeType=��2��������д�������������writeHost��readhost���Ϸ���
switchType:
    1.Ĭ��ֵ���Զ��л�
����2.����MySQL����ͬ����״̬�����Ƿ��л�
    3
