package com.ruoyi.co.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.co.mapper.RyCoAgencyMapper;
import com.ruoyi.co.domain.RyCoAgency;
import com.ruoyi.co.service.IRyCoAgencyService;
import com.ruoyi.common.core.text.Convert;

/**
 * 代理机构信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-01
 */
@Service("RyCoAgencyServiceImpl")
public class RyCoAgencyServiceImpl implements IRyCoAgencyService 
{
    @Autowired
    private RyCoAgencyMapper ryCoAgencyMapper;

    /**
     * 查询代理机构信息
     * 
     * @param agencyId 代理机构信息ID
     * @return 代理机构信息
     */
    @Override
    public RyCoAgency selectRyCoAgencyById(String agencyId)
    {
        return ryCoAgencyMapper.selectRyCoAgencyById(agencyId);
    }

    /**
     * 查询代理机构信息列表
     * 
     * @param ryCoAgency 代理机构信息
     * @return 代理机构信息
     */
    @Override
    public List<RyCoAgency> selectRyCoAgencyList(RyCoAgency ryCoAgency)
    {
        return ryCoAgencyMapper.selectRyCoAgencyList(ryCoAgency);
    }

    /**
     * 新增代理机构信息
     * 
     * @param ryCoAgency 代理机构信息
     * @return 结果
     */
    @Override
    public int insertRyCoAgency(RyCoAgency ryCoAgency)
    {
        return ryCoAgencyMapper.insertRyCoAgency(ryCoAgency);
    }

    /**
     * 修改代理机构信息
     * 
     * @param ryCoAgency 代理机构信息
     * @return 结果
     */
    @Override
    public int updateRyCoAgency(RyCoAgency ryCoAgency)
    {
        return ryCoAgencyMapper.updateRyCoAgency(ryCoAgency);
    }

    /**
     * 删除代理机构信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRyCoAgencyByIds(String ids)
    {
        return ryCoAgencyMapper.deleteRyCoAgencyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除代理机构信息信息
     * 
     * @param agencyId 代理机构信息ID
     * @return 结果
     */
    @Override
    public int deleteRyCoAgencyById(Integer agencyId)
    {
        return ryCoAgencyMapper.deleteRyCoAgencyById(agencyId);
    }

   @Override
    public List<RyCoAgency> selectAllRyCoAgencyList(){
     return  ryCoAgencyMapper.selectAllRyCoAgencyList();
    };
}
