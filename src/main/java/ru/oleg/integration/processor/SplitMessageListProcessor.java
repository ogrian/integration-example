package ru.oleg.integration.processor;

import java.util.List;
import ru.oleg.integration.dto.Message;
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
            List<SplitMessageData> inputData = (List<SplitMessageData>) data;
            inputData.forEach(item ->{
                System.out.printf("I have item # %d with name %s%n", item.getNumber(), item.getName());
            });
        } catch (Exception exc) {
            throw new RuntimeException("Unexpected input data type");
        }
        return null;
    }

}
