package com.ruoyi.co.service.ipml;

import java.util.List;

import com.ruoyi.co.domain.RyCoFirstapplicant;
import com.ruoyi.co.mapper.RyCoFirstapplicantMapper;
import com.ruoyi.co.service.IRyCoFirstapplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-27
 */
@Service
public class RyCoFirstapplicantServiceImpl implements IRyCoFirstapplicantService
{
    @Autowired
    private RyCoFirstapplicantMapper ryCoFirstapplicantMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public RyCoFirstapplicant selectRyCoFirstapplicantById(Long id)
    {
        return ryCoFirstapplicantMapper.selectRyCoFirstapplicantById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param ryCoFirstapplicant 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<RyCoFirstapplicant> selectRyCoFirstapplicantList(RyCoFirstapplicant ryCoFirstapplicant)
    {
        return ryCoFirstapplicantMapper.selectRyCoFirstapplicantList(ryCoFirstapplicant);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param ryCoFirstapplicant 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertRyCoFirstapplicant(RyCoFirstapplicant ryCoFirstapplicant)
    {
        return ryCoFirstapplicantMapper.insertRyCoFirstapplicant(ryCoFirstapplicant);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param ryCoFirstapplicant 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateRyCoFirstapplicant(RyCoFirstapplicant ryCoFirstapplicant)
    {
        return ryCoFirstapplicantMapper.updateRyCoFirstapplicant(ryCoFirstapplicant);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRyCoFirstapplicantByIds(String ids)
    {
        return ryCoFirstapplicantMapper.deleteRyCoFirstapplicantByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteRyCoFirstapplicantById(Long id)
    {
        return ryCoFirstapplicantMapper.deleteRyCoFirstapplicantById(id);
    }
}
