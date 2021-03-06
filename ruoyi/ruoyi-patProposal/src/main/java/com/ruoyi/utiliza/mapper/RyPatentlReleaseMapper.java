package com.ruoyi.utiliza.mapper;

import java.util.List;
import com.ruoyi.utiliza.domain.RyPatentlRelease;

/**
 * 专利运用解押Mapper接口
 * 
 * @author wxb
 * @date 2020-09-08
 */
public interface RyPatentlReleaseMapper 
{
    /**
     * 查询专利运用解押
     * 
     * @param permitId 专利运用解押ID
     * @return 专利运用解押
     */
    public RyPatentlRelease selectRyPatentlReleaseById(Long permitId);

    /**
     * 查询专利运用解押列表
     * 
     * @param ryPatentlRelease 专利运用解押
     * @return 专利运用解押集合
     */
    public List<RyPatentlRelease> selectRyPatentlReleaseList(RyPatentlRelease ryPatentlRelease);

    /**
     * 新增专利运用解押
     * 
     * @param ryPatentlRelease 专利运用解押
     * @return 结果
     */
    public int insertRyPatentlRelease(RyPatentlRelease ryPatentlRelease);

    /**
     * 修改专利运用解押
     * 
     * @param ryPatentlRelease 专利运用解押
     * @return 结果
     */
    public int updateRyPatentlRelease(RyPatentlRelease ryPatentlRelease);

    /**
     * 删除专利运用解押
     * 
     * @param permitId 专利运用解押ID
     * @return 结果
     */
    public int deleteRyPatentlReleaseById(Long permitId);

    /**
     * 批量删除专利运用解押
     * 
     * @param permitIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteRyPatentlReleaseByIds(String[] permitIds);
}
