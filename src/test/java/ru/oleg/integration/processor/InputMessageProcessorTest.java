package ru.oleg.integration.processor;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.oleg.integration.dto.InputMessageData;
import ru.oleg.integration.dto.Message;
import ru.oleg.integration.dto.SplitMessageData;

public class InputMessageProcessorTest {

    @Test
    @DisplayName("Происходит ошибка при передаче в процессор некорректных данных")
    public void shouldThrowExceptionWhenInputIsIncorrect() {
        Message message = new Message();
        message.setData("Неверный тип данных");
        InputMessageDataProcessor  processor = new InputMessageDataProcessor();

        Assertions.assertThrows(RuntimeException.class, () -> processor.process(message));
    }

    @Test
    @DisplayName("Обрабатываются корректные данные")
    public void shouldProcessCorrectData() {
        Message message = new Message();
        InputMessageData data = new InputMessageData();
        data.setStrField("Какая-то строка");
        data.setIntField(100);
        message.setData(data);

        InputMessageDataProcessor  processor = new InputMessageDataProcessor();
        Message result = processor.process(message);

        Assertions.assertNotNull(result.getData());
        Assertions.assertInstanceOf(List.class, result.getData());
        Assertions.assertEquals(100, ((List<SplitMessageData>)result.getData()).size());
    }
}
