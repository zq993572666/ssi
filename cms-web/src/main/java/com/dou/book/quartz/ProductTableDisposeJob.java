/*
 * NumAndDevicePayReportJob
 * V 1.0.0
 * 2013/9/23
 *
 * Copyright © 2012 中国电信股份有限公司增值业务运营中心 版权所有
 *
 * 所有文字、代码资料，版权均属中国电信股份有限公司增值业务运营中心
 * 所有，任何公司或个人未经本司协议授权，不得复制、下载、存储或公开
 * 显示。违者本公司将依法追究责任。
 */

package com.dou.book.quartz;

import java.io.Serializable;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.dou.book.data.service.BookService;
import com.mysql.jdbc.TimeUtil;

/**
 * 日定时任务TODO
 * 
 * @author bqf
 */

public class ProductTableDisposeJob extends QuartzJobBean implements Serializable {
	private static final long serialVersionUID = -1643681032012119693L;
	final Logger logger = LoggerFactory.getLogger(ProductTableDisposeJob.class);

	private BookService bookService;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		long startTime = System.currentTimeMillis();
		logger.info("更新品牌预设表任务启动");
		bookService.findAllBook();
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}


}
