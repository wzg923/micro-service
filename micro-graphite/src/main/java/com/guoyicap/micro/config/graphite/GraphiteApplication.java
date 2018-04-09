package com.guoyicap.micro.config.graphite;

import com.codahale.metrics.MetricFilter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.graphite.GraphiteReporter;
import com.codahale.metrics.graphite.PickledGraphite;
import com.codahale.metrics.jvm.GarbageCollectorMetricSet;
import com.codahale.metrics.jvm.MemoryUsageGaugeSet;
import com.codahale.metrics.jvm.ThreadStatesGaugeSet;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

/**
 * Created by wuyu on 2016/7/9.
 */
@SpringBootApplication
@EnableMetrics
public class GraphiteApplication {
    public static void main(String[] args) {
        SpringApplication.run(GraphiteApplication.class, args);
    }


    @Bean
    public MetricsConfigurerAdapter metricsConfigurerAdapter(){
        return new MetricsConfigurerAdapter() {
            @Override
            public void configureReporters(MetricRegistry metricRegistry) {
                metricRegistry.register("jvm.gc", new GarbageCollectorMetricSet());
                metricRegistry.register("jvm.mem", new MemoryUsageGaugeSet());
                metricRegistry.register("jvm.thread-states", new ThreadStatesGaugeSet());

                GraphiteReporter reporter = GraphiteReporter.forRegistry(metricRegistry)
                        .convertDurationsTo(TimeUnit.MILLISECONDS)
                        .filter(MetricFilter.ALL)
                        .build(new PickledGraphite("localhost",20000));
                registerReporter(reporter);
                reporter.start(1L, TimeUnit.SECONDS);
            }
        };
    }



}
