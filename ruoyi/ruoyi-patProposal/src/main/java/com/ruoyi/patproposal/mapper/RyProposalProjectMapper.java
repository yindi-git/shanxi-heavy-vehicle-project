package com.ruoyi.patproposal.mapper;

import java.util.List;
import com.ruoyi.patproposal.domain.RyProposalProject;

/**
 * 项目名称Mapper接口
 * 
 * @author ZhenMinZhang
 * @date 2020-09-09
 */
public interface RyProposalProjectMapper 
{
    /**
     * 查询项目名称
     * 
     * @param projectId 项目名称ID
     * @return 项目名称
     */
    public RyProposalProject selectRyProposalProjectById(String projectId);

    /**
     * 查询项目名称列表
     * 
     * @param ryProposalProject 项目名称
     * @return 项目名称集合
     */
    public List<RyProposalProject> selectRyProposalProjectList(RyProposalProject ryProposalProject);

    /**
     * 新增项目名称
     * 
     * @param ryProposalProject 项目名称
     * @return 结果
     */
    public int insertRyProposalProject(RyProposalProject ryProposalProject);

    /**
     * 修改项目名称
     * 
     * @param ryProposalProject 项目名称
     * @return 结果
     */
    public int updateRyProposalProject(RyProposalProject ryProposalProject);

    /**
     * 删除项目名称
     * 
     * @param projectId 项目名称ID
     * @return 结果
     */
    public int deleteRyProposalProjectById(String projectId);

    /**
     * 批量删除项目名称
     * 
     * @param projectIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteRyProposalProjectByIds(String[] projectIds);
}
