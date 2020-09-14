package com.ruoyi.utiliza.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.utiliza.domain.RyPatentlPermit;
import com.ruoyi.utiliza.mapper.RyPatentlPermitMapper;
import com.ruoyi.utiliza.service.IRyPatentlPermitService;

/**
 * 专利运用许可Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-02
 */
@Service
public class RyPatentlPermitServiceImpl implements IRyPatentlPermitService {
    @Autowired
    private RyPatentlPermitMapper ryPatentlPermitMapper;

    /**
     * 查询专利运用许可
     * 
     * @param permitId 专利运用许可ID
     * @return 专利运用许可
     */
    @Override
    public RyPatentlPermit selectRyPatentlPermitById(Long permitId) {
        return ryPatentlPermitMapper.selectRyPatentlPermitById(permitId);
    }

    /**
     * 查询专利运用许可列表
     * 
     * @param ryPatentlPermit 专利运用许可
     * @return 专利运用许可
     */
    @Override
    public List<RyPatentlPermit> selectRyPatentlPermitList(RyPatentlPermit ryPatentlPermit) {
        return ryPatentlPermitMapper.selectRyPatentlPermitList(ryPatentlPermit);
    }

    /**
     * 新增专利运用许可
     * 
     * @param ryPatentlPermit 专利运用许可
     * @return 结果
     */
    @Override
    public int insertRyPatentlPermit(RyPatentlPermit ryPatentlPermit) {
        ryPatentlPermit.setCreateTime(DateUtils.getNowDate());
        return ryPatentlPermitMapper.insertRyPatentlPermit(ryPatentlPermit);
    }

    /**
     * 修改专利运用许可
     * 
     * @param ryPatentlPermit 专利运用许可
     * @return 结果
     */
    @Override
    public int updateRyPatentlPermit(RyPatentlPermit ryPatentlPermit) {
        return ryPatentlPermitMapper.updateRyPatentlPermit(ryPatentlPermit);
    }

    /**
     * 删除专利运用许可对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRyPatentlPermitByIds(String ids) {
        return ryPatentlPermitMapper.deleteRyPatentlPermitByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除专利运用许可信息
     * 
     * @param permitId 专利运用许可ID
     * @return 结果
     */
    @Override
    public int deleteRyPatentlPermitById(Long permitId) {
        return ryPatentlPermitMapper.deleteRyPatentlPermitById(permitId);
    }

    @Override
    public int getNewIdPermit() {
        return ryPatentlPermitMapper.getNewIdPermit();
    }
}
