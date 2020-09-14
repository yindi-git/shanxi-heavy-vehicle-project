package com.ruoyi.co.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.co.mapper.RyCoCurrencyTypeMapper;
import com.ruoyi.co.domain.RyCoCurrencyType;
import com.ruoyi.co.service.IRyCoCurrencyTypeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 货币种类信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-01
 */
@Service
public class RyCoCurrencyTypeServiceImpl implements IRyCoCurrencyTypeService 
{
    @Autowired
    private RyCoCurrencyTypeMapper ryCoCurrencyTypeMapper;

    /**
     * 查询货币种类信息
     * 
     * @param currencyTypeId 货币种类信息ID
     * @return 货币种类信息
     */
    @Override
    public RyCoCurrencyType selectRyCoCurrencyTypeById(Integer currencyTypeId)
    {
        return ryCoCurrencyTypeMapper.selectRyCoCurrencyTypeById(currencyTypeId);
    }

    /**
     * 查询货币种类信息列表
     * 
     * @param ryCoCurrencyType 货币种类信息
     * @return 货币种类信息
     */
    @Override
    public List<RyCoCurrencyType> selectRyCoCurrencyTypeList(RyCoCurrencyType ryCoCurrencyType)
    {
        return ryCoCurrencyTypeMapper.selectRyCoCurrencyTypeList(ryCoCurrencyType);
    }

    /**
     * 新增货币种类信息
     * 
     * @param ryCoCurrencyType 货币种类信息
     * @return 结果
     */
    @Override
    public int insertRyCoCurrencyType(RyCoCurrencyType ryCoCurrencyType)
    {
        return ryCoCurrencyTypeMapper.insertRyCoCurrencyType(ryCoCurrencyType);
    }

    /**
     * 修改货币种类信息
     * 
     * @param ryCoCurrencyType 货币种类信息
     * @return 结果
     */
    @Override
    public int updateRyCoCurrencyType(RyCoCurrencyType ryCoCurrencyType)
    {
        return ryCoCurrencyTypeMapper.updateRyCoCurrencyType(ryCoCurrencyType);
    }

    /**
     * 删除货币种类信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRyCoCurrencyTypeByIds(String ids)
    {
        return ryCoCurrencyTypeMapper.deleteRyCoCurrencyTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除货币种类信息信息
     * 
     * @param currencyTypeId 货币种类信息ID
     * @return 结果
     */
    @Override
    public int deleteRyCoCurrencyTypeById(Integer currencyTypeId)
    {
        return ryCoCurrencyTypeMapper.deleteRyCoCurrencyTypeById(currencyTypeId);
    }
}
