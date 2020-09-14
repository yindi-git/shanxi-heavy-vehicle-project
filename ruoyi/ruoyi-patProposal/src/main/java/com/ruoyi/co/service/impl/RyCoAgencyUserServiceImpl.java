package com.ruoyi.co.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.co.mapper.RyCoAgencyUserMapper;
import com.ruoyi.co.domain.RyCoAgencyUser;
import com.ruoyi.co.service.IRyCoAgencyUserService;
import com.ruoyi.common.core.text.Convert;

/**
 * 代理人信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-01
 */
@Service
public class RyCoAgencyUserServiceImpl implements IRyCoAgencyUserService 
{
    @Autowired
    private RyCoAgencyUserMapper ryCoAgencyUserMapper;

    /**
     * 查询代理人信息
     * 
     * @param agencyUserId 代理人信息ID
     * @return 代理人信息
     */
    @Override
    public RyCoAgencyUser selectRyCoAgencyUserById(Integer agencyUserId)
    {
        return ryCoAgencyUserMapper.selectRyCoAgencyUserById(agencyUserId);
    }

    /**
     * 查询代理人信息列表
     * 
     * @param ryCoAgencyUser 代理人信息
     * @return 代理人信息
     */
    @Override
    public List<RyCoAgencyUser> selectRyCoAgencyUserList(RyCoAgencyUser ryCoAgencyUser)
    {
        return ryCoAgencyUserMapper.selectRyCoAgencyUserList(ryCoAgencyUser);
    }

    /**
     * 新增代理人信息
     * 
     * @param ryCoAgencyUser 代理人信息
     * @return 结果
     */
    @Override
    public int insertRyCoAgencyUser(RyCoAgencyUser ryCoAgencyUser)
    {
        return ryCoAgencyUserMapper.insertRyCoAgencyUser(ryCoAgencyUser);
    }

    /**
     * 修改代理人信息
     * 
     * @param ryCoAgencyUser 代理人信息
     * @return 结果
     */
    @Override
    public int updateRyCoAgencyUser(RyCoAgencyUser ryCoAgencyUser)
    {
        return ryCoAgencyUserMapper.updateRyCoAgencyUser(ryCoAgencyUser);
    }

    /**
     * 删除代理人信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRyCoAgencyUserByIds(String ids)
    {
        return ryCoAgencyUserMapper.deleteRyCoAgencyUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除代理人信息信息
     * 
     * @param agencyUserId 代理人信息ID
     * @return 结果
     */
    @Override
    public int deleteRyCoAgencyUserById(Integer agencyUserId)
    {
        return ryCoAgencyUserMapper.deleteRyCoAgencyUserById(agencyUserId);
    }

    @Override
    public  List<RyCoAgencyUser>  selectListByAgencyId(String agencyid){
        return ryCoAgencyUserMapper.selectListByAgencyId(agencyid);
    }
}
