package com.ruoyi.patproposal.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.patproposal.mapper.PatCommonMapper;

/**
 * @author: zhoudongyang
 * @time: 2020/8/13 9:41
 */
@Service("PatCommonService")
public class PatCommonService {

    @Autowired
    PatCommonMapper patCommonMapper;

    /**
     * 获取申请人相关信息
     * 
     * @return
     */
    public List<Map> getApplicant() {
        return patCommonMapper.getApplicant();
    }

    /**
     * 获取申请人相关信息
     * 
     * @return
     */
    public String getApplicantName(String applicantId) {
        return patCommonMapper.getApplicantName(applicantId);
    }

    /**
     * 获取发明类型
     * 
     * @return
     */
    public List<Map> getProposalType() {
        return patCommonMapper.getProposalType();
    }

    /**
     * 获取专利类型
     * 
     * @return
     */
    public List<Map> getProposalPatent() {
        return patCommonMapper.getProposalPatent();
    }

    /**
     * 获取发明重要度
     * 
     * @return
     */
    public List<Map> getProposalImportance() {
        return patCommonMapper.getProposalImportance();
    }

    /**
     * 获取所有专利列表
     * 
     * @return
     */
    public List<Map> getProposalList() {
        return patCommonMapper.getProposalList();
    }

    /**
     * 获取所属研发项目
     * 
     * @return
     */
    public List<Map> getProposalProject() {
        return patCommonMapper.getProposalProject();
    }

    /**
     * 获取车型
     * 
     * @return
     */
    public List<Map> getProposalMotorcycle() {
        return patCommonMapper.getProposalMotorcycle();
    }

    /**
     * 获取国家
     * 
     * @return
     */
    public List<Map> getProposalCountry() {
        return patCommonMapper.getProposalCountry();
    }

    /**
     * 获取发明技术领域
     * 
     * @return
     */
    public List<Map> getProposalTechnical() {
        return patCommonMapper.getProposalTechnical();
    }

    /**
     * 获取当前流程环节
     * 
     * @return
     */
    public Map getTodoItem(String str) {
        return patCommonMapper.getTodoItem(str);
    }

    public List<Map> getProposalComment(String instanceId) {
        return patCommonMapper.getProposalComment(instanceId);
    }

    public int getNewIdPermit(@Param(value = "tableName") String tableName) {
        return patCommonMapper.getNewIdPermit(tableName);
    };
}
