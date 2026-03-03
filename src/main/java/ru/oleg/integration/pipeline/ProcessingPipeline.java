package ru.oleg.integration.pipeline;

import ru.oleg.integration.processor.Processor;

public interface ProcessingPipeline {

    void start();

    <T, S> ProcessingPipeline process(Processor processor);

}
