package com.ruoyi.utiliza.mapper;

import java.util.List;

import com.ruoyi.utiliza.domain.RyPatentlPermit;

/**
 * 专利运用许可Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-02
 */
public interface RyPatentlPermitMapper {
    /**
     * 查询专利运用许可
     * 
     * @param permitId 专利运用许可ID
     * @return 专利运用许可
     */
    public RyPatentlPermit selectRyPatentlPermitById(Long permitId);

    /**
     * 查询专利运用许可列表
     * 
     * @param ryPatentlPermit 专利运用许可
     * @return 专利运用许可集合
     */
    public List<RyPatentlPermit> selectRyPatentlPermitList(RyPatentlPermit ryPatentlPermit);

    /**
     * 新增专利运用许可
     * 
     * @param ryPatentlPermit 专利运用许可
     * @return 结果
     */
    public int insertRyPatentlPermit(RyPatentlPermit ryPatentlPermit);

    /**
     * 修改专利运用许可
     * 
     * @param ryPatentlPermit 专利运用许可
     * @return 结果
     */
    public int updateRyPatentlPermit(RyPatentlPermit ryPatentlPermit);

    /**
     * 删除专利运用许可
     * 
     * @param permitId 专利运用许可ID
     * @return 结果
     */
    public int deleteRyPatentlPermitById(Long permitId);

    /**
     * 批量删除专利运用许可
     * 
     * @param permitIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteRyPatentlPermitByIds(String[] permitIds);

    public int getNewIdPermit();
}
