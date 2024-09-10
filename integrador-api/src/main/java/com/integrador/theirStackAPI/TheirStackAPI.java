package com.integrador.theirStackAPI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TheirStackAPI
{
	static private String key = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ5YXJpbjQxODI4QG9iaXNpbXMuY29tIiwic"
			+ "GVybWlzc2lvbnMiOiJ1c2VyIn0.njAd-nKT4drQiY4ZkaVdu8UnFYoMAlX3IBIncvj9pfM";
	
	static private String url = "https://api.theirstack.com/v1/jobs/search?format=json&token=" + key;
	
	public static ResponseJSON postRequest()
	{
		HttpHeaders header = new HttpHeaders();
		header.setContentType( MediaType.APPLICATION_JSON );
		header.set( "accept", "application/json" );
		
		String json = "{\n  \"order_by\": [\n    {\n      \"desc\": true,\n      \"field\": \"date_posted\"\n    },\n    {\n      \"desc\": true,\n      \"field\": \"discovered_at\"\n    }\n  ],\n  \"page\": 0,\n  \"limit\": 10,\n  \"company_description_pattern_or\": [],\n  \"company_description_pattern_not\": [],\n  \"company_description_pattern_accent_insensitive\": false,\n  \"min_revenue_usd\": null,\n  \"max_revenue_usd\": null,\n  \"min_employee_count\": null,\n  \"max_employee_count\": null,\n  \"min_employee_count_or_null\": null,\n  \"max_employee_count_or_null\": null,\n  \"min_funding_usd\": null,\n  \"max_funding_usd\": null,\n  \"funding_stage_or\": [],\n  \"industry_or\": [],\n  \"industry_not\": [],\n  \"industry_id_or\": [],\n  \"industry_id_not\": [],\n  \"company_tags_or\": [],\n  \"company_type\": \"all\",\n  \"company_investors_or\": [],\n  \"company_investors_partial_match_or\": [],\n  \"company_technology_slug_or\": [],\n  \"company_technology_slug_and\": [],\n  \"company_technology_slug_not\": [],\n  \"only_yc_companies\": false,\n  \"company_location_pattern_or\": [],\n  \"company_country_code_or\": [],\n  \"company_country_code_not\": [],\n  \"company_list_id_or\": [],\n  \"company_list_id_not\": [],\n  \"company_linkedin_url_exists\": null,\n  \"revealed_company_data\": null,\n  \"company_name_or\": [],\n  \"company_name_case_insensitive_or\": [],\n  \"company_id_or\": [],\n  \"company_domain_or\": [],\n  \"company_domain_not\": [],\n  \"company_name_not\": [],\n  \"company_name_partial_match_or\": [],\n  \"company_name_partial_match_not\": [],\n  \"company_linkedin_url_or\": [],\n  \"job_title_or\": [],\n  \"job_title_not\": [],\n  \"job_title_pattern_and\": [],\n  \"job_title_pattern_or\": [],\n  \"job_title_pattern_not\": [],\n  \"job_country_code_or\": [\"BR\"],\n  \"job_country_code_not\": [],\n  \"posted_at_max_age_days\": null,\n  \"posted_at_gte\": null,\n  \"posted_at_lte\": null,\n  \"discovered_at_max_age_days\": null,\n  \"discovered_at_min_age_days\": null,\n  \"discovered_at_gte\": null,\n  \"discovered_at_lte\": null,\n  \"job_description_pattern_or\": [],\n  \"job_description_pattern_not\": [],\n  \"job_description_pattern_is_case_insensitive\": true,\n  \"remote\": null,\n  \"only_jobs_with_reports_to\": null,\n  \"reports_to_exists\": null,\n  \"final_url_exists\": null,\n  \"only_jobs_with_hiring_managers\": null,\n  \"hiring_managers_exists\": null,\n  \"job_id_or\": [],\n  \"job_ids\": [],\n  \"min_salary_usd\": null,\n  \"max_salary_usd\": null,\n  \"job_technology_slug_or\": [],\n  \"job_technology_slug_not\": [],\n  \"job_technology_slug_and\": [],\n  \"job_location_pattern_or\": [],\n  \"job_location_pattern_not\": [],\n  \"scraper_name_pattern_or\": [],\n  \"include_total_results\": false,\n  \"blur_company_data\": false,\n  \"group_by\": []\n}";
		
		HttpEntity entity = new HttpEntity( json, header );
		
		RestTemplate template = new RestTemplate();
		ResponseEntity<ResponseJSON> resp = template.exchange( url, HttpMethod.POST, entity, ResponseJSON.class );
		
		return resp.getBody();
	}// postRequest
}
