package com.ruoyi.utiliza.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.utiliza.mapper.RyPatentlReleaseMapper;
import com.ruoyi.utiliza.domain.RyPatentlRelease;
import com.ruoyi.utiliza.service.IRyPatentlReleaseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 专利运用解押Service业务层处理
 * 
 * @author wxb
 * @date 2020-09-08
 */
@Service
public class RyPatentlReleaseServiceImpl implements IRyPatentlReleaseService 
{
    @Autowired
    private RyPatentlReleaseMapper ryPatentlReleaseMapper;

    /**
     * 查询专利运用解押
     * 
     * @param permitId 专利运用解押ID
     * @return 专利运用解押
     */
    @Override
    public RyPatentlRelease selectRyPatentlReleaseById(Long permitId)
    {
        return ryPatentlReleaseMapper.selectRyPatentlReleaseById(permitId);
    }

    /**
     * 查询专利运用解押列表
     * 
     * @param ryPatentlRelease 专利运用解押
     * @return 专利运用解押
     */
    @Override
    public List<RyPatentlRelease> selectRyPatentlReleaseList(RyPatentlRelease ryPatentlRelease)
    {
        return ryPatentlReleaseMapper.selectRyPatentlReleaseList(ryPatentlRelease);
    }

    /**
     * 新增专利运用解押
     * 
     * @param ryPatentlRelease 专利运用解押
     * @return 结果
     */
    @Override
    public int insertRyPatentlRelease(RyPatentlRelease ryPatentlRelease)
    {
        ryPatentlRelease.setCreateTime(DateUtils.getNowDate());
        return ryPatentlReleaseMapper.insertRyPatentlRelease(ryPatentlRelease);
    }

    /**
     * 修改专利运用解押
     * 
     * @param ryPatentlRelease 专利运用解押
     * @return 结果
     */
    @Override
    public int updateRyPatentlRelease(RyPatentlRelease ryPatentlRelease)
    {
        return ryPatentlReleaseMapper.updateRyPatentlRelease(ryPatentlRelease);
    }

    /**
     * 删除专利运用解押对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRyPatentlReleaseByIds(String ids)
    {
        return ryPatentlReleaseMapper.deleteRyPatentlReleaseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除专利运用解押信息
     * 
     * @param permitId 专利运用解押ID
     * @return 结果
     */
    @Override
    public int deleteRyPatentlReleaseById(Long permitId)
    {
        return ryPatentlReleaseMapper.deleteRyPatentlReleaseById(permitId);
    }
}
