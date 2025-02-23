package com.batch.job.batch001

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager

@Configuration
@EnableBatchProcessing
class Batch001Config(
    private val jobRepository: JobRepository,
    private val transactionManager: PlatformTransactionManager,
    private val tasklet1: Batch001Tasklet
) {
    @Bean
    fun batch001Job(): Job {
        return JobBuilder("batch001Job", jobRepository)
            .start(this.batch001Step())
            .build()
    }

    @Bean
    fun batch001Step(): Step {
        return StepBuilder("batch001Step", jobRepository)
            .tasklet(tasklet1, transactionManager)
            .build()
    }
}