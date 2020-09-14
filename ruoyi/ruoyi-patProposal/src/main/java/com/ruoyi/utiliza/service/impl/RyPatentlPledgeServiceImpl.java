package com.ruoyi.utiliza.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.utiliza.mapper.RyPatentlPledgeMapper;
import com.ruoyi.utiliza.domain.RyPatentlPledge;
import com.ruoyi.utiliza.service.IRyPatentlPledgeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 专利运用质押Service业务层处理
 * 
 * @author wxb
 * @date 2020-09-04
 */
@Service
public class RyPatentlPledgeServiceImpl implements IRyPatentlPledgeService 
{
    @Autowired
    private RyPatentlPledgeMapper ryPatentlPledgeMapper;

    /**
     * 查询专利运用质押
     * 
     * @param permitId 专利运用质押ID
     * @return 专利运用质押
     */
    @Override
    public RyPatentlPledge selectRyPatentlPledgeById(Long permitId)
    {
        return ryPatentlPledgeMapper.selectRyPatentlPledgeById(permitId);
    }

    /**
     * 查询专利运用质押列表
     * 
     * @param ryPatentlPledge 专利运用质押
     * @return 专利运用质押
     */
    @Override
    public List<RyPatentlPledge> selectRyPatentlPledgeList(RyPatentlPledge ryPatentlPledge)
    {
        return ryPatentlPledgeMapper.selectRyPatentlPledgeList(ryPatentlPledge);
    }

    /**
     * 新增专利运用质押
     * 
     * @param ryPatentlPledge 专利运用质押
     * @return 结果
     */
    @Override
    public int insertRyPatentlPledge(RyPatentlPledge ryPatentlPledge)
    {
        ryPatentlPledge.setCreateTime(DateUtils.getNowDate());
        return ryPatentlPledgeMapper.insertRyPatentlPledge(ryPatentlPledge);
    }

    /**
     * 修改专利运用质押
     * 
     * @param ryPatentlPledge 专利运用质押
     * @return 结果
     */
    @Override
    public int updateRyPatentlPledge(RyPatentlPledge ryPatentlPledge)
    {
        return ryPatentlPledgeMapper.updateRyPatentlPledge(ryPatentlPledge);
    }

    /**
     * 删除专利运用质押对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRyPatentlPledgeByIds(String ids)
    {
        return ryPatentlPledgeMapper.deleteRyPatentlPledgeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除专利运用质押信息
     * 
     * @param permitId 专利运用质押ID
     * @return 结果
     */
    @Override
    public int deleteRyPatentlPledgeById(Long permitId)
    {
        return ryPatentlPledgeMapper.deleteRyPatentlPledgeById(permitId);
    }
}
