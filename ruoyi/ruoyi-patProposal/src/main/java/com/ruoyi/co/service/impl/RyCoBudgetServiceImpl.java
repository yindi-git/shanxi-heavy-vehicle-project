package com.ruoyi.co.service.ipml;
import java.util.List;

import com.ruoyi.co.domain.RyCoBudget;
import com.ruoyi.co.mapper.RyCoBudgetMapper;
import com.ruoyi.co.service.IRyCoBudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2020-09-01
 */
@Service
public class RyCoBudgetServiceImpl implements IRyCoBudgetService
{
    @Autowired
    private RyCoBudgetMapper ryCoBudgetMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param budgetid 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public RyCoBudget selectRyCoBudgetById(Integer budgetid)
    {
        return ryCoBudgetMapper.selectRyCoBudgetById(budgetid);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param ryCoBudget 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<RyCoBudget> selectRyCoBudgetList(RyCoBudget ryCoBudget)
    {
        return ryCoBudgetMapper.selectRyCoBudgetList(ryCoBudget);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param ryCoBudget 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertRyCoBudget(RyCoBudget ryCoBudget)
    {
        return ryCoBudgetMapper.insertRyCoBudget(ryCoBudget);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param ryCoBudget 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateRyCoBudget(RyCoBudget ryCoBudget)
    {
        return ryCoBudgetMapper.updateRyCoBudget(ryCoBudget);
    }

    /**
     * 删除【请填写功能名称】对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRyCoBudgetByIds(String ids)
    {
        return ryCoBudgetMapper.deleteRyCoBudgetByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param budgetid 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteRyCoBudgetById(Integer budgetid)
    {
        return ryCoBudgetMapper.deleteRyCoBudgetById(budgetid);
    }

    @Override
    public List<RyCoBudget> selectAllBudgetList(){
        return ryCoBudgetMapper.selectAllBudgetList();
    };
}
