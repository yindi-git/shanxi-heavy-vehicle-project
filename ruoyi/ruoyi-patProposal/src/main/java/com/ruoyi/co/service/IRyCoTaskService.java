package com.ruoyi.co.service;

import java.util.List;

import com.ruoyi.co.domain.RyCoTask;


/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2020-08-27
 */
public interface IRyCoTaskService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param taskid 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public RyCoTask selectRyCoTaskById(Integer taskid);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param ryCoTask 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<RyCoTask> selectRyCoTaskList(RyCoTask ryCoTask);

    /**
     * 新增【请填写功能名称】
     * 
     * @param ryCoTask 【请填写功能名称】
     * @return 结果
     */
    public int insertRyCoTask(RyCoTask ryCoTask);

    /**
     * 修改【请填写功能名称】
     * 
     * @param ryCoTask 【请填写功能名称】
     * @return 结果
     */
    public int updateRyCoTask(RyCoTask ryCoTask);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRyCoTaskByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param taskid 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteRyCoTaskById(Integer taskid);
}
