package dao;

import entity.SysConfigEntity;

public interface ISysConfigDao {
     String getValueByKey(String key);

     void addConfig(SysConfigEntity config);

     void updateConfig(String key, String value);

     void deleteConfig(String key);
}
