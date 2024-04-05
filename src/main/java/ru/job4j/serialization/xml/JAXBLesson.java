package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class JAXBLesson {

    public static void main(String[] args) throws Exception {
        MainObject object = new MainObject(new OtherObject(1, "NoName"), true, 2, "Beliberda", new String[]{"a", "b", "c"});
        JAXBContext context = JAXBContext.newInstance(MainObject.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(object, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            MainObject result = (MainObject) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
