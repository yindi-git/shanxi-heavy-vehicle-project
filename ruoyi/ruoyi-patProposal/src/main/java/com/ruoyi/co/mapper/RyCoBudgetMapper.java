package com.ruoyi.co.mapper;

import java.util.List;

import com.ruoyi.co.domain.RyCoBudget;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2020-09-01
 */
public interface RyCoBudgetMapper
{
    /**
     * 查询【请填写功能名称】
     *
     * @param budgetid 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public RyCoBudget selectRyCoBudgetById(Integer budgetid);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param ryCoBudget 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<RyCoBudget> selectRyCoBudgetList(RyCoBudget ryCoBudget);

    /**
     * 新增【请填写功能名称】
     *
     * @param ryCoBudget 【请填写功能名称】
     * @return 结果
     */
    public int insertRyCoBudget(RyCoBudget ryCoBudget);

    /**
     * 修改【请填写功能名称】
     *
     * @param ryCoBudget 【请填写功能名称】
     * @return 结果
     */
    public int updateRyCoBudget(RyCoBudget ryCoBudget);

    /**
     * 删除【请填写功能名称】
     *
     * @param budgetid 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteRyCoBudgetById(Integer budgetid);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param budgetids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRyCoBudgetByIds(String[] budgetids);

    public List<RyCoBudget> selectAllBudgetList();
}
