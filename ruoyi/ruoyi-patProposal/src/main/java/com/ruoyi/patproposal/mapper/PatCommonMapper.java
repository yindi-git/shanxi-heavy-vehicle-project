package com.ruoyi.patproposal.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * @author: zhoudongyang
 * @time: 2020/8/13 9:44
 */
public interface PatCommonMapper {
    List<Map> getApplicant();

    String getApplicantName(String applicantId);

    List<Map> getProposalType();

    List<Map> getProposalPatent();

    List<Map> getProposalImportance();

    List<Map> getProposalProject();

    List<Map> getProposalMotorcycle();

    List<Map> getProposalCountry();

    List<Map> getProposalTechnical();

    Map getTodoItem(String str);

    List<Map> getProposalComment(String instanceId);

    List<Map> getProposalList();

    int getNewIdPermit(@Param(value = "tableName") String tableName);

}
