package com.ruoyi.co.service.ipml;

import java.util.List;

import com.ruoyi.co.domain.RyCoTask;
import com.ruoyi.co.mapper.RyCoTaskMapper;
import com.ruoyi.co.service.IRyCoTaskService;
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
public class RyCoTaskServiceImpl implements IRyCoTaskService
{
    @Autowired
    private RyCoTaskMapper ryCoTaskMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param taskid 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public RyCoTask selectRyCoTaskById(Integer taskid)
    {
        return ryCoTaskMapper.selectRyCoTaskById(taskid);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param ryCoTask 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<RyCoTask> selectRyCoTaskList(RyCoTask ryCoTask)
    {
        return ryCoTaskMapper.selectRyCoTaskList(ryCoTask);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param ryCoTask 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertRyCoTask(RyCoTask ryCoTask)
    {
        return ryCoTaskMapper.insertRyCoTask(ryCoTask);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param ryCoTask 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateRyCoTask(RyCoTask ryCoTask)
    {
        return ryCoTaskMapper.updateRyCoTask(ryCoTask);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRyCoTaskByIds(String ids)
    {
        return ryCoTaskMapper.deleteRyCoTaskByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param taskid 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteRyCoTaskById(Integer taskid)
    {
        return ryCoTaskMapper.deleteRyCoTaskById(taskid);
    }
}
