package com.cx.springboot.config.ehcache;


import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.core.io.ClassPathResource;

//@Configuration
//@EnableCaching //标注启动了缓存
public class EhcacheConfiguration {

    /**
     * ehcache 的主要管器
     *
     * @param bean
     * @return
     */
//    @Bean(name = "appEhCacheCacheManager")
    public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean) {
        return new EhCacheCacheManager(bean.getObject());
    }

    /**
     * 根据shared与否的设置,spring分别通过CacheManager.create()或者 new CacheManager()方法来创建一个ehcache基地
     * @return
     */
//    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("classpath/ehcache.xml"));
        ehCacheManagerFactoryBean.setShared(true);
        return ehCacheManagerFactoryBean;
    }


}
