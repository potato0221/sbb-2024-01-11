package com.ll.sbb20240111;


import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BatchService {

    private final JobLauncher jobLauncher;
    private final Job simpleJob;

    public void runBatchJob() {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(simpleJob, jobParameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
