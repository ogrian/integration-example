package ru.oleg.integration.pipeline;

import ru.oleg.integration.processor.Processor;

public interface IntegrationPipeline {

    void start();

    <T, S> IntegrationPipeline process(Processor processor);

}
