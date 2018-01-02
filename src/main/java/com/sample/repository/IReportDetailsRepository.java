package com.sample.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.sample.model.ReportDetails;

public interface IReportDetailsRepository extends CrudRepository<ReportDetails, Serializable>{

}
