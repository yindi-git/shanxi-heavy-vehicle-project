package com.ruoyi.co.service;

import java.util.List;

import com.ruoyi.co.domain.RyCoBudget;


/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2020-09-01
 */
public interface IRyCoBudgetService
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
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRyCoBudgetByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param budgetid 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteRyCoBudgetById(Integer budgetid);

    public List<RyCoBudget> selectAllBudgetList();
}
