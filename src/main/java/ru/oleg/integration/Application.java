package ru.oleg.integration;

import ru.oleg.integration.dto.InputMessageData;
import ru.oleg.integration.dto.Message;
import ru.oleg.integration.dto.Settings;
import ru.oleg.integration.pipeline.IntegrationPipelineImpl;
import ru.oleg.integration.processor.InputMessageDataProcessor;
import ru.oleg.integration.processor.SplitMessageListProcessor;

public class Application {

    public static void main(String... args) {
        Message message = new Message();

        InputMessageData data = new InputMessageData();
        data.setIntField(23);
        data.setStrField("Hello");
        message.setData(data);
        message.setSourceData(data);
        message.setSettings(new Settings());

        new IntegrationPipelineImpl(message)
            .process(new InputMessageDataProcessor())
            .process(new SplitMessageListProcessor())
            .start();
    }

}
