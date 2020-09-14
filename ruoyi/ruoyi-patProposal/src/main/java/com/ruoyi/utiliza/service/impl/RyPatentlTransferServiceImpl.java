package com.ruoyi.utiliza.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.utiliza.mapper.RyPatentlTransferMapper;
import com.ruoyi.utiliza.domain.RyPatentlTransfer;
import com.ruoyi.utiliza.service.IRyPatentlTransferService;
import com.ruoyi.common.core.text.Convert;

/**
 * 专利运用转让Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-04
 */
@Service
public class RyPatentlTransferServiceImpl implements IRyPatentlTransferService 
{
    @Autowired
    private RyPatentlTransferMapper ryPatentlTransferMapper;

    /**
     * 查询专利运用转让
     * 
     * @param permitId 专利运用转让ID
     * @return 专利运用转让
     */
    @Override
    public RyPatentlTransfer selectRyPatentlTransferById(Long permitId)
    {
        return ryPatentlTransferMapper.selectRyPatentlTransferById(permitId);
    }

    /**
     * 查询专利运用转让列表
     * 
     * @param ryPatentlTransfer 专利运用转让
     * @return 专利运用转让
     */
    @Override
    public List<RyPatentlTransfer> selectRyPatentlTransferList(RyPatentlTransfer ryPatentlTransfer)
    {
        return ryPatentlTransferMapper.selectRyPatentlTransferList(ryPatentlTransfer);
    }

    /**
     * 新增专利运用转让
     * 
     * @param ryPatentlTransfer 专利运用转让
     * @return 结果
     */
    @Override
    public int insertRyPatentlTransfer(RyPatentlTransfer ryPatentlTransfer)
    {
        ryPatentlTransfer.setCreateTime(DateUtils.getNowDate());
        return ryPatentlTransferMapper.insertRyPatentlTransfer(ryPatentlTransfer);
    }

    /**
     * 修改专利运用转让
     * 
     * @param ryPatentlTransfer 专利运用转让
     * @return 结果
     */
    @Override
    public int updateRyPatentlTransfer(RyPatentlTransfer ryPatentlTransfer)
    {
        return ryPatentlTransferMapper.updateRyPatentlTransfer(ryPatentlTransfer);
    }

    /**
     * 删除专利运用转让对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRyPatentlTransferByIds(String ids)
    {
        return ryPatentlTransferMapper.deleteRyPatentlTransferByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除专利运用转让信息
     * 
     * @param permitId 专利运用转让ID
     * @return 结果
     */
    @Override
    public int deleteRyPatentlTransferById(Long permitId)
    {
        return ryPatentlTransferMapper.deleteRyPatentlTransferById(permitId);
    }
}
