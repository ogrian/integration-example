package ru.oleg.integration.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ru.oleg.integration.dto.InputMessageData;
import ru.oleg.integration.dto.Message;
import ru.oleg.integration.dto.SplitMessageData;

public class InputMessageDataProcessor implements Processor {

    @Override
    public Message process(Message message) {
        Object data = message.getData();
        if (!(data instanceof InputMessageData inputData)) {
            throw new RuntimeException("Unexpected input data type");
        }

        List<SplitMessageData> result = new ArrayList<>();
        for (int i = 0; i < inputData.getIntField(); i++) {
            SplitMessageData splitMessageData = new SplitMessageData();
            splitMessageData.setNumber(i);
            splitMessageData.setName("Name %s - %d".formatted(inputData.getStrField(), new Random().nextInt()));
            result.add(splitMessageData);
        }

        Message outputMessage = new Message();
        outputMessage.setData(result);
        return outputMessage;
    }

}
