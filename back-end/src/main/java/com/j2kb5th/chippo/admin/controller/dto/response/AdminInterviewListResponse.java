package com.j2kb5th.chippo.admin.controller.dto.response;

import com.j2kb5th.chippo.interview.domain.Interview;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor // 임시용
public class AdminInterviewListResponse {
    private final List<AdminInterviewResponse> interviews;

//    public AdminInterviewListResponse(List<Interview> interviews){
//        if (Objects.isNull(interviews)){
//            // 처리 필요
//        }
//        this.interviews = interviews.stream()
//                .map(AdminInterviewResponse::new)
//                .collect(Collectors.toList());
}
