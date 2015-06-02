package com.hrt.web.dp;

import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloWorldConfiguration extends Configuration {

	@NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";
   
    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;
    
    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }
	

}
