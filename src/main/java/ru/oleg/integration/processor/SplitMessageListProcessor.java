package ru.oleg.integration.processor;

import java.util.List;
import ru.oleg.integration.dto.Message;
import ru.oleg.integration.dto.ResultMessageData;
import ru.oleg.integration.dto.SplitMessageData;

public class SplitMessageListProcessor implements Processor {

    @SuppressWarnings("unchecked")
    @Override
    public Message process(Message message) {
        Object data = message.getData();
        if (!(data instanceof List<?>)) {
            throw new RuntimeException("Unexpected input data type");
        }

        try {
            ResultMessageData resultMessageData = new ResultMessageData();
            List<SplitMessageData> inputData = (List<SplitMessageData>) data;
            inputData.forEach(item -> {
                resultMessageData.getStrings().add("I have item # %d with name %s%n".formatted(item.getNumber(), item.getName()));
            });
            message.setData(resultMessageData);
            return message;
        } catch (Exception exc) {
            throw new RuntimeException("Unexpected input data type");
        }
    }

}
