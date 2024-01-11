package com.ll.sbb20240111;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BatchController {
    private final BatchService batchService;

    @GetMapping("/run-batch")
    public String runBatchJob(){
        batchService.runBatchJob();
        return "배치 작업 시작";
    }
}
