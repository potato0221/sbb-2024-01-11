package com.ll.sbb20240111.batch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@SpringBatchTest
public class BatchTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private Job simpleJob;

    @Test
    @DisplayName("job 실행")
    public void testSimpleJob() throws Exception {
        jobLauncherTestUtils.setJob(simpleJob);

        JobExecution jobExecution = jobLauncherTestUtils.launchJob(new JobParameters());

        assertEquals("COMPLETED", jobExecution.getExitStatus().getExitCode());
    }
}