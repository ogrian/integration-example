package ru.oleg.integration.pipeline;

import java.util.LinkedList;
import ru.oleg.integration.dto.Message;
import ru.oleg.integration.processor.Processor;

public class ProcessingPipelineImpl implements ProcessingPipeline {

    private final LinkedList<Processor> processors = new LinkedList<>();
    private Message message;

    public ProcessingPipelineImpl(Message message) {
        this.message = message;
    }

    @Override
    public void start() {
        processors.forEach(processor -> this.message = processor.process(message));
    }

    @Override
    public <T, S> ProcessingPipeline process(Processor processor) {
        this.processors.add(processor);
        return this;
    }

}
