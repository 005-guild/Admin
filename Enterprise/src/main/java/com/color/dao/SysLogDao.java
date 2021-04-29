package com.color.dao;

import com.color.entity.SysLog;

import java.util.List;


public interface SysLogDao {
    /**
     * 保存日志
     * @param sysLog
     */
    void saveLog(SysLog sysLog);

    /**
     * 查询全部日志信息
     * @return
     */
    List<SysLog> queryAllSysLog();
}
