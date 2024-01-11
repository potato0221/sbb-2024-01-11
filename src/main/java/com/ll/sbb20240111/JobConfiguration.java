package com.ll.sbb20240111;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
public class JobConfiguration {
    @Bean
    public Job simpleJob1(JobRepository jobRepository, Step simpleStep1) {
        return new JobBuilder("simpleJob", jobRepository)
                .start(simpleStep1)
                .build();
    }
    @Bean
    public Step simpleStep1(JobRepository jobRepository, PlatformTransactionManager transactionManager){
        return new StepBuilder("simpleStep1", jobRepository)
                .tasklet((stepContribution, chunkContent)->{
                    System.out.println("hello-world");
                    return RepeatStatus.FINISHED;
                }, transactionManager).build();
    }
}
