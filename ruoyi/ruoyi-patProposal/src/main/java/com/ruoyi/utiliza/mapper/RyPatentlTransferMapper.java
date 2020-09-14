package com.ruoyi.utiliza.mapper;

import java.util.List;
import com.ruoyi.utiliza.domain.RyPatentlTransfer;

/**
 * 专利运用转让Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-04
 */
public interface RyPatentlTransferMapper 
{
    /**
     * 查询专利运用转让
     * 
     * @param permitId 专利运用转让ID
     * @return 专利运用转让
     */
    public RyPatentlTransfer selectRyPatentlTransferById(Long permitId);

    /**
     * 查询专利运用转让列表
     * 
     * @param ryPatentlTransfer 专利运用转让
     * @return 专利运用转让集合
     */
    public List<RyPatentlTransfer> selectRyPatentlTransferList(RyPatentlTransfer ryPatentlTransfer);

    /**
     * 新增专利运用转让
     * 
     * @param ryPatentlTransfer 专利运用转让
     * @return 结果
     */
    public int insertRyPatentlTransfer(RyPatentlTransfer ryPatentlTransfer);

    /**
     * 修改专利运用转让
     * 
     * @param ryPatentlTransfer 专利运用转让
     * @return 结果
     */
    public int updateRyPatentlTransfer(RyPatentlTransfer ryPatentlTransfer);

    /**
     * 删除专利运用转让
     * 
     * @param permitId 专利运用转让ID
     * @return 结果
     */
    public int deleteRyPatentlTransferById(Long permitId);

    /**
     * 批量删除专利运用转让
     * 
     * @param permitIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteRyPatentlTransferByIds(String[] permitIds);
}
