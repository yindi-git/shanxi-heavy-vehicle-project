package com.ruoyi.patproposal.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.patproposal.mapper.RyProposalProjectMapper;
import com.ruoyi.patproposal.domain.RyProposalProject;
import com.ruoyi.patproposal.service.IRyProposalProjectService;
import com.ruoyi.common.core.text.Convert;

/**
 * 项目名称Service业务层处理
 * 
 * @author ZhenMinZhang
 * @date 2020-09-09
 */
@Service
public class RyProposalProjectServiceImpl implements IRyProposalProjectService 
{
    @Autowired
    private RyProposalProjectMapper ryProposalProjectMapper;

    /**
     * 查询项目名称
     * 
     * @param projectId 项目名称ID
     * @return 项目名称
     */
    @Override
    public RyProposalProject selectRyProposalProjectById(String projectId)
    {
        return ryProposalProjectMapper.selectRyProposalProjectById(projectId);
    }

    /**
     * 查询项目名称列表
     * 
     * @param ryProposalProject 项目名称
     * @return 项目名称
     */
    @Override
    public List<RyProposalProject> selectRyProposalProjectList(RyProposalProject ryProposalProject)
    {
        return ryProposalProjectMapper.selectRyProposalProjectList(ryProposalProject);
    }

    /**
     * 新增项目名称
     * 
     * @param ryProposalProject 项目名称
     * @return 结果
     */
    @Override
    public int insertRyProposalProject(RyProposalProject ryProposalProject)
    {
        ryProposalProject.setCreateTime(DateUtils.getNowDate());
        return ryProposalProjectMapper.insertRyProposalProject(ryProposalProject);
    }

    /**
     * 修改项目名称
     * 
     * @param ryProposalProject 项目名称
     * @return 结果
     */
    @Override
    public int updateRyProposalProject(RyProposalProject ryProposalProject)
    {
        return ryProposalProjectMapper.updateRyProposalProject(ryProposalProject);
    }

    /**
     * 删除项目名称对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRyProposalProjectByIds(String ids)
    {
        return ryProposalProjectMapper.deleteRyProposalProjectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除项目名称信息
     * 
     * @param projectId 项目名称ID
     * @return 结果
     */
    @Override
    public int deleteRyProposalProjectById(String projectId)
    {
        return ryProposalProjectMapper.deleteRyProposalProjectById(projectId);
    }
}
