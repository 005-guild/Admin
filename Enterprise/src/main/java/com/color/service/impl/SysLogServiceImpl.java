package com.color.service.impl;

import com.github.pagehelper.PageHelper;
import com.color.dao.SysLogDao;
import com.color.entity.SysLog;
import com.color.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public void saveLog(SysLog sysLog) {
        sysLogDao.saveLog(sysLog);
    }

    @Override
    public List<SysLog> queryAllSysLog(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return sysLogDao.queryAllSysLog();
    }
}
