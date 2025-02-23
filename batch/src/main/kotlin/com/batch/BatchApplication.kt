package com.batch

import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.*

@SpringBootApplication
class BatchApplication {
    
    @Bean
    fun run(jobLauncher: JobLauncher, batch001Job: Job) = CommandLineRunner { args ->
        // 引数がない場合は実行しない
        if (args.isEmpty()) {
            println("Please provide job name as argument")
            return@CommandLineRunner
        }

        val jobName = args[0]
        
        when (jobName) {
            "batch001" -> {
                val jobParameters = JobParametersBuilder()
                    .addString("datetime", Date().toString())
                    .toJobParameters()
                
                jobLauncher.run(batch001Job, jobParameters)
                println("Batch001 job has been completed")
            }
            else -> println("Unknown job name: $jobName")
        }
    }
}

fun main(args: Array<String>) {
	runApplication<BatchApplication>(*args)
}
