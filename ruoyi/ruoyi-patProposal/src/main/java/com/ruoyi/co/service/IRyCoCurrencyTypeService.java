package com.ruoyi.co.service;

import java.util.List;
import com.ruoyi.co.domain.RyCoCurrencyType;

/**
 * 货币种类信息Service接口
 * 
 * @author ruoyi
 * @date 2020-09-01
 */
public interface IRyCoCurrencyTypeService 
{
    /**
     * 查询货币种类信息
     * 
     * @param currencyTypeId 货币种类信息ID
     * @return 货币种类信息
     */
    public RyCoCurrencyType selectRyCoCurrencyTypeById(Integer currencyTypeId);

    /**
     * 查询货币种类信息列表
     * 
     * @param ryCoCurrencyType 货币种类信息
     * @return 货币种类信息集合
     */
    public List<RyCoCurrencyType> selectRyCoCurrencyTypeList(RyCoCurrencyType ryCoCurrencyType);

    /**
     * 新增货币种类信息
     * 
     * @param ryCoCurrencyType 货币种类信息
     * @return 结果
     */
    public int insertRyCoCurrencyType(RyCoCurrencyType ryCoCurrencyType);

    /**
     * 修改货币种类信息
     * 
     * @param ryCoCurrencyType 货币种类信息
     * @return 结果
     */
    public int updateRyCoCurrencyType(RyCoCurrencyType ryCoCurrencyType);

    /**
     * 批量删除货币种类信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRyCoCurrencyTypeByIds(String ids);

    /**
     * 删除货币种类信息信息
     * 
     * @param currencyTypeId 货币种类信息ID
     * @return 结果
     */
    public int deleteRyCoCurrencyTypeById(Integer currencyTypeId);
}
