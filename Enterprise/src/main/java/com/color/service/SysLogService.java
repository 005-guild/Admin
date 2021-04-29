package com.color.service;

import com.color.entity.SysLog;

import java.util.List;

public interface SysLogService {
    /**
     * 保存日志
     * @param sysLog
     */
    void saveLog(SysLog sysLog);

    /**
     * 查询全部日志信息
     * @param page
     * @param size
     * @return
     */
    List<SysLog> queryAllSysLog(Integer page, Integer size);
}
