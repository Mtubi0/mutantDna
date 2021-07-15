package ar.com.mutantdna.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ar.com.mutantdna.converter.DnaEvaluationRequestToDnaMatrixConverter;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DnaEvaluationRequestToDnaMatrixConverter());
    }
}