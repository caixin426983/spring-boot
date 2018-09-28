package com.cx.springboot.test;


import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;

public class CacheTest {


    public static void main(String[] args) {

        //1.创建缓存管理器
        CacheManager cacheManager = CacheManager.create("./src/main/resources/ehcache.xml");




        //2.获取缓存对象
        Cache cache = cacheManager.getCache("test");


        System.out.println(cache.getSize());

        //3.创建元素
        Element element = new Element("name", "张三");

        //4.将元素添加到缓存
        cache.put(element);

        //5.获取缓存
        Element name = cache.get("name");
        System.out.println(name);
        System.out.println(name.getObjectValue());


        //6.删除元素
        cache.remove("name");

        Student student = new Student("张珊", 22, 1);
        Element element1 = new Element("张珊", student);
        cache.put(element1);

        Element value = cache.get("张珊");
        Student valueObjectKey = (Student) value.getObjectValue();
        System.out.println(valueObjectKey);


        System.out.println(cache.getSize());


        //7.刷新缓存
        cache.flush();

        //8.关闭缓存管理器
        cacheManager.shutdown();



    }


    static class Student {

        public static void main(String[] args) {

            CacheManager cacheManager = CacheManager.create();
            CacheConfiguration cacheConfiguration = new CacheConfiguration();
            cacheConfiguration.setName("APP");
            cacheConfiguration.setEternal(false);
            cacheConfiguration.setMaxBytesLocalHeap(1000L);
            cacheConfiguration.setTimeToIdleSeconds(5000);
            cacheConfiguration.setTimeToLiveSeconds(6000);
            cacheConfiguration.setOverflowToOffHeap(false);

            Cache cache1 = new Cache(cacheConfiguration);
            cacheManager.addCache(cache1);

            //2.获取缓存对象
            Cache cache = cacheManager.getCache("APP");

            //3.创建元素
            Element element = new Element("name", "张三");

            //4.将元素添加到缓存
            cache.put(element);

            //5.获取缓存
            Element name = cache.get("name");
            System.out.println(name);
            System.out.println(name.getObjectValue());

        }

        private String name;

        private Integer age;

        private Integer sex;

        public Student() {
        }

        public Student(String name, Integer age, Integer sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getSex() {
            return sex;
        }

        public void setSex(Integer sex) {
            this.sex = sex;
        }
    }
}
