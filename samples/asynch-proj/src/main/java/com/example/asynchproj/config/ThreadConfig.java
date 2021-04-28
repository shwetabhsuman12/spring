package com.example.asynchproj.config;

import java.util.concurrent.Executor;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


@ConfigurationProperties(prefix="AsyncThread")
public class ThreadConfig {
		int corePoolSize;
		int maxPoolSize;
		int queueCap;
		
		
		public int getMaxPoolSize() {
			return maxPoolSize;
		}

		public void setMaxPoolSize(int maxPoolSize) {
			this.maxPoolSize = maxPoolSize;
		}

		public int getQueueCap() {
			return queueCap;
		}

		public void setQueueCap(int queueCap) {
			this.queueCap = queueCap;
		}

		public int getCorePoolSize() {
			return corePoolSize;
		}

		public void setCorePoolSize(int corePoolSize) {
			this.corePoolSize = corePoolSize;
		}
		
		@Bean
		  public Executor taskExecutor() {
			System.out.println("Core Pool Size is :" + getCorePoolSize());
		    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		    executor.setCorePoolSize(getCorePoolSize());
		    executor.setMaxPoolSize(getMaxPoolSize());
		    executor.setQueueCapacity(getQueueCap());
		    executor.setThreadNamePrefix("AsyncThreadMgmtSOR-");
		    executor.initialize();
		    return executor;
		  }
		
}
