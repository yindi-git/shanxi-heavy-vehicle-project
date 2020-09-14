package com.ruoyi.co.mapper;

import java.util.List;

import com.ruoyi.co.domain.RyCoFirstapplicant;


/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-27
 */
public interface RyCoFirstapplicantMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public RyCoFirstapplicant selectRyCoFirstapplicantById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param ryCoFirstapplicant 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<RyCoFirstapplicant> selectRyCoFirstapplicantList(RyCoFirstapplicant ryCoFirstapplicant);

    /**
     * 新增【请填写功能名称】
     * 
     * @param ryCoFirstapplicant 【请填写功能名称】
     * @return 结果
     */
    public int insertRyCoFirstapplicant(RyCoFirstapplicant ryCoFirstapplicant);

    /**
     * 修改【请填写功能名称】
     * 
     * @param ryCoFirstapplicant 【请填写功能名称】
     * @return 结果
     */
    public int updateRyCoFirstapplicant(RyCoFirstapplicant ryCoFirstapplicant);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteRyCoFirstapplicantById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRyCoFirstapplicantByIds(String[] ids);
}
