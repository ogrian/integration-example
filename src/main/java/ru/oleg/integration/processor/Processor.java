package ru.oleg.integration.processor;

import ru.oleg.integration.dto.Message;

public interface Processor {

    Message process(Message message);

}

